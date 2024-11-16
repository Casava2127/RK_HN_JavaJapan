package JV_GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
class Bai4_ChuoiKyTu extends JFrame implements ActionListener 
{
	JLabel lb1, lb2, lb3, lb4, lb5;
	JTextField tField1, tField2, tField3, tField4, tField5;
	JButton okButton, resetButton, exitButton;
	JPanel pn1, pn2, pn;
	
	public Bai4_ChuoiKyTu(String title) {
		super(title);
		GUI();
	}
	
	public void GUI()
	{
		lb1 = new JLabel("Enter a String");
		lb2 = new JLabel("To UpperCase");
		lb3 = new JLabel("To LowerCase");
		lb4 = new JLabel("To LowUpper");
		lb5 = new JLabel("Number of word");
		
		tField1 = new JTextField();
		tField2 = new JTextField();
		tField3 = new JTextField();
		tField4 = new JTextField();
		tField5 = new JTextField();
		
		okButton = new JButton("OK");
		resetButton = new JButton("Reset");
		exitButton = new JButton("Exit");
		
		okButton.addActionListener(this);
		resetButton.addActionListener(this);
		exitButton.addActionListener(this);
		
		pn = new JPanel(new GridLayout(2, 1));
		pn1 = new JPanel(new GridLayout(5, 2));
		pn2 = new JPanel(new FlowLayout());
		
		pn1.add(lb1);
		pn1.add(tField1);
		pn1.add(lb2);
		pn1.add(tField2);
		pn1.add(lb3);
		pn1.add(tField3);
		pn1.add(lb4);
		pn1.add(tField4);
		pn1.add(lb5);
		pn1.add(tField5);
		
		pn2.add(okButton);
		pn2.add(resetButton);
		pn2.add(exitButton);
		
		pn.add(pn1);
		pn.add(pn2);
		
		add(pn);
		
		//setBounds(100, 100, 450, 300);
		setSize(500, 300);
		show();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == okButton) {
			String string = tField1.getText();
			int count = 0;
			char SPACE = ' ';
			int size = string.length();
			Boolean notCount = true;
			for(int i = 0; i < size; i++) {
				if(string.charAt(i) != SPACE) {
					if(notCount) {
						count ++;
						notCount = false;
					}
				}
				else notCount = true;
			}
			String string2 = string;
			char[] s = string2.toCharArray();
			string2 = "";
			for(int j = 0; j < s.length; j++) {
				int ascii = s[j];
				if(ascii >= 65 && ascii <= 90) {
					string2 += (char)(ascii += 32);
				}
				
				else if(ascii >= 97 && ascii <= 122 )
				{
					string2 += (char)(ascii -= 32);
				}
				else string2 += (char)(ascii);
			}
			
			tField2.setText(string.toUpperCase());
			tField3.setText(string.toLowerCase());
			tField4.setText(string2);
			tField5.setText(Integer.toString(count)); 
			
		}
		else if(e.getSource() == resetButton) {
			tField1.setText("");
			tField2.setText("");
			tField3.setText("");
			tField4.setText("");
			tField5.setText("");
		}
		else if(e.getSource() == exitButton) {
			System.exit(0);
		}
			
	}
	
	public static void main(String[] args) {
		new Bai4_ChuoiKyTu("Xử lý chuỗi ký tự");
	}
}