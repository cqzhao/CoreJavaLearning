package cqzhao.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;

public class ButtonTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				ButtonPanel bp = new ButtonPanel();
				bp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				bp.setVisible(true);
			}
		});
	}

}

class ButtonPanel extends JFrame {
	public ButtonPanel() {
		setSize(300,300);
//		JComponent jc = new JComponent() {
//			public void paintComponent(Graphics g){
//				
//			}
//		};
		jc = new JPanel();
		add(jc);
		
//		JButton yellowButton = new JButton("Yellow");
//		JButton redButton = new JButton("Red");
//		JButton blueButton = new JButton("Blue");
//		colorAction yA = new colorAction(Color.YELLOW);
//		colorAction rA = new colorAction(Color.red);
//		colorAction bA = new colorAction(Color.blue);
//		yellowButton.addActionListener(yA);
//		redButton.addActionListener(rA);
//		blueButton.addActionListener(bA);
//		jc.add(yellowButton);
//		jc.add(blueButton);
//		jc.add(redButton);
		
//		makeButton("Yellow", Color.yellow);
//		makeButton("red", Color.red);
//		makeButton("blue", Color.blue);
		
		
		colorAction yA = new colorAction("yellow", new ImageIcon("blue-ball.gif"), Color.YELLOW);
		colorAction rA = new colorAction("red", new ImageIcon("blue-ball.gif"), Color.red);
		colorAction bA = new colorAction("blue", new ImageIcon("blue-ball.gif"), Color.blue);
		colorAction gA = new colorAction("green", new ImageIcon("blue-ball.gif"), Color.green);
		JButton blueButton = new JButton(bA);
		jc.add(blueButton);
		JButton redButton = new JButton(rA);
		jc.add(redButton);
		JButton yellowButton = new JButton(yA);
		jc.add(yellowButton);
		JButton greenButton = new JButton(gA);
		jc.add(greenButton);
		
		InputMap imap = jc.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		ActionMap amap = jc.getActionMap();

		KeyStroke yKey = KeyStroke.getKeyStroke("shift Y");
		if(yKey == null){
			System.out.println("Null");
		}else{
			System.out.println(yKey.toString());
		}
		imap.put(yKey, "jc.Yellow");
		amap.put("jc.Yellow", yA);

		KeyStroke rKey = KeyStroke.getKeyStroke("ctrl shift R");
		imap.put(rKey, "jc.red");
		amap.put("jc.red", rA);
		
		KeyStroke bKey = KeyStroke.getKeyStroke("esc");
		if(bKey == null){
			System.out.println("Null");
		}else{
			System.out.println(bKey.toString());
		}
		imap.put(bKey, "jc.b");
		amap.put("jc.b", bA);
		

	}
	
	public void makeButton(String name,final Color c){
		JButton jb = new JButton(name);
		jc.add(jb);
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jc.setBackground(c);				
			}
		});
	}


//	class colorAction implements ActionListener {
//		public colorAction(Color c) {
//			bgColor = c;
//		}
//
//		@Override
//		public void actionPerformed(ActionEvent event) {
//			jc.setBackground(bgColor);
//			System.out.println(bgColor.toString());
//		}
//		private Color bgColor;
//	}
	class colorAction extends AbstractAction {
		public colorAction(String name, ImageIcon icon, Color c) {
			putValue(Action.NAME, name);
			putValue(Action.SMALL_ICON, icon);
			putValue("color", c);
			putValue(Action.SHORT_DESCRIPTION, "change the color to given color");
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			jc.setBackground((Color) getValue("color"));
		}
	}

	private JPanel jc;

}