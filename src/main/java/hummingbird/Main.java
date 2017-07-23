package hummingbird;

import javax.io.File;
import javax.lang.Try;
import javax.util.List;
import javax.util.Map;

import static javax.io.File.*;

public class Main extends cilantro.Main {
	
	public String name() {
		return "Hummingbird";
	}
	
	public String description() {
		return "JRE Minification Tool";
	}
	
	public String version() {
		return "0.0.1";
	}
	
	public Integer execute(List<String> parameters, Map<String, String> options) throws Exception {
		console.print(this.header());
		File jre = file(parameters.get(0, ""));
		if (jre.exists() == false)
			return error(-1, "Please specify a valid JRE location");

		if (file(jre, "bin/java").exists() == false && file(jre, "bin/java.exe").exists() == false)
			return error(-1, "Directory " + jre + " is not a valid JRE");
		
		return execute(jre, options);
	}
	
	protected Integer execute(File jre, Map<String, String> options) throws Exception {
		println("Removing unnessecary files...");
		jre.search().forEach(file -> {
			String path = file.relative(jre);
			if ((path.startsWith("bin") == false  && path.startsWith("lib") == false) || path.endsWith(".jsa") || path.endsWith(".txt") ) {
				println(" - deleting file " + file);
				Try.attempt(() -> file.delete());
			}
		});
		
		println("Minification complete.");
		return 0;
	}

	public static void main(String[] arguments) throws Exception {
		main(Main.class, arguments);
	}
}
