package krathong.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;

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
	private String name;
	private String icon;
	
	public SplashScreen(String name, String dev, String version, String icon){
		
		this.name = name;
		this.icon = icon;
		setAlwaysOnTop(true);
		setLayout(new BorderLayout());
		progressBar = new JProgressBar(0, 10);
		progressBar.setValue(5);
		add(drawText(name, dev, version, icon), BorderLayout.CENTER);
		add(progressBar, BorderLayout.SOUTH);
		setVisible(true);
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		progressRunner();
		
	}
	
	private void progressRunner(){
		
		runner = new Thread(this);
		runner.start();
		
	}
	
	private JPanel drawText(String name, String dev, String version, String icon){
		
		JPanel outer = new backgroundPanel();
		outer.setLayout(new GridLayout(3,1));
		JLabel appName = new JLabel(name + " " + version);
		appName.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		JLabel devName = new JLabel(dev);
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
		
		for(int i = 0; i <= 10; i++){
			try {
				Thread.sleep(500);
				progressBar.setValue(progressBar.getValue());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		new MainFrame(name, icon);
		dispose();
		runner.stop();
		
	}
	
}
