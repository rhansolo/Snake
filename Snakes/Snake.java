import java.util.*;
import java.awt.Graphics;

public class Snake extends Entity{
    private int startingLength;
    private String[] direction = {"UP","DOWN","LEFT","RIGHT"};

    private ArrayList<Coordinate> coordList= new ArrayList<Coordinate>(3);
    private Game game;

	  public Snake(Game game, float x, float y) {
		    super(x, y);
		    this.game = game;
        startingLength = 3;
        segmentList.set(0,new Segment(0,0));
        segmentList.set(1,new Segment(1,0));
        segmentList.set(2,new Segment(2,0));
	  }

	  @Override
	  public void tick() {
		    if(game.getKeyManager().up)
			     y -= 3;
		    if(game.getKeyManager().down)
			     y += 3;
		    if(game.getKeyManager().left)
			     x -= 3;
		    if(game.getKeyManager().right)
			     x += 3;
	   }

	  @Override
	  public void render(Graphics g) {
      g.setColor(Color.GREEN);
      for (Coordinate c: coordList){
        g.fillRect(c.x * BOX_WIDTH, c.y * BOX_HEIGHT, BOX_WIDTH, BOX_HEIGHT);
      }
      g.setColor(Color.BLACK);
	  }

}
