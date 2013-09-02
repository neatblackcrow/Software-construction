package krathong.control;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import krathong.view.SplashScreen;

public final class ActionManager {

	private static ConfigManager configManager;
	
	public static void main(String[] args){
		
		configManager = new ConfigManager();
		fetchFont();
		fetchTheme();
	
		// Spawn the splash screen, then the splash is going to instantiate the main application frame.
		new SplashScreen(configManager.getWindowState());
		
	}
	
	private static void fetchFont(){
		
		final String FONT_LOCATION = "./resources/lucida_grande.ttf";

		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(FONT_LOCATION)));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FontFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	private static void fetchTheme(){
		
		try {
			if(configManager.getTheme().equals(configManager.THEME_SEAGLASS)){
				UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
			}
			else if(configManager.getTheme().equals(configManager.THEME_OSDEFAULT)){
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
			else if(configManager.getTheme().equals(configManager.THEME_JAVADEFAULT)){
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ActionManager(){
		
		
		
	}
	
}
