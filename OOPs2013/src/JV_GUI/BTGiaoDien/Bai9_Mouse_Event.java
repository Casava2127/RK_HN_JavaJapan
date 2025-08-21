package JV_GUI.BTGiaoDien;

import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Bai9_Mouse_Event extends JFrame implements MouseListener
{
	public Bai9_Mouse_Event(String title)
	{
		super(title);
		requestFocus();
		addMouseListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing (WindowEvent we) {
				dispose();
				System.exit(0);
		}
		});
	}
	public void mouseClicked(MouseEvent e) {
		if(e.isMetaDown()) return;
			else {
				System.out.println("You left click the mouse at " + e.getX() + " " + e.getY());
			}
	}
	public void mousePressed(MouseEvent e) {
		System.out.println("You press the mouse at " + e.getX() + " " + e.getY());
	}
	public void mouseReleased(MouseEvent e) {
		System.out.println("You release the mouse at " + e.getX() + " " + e.getY());
	}
	public void mouseEntered(MouseEvent e) {
		System.out.println("You enter the mouse at " + e.getX() + " " + e.getY());
	}
	public void mouseExited(MouseEvent e) {
		System.out.println("You exit the window at " + e.getX() + " " + e.getY());
	}
	public static void main(String[] args) {
		Bai9_Mouse_Event mEvent = new Bai9_Mouse_Event("Mouse Test");
		mEvent.setBounds(100, 100, 300, 200);
		mEvent.setVisible(true);
	}
}
