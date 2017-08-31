package hummingbird.jre;

import javax.util.List;
import static javax.util.List.*;

public class Feature {
	
	public static Feature LANG = new Feature("lang", list());
	public static Feature UTIL = new Feature("util", list());
	public static Feature JDBC = new Feature("jdbc", list());
	public static Feature NIO = new Feature("nio", list());
	public static Feature XML = new Feature("xml", list());
	public static Feature WEBSERVICES = new Feature("webservices", list());
	public static Feature AWT = new Feature("awt", list());
	public static Feature SWT = new Feature("swt", list());
	public static Feature BEANS = new Feature("beans", list());
	public static Feature CORBA = new Feature("corba", list());
	public static Feature IMAGE = new Feature("image", list());
	public static Feature JMX = new Feature("jmx", list());
	public static Feature JNDI = new Feature("jndi", list());
	public static Feature MEDIA = new Feature("media", list());
	public static Feature NET = new Feature("net", list());
	public static Feature BCEL = new Feature("bcel", list());
	public static Feature XALAN = new Feature("xalan", list());
	public static Feature XERCES = new Feature("xerces", list());
	public static Feature XPATH = new Feature("xpath", list());
	public static Feature GLASSFISH = new Feature("glassfish", list());
	
	public static Feature APPLET = new Feature("applet", list());
	public static Feature TIME = new Feature("time", list());
	public static Feature SECURITY = new Feature("security", list());
	public static Feature MANAGEMENT = new Feature("management", list());
	public static Feature ENCRYPTION = new Feature("encryption", list());
	public static Feature NASHORN = new Feature("nashorn", list());
	

	public static Feature RMI = new Feature("rmi", list("bin/rmid", "bin/rmiregistry", "bin/tnameserv", "bin/orbd", "bin/servertool", "bin/policytool"));
	public static Feature KERBEROS = new Feature("kerberos", list("bin/keytool", "bin/kinit", "bin/klist", "bin/ktab"));

	public static Feature JAVAFX = new Feature("javafx",
		list("lib/ant-javafx.jar", "lib/javafx.properties", "lib/jfxswt.jar"),
		list("decora-sse", "decora_sse", "fxplugins", "glass", "glib-lite", "gstreamer-lite", "javafx-font", "javafx_font_t2k", "javafx-iio", "jfxmedia", "jfxwebkit", "prism_common", "prism-d3d", "prism_es2", "prism_sw", "javafx_font_freetype", "javafx_font_pango")
	);
	
	public static Feature WEBSTART = new Feature("webstart", list("bin/javaws", "lib/javaws.jar"));
	public static Feature JFR = new Feature("jfr", list("lib/jfr", "lib/jfr.jar"));
	
	public static List<Feature> FEATURES = list(JAVAFX, WEBSTART, JFR);
	
	public static List<Feature> features(String... names) {
		return features(list(names));
	}

	public static List<Feature> features(List<String> names) {
		return FEATURES.filter(feature -> names.contains(feature.name));
	}
	
	protected String name;
	protected List<String> files = list();
	protected List<String> libraries = list();
	protected List<String> classes = list();
	
	public Feature(String name, List<String> files) {
		this(name, files, list());
	}
	
	public Feature(String name, List<String> files, List<String> libraries) {
		this(name, files, libraries, list());
	}
	
	public Feature(String name, List<String> files, List<String> libraries, List<String> classes) {
		this.name = name;
		this.files = files;
		this.classes = classes;
		this.libraries = libraries.flatMap(library -> list("bin/" + library + ".dll", "lib/" + library + "dylib", "lib/i386/" + library + ".so", "lib/amd64/" + library + ".so"));
	}
	
	public boolean equals(Object object) {
		if (Feature.class.isInstance(object))
			return this.equals((Feature)object);
		
		return false;
	}
	
	public boolean contains(String file) {
		return this.files.contains(file) || this.libraries.contains(file);
	}
	
	public boolean equals(Feature feature) {
		return feature.name.equals(this.name);
	}
	
	public String toString() {
		return "feature: [name=" + this.name + "]\n\t" + "files: " + this.files + "\n\t" + "libraries: " + this.libraries + "\n\t" + "classes: " + this.classes + "\n";
	}
	
	// awt.dll - awt
	
	// bci.dll - unknown
	// dcpr.dll - awt or swt
	// deploy.dll - applet, webstart
	// dtplugin/* - applet
	
	//dt_socket - debug
	//dt_shmem - debug
	
	//fontmanager.dll - fonts
	
	// hprof.dll - profiler, debug
	// java_crw_demo.dll - profiles
	// instrument - instrument, profiler, bebug
	
	// j2pcsc.dll - smartcard
	// j2pkcs11.dll - encryption
	// jaas_nt.dll - security, windows nt
	
	// JavaAccessBridge-64.dll - accessability
	// javacpl.exe - java control panel
	
	// java-rmi.exe
	// java.exe - core
	// java.dll - core
	// javaw.exe - core
	// javaws.exe - webstart
	
	// JAWTAccessBridge-64.dll - awt
	// jabswitch.exe - accessabilitiy
	// jp2iexp.dll - applet
	// jp2launcher.exe - webstart
	// jp2native.dll - applet
	// jp2ssv.dll - applet
	
	// jpeg.dll - images
	// jsdt.dll - unknown
	
	// jsound.dll - sound
	// jsoundds.dll - sound
	// kcms.dll - color, images
	
	// klist.exe - security, kerberos
	// kinit.exe - security, kerberos
	// ktab.exe - seucurity, kerberos
	
	// lcms.dll - images
	// management.dll - management, profiler
	// mlib_image.dll - image, awt
	
	// msvcp120.dll - core, unknown
	// msvcr100.dll - core, unknown
	// msvcr120.dll - core, unknown
	// net.dll - networking
	// nio.dll - networking, io, nio
	
	// orbd.exe - rmi
	// rmid.exe - rmi
	// rmiregsitry.exe - rmi 
	
	// splashscreen.dll - awt, splashscreen
	
	// pack200.exe - compression
	// unpack200.exe - compression
	// unpack.dll - compression
	// zip.dll - compression
	
	// verify.dll - core, unknown
	
	// plugin2/* - applet
	// resource.dll - resource
	
	// ssvagent.exe - applet
	// ssv.ddl - applet
	
	// sunec.dll - encryption
	// sunmscapi.dll - encryption, security
	
	// w2k_lsa_auth.dll - security
	
	// t2k.dll - awt, font
	// WindowsAccessBridge-64.dll - accessability
	
	// wsdetect.dll - webstart
	
	// npt.dll - core, unknown
	// jawt - awt
	// jdwp (java debug wire protocol) - debug
	// jfr (java flight recorder) - debug, profiler
	
	// jjs.exe - javascript
	// jli - core
}