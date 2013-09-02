package krathong.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private final int HEIGHT = 500;
	private final int WIDTH = 800;
	
	public MainFrame(String name, String icon){
		
		setTitle(name);
		setSize(WIDTH, HEIGHT);
		setIconImage(new ImageIcon(icon).getImage());
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
}
