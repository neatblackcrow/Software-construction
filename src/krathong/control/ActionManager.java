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
		
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(configManager.getFont())));
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
	
		new SplashScreen(configManager.getName() ,configManager.getDev(), configManager.getVersion(), configManager.getIcon());
		
	}
	
	public ActionManager(){
		
		
		
	}
	
}
