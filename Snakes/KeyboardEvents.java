import java.io.*;
import java.util.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeyboardEvents extends JPanel {
	
	public KeyboardEvents() {
		KeyListener listener = new MyKeyListener();
		addKeyListener(listener);
		setFocusable(true);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("test");
		KeyboardEvents  keyboardExample = new KeyboardEvents();
		frame.add(keyboardExample);
		frame.setSize(200, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public class MyKeyListener implements KeyListener {
		public void keyTyped(KeyEvent e) {
		}
		public void keyPressed(KeyEvent e) {
		    if (KeyEvent.getKeyText(e.getKeyCode()) == "Space"){
			System.exit(0);
		    }
			System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
		}
		public void keyReleased(KeyEvent e) {
			System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
		}
	}
}

