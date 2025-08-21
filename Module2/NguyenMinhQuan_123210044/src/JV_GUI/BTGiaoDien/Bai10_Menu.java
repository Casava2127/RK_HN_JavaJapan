package JV_GUI.BTGiaoDien;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
class Bai10_Menu extends JFrame 
{
	public Bai10_Menu(String title) {
		super(title);
		setBounds(300, 200, 200, 200);
		MenuBar menuBar = new MenuBar();
		setMenuBar(menuBar);
		Menu f = new Menu("File");
		f.add(new MenuItem("File"));
		f.add(new MenuItem("Open"));
		f.add(new MenuItem("Exit"));
		menuBar.add(f);
		Menu editMenu = new Menu("Edit");
		editMenu.add(new MenuItem("Copy"));
		editMenu.add(new MenuItem("Cut"));
		editMenu.add(new MenuItem("Paste"));
		Menu subMenu = new Menu("Option");
		subMenu.add(new MenuItem("First"));
		subMenu.add(new MenuItem("Second"));
		subMenu.add(new MenuItem("Third"));
		editMenu.add(subMenu);
		editMenu.add(new CheckboxMenuItem("Protected"));
		menuBar.add(editMenu);
		show();
	}
	public static void main(String[] args) {
		new Bai10_Menu("Menu Demo");
	}
}