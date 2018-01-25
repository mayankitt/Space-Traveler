package game.world;

import java.awt.Graphics;

import game.GameConstants;
import game.Handler;
import game.tiles.Tile;
import game.utils.Utils;

public class World {
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;

	public World(Handler handler, String path) {
		this.handler = handler;
		loadWorld(path);
	}

	public void tick() {

	}

	public void render(Graphics g) {
		int xStart = Math.max(0, (int) (handler.getGameCamera().getxOffset() / GameConstants.TILE_WIDTH));
		int xEnd = Math.min(width,
				(int) ((handler.getGameCamera().getxOffset() + handler.getWidth()) / GameConstants.TILE_WIDTH) + 1);
		int yStart = Math.max(0, (int) (handler.getGameCamera().getyOffset()) / GameConstants.TILE_HEIGHT);
		int yEnd = Math.min(height,
				(int) ((handler.getGameCamera().getyOffset() + handler.getHeight()) / GameConstants.TILE_HEIGHT) + 1);
		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * GameConstants.TILE_WIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * GameConstants.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
	}

	public Tile getTile(int x, int y) {
		Tile tile = Tile.tiles[tiles[x][y]];
		if (tile == null)
			return null;
		return tile;
	}

	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);

		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
