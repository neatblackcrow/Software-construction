package krathong.control;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public final class ConfigManager {

	private Document configDoc;
	
	private Node config;
	private Node info;
	private Node file;
	
	private Node theme;
	private Node waterShadeColor;
	private Node waterColor;
	private Node threadManager;
	private Node threadManualThreshold;
	private Node windowState;
	
	private Node name;
	private final String dev = "Voravut Nateluercha";
	private Node description;
	private Node version;
	
	private Node help;
	private Node icon;
	private Node font;
	
	public final String THEME_SEAGLASS = "SeaGlass";
	public final String THEME_OSDEFAULT  = "OSDefault";
	public final String THEME_JAVADEFAULT = "JavaDefault";
	
	public final String WINDOW_NORMAL = "normal";
	public final String WINDOW_MAXIMIZED = "maximize";
	
	public final String THREAD_AUTO = "automatic";
	public final String THREAD_MANUAL = "manual";
	
	
	public ConfigManager(){
		
		final String SETTING_NODE = "setting";
		final String INFO_NODE = "info";
		final String FILE_NODE = "file";
		configDoc = getDocument("./resources/configuration.xml");
		config = configDoc.getElementsByTagName(SETTING_NODE).item(0);
		info = configDoc.getElementsByTagName(INFO_NODE).item(0);
		file = configDoc.getElementsByTagName(FILE_NODE).item(0);
		loadContent();
		
	}
	
	private void loadContent(){
		
		// HARD CODED :(
		theme = config.getChildNodes().item(0);
		waterShadeColor = config.getChildNodes().item(1);
		waterColor = config.getChildNodes().item(2);
		threadManager = config.getChildNodes().item(3);
		threadManualThreshold = config.getChildNodes().item(4);
		windowState = config.getChildNodes().item(5);
		name = info.getChildNodes().item(0);
		description = info.getChildNodes().item(1);
		version = info.getChildNodes().item(2);
		help = file.getChildNodes().item(0);
		icon = file.getChildNodes().item(1);
		font = file.getChildNodes().item(2);
		
	}
	
	private Document getDocument(String doc){
		
		try{
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			
			factory.setIgnoringComments(false);
			factory.setIgnoringElementContentWhitespace(true);
			factory.setValidating(true);
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			return builder.parse(new InputSource(doc));
			
		}
		
		catch(Exception ex){
			
			System.out.println(ex.getMessage());
			System.exit(1);
			
		}
		
		return null;
		
	}
	
	public void saveSetting(){
		
		try {
			Transformer t = TransformerFactory.newInstance().newTransformer();
			t.setOutputProperty(OutputKeys.INDENT, "yes");
			t.setOutputProperty(OutputKeys.METHOD, "xml");
			t.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			t.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "configuration.dtd");
			t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			
			t.transform(new DOMSource(configDoc), new StreamResult(new FileOutputStream("./resources/configuration.xml")));
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getTheme() {
		return theme.getTextContent();
	}

	public void setTheme(String theme) {
		this.theme.setTextContent(theme);
	}

	public String getWaterShadeColor() {
		return waterShadeColor.getTextContent();
	}

	public void setWaterShadeColor(String waterShadeColor) {
		this.waterShadeColor.setTextContent(waterShadeColor);
	}

	public String getWaterColor() {
		return waterColor.getTextContent();
	}

	public void setWaterColor(String waterColor) {
		this.waterColor.setTextContent(waterColor);
	}

	public String getThreadManager() {
		return threadManager.getTextContent();
	}

	public void setThreadManager(String threadManager) {
		this.threadManager.setTextContent(threadManager);
	}

	public String getThreadManualThreshold() {
		return threadManualThreshold.getTextContent();
	}

	public void setThreadManualThreshold(String threadManualThreshold) {
		this.threadManualThreshold.setTextContent(threadManualThreshold);
	}

	public String getWindowState() {
		return windowState.getTextContent();
	}

	public void setWindowState(String windowState) {
		this.windowState.setTextContent(windowState);
	}

	public String getName() {
		return name.getTextContent();
	}

	public String getDev() {
		return dev;
	}

	public String getDescription() {
		return description.getTextContent();
	}

	public String getVersion() {
		return version.getTextContent();
	}

	public String getHelp() {
		return help.getTextContent();
	}
	
	public String getIcon(){
		return icon.getTextContent();
	}
	
	public String getFont(){
		return font.getTextContent();
	}
	
}
