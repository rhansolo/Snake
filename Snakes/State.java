import java.awt.Graphics;
//class for the base of Game and Menu State
public abstract class State {
    
    protected Game game;
    
    private static State currentState = null;
    
    public State(Game game){
	    this.game = game;
	}
    
    public static void setState(State state){
	currentState = state;
    }

    public static State getState(){
	return currentState;
    }
    public int getScore(){return 0;}
    public void setScore(int score){};
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
    
}
