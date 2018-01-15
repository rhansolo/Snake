import java.util.*;
import java.awt.Graphics;
import java.awt.Color;

public class Snake extends Entity{

    private ArrayList<Coordinate> coordList= new ArrayList<Coordinate>();
    private Game game;
    private String lastDirection= "RIGHT";
    private String currDirection= "RIGHT";

    public Snake(Game game, int  x, int  y) {
	super(x, y);
	this.game = game;
	coordList.add(0,new Coordinate(10,10));
	coordList.add(1,new Coordinate(110,10));
	coordList.add(2,new Coordinate(210,10));
	coordList.add(3, new Coordinate(310,10));
	coordList.add(4, new Coordinate(410,10));
	coordList.add(5, new Coordinate(510,10));
	coordList.add(6, new Coordinate(610,10));
	coordList.add(7, new Coordinate(710,10));


    }

    public void tick() {
      int  xCor = (int)coordList.get(0).getXcor();
    	int  yCor = (int)coordList.get(0).getYcor();
      for (int i = 1; i < coordList.size(); i++){
        if ((xCor == (int)coordList.get(i).getXcor()) && (yCor == (int)coordList.get(i).getYcor())){
          System.exit(0);
        }
      }
 	Coordinate newHead;
	System.out.println(lastDirection);
	currDirection = game.getKeyManager().direction;
	System.out.println(currDirection);
	if(currDirection.equals("RIGHT")){
	    newHead = new Coordinate(coordList.get(0).getXcor()+1,coordList.get(0).getYcor());
	    coordList.add(0,newHead);
	    coordList.remove(coordList.size() - 1);
	}
	else if(currDirection.equals("LEFT")){
	    newHead = new Coordinate(coordList.get(0).getXcor()-1,coordList.get(0).getYcor());
	    coordList.add(0,newHead);
	    coordList.remove(coordList.size() - 1);

	}
	else if(currDirection.equals("UP")){
	    newHead = new Coordinate(coordList.get(0).getXcor(),coordList.get(0).getYcor()-1);
	    coordList.add(0,newHead);
	    coordList.remove(coordList.size() - 1);
	}
	else if(currDirection.equals("DOWN")){
	    newHead = new Coordinate(coordList.get(0).getXcor(),coordList.get(0).getYcor()+1);
	    coordList.add(0,newHead);
	    coordList.remove(coordList.size() - 1);

	}
	checkCollision();
  lastDirection = currDirection;
    }
    public void render(Graphics g) {
	g.setColor(Color.GREEN);
	//System.out.println(coordList.size());
	for (Coordinate c: coordList){
	    g.fillRect((int)c.getXcor()*10, (int)c.getYcor()*10, 10, 10);
	}
	g.setColor(Color.BLACK);
    }

    public void grow(){
      int last = coordList.size()-1;
      double dx = coordList.get(last-2).xcor - coordList.get(last-1).xcor;
      double dy = coordList.get(last-1).ycor - coordList.get(last-1).ycor;
      Coordinate temp = new Coordinate(dx,dy);
      coordList.add(temp);
    }

    public boolean eat(Apple food){
      int xtemp = (int)coordList.get(0).xcor;
      int ytemp = (int)coordList.get(0).ycor;
      if (xtemp == food.getXcor() / 10 || xtemp == food.getXcor() / 10 + 1){
        if (ytemp == food.getYcor() / 10 || ytemp == food.getYcor() / 10 + 1){
          return true;
        }
      }
      return false;
    }
    public ArrayList<Coordinate> getCoordList(){
      return this.coordList;
    }
    public void checkCollision(){
    	int  xCor = (int)coordList.get(0).getXcor();
    	int  yCor = (int)coordList.get(0).getYcor();
    	/*System.out.println("width: " + game.width);
    	System.out.println(xCor);
    	System.out.println("length : " + game.height);
    	System.out.println(yCor);
      */
      // Not sure why this doesn't work !!!!!!
      /*for (int i = 1; i < coordList.size(); i++){
        if ((xCor == (int)coordList.get(i).getXcor()) && (yCor == (int)coordList.get(i).getYcor())){
          System.exit(0);
        }
      }
      */
      if (lastDirection.equals("RIGHT") && currDirection.equals("LEFT")){
        System.exit(0);
      }
      if (lastDirection.equals("LEFT") && currDirection.equals("RIGHT")){
        System.exit(0);
      }
      if (lastDirection.equals("UP") && currDirection.equals("DOWN")){
        System.exit(0);
      }
      if (lastDirection.equals("DOWN") && currDirection.equals("UP")){
        System.exit(0);
      }
    	if ( xCor*10 > game.width || xCor == 0 || yCor*10 > game.height || yCor == 0){
    		System.exit(0);
    	}
    }

}
