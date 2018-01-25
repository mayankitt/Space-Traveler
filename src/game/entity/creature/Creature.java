package game.entity.creature;

import game.GameConstants;
import game.Handler;
import game.entity.Entity;

public abstract class Creature extends Entity {

	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3;
	public static final int DEFAULT_CREATURE_WIDTH = GameConstants.TILE_WIDTH,
			DEFAULT_CREATURE_HEIGHT = GameConstants.TILE_HEIGHT;

	protected int health;
	protected float speed;
	protected float xMove, yMove;

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}

	public void move() {
		moveX();
		moveY();
	}

	public void moveX() {
		if (xMove > 0) {
			int tx = (int) (x + xMove + bounds.x + bounds.width) / GameConstants.TILE_WIDTH;
			if (!collisionWithTile(tx, (int) (y + bounds.y) / GameConstants.TILE_HEIGHT)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / GameConstants.TILE_HEIGHT)) {
				x += xMove;
			} else {
				x = tx * GameConstants.TILE_WIDTH - bounds.x - bounds.width - 1;
			}
		} else if (xMove < 0) {
			int tx = (int) (x + xMove + bounds.x) / GameConstants.TILE_WIDTH;
			if (!collisionWithTile(tx, (int) (y + bounds.y) / GameConstants.TILE_HEIGHT)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / GameConstants.TILE_HEIGHT)) {
				x += xMove;
			} else {
				x = tx * GameConstants.TILE_WIDTH + GameConstants.TILE_WIDTH - bounds.x;
			}
		}

		if (x < 0)
			x = 0;
		if (y < 0)
			y = 0;
		if (x > handler.getWorld().getWidth() * GameConstants.TILE_WIDTH - getWidth())
			x = handler.getWorld().getWidth() * GameConstants.TILE_WIDTH - getWidth();
		if (y > handler.getWorld().getHeight() * GameConstants.TILE_HEIGHT - getHeight())
			y = handler.getWorld().getHeight() * GameConstants.TILE_HEIGHT - getHeight();
	}

	public void moveY() {
		if (yMove < 0) {
			int ty = (int) ((y + yMove + bounds.y) / GameConstants.TILE_HEIGHT);
			if (!collisionWithTile((int) (x + bounds.x) / GameConstants.TILE_WIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / GameConstants.TILE_WIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * GameConstants.TILE_HEIGHT + GameConstants.TILE_HEIGHT - bounds.y;
			}
		} else if (yMove > 0) {
			int ty = (int) ((y + yMove + bounds.y + bounds.height) / GameConstants.TILE_HEIGHT);
			if (!collisionWithTile((int) (x + bounds.x) / GameConstants.TILE_WIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / GameConstants.TILE_WIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * GameConstants.TILE_HEIGHT - bounds.y - bounds.height - 1;
			}
		}
	}

	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}

	public float getxMove() {
		return xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public static int getDefaultHealth() {
		return DEFAULT_HEALTH;
	}

	public static float getDefaultSpeed() {
		return DEFAULT_SPEED;
	}
}
