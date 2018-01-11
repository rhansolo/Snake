import java.io.*;
import java.util.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeyboardEvents extends JPanel {
    public String direction;
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
        public String direction;
		    public void keyTyped(KeyEvent e) {
		      }
		    public void keyPressed(KeyEvent e) {
		    //String key = KeyEvent.getKeyText(e.getKeyCode());
		    if (KeyEvent.getKeyText(e.getKeyCode()) == "Space"){
			       System.exit(0);
		    }
		    else if (KeyEvent.getKeyText(e.getKeyCode()).equals("W") ){
			       direction = "UP";
		    }
		    else if (KeyEvent.getKeyText(e.getKeyCode()).equals("A")){
			       direction = "LEFT";
		    }
		    else if (KeyEvent.getKeyText(e.getKeyCode()).equals("S")){
			       direction = "DOWN";
		    }
		    else if (KeyEvent.getKeyText(e.getKeyCode()).equals("D")){
			       direction = "RIGHT";
		    }
		    System.out.println(direction);
		}
		public void keyReleased(KeyEvent e) {
		}
	}
}
