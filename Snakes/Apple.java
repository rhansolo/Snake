import java.util.Random;
import java.awt.Graphics;
import java.awt.Color;
public class Apple {
    private Game game;
    int xCor, yCor;

    public Apple(Game game){
      Random rand = new Random();
      xCor = rand.nextInt((game.width + 1));
      yCor = rand.nextInt((game.height + 1));
	    this.game = game;
    }
    /*public void generatePlacement(){
	     Random rand = new Random();
	     int xCor = rand.nextInt((game.width + 1));
	     int yCor = rand.nextInt((game.height + 1));
    }
    */
    public void tick(){

    }
    public void render(Graphics g){
      g.setColor(Color.RED);
      g.fillOval(xCor,yCor,10,10);
      g.setColor(Color.BLACK);
    }
    public int getXCor(){
	     return xCor;
    }
    public int getXcor(){
	     return yCor;
    }

}
