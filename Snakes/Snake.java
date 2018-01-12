import java.util.*;
import java.awt.Graphics;
import java.awt.Color;

public class Snake extends Entity{
    private int startingLength;
    
    private ArrayList<Coordinate> coordList= new ArrayList<Coordinate>();
    private Game game;

    public Snake(Game game, double x, double y) {
	super(x, y);
	this.game = game;
	startingLength = 3;
	coordList.add(0,new Coordinate(10.0,10.0));
	coordList.add(1,new Coordinate(11.0,10.0));
	coordList.add(2,new Coordinate(12.0,10.0));
    }
    
    public void tick() {
	Coordinate newHead;
	if(game.getKeyManager().direction.equals("RIGHT")){
	    newHead = new Coordinate(coordList.get(0).getXcor()+.5,coordList.get(0).getYcor());
	    coordList.add(0,newHead);
	    coordList.remove(coordList.size() - 1);
	}
	else if(game.getKeyManager().direction.equals("LEFT")){
	    newHead = new Coordinate(coordList.get(0).getXcor()-.5,coordList.get(0).getYcor());
	    coordList.add(0,newHead);
	    coordList.remove(coordList.size() - 1);
	}
	else if(game.getKeyManager().direction.equals("UP")){
	    newHead = new Coordinate(coordList.get(0).getXcor(),coordList.get(0).getYcor()-.5);
	    coordList.add(0,newHead);
	    coordList.remove(coordList.size() - 1);
	}
	else if(game.getKeyManager().direction.equals("DOWN")){
	    newHead = new Coordinate(coordList.get(0).getXcor(),coordList.get(0).getYcor()+.5);
	    coordList.add(0,newHead);
	    coordList.remove(coordList.size() - 1);
	}
		checkCollision();
    }
    public void render(Graphics g) {
	g.setColor(Color.GREEN);
	for (Coordinate c: coordList){
	    g.fillRect((int)c.getXcor() * 10, (int)c.getYcor() * 10, 10, 10);
	}
	g.setColor(Color.BLACK);
    }
    public void checkCollision(){
    	int  xCor = (int)coordList.get(0).getXcor();
    	int  yCor = (int)coordList.get(0).getYcor();
    	System.out.println("width: " + game.width);
    	System.out.println(xCor);
    	System.out.println("length : " + game.height);
    	System.out.println(yCor);
    	if ( xCor*10 > game.width || xCor == 0 || yCor*10 > game.height || yCor == 0){
    		System.exit(0);
    	}
    }
    
}
