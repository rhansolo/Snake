import java.util.Random;
public class Apple{
    private Game game;
    private int xCor;
    private int yCor;

    public Apple(Game game){
	this.game = game;
    }
    public void generatePlacement(){
	Random rand = new Random();
	int xCor = rand.nextInt((game.width + 1));
	int yCor = rand.nextInt((game.height + 1));
    }
    public int getXCor(){
	return xCor;
    }
    public int getXcor(){
	return yCor;
    }
    
}
