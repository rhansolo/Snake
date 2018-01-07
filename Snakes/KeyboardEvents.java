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
		    else if (KeyEvent.getKeyText(e.getKeyCode()).equals("W")){
			System.out.println("move snake up");
		    }
		    else if (KeyEvent.getKeyText(e.getKeyCode()).equals("A")){
			System.out.println("move snake left");
		    }
		    else if (KeyEvent.getKeyText(e.getKeyCode()).equals("S")){
			System.out.println("move snake down");
		    }
		    else if (KeyEvent.getKeyText(e.getKeyCode()).equals("D")){
			System.out.println("move snake right");
		    }
		      
		}
		public void keyReleased(KeyEvent e) {
		}
	}
}

