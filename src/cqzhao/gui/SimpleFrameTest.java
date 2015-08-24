package cqzhao.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.*;

import javax.swing.*;

public class SimpleFrameTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SimpleFrame frame = new SimpleFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}

class SimpleFrame extends JFrame {
	public SimpleFrame() {
		// setLocation(PX, PY);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dm = tk.getScreenSize();
		screenHeight = dm.height;
		screenWidth = dm.width;
		// setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setSize(screenWidth / 2, screenHeight / 2);
		setLocation(screenWidth / 4, screenHeight / 4);
//		setLocationByPlatform(true);

		add(new MyComponent());
		// java.awt.Image it = tk.getImage("icon.gif");
		java.awt.Image it = new ImageIcon("icon.gif").getImage();
		setIconImage(it);

		setTitle("HELLO!");
	}

	class MyComponent extends JComponent {

		@Override
		public void paintComponent(Graphics g) {
			g.drawString("Hello!", START_X, START_Y);
			setBackground(SystemColor.textText);
			Graphics2D g2 = (Graphics2D) g;
			double centery = getHeight()/2.0;
			double centerx = getWidth()/2.0;
			double height = getHeight()/4.0;
			double weight = getWidth()/4.0;
			System.out.println(centerx+"  "+centery);
			Point2D center = new Point2D.Double(centerx,centery);
			Point2D left = new Point2D.Double(centerx-weight/2.0,centery-height/2.0);
			Point2D left2 = new Point2D.Double(centerx-weight/2.0,centery-weight/2.0);
			Point2D right = new Point2D.Double(centerx+weight/2.0,centery+height/2.0);
			Rectangle2D rect = new Rectangle2D.Double();
			rect.setFrameFromCenter(center, left); 
			g2.setPaint(Color.red);
			g2.fill(rect);
			
			Ellipse2D ell = new Ellipse2D.Double();
			ell.setFrameFromCenter(center, left);
			g2.draw(ell);
			
			g2.setPaint(new Color(0,245,123));
			Line2D line = new Line2D.Double(left,right);
			g2.draw(line);

			Ellipse2D ell2 = new Ellipse2D.Double();
			ell2.setFrameFromCenter(center,left2);;
			g2.draw(ell2);

		}

		private int START_X = 75;
		private int START_Y = 100;
	}

	private final int DEFAULT_WIDTH = 200;
	private final int DEFAULT_HEIGHT = 200;
	private final int PX = 400;
	private final int PY = 400;
	private int screenHeight;
	private int screenWidth;
}
