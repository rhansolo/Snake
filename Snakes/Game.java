import java.util.*;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
    private Display display;

    int height, width;
    String title;
    boolean running;
    int lives;
    boolean lifeDecreased;
    boolean paused;

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

    public void decreaseLife(){
	lives --;
	lifeDecreased = true;
	System.out.println("here");
    }

    private void init(){
	display = new Display(title, width, height);
	display.getFrame().addKeyListener(keyManager);

	gameState = new GameState(this,0);
	menuState = new Menu(this);
	State.setState(gameState);

    }
    private void initNewLife(){
	display.getFrame().addKeyListener(keyManager);
	int tmp = gameState.getScore();
	gameState = new GameState(this,tmp);
	//menuState = new Menu(this);
	State.setState(gameState);
    }

    private void tick(){
	KeyboardEvents.tick();
	if (State.getState() != null){
	    State.getState().tick();
	}
    }
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

    public void run(){

	init();

	int fps = 30;
	double timePerTick = 1000000000 / fps;
	double delta = 0;
	long now;
	long lastTime = System.nanoTime();
	long timer = 0;
	int ticks = 0;
	
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
		if (lifeDecreased){
		    lifeDecreased = false;
		    int tmp = gameState.getScore();
		    System.out.println(tmp);
		    initNewLife();
		    display.getTxtLives().setText("Lives:" + lives);
		    
		    display.getTxtCurrentScore().setText("Current Score:  " + tmp);
		    
		}
	    }
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
	System.exit(0);
	end();
    }
    public State getGameState(){
	return gameState;
    }

    public KeyboardEvents getKeyManager(){
	return keyManager;
    }

    public Display getDisplay(){
      return display;
    }

    public synchronized void start() {
	if (running)
	    return;
	running = true;
	thread = new Thread(this);
	thread.start();
    }
    public synchronized void end() {
	if (!running)
	    return;
	running = false;
	try {
	    thread.join();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }
    public static void main(String[] args){
	Game game = new Game("Snake", 1040, 750);
	game.start();
    }

}
