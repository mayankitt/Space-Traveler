package game.gfx;

import game.GameConstants;
import game.Handler;
import game.entity.Entity;

public class GameCamera {

	private Handler handler;
	private float xOffset, yOffset;

	public GameCamera(Handler handler, float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	public void checkBlankSpace() {
		if (xOffset < 0)
			xOffset = 0;
		if (yOffset < 0)
			yOffset = 0;
		if (xOffset > handler.getWorld().getWidth() * GameConstants.TILE_WIDTH - handler.getWidth())
			xOffset = handler.getWorld().getWidth() * GameConstants.TILE_WIDTH - handler.getWidth();
		if (yOffset > handler.getWorld().getHeight() * GameConstants.TILE_HEIGHT - handler.getHeight())
			yOffset = handler.getWorld().getHeight() * GameConstants.TILE_HEIGHT - handler.getHeight();
	}

	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
		checkBlankSpace();
	}

	public float getxOffset() {
		return xOffset;
	}

	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
}
