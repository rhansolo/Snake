import java.util.*;

public class Game implements Runnable {
	private Display display;

	int height, width;
	String title;
	boolean running;

	private Thread thread;

	private BufferStrategy bs;
	private Graphics g;

	//Input
	private KeyBoardEvents keyManager;

	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}

	private void init(){
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();

		/*
		gameState = new GameState(this);
		menuState = new MenuState(this);
		State.setState(gameState);
		*/
	}

	private void tick(){
		KeyBoardEvents.tick();
		
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



		//End Drawing!
		bs.show();
		g.dispose();
	}

	public void run(){

		init();

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while(running){
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
		}

		stop();

	}

	public KeyManager getKeyManager(){
		return keyManager;
	}

	public synchronized void start() {
		if (running)
			return;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void end() {
		if (!running)
			return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
