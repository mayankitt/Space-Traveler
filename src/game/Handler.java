package game;

import java.awt.Canvas;

import game.gfx.GameCamera;
import game.input.KeyManager;
import game.input.MouseManager;
import game.world.World;

public class Handler {

	private Game game;
	private World world;

	public Handler(Game game) {
		this.game = game;
	}

	public Game getGame() {
		return game;
	}

	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}

	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}

	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public World getWorld() {
		return world;
	}

	public Canvas getCanvas() {
		return game.getGameWindow().getCanvas();
	}

	public int getWidth() {
		return game.getWidth();
	}

	public int getHeight() {
		return game.getHeight();
	}
}
