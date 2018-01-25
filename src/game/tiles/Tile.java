package game.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.GameConstants;

public class Tile {

	public static Tile[] tiles = new Tile[GameConstants.TILE_COUNT];
	public static int tileWidth = GameConstants.TILE_WIDTH;
	public static int tileHeight = GameConstants.TILE_HEIGHT;

	protected BufferedImage texture;
	protected final int id;

	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;

		tiles[id] = this;
	}

	public void tick() {

	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, tileWidth, tileHeight, null);
	}

	public boolean isSolid() {
		return false;
	}

	public int getID() {
		return id;
	}
}
