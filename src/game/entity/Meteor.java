package game.entity;

import game.Handler;
import game.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Meteor extends Entity {
    private BufferedImage meteorImage;
    BufferedImage img1, img2, img3, img4;
    private int speed, health, dist;

    public Meteor(Handler handler, float x, float y, BufferedImage meteorImage) {
        super(handler, x, y, meteorImage.getWidth(), meteorImage.getHeight());
        this.meteorImage = meteorImage;
        speed = 2;
        health = meteorImage.getHeight() * meteorImage.getWidth() / 10;
        int w = meteorImage.getWidth() / 2;
        int h = meteorImage.getHeight() / 2;
        img1 = meteorImage.getSubimage(0, 0, w, h);
        img2 = meteorImage.getSubimage(w, 0, w, h);
        img3 = meteorImage.getSubimage(0, h, w, h);
        img4 = meteorImage.getSubimage(w, h, w, h);
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void damage(int p) {
        if(health > 0)
            health -= p;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public boolean isVisible() {
        return getY() < handler.getHeight() && dist <= 20;
    }

    @Override
    public void tick() {
        if(getY() < handler.getHeight())
            setY(getY() + speed);
        if(health <= 0) {
            health = 0;
            dist++;
        }
    }

    @Override
    public void render(Graphics g) {
        if(health > 0)
            g.drawImage(meteorImage, (int) getX(), (int) getY(), handler.getGame().getGameWindow().getFrame());
        else if(dist < 20){
            int w = meteorImage.getWidth() / 2, h = meteorImage.getHeight() / 2;
            g.drawImage(img1, (int) getX() - dist, (int) getY() - dist, handler.getGame().getGameWindow().getFrame());
            g.drawImage(img2, (int) getX() + w + dist, (int) getY() - dist, handler.getGame().getGameWindow().getFrame());
            g.drawImage(img3, (int) getX() - dist, (int) getY() + h + dist, handler.getGame().getGameWindow().getFrame());
            g.drawImage(img4, (int) getX() + w + dist, (int) getY() + h + dist, handler.getGame().getGameWindow().getFrame());
        }
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
