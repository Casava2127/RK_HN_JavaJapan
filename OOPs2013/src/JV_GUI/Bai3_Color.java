package JV_GUI;

import java.awt.BorderLayout;import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Bai3_Color extends JFrame implements ActionListener {
	JPanel main = new JPanel(new BorderLayout(11, 11));
	JPanel panbtn = new JPanel();
	JPanel panta = new JPanel();
	JTextArea tArea = new JTextArea();
	JButton jbtnRed = new JButton("RED");
	JButton jbtnGreen = new JButton("GREEN");
	JButton jbtnBlue = new JButton("BLUE");
	JButton jbtnExit = new JButton("Exit");

	public Bai3_Color(String title) {
		super(title);
		panbtn.add(jbtnRed);
		panbtn.add(jbtnGreen);
		panbtn.add(jbtnBlue);
		panbtn.add(jbtnExit);
		jbtnRed.addActionListener(this);
		jbtnGreen.addActionListener(this);
		jbtnBlue.addActionListener(this);
		jbtnExit.addActionListener(this);
		panta.add(tArea);
		main.add("North", panta);
		main.add("South", panbtn);
		setContentPane(main);
		pack();
		setBounds(100, 100, 450, 300);
		setVisible(true);
	}
	
	public void actionPerformed (ActionEvent e) {
		if (e.getSource() == jbtnRed) {
			panta.setBackground(Color.RED);
			panbtn.setBackground(Color.RED);
			main.setBackground(Color.RED);
		}
		else {
			if (e.getSource() == jbtnGreen) {
				panta.setBackground(Color.GREEN);
				panbtn.setBackground(Color.GREEN);
				main.setBackground(Color.GREEN);
			}
			if (e.getSource() == jbtnBlue) {
				panta.setBackground(Color.BLUE);
				panbtn.setBackground(Color.BLUE);
				main.setBackground(Color.BLUE);
			}
			else {
				if (e.getSource() == jbtnExit)
				{
					this.dispose();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new Bai3_Color("Changed Backgroung Color");
	}

}
