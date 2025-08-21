package JV_GUI.BTGiaoDien;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


@SuppressWarnings("serial")
public class Bai7_Items_Event extends JFrame implements ItemListener 
{
	Checkbox male, female;
	Choice ch;
	List list;
	JLabel label;
	Bai7_Items_Event(String title) {
		super(title);
		setLayout(new FlowLayout());
		male = new Checkbox("Male");
		female = new Checkbox("Female");
		ch = new Choice();
		ch.add("MS DOS");
		ch.add("MS Windows");
		ch.add("UNIX");
		list = new List(3);
		list.add("Tiger");
		list.add("Lion");
		list.add("Elephant");
		list.add("Fox");
		list.add("Monkey");
		label = new JLabel("The event is displayed here");
		add (male); add(female); add(ch); add(list); add(label);
		male.addItemListener(this);
		female.addItemListener(this);
		ch.addItemListener(this);
		list.addItemListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing (WindowEvent we) {
				dispose();
				System.exit(0);
		}
		});
	}
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == male)
			if(male.getState()) label.setText("You select male item");
			else label.setText("You deselect male item");
		else if(e.getSource() == female) 
			if(female.getState()) label.setText("You select female item");
			else label.setText("You deselect female item");
		else if(e.getSource() == ch) label.setText("You select " + ch.getSelectedItem() + " in the choice");
		else if(e.getSource() == list) label.setText("You seclect " + list.getSelectedItem() + " on the list");
	}
	public static void main(String[] args) {
		Bai7_Items_Event w = new Bai7_Items_Event("Items Event");
		w.setBounds(100, 100, 300, 200);
		w.show();
	}
}