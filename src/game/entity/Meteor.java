package game.entity;

import game.Handler;
import game.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Meteor extends Entity {
    private BufferedImage meteorImage;
    private int speed;

    public Meteor(Handler handler, float x, float y, BufferedImage meteorImage) {
        super(handler, x, y, meteorImage.getWidth(), meteorImage.getHeight());
        this.meteorImage = meteorImage;
        speed = 2;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void tick() {
        if(getY() < handler.getHeight())
            setY(getY() + speed);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(meteorImage, (int) getX(), (int) getY(), getWidth(), getHeight(), handler.getGame().getGameWindow().getFrame());
    }

    public static BufferedImage generateRandomMeteor(Random r) {
        int s = r.nextInt(20);
        BufferedImage image = null;
        switch (s) {
            case 0:
                image = Assets.meteorBrown_big1;
                break;
            case 1:
                image = Assets.meteorBrown_big2;
                break;
            case 2:
                image = Assets.meteorBrown_big3;
                break;
            case 3:
                image = Assets.meteorBrown_big4;
                break;
            case 4:
                image = Assets.meteorBrown_med1;
                break;
            case 5:
                image = Assets.meteorBrown_med3;
                break;
            case 6:
                image = Assets.meteorBrown_small1;
                break;
            case 7:
                image = Assets.meteorBrown_small2;
                break;
            case 8:
                image = Assets.meteorBrown_tiny1;
                break;
            case 9:
                image = Assets.meteorBrown_tiny2;
                break;
            case 10:
                image = Assets.meteorGrey_big1;
                break;
            case 11:
                image = Assets.meteorGrey_big2;
                break;
            case 12:
                image = Assets.meteorGrey_big3;
                break;
            case 13:
                image = Assets.meteorGrey_big4;
                break;
            case 14:
                image = Assets.meteorGrey_med1;
                break;
            case 15:
                image = Assets.meteorGrey_med2;
                break;
            case 16:
                image = Assets.meteorBrown_small1;
                break;
            case 17:
                image = Assets.meteorBrown_small2;
                break;
            case 18:
                image = Assets.meteorBrown_tiny1;
                break;
            case 19:
                image = Assets.meteorBrown_tiny2;
                break;
            default:
                image = Assets.meteorBrown_tiny2;
        }
        return image;
    }
}
