package krathong.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

public final class SplashScreen extends JWindow implements Runnable {

	private static final long serialVersionUID = 1L;
	private final int HEIGHT = 250;
	private final int WIDTH = 400;

	private JProgressBar progressBar;
	private Thread runner;
	private final String APP_NAME = "Krathong 2013";
	private final String DEV_NAME = "Voravut Nateluercha";
	private final String VERSION = "1.0 build 1";
	private final String DESCRIPTION = "This is the part of 01418217 Software Construction.";
	
	private final String loadedWindowState;
	
	public SplashScreen(String windowState){
		
		loadedWindowState = windowState;
		setAlwaysOnTop(true);
		setLayout(new BorderLayout());
		progressBar = new JProgressBar(1, 10);
		add(drawText(), BorderLayout.CENTER);
		add(progressBar, BorderLayout.SOUTH);
		setVisible(true);
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		progressThread();
		
	}
	
	private void progressThread(){
		
		runner = new Thread(this);
		runner.start();
		
	}
	
	private JPanel drawText(){
		
		JPanel outer = new backgroundPanel();
		outer.setLayout(new GridLayout(3,1));
		JLabel appName = new JLabel(APP_NAME + " " + VERSION);
		appName.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		JLabel devName = new JLabel(DEV_NAME);
		devName.setFont(new Font("Lucida Grande", Font.TRUETYPE_FONT, 12));
		outer.add(appName);
		outer.add(devName);
		
		return outer;
		
	}
	private class backgroundPanel extends JPanel{

		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g){

			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
			int w = getWidth();
			int h = getHeight();
			Color color1 = new Color(169, 169, 169);
			Color color2 = Color.white;
			GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2, false);
			g2d.setPaint(gp);
			g2d.fillRect(0, 0, w, h);

		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		
		JFrame main = new MainFrame();
		main.setExtendedState(Integer.parseInt(loadedWindowState));
		main.setVisible(false);
		for(int i = 1; i <= 10; i++){
			try {
				Thread.sleep(500);
				progressBar.setValue(progressBar.getValue() + 1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		// Fading the splash
		for(int i = 5; i >= 0; i--){
			try {
				Thread.sleep(200);
				
				setOpacity((float) (getOpacity() - 0.15)); 
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		dispose();
		main.setVisible(true);
		runner.stop();
		
	}
	
}
