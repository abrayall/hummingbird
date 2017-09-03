package hummingbird;

import static javax.io.File.*;
import static javax.util.Map.*;
import static javax.util.List.*;
import static hummingbird.jre.Feature.*;

import java.io.BufferedOutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.io.File;
import javax.io.Streams;
import javax.lang.Try;
import javax.util.List;
import javax.util.Map;

import hummingbird.jre.Feature;
import vermouth.Version;


public class Main extends cilantro.Main {
	
	public String name() {
		return "Hummingbird";
	}
	
	public String description() {
		return "JRE Minification Tool";
	}
	
	public String version() {
		return Version.getVersion().toString();
	}
	
	public Integer execute(List<String> parameters, Map<String, String> options) throws Exception {
		console.print(this.header());
		File jre = file(parameters.get(0, ""));
		if (jre.exists() == false)
			return error(-1, "Please specify a valid JRE location");

		if (file(jre, "bin/java").exists() == false && file(jre, "bin/java.exe").exists() == false)
			return error(-1, "Directory " + jre + " is not a valid JRE");
		
		return execute(jre, Level.level(options.get("level", "normal")), options);
	}
	
	protected Integer execute(File jre, Level level, Map<String, String> options) throws Exception {
		return execute(jre, level.features, options);
	}
	
	protected Integer execute(File jre, List<Feature> features, Map<String, String> options) throws Exception {
		long start = System.currentTimeMillis();
		println("Removing unnessecary files...");
		clean(jre, invert(features), options);
		
		println("Compressing files...");
		compress(jre, options);
		
		println("Minification complete [" + ((System.currentTimeMillis() - start) / 1000) + " seconds].");
		return 0;
	}

	protected void clean(File jre, List<Feature> unwanted, Map<String, String> options) throws Exception {
		jre.search().forEach(file -> {
			String path = file.relative(jre);
			if ((path.startsWith("bin") == false  && path.startsWith("lib") == false) || path.endsWith(".jsa") || path.endsWith(".txt") || contains(unwanted, path)) {
				println("  Deleting file " + file + "...");
				Try.attempt(() -> file.delete());
			}
		});
	}
	
	protected void compress(File jre, Map<String, String> options) throws Exception {
		jre.search(".*jar").forEach(jar -> Try.attempt(() -> compress(jar)));
	}
	
	protected void compress(File jar) throws Exception {
		println("  Compressing jar " + jar + "...");
		File compressed = file(jar.parent(), jar.name().replace(".jar", "-compressed.jar"));
		copy(new JarInputStream(jar.inputStream()), zip(compressed));
		jar.delete();
		compressed.rename(jar);
	}
	
	protected void copy(JarInputStream input, ZipOutputStream output) throws Exception {
		JarEntry entry = input.getNextJarEntry();
		while (entry != null) {
			output.putNextEntry(new ZipEntry(entry.getName()));
			Streams.copy(input, output, false);
			entry = input.getNextJarEntry();
		}
		
		Streams.close(input);
		Streams.close(output);
	}
	
	protected ZipOutputStream zip(File file) throws Exception {
		ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(file.outputStream()));
		zip.setMethod(ZipOutputStream.DEFLATED);
		zip.setLevel(Deflater.BEST_COMPRESSION);
		return zip;
	}
	
	protected boolean contains(List<Feature> features, String file) {
		return features.filter(feature -> feature.contains(file)).size() > 0;
	}
	
	public static void main(String[] arguments) throws Exception {
		main(Main.class, arguments);
	}
	
	public static class Level {
		
		public static Level NORMAL = new Level(FEATURES);
		public static Level LIGHT  = new Level(FEATURES.without(Feature.JAVAFX, Feature.WEBSTART, Feature.JFR));
		
		public static Map<String, Level> levels = map(
			entry("normal", NORMAL),
			entry("light", LIGHT)
		);
		
		public static Level level(String name) {
			return levels.getOrDefault(name, NORMAL);
		}
		
		protected List<Feature> features;
		protected Level(List<Feature> features) {
			this.features = features;
		}
		
		protected Level(Feature...features) {
			this(list(features));
		}
	}
}
