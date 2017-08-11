package hummingbird.jre;

import javax.util.List;
import static javax.util.List.*;

public class Feature {
	public List<String> LANG = list();
	public List<String> UTIL = list();
	public List<String> JDBC = list();
	public List<String> NIO = list();
	public List<String> XML = list();
	public List<String> WEBSERVICES = list();
	public List<String> AWT = list();
	public List<String> SWT = list();
	public List<String> BEANS = list();
	public List<String> CORBA = list();
	public List<String> IMAGE = list();
	public List<String> JMX = list();
	public List<String> JNDI = list();
	public List<String> MEDIA = list();
	public List<String> NET = list();
	public List<String> BCEL = list();
	public List<String> XALAN = list();
	public List<String> XERCES = list();
	public List<String> XPATH = list();
	public List<String> GLASSFISH = list();
	
	public List<String> RMI = list("bin/rmid", "bin/rmiregistry", "bin/tnameserv", "bin/orbd", "bin/servertool", "bin/policytool");
	public List<String> KERBEROS = list("bin/keytool", "bin/kinit", "bin/klist", "bin/ktab");
	
	
	public List<String> APPLET = list();
	public List<String> TIME = list();
	public List<String> SECURITY = list();
	public List<String> MANAGEMENT = list();
	public List<String> ENCRYPTION = list();
	
	public List<String> FX = list();
	public List<String> WEBSTART = list("bin/javaws", "lib/javaws.jar");
	public List<String> JFR = list("lib/jfr", "lib/jfr.jar");
	
	public List<String> NASHORN = list();
	
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
	
	// prism_common.dll - javafx
	// javafx_font.dll - javafx
	// prism_d3d.dll - javafx
	// prism_sw.dll - javafx
	// jfxmedia.dll - javafx
	// jfxwebkit.dll - javafx
	// javafx_font.dll - javafx
	// javafx_font_t2k.dll - javafx
	// javafx_iio.dll - javafx
	// fxplugins.dll - javafx
	// glass.dll - javafx
	// glib-lite.dll - javafx
	// gstreamer-lite.dll - javafx
	// decora_sse.dll - javafx
	
}