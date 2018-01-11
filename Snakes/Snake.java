import java.util.*;
import java.awt.Graphics;

public class Snake extends Entity{
    private int startingLength;

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
	    	Coordinate newHead;
		  if(game.getKeyManager().direction.equals("RIGHT"))
		      newHead = new Coordinate(coordList.get(0).getXcor()+1,coordList.get(0).getYcor());
		  else if(game.getKeyManager().direction.equals("LEFT"))
		      newHead = new Coordinate(coordList.get(0).getXcor()-1,coordList.get(0).getYcor());
		  else if(game.getKeyManager().direction.equals("UP"))
		      newHead = new Coordinate(coordList.get(0).getXcor(),coordList.get(0).getYcor()+1);
		  else if(game.getKeyManager().direction.equals("DOWN"))
		      newHead = new Coordinate(coordList.get(0).getXcor(),coordList.get(0).getYcor()-1);
		  coordList.add(0,newHead);
		  coordList.remove(coordList.size() - 1);
	      }
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
