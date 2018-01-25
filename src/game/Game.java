package game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import game.gfx.GameCamera;
import game.gui.GameWindow;
import game.input.KeyManager;
import game.input.MouseManager;
import game.state.State;

public class Game implements Runnable {

	private Handler handler;
	private GameWindow gameWindow;
	private MouseManager mouseManager;
	private KeyManager keyManager;
	private GameCamera gameCamera;
	private BufferStrategy bufferStrategy;
	private State currentState;
	private Graphics graphics;
	private String title;
	private Thread gameThread;
	private int width, height;
	private boolean running;

	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;

		running = false;
	}

	public GameWindow getGameWindow() {
		return gameWindow;
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}
	
	public State getCurrentState() {
		return currentState;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		gameThread = new Thread(this);
		gameThread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		init();

		double timePerTick = 1_000_000_000 / GameConstants.FPS;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();

		long timer = 0;
		long ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}

			if (timer > 1_000_000_000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}

	private void init() {
		handler = new Handler(this);
		gameWindow = new GameWindow(title, width, height);
		gameWindow.show();
		mouseManager = new MouseManager();
		gameWindow.getFrame().addMouseListener(mouseManager);
		gameWindow.getFrame().addMouseMotionListener(mouseManager);
		keyManager = new KeyManager();
		gameWindow.getFrame().addKeyListener(keyManager);
		gameCamera = new GameCamera(handler, 0, 0);
	}

	private void tick() {
		currentState.tick();
	}

	private void render() {
		bufferStrategy = gameWindow.getCanvas().getBufferStrategy();
		if (bufferStrategy == null) {
			gameWindow.getCanvas().createBufferStrategy(3);
			return;
		}
		graphics = bufferStrategy.getDrawGraphics();
		graphics.clearRect(0, 0, width, height);

		currentState.render(graphics);

		bufferStrategy.show();
		graphics.dispose();
	}
}
