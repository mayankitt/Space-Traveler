package game.entity;

import game.Handler;
import game.gfx.Assets;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Meteor extends Entity {
    private static int MAX_DEGREES = 360;
    private BufferedImage meteorImage;
    private BufferedImage img1, img2, img3, img4;
    private int speed, health, dist, rotationDirection;
    private double rotationSpeed, rotation;

    public Meteor(Handler handler, float x, float y, BufferedImage meteorImage) {
        super(handler, x, y, meteorImage.getWidth(), meteorImage.getHeight());
        this.meteorImage = meteorImage;
        speed = 2;
        health = meteorImage.getHeight() * meteorImage.getWidth() / 10;
        Random random = new Random();
        rotation = random.nextInt(MAX_DEGREES);
        rotationSpeed = random.nextDouble() + 1d;
        rotationDirection = random.nextInt(10) > 8? -1 : 1;
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
        rotation = (rotation + MAX_DEGREES + (rotationDirection * rotationSpeed)) % MAX_DEGREES;
    }

    @Override
    public void render(Graphics g) {
        AffineTransform at = new AffineTransform();
        at.translate(getX(), getY());
        at.rotate(Math.toRadians(rotation), meteorImage.getWidth() / 2, meteorImage.getHeight() / 2);
        Graphics2D g2d = (Graphics2D) g;
        if(health > 0) {
            g2d.drawImage(meteorImage, at, handler.getGame().getGameWindow().getFrame());
        }
        else if(dist < 20){
            int w = meteorImage.getWidth() / 2, h = meteorImage.getHeight() / 2;

            at.translate(-dist, -dist);
            g2d.drawImage(img1, at, handler.getGame().getGameWindow().getFrame());

            at.translate(w + dist, -dist);
            g2d.drawImage(img2, at, handler.getGame().getGameWindow().getFrame());

            at.translate(-dist,h + dist);
            g2d.drawImage(img3, at, handler.getGame().getGameWindow().getFrame());

            at.translate( w + dist, 0);
            g2d.drawImage(img4, at, handler.getGame().getGameWindow().getFrame());
        }
    }

    public static BufferedImage generateRandomMeteor(Random r) {
        int s = r.nextInt(20);
        BufferedImage image;
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
