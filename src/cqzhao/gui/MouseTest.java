package cqzhao.gui;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				MouseFrame mf = new MouseFrame();
				mf.setVisible(true);
				mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}

}

class MouseFrame extends JFrame {
	public MouseFrame() {
		this.setFrame();
		this.setTitle("Mouse Painting");
		this.setSize(width, height);
		this.setLocation(pos);
		MousePaint jc = new MousePaint();
		this.add(jc);
	}

	private void setFrame() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dm = tk.getScreenSize();
		height = (int) dm.getHeight() / 2;
		width = (int) dm.getWidth() / 2;
		pos = new Point(width / 2, height / 2);

	}

	private int height;
	private int width;
	private Point pos;
}

class MousePaint extends JComponent {
	private ArrayList<Rectangle2D> squares;
	private Rectangle2D current;
	private final double SIDELENGTH = 10.0;

	public MousePaint() {
		squares = new ArrayList<Rectangle2D>();
		current = null;

		addMouseListener(new MouseHandler());
		addMouseMotionListener(new MouseMotionHandler());
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		for (Rectangle2D rc : squares) {
			g2.draw(rc);
		}
	}

	private Rectangle2D find(Point2D p){
		for(Rectangle2D g : squares){
			if(g.contains(p)) return g;
		}
		return null;
	}

	private void add(Point2D p) {
		if (find(p) == null) {
			squares.add(new Rectangle2D.Double((p.getX() - SIDELENGTH / 2.0), (p.getY() - SIDELENGTH), SIDELENGTH,
					SIDELENGTH));
		}
		repaint();
	}

	private void remove() {
		squares.remove(current);
		current = null;
		repaint();
	}
	
	private void remove(Point2D p){
		Rectangle2D here = find(p);
		if(p != null){
			squares.remove(here);
			repaint();
		}else{
			System.out.println("Not Found in Squares");
		}
	}

	class MouseHandler extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			if (current != null && e.getClickCount() >= 2) {
				remove();
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			super.mousePressed(e);
//			System.out.println(e.getModifiersEx()+"  "+e.BUTTON3_DOWN_MASK);
			Point2D p = (Point2D) e.getPoint();
			current = find(p);
			if (current == null) {
				if(e.getModifiersEx() == e.BUTTON1_DOWN_MASK){
					add(p);
					
			
				}
			}
		}
	}
	
	class MouseMotionHandler implements MouseMotionListener{
		@Override
		public void mouseMoved(MouseEvent e) {
//			// set cursor
//			if(find(e.getPoint()) == null){
//				setCursor(Cursor.getDefaultCursor());
//			}else{
//				setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
//			}
			add(e.getPoint());
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			if(current != null){
				System.out.println(e.getPoint().toString()+" "+ current.toString()+" "+e.getModifiersEx());
				int x = e.getX();
				int y = e.getY();
				current.setFrame(x-SIDELENGTH/2.0, y-SIDELENGTH/2.0, SIDELENGTH, SIDELENGTH);
				repaint();
			}else{
				System.out.println(e.getPoint().toString()+" Null "+e.getModifiersEx());
				if(e.getModifiersEx() == e.BUTTON3_DOWN_MASK){
					remove(e.getPoint());
					
				}
			}
		}
	}

}