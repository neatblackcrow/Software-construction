package krathong.view;

import java.awt.BorderLayout;
import java.awt.Color;
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
	
	public SplashScreen(String name, String dev, String version, String icon){
		
		setAlwaysOnTop(true);
		setLayout(new BorderLayout());
		add(new backgroundPanel());
		progressBar = new JProgressBar(0, 10);
		progressBar.setValue(5);
		//add(drawText(name, dev, version, icon), BorderLayout.CENTER);
		add(progressBar, BorderLayout.SOUTH);
		setVisible(true);
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		
	}
	
	private JPanel drawText(String name, String dev, String version, String icon){
		
		JPanel outer = new JPanel();
		outer.setLayout(new GridLayout(3,1));
		
		JLabel devName = new JLabel(dev);
		
		return outer;
		
	}
	private class backgroundPanel extends JPanel{

		private static final long serialVersionUID = 1L;

		public void paint(Graphics g){

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

	@Override
	public void run() {
		
		
		
	}
	
}
