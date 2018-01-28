package game.entity;

import game.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerLaser extends Entity {
    BufferedImage laserImage;
    public int speed;

    public PlayerLaser(Handler handler, float x, float y, BufferedImage laserImage) {
        super(handler, x, y, laserImage.getWidth(), laserImage.getHeight());
        this.laserImage = laserImage;
        speed = 15;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void tick() {
        if(getY() > -laserImage.getHeight())
            setY(getY() - speed);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(laserImage, (int)getX(), (int)getY(), handler.getGame().getGameWindow().getFrame());
    }
}
