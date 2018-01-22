import java.util.Random;
import java.awt.Graphics;
import java.awt.Color;
public class Apple {
    private Game game;
    int xCor, yCor;

    public Apple(Game game){
      Random rand = new Random();
      // generates a randomn location for the apple to spawn
      xCor = rand.nextInt((game.width + 1));
      yCor = rand.nextInt((game.height + 1));
      while ((xCor / 10 < 10) || (xCor / 10 > game.width / 10 - 5)){
        xCor = rand.nextInt((game.width + 1));
      }
      while ((yCor / 10 > game.height / 10 - 5 )|| (yCor / 10 < 9)){
        yCor = rand.nextInt((game.width + 1));
      }
	    this.game = game;
    }
    //draws the apple on the screen
    public void render(Graphics g){
      g.setColor(Color.RED);
      g.fillOval(xCor,yCor,10,10);
      g.setColor(Color.BLACK);
    }
    //accessors
    public int getXcor(){
	     return xCor;
    }
    public int getYcor(){
	     return yCor;
    }

}
