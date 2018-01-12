import java.util.*;
import java.awt.Graphics;
import java.awt.Color;

public class Snake extends Entity{
    private int startingLength;
    
    private ArrayList<Coordinate> coordList= new ArrayList<Coordinate>();
    private Game game;

    public Snake(Game game, float x, float y) {
	super(x, y);
	this.game = game;
	startingLength = 3;
	coordList.add(0,new Coordinate(0,0));
	coordList.add(1,new Coordinate(1,0));
	coordList.add(2,new Coordinate(2,0));
    }
    
    public void tick() {
	Coordinate newHead;
	if(game.getKeyManager().direction.equals("RIGHT")){
	    newHead = new Coordinate(coordList.get(0).getXcor()+1,coordList.get(0).getYcor());
	    coordList.add(0,newHead);
	    coordList.remove(coordList.size() - 1);
	}
	else if(game.getKeyManager().direction.equals("LEFT")){
	    newHead = new Coordinate(coordList.get(0).getXcor()-1,coordList.get(0).getYcor());
	    coordList.add(0,newHead);
	    coordList.remove(coordList.size() - 1);
	}
	else if(game.getKeyManager().direction.equals("UP")){
	    newHead = new Coordinate(coordList.get(0).getXcor(),coordList.get(0).getYcor()+1);
	    coordList.add(0,newHead);
	    coordList.remove(coordList.size() - 1);
	}
	else if(game.getKeyManager().direction.equals("DOWN")){
	    newHead = new Coordinate(coordList.get(0).getXcor(),coordList.get(0).getYcor()-1);
	    coordList.add(0,newHead);
	    coordList.remove(coordList.size() - 1);
	}
    }
    public void render(Graphics g) {
	g.setColor(Color.GREEN);
	for (Coordinate c: coordList){
	    g.fillRect(c.getXcor() * 10, c.getYcor() * 10, 10, 10);
	}
	g.setColor(Color.BLACK);
    }
    
}
