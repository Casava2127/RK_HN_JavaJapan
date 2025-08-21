package JV_GUI.BTGiaoDien;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Bai6_ActionEvent extends JFrame implements ActionListener {
	JButton button;
	JTextField tField;
	List list;
	JLabel label;

	Bai6_ActionEvent(String tile) {
		super(tile);
		setLayout(new FlowLayout());
		
		button = new JButton("OK");
		tField = new JTextField(12);
		list = new List(3);
		list.add("Tiger");
		list.add("Lion");
		list.add("Elephant");
		list.add("Fox");
		list.add("Monkey");
		
		label = new JLabel("The event is displayed here");
		add(button); add(tField); add(list); add(label);
		
		button.addActionListener(this);
		tField.addActionListener(this);
		list.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing (WindowEvent we) {
				dispose();
				System.exit(0);
		}
		});
	}
	
	public void actionPerformed (ActionEvent e) 
	{
		if (e.getSource() == button) label.setText("You Click on the Button");
		else if (e.getSource() == tField) label.setText("You Enter in the TextField");
		else if (e.getSource() == list) label.setText("You Double Click on List");
	}
	
	public static void main(String[] args) {
		Bai6_ActionEvent aEvent = new Bai6_ActionEvent("Action Event");
		aEvent.setBounds(100, 100, 300, 200);
		aEvent.show();
	}
}
