package JV_GUI;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


@SuppressWarnings("serial")
public class Bai2_Arithmetic_Operations extends JFrame implements ActionListener 
{
	JLabel lb1, lb2, lb3, lb;
	JTextField txt1, txt2, txt3;
	JButton cong, tru, nhan, chia, reset, exit;
	JPanel pn1, pn2, pn3, pn4, pn;

	public Bai2_Arithmetic_Operations(String title) {
		super(title);
		GUI();
	}
	
	public void GUI() {
		lb = new JLabel("Basic Arithmetic Operations");
		lb1 = new JLabel("Number 1:");
		lb2 = new JLabel("Number 2:");
		lb3 = new JLabel("Result:");
		
		txt1 = new JTextField();
		txt2 = new JTextField();
		txt3 = new JTextField();
		
		cong = new JButton("Addition");
		tru = new JButton("Subtracton");
		nhan = new JButton("Multiplication");
		chia = new JButton("Division");
		reset = new JButton("Reset");
		exit = new JButton("Exit");
		
		cong.addActionListener(this);
		tru.addActionListener(this);
		nhan.addActionListener(this);
		chia.addActionListener(this);
		reset.addActionListener(this);
		exit.addActionListener(this);
		
		pn = new JPanel(new GridLayout(4, 1));
		pn1 = new JPanel();
		pn2 = new JPanel(new GridLayout(3, 2));
		pn3 = new JPanel(new FlowLayout());
		pn4 = new JPanel(new FlowLayout());
		
		pn1.add(lb);
		
		pn2.add(lb1);
		pn2.add(txt1);
		pn2.add(lb2);
		pn2.add(txt2);
		pn2.add(lb3);
		pn2.add(txt3);
		
		pn3.add(cong);
		pn3.add(tru);
		pn3.add(nhan);
		pn3.add(chia);
		
		pn4.add(reset);
		pn4.add(exit);
		
		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);
		pn.add(pn4);
		
		add(pn);
		
		setSize(500, 300);
		show();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cong) {
			int a = Integer.parseInt(txt1.getText());
			int b = Integer.parseInt(txt2.getText());
			txt3.setText(Integer.toString(a+b));
		}
		if (e.getSource() == tru) {
			int a = Integer.parseInt(txt1.getText());
			int b = Integer.parseInt(txt2.getText());
			txt3.setText(Integer.toString(a-b));
		}
		if (e.getSource() == nhan) {
			int a = Integer.parseInt(txt1.getText());
			int b = Integer.parseInt(txt2.getText());
			txt3.setText(Integer.toString(a*b));
		}
		if (e.getSource() == chia){
			int a = Integer.parseInt(txt1.getText());
			int b = Integer.parseInt(txt2.getText());
			txt3.setText(Float.toString((float)a/b));
		}
		if(e.getSource() == reset) {
			txt1.setText("");
			txt2.setText("");
			txt3.setText("");
		}
		
		if(e.getSource() == exit) System.exit(0);
	}

	public static void main(String[] args) {
		new Bai2_Arithmetic_Operations("Arithmetic Operations");
	}
}
