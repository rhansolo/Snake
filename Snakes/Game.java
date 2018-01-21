import java.util.*;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
    private Display display;
    //properties
    int height, width;
    String title;
    boolean running;
    int lives;
    boolean lifeDecreased;
    boolean paused;

    //game variables
    private Thread thread;
    private BufferStrategy bs;
    private Graphics g;

    //States
    private State gameState;
    private State menuState;

    //Input
    private KeyboardEvents keyManager;

    public Game(String title, int width, int height){
	this.width = width;
	this.height = height;
	this.title = title;
	keyManager = new KeyboardEvents();

	lives = 3;
    }
    //decrease life of the snake after collision
    public void decreaseLife(){
	lives --;
	lifeDecreased = true;
	System.out.println("here");
    }
    //sets screen for the beginning of the game
    private void init(){
	display = new Display(title, width, height);
	display.getFrame().addKeyListener(keyManager);

	gameState = new GameState(this,0);
	menuState = new Menu(this);
	State.setState(gameState);
	//State.setState(menuState);
    }
    //resets screen when snake loses a life;
    private void initNewLife(){
	int tmp = gameState.getScore();
	gameState = new GameState(this,tmp);
       	State.setState(gameState);
    }
    //regular tick when game is ongoing
    private void tick(){
	KeyboardEvents.tick();
	if (State.getState() != null){
	    State.getState().tick();
	}
    }
    //keyboard still looking for space pressed by the player if game is paused
    private void tick2(){
	KeyboardEvents.tick();
    }
    private void render(){

	bs = display.getCanvas().getBufferStrategy();
	if(bs == null){
	    display.getCanvas().createBufferStrategy(3);
	    return;
	}
	g = bs.getDrawGraphics();
	//Clear Screen
	g.clearRect(0, 0, width, height);
	//Draw Here!

	if(State.getState() != null)
	    State.getState().render(g);

	//End Drawing!
	bs.show();
	g.dispose();

    }
    //main method of the game
    public void run(){
	init();
	int fps = 30;
	double timePerTick = 1000000000 / fps;
	double delta = 0;
	long now;
	long lastTime = System.nanoTime();
	long timer = 0;
	int ticks = 0;
	boolean restart = true;
	while (restart){
	    while(lives > 0){
		if (!keyManager.pause){	    
		    now = System.nanoTime();
		    delta += (now - lastTime) / timePerTick;
		    timer += now - lastTime;

		    lastTime = now;
		    
		    if(delta >= 1){
			tick();
			render();
			ticks++;
			delta--;
		    }
		    
		    if(timer >= 1000000000){
			System.out.println("Ticks and Frames: " + ticks);
			ticks = 0;
			timer = 0;
		    }
		    //checks if the snake lost a life
		    if (lifeDecreased){
			lifeDecreased = false;
			int tmp = gameState.getScore();
			System.out.println(tmp);
			initNewLife();
			display.getTxtLives().setText("Lives:  " + lives);
			display.getTxtCurrentScore().setText("Current Score:  " + tmp);
			
		    }
		}
		//gets here if game is paused
		else{
		    now = System.nanoTime();
		    timer += now - lastTime;
		    lastTime = now;
		    delta += (now - lastTime) / timePerTick;
		    if(delta >= 1){
			tick2();
		    }
		    
		}
	    }
	    //pops up when all 3 lives are used. 
	    int p =JOptionPane.showConfirmDialog(null,"Try Again?","Game Over",JOptionPane.YES_NO_OPTION);
	    // game ends, system exits
	    if ( p == 1){
		System.out.println("option1");
		restart = false;
	    }
	    // game restarts, scores and lives are reset back to default
	    else{
		lives = 3;
		fps = 30;
		timePerTick = 1000000000 / fps;
		delta = 0;
		lastTime = System.nanoTime();
		timer = 0;
		ticks = 0;
		gameState.setScore(0);
		display.getTxtLives().setText("Lives:  " + lives);
	    }
	}
	System.exit(0);
	
    }
    //reads the current state
    public State getGameState(){
	return gameState;
    }
    //reads user input
    public KeyboardEvents getKeyManager(){
	return keyManager;
    }
    //displays state on screen
    public Display getDisplay(){
      return display;
    }
    //starts threading
    public synchronized void start() {
	if (running)
	    return;
	running = true;
	thread = new Thread(this);
	thread.start();
    }
    // main class, starts the game
    public static void main(String[] args){
	Game game = new Game("Snake", 1040, 750);
	game.start();
    }

}
