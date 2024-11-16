package JV_GUI;

import java.awt.EventQueue;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.security.PublicKey;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Bai8_KeyEvent extends JFrame implements KeyListener {
	Label label;
	Bai8_KeyEvent(String title) {
		super (title);
		label = new Label("A", label.CENTER);
		add(label);
		requestFocus();
		addKeyListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing (WindowEvent we) {
				dispose();
				System.exit(0);
		}
		});
	}
	
	public void keyTyped (KeyEvent e) {
		label.setText(String.valueOf(e.getKeyChar()));
	}
	
	public void keyPressed (KeyEvent e) {}
	public void keyRealeased (KeyEvent e) {}

	public static void main(String[] args) {
		Bai8_KeyEvent keyEvent = new Bai8_KeyEvent("Key Event Test");
		keyEvent.setBounds(100, 100, 300, 300);
		keyEvent.setVisible(true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
