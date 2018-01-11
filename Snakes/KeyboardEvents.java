import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.KeyEvent;
  public class KeyboardEvents implements KeyListener {
      public String direction;
      public void keyTyped(KeyEvent e) {
      }
      public static void tick(){

      }
      public void keyPressed(KeyEvent e) {
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
      }
      public void keyReleased(KeyEvent e) {
      }
  }
