package krathong.view;

import java.awt.Font;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public final class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private final int HEIGHT = 500;
	private final int WIDTH = 800;
	
	private final String APP_NAME = "Krathong 2013";
	private final String ICON_LOCATION = "./resources/icon.png";
	
	private final String MAIN = "Main";
	private final String FULLSCREEN = "View in full screen";
	private final String LOCK_PANEL = "Lock panels";
	private final String RUNTIME_VIEW = "View runtime-stats";
	private final String EXIT = "Exit";
	
	private final String CONFIG = "Configuration";
	private final String RESTORE_CONFIG = "Restore to default configuration";
	private final String SAVE_CONFIG = "Save current configuration";
	private final String CONFIGS = "Configurations";
	
	private final String HELP = "Help";
	private final String MANUAL = "User Manual";
	private final String ABOUT_ME = "About Me :)";
	
	private HashMap<String, ImageIcon> resources;
	
	public MainFrame(){
		
		setTitle(APP_NAME);
		setSize(WIDTH, HEIGHT);
		fetchResources();
		setIconImage(new ImageIcon(ICON_LOCATION).getImage());
		setLocationRelativeTo(null);
		setJMenuBar(createMenu());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAutoRequestFocus(true);
		//setVisible(true); Leave it to SplashScreen to manage its visibility.
		
	}
	
	private void fetchResources(){
		
		// HARD CODED :(
		
		resources = new HashMap<String, ImageIcon>();
		resources.put("full_screen", new ImageIcon("./resources/fullscreen.png"));
		resources.put("lock_panel", new ImageIcon("./resources/lockpanel.png"));
		resources.put("runtime_view", new ImageIcon("./resources/runtimeView.png"));
		resources.put("exit", new ImageIcon("./resources/exit.png"));
		resources.put("restore_config", new ImageIcon("./resources/restoreconfig.png"));
		resources.put("save_config", new ImageIcon("./resources/saveconfig.png"));
		resources.put("config", new ImageIcon("./resources/config.png"));
		resources.put("manual", new ImageIcon("./resources/help.png"));
		resources.put("about_me", new ImageIcon("./resources/aboutme.png"));
		
	}
	
	private Font getUIFont(){
		
		return new Font("Lucida Grande", Font.TRUETYPE_FONT, 12);
		
	}
	
	private JMenuBar createMenu(){
		
		JMenuBar menu = new JMenuBar();
		menu.add(createMainMenu());
		menu.add(createConfigMenu());
		menu.add(createHelpMenu());
		
		return menu;
	}
	
	private JMenu createMainMenu(){
		
		JMenu mainMenu = new JMenu(MAIN);
		mainMenu.add(new JCheckBoxMenuItem(FULLSCREEN, resources.get("full_screen")));
		mainMenu.add(new JCheckBoxMenuItem(LOCK_PANEL, resources.get("lock_panel")));
		mainMenu.add(createMenuItem(RUNTIME_VIEW, resources.get("runtime_view")));
		mainMenu.add(createMenuItem(EXIT, resources.get("exit")));
		mainMenu.setFont(getUIFont());
		
		return mainMenu;
		
	}
	
	private JMenu createConfigMenu(){
		
		JMenu configMenu = new JMenu(CONFIG);
		configMenu.add(createMenuItem(RESTORE_CONFIG, resources.get("restore_config")));
		configMenu.add(createMenuItem(SAVE_CONFIG, resources.get("save_config")));
		configMenu.add(createMenuItem(CONFIGS, resources.get("config")));
		configMenu.setFont(getUIFont());
		
		return configMenu;
	
	}
	
	private JMenu createHelpMenu(){
		
		JMenu helpMenu = new JMenu(HELP);
		helpMenu.add(createMenuItem(MANUAL, resources.get("manual")));
		helpMenu.add(createMenuItem(ABOUT_ME, resources.get("about_me")));
		helpMenu.setFont(getUIFont());
		
		return helpMenu;
	}
	
	private JMenuItem createMenuItem(String name, ImageIcon icon){
		
		JMenuItem menuItem = new JMenuItem(name, icon);
		menuItem.setFont(getUIFont());
		
		return menuItem;
		
	}
	
}
