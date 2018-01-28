package game.entity.creature;

import game.GameConstants;
import game.Handler;
import game.entity.Entity;

public abstract class Creature extends Entity {

	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3;

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
		x += (xMove * getSpeed());
		if (x < 0)
			x = 0;
		if (x > handler.getWidth() - getWidth())
			x = handler.getWidth() - getWidth();
	}

	public void moveY() {
		y += (yMove * getSpeed());
		if (y < 0)
			y = 0;
		if (y > handler.getHeight() - getHeight())
			y = handler.getHeight() - getHeight();
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
