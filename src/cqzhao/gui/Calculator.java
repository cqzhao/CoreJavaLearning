package cqzhao.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculator {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				CalculatorFrame cf = new CalculatorFrame();
				cf.setDefaultCloseOperation(cf.EXIT_ON_CLOSE);
				cf.setVisible(true);
				cf.setTitle("Calculator");
			}
		});
	}

}

class CalculatorFrame extends JFrame {
	public CalculatorFrame() {
		setBounds(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);
		CalculatorPanel cp = new CalculatorPanel();
		add(cp);
	}

	private final int DEFAULT_WIDTH = 300;
	private final int DEFAULT_HEIGHT = 300;
}

class CalculatorPanel extends JComponent {
	private JButton display = null;
	private JPanel btns = null;
	private double result = 0.0;
	private StringBuilder first = new StringBuilder("");
	private StringBuilder second = new StringBuilder("");
	// + - * / = is 1 to 5, respectively.
	private int command = 0;
	private String cmd = "+-*/=";

	public CalculatorPanel() {
		display = new JButton("0");
		setLayout(new BorderLayout());
		add(display, BorderLayout.NORTH);
		display.setAlignmentY(RIGHT_ALIGNMENT);
		display.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				result = 0.0;
				command = 0;
				first.delete(0, first.length());
				second.delete(0, second.length());
				display.setText(result + "");

			}
		});

		btns = new JPanel();
		btns.setLayout(new GridLayout(4, 4));

		btns.add(makeButton("7", new InputAction()));
		btns.add(makeButton("8", new InputAction()));
		btns.add(makeButton("9", new InputAction()));
		btns.add(makeButton("/", new CommandAction()));

		btns.add(makeButton("4", new InputAction()));
		btns.add(makeButton("5", new InputAction()));
		btns.add(makeButton("6", new InputAction()));
		btns.add(makeButton("*", new CommandAction()));

		btns.add(makeButton("1", new InputAction()));
		btns.add(makeButton("2", new InputAction()));
		btns.add(makeButton("3", new InputAction()));
		btns.add(makeButton("-", new CommandAction()));

		btns.add(makeButton("0", new InputAction()));
		btns.add(makeButton(".", new InputAction()));
		btns.add(makeButton("=", new CommandAction()));
		btns.add(makeButton("+", new CommandAction()));

		add(btns, BorderLayout.CENTER);

	}

	private JButton makeButton(String text, ActionListener al) {
		JButton bt = new JButton(text);
		bt.addActionListener(al);
		return bt;
	}

	class InputAction implements ActionListener {
		@Override
		public void actionPerformed(java.awt.event.ActionEvent e) {
			String current = ((JButton) e.getSource()).getText();
			second.append(current);
			display.setText(second.toString());

		}
	}

	class CommandAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String current = ((JButton) e.getSource()).getText();
//			command = cmd.indexOf(current) + 1;
			int tempcmd = cmd.indexOf(current) + 1;
			System.out.println(first.toString()+" "+ second.toString()+" "+ result);
//			switch (command) {
			switch (tempcmd) {
			case 1:
			case 2:
			case 3:
			case 4:
				if(first.length() == 0){
					first.append(second);
					second.delete(0, second.length());
				}else{
					result = calResult(first, second, command);
					display.setText(result + "");
					first.delete(0, first.length());
					first.append(result);
					second.delete(0, second.length());
				}
				command = tempcmd;
				break;
			case 5:
				result = calResult(first, second, command);
				display.setText(result + "");
				first.delete(0, first.length());
				first.append(result);
				second.delete(0, second.length());

			}

		}
	}
	private double calResult(StringBuilder first, StringBuilder second, int cmd){
		double f1, f2, result;
		if(first.length()==0){
			f1 = 0.0;
		}else{
			f1 = Double.parseDouble(first.toString());
		}
		if(second.length()==0){
			f2 = 0.0;
		}else{
			f2 = Double.parseDouble(second.toString());
		}
		switch(cmd){
		case 1:
			result = f1 + f2;
			break;
		case 2:
			result = f1 - f2;
			break;
		case 3:
			result  = f1 * f2;
			break;
		case 4:
			result  = f1 / f2;
			break;
		
		default:
			result = 0;
			}
		return result;
	}
}