package game.entity;

import game.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerLaser extends Entity {
    private BufferedImage laserImage, laserImage2, laserImage3, trailEffect;
    private int speed, state;
    private boolean active;

    public PlayerLaser(Handler handler, float x, float y, BufferedImage laserImage, BufferedImage laserImage2, BufferedImage laserImage3, BufferedImage trailEffect) {
        super(handler, x, y, laserImage.getWidth(), laserImage.getHeight());
        this.laserImage = laserImage;
        this.laserImage2 = laserImage2;
        this.laserImage3 = laserImage3;
        this.trailEffect = trailEffect;
        speed = 15;
        state = 0;
        active = true;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void blast() {
        active = false;
    }

    public boolean isVisible() {
        return getY() > -getHeight();
    }

    @Override
    public void tick() {
        if(active && getY() > -laserImage.getHeight())
            setY(getY() - speed);
        else if(!active && state < 12)
            state++;
        else
            setY(-laserImage.getHeight());
    }

    @Override
    public void render(Graphics g) {
        if(active) {
            g.drawImage(laserImage, (int) getX(), (int) getY(), handler.getGame().getGameWindow().getFrame());
            g.drawImage(trailEffect, (int) getX() - (trailEffect.getWidth() / 3) + 1, (int) getY() + (getHeight() - trailEffect.getHeight()), handler.getGame().getGameWindow().getFrame());
        }
        else if(state < 4)
            g.drawImage(laserImage3, (int)getX() - (laserImage2.getWidth() / 2), (int)getY(), handler.getGame().getGameWindow().getFrame());
        else if(state < 7)
            g.drawImage(laserImage2, (int)getX() - (laserImage2.getWidth() / 2), (int)getY(), handler.getGame().getGameWindow().getFrame());
    }
}
