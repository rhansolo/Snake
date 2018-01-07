import java.util.*;

public class Game implements Runnable {
	private Display display;
	
	int height, width;
	String title;
	boolean running;

	private Thread thread;

	public void run() {

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
