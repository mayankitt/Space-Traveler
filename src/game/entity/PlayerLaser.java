package game.entity;

import game.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerLaser extends Entity {
    private BufferedImage laserImage, laserImage2, laserImage3;
    private int speed, state;
    private boolean active;

    public PlayerLaser(Handler handler, float x, float y, BufferedImage laserImage, BufferedImage laserImage2, BufferedImage laserImage3) {
        super(handler, x, y, laserImage.getWidth(), laserImage.getHeight());
        this.laserImage = laserImage;
        this.laserImage2 = laserImage2;
        this.laserImage3 = laserImage3;
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

    @Override
    public void tick() {
        if(active && getY() > -laserImage.getHeight())
            setY(getY() - speed);
        else if(!active && state < 7)
            state++;
        else
            setY(-laserImage.getHeight());
    }

    @Override
    public void render(Graphics g) {
        if(active)
            g.drawImage(laserImage, (int)getX(), (int)getY(), handler.getGame().getGameWindow().getFrame());
        else if(state < 3)
            g.drawImage(laserImage2, (int)getX(), (int)getY(), handler.getGame().getGameWindow().getFrame());
        else if(state < 7)
            g.drawImage(laserImage3, (int)getX(), (int)getY(), handler.getGame().getGameWindow().getFrame());
    }
}
