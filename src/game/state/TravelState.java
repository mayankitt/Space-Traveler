package game.state;

import game.Handler;
import game.entity.Meteor;
import game.entity.PlayerLaser;
import game.entity.creature.Player;
import game.gfx.Assets;
import game.utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class TravelState extends State {
    private Random random;
    private ArrayList<PlayerLaser> playerLasers;
    private ArrayList<Meteor> meteors;
    private Player player;
    private double backPosY;
    private boolean fireFlag;

    public TravelState(Handler handler) {
        super(handler);
        player = new Player(handler, (handler.getWidth() - Assets.playerShip1_blue.getWidth()) / 2,
                handler.getHeight() - Assets.playerShip1_blue.getHeight() - 10,
                Assets.playerShip1_blue.getWidth(), Assets.playerShip1_blue.getHeight());

        random = new Random();
        playerLasers = new ArrayList<>();
        meteors = new ArrayList<>();
    }

    @Override
    public void tick() {
        updateBackgroundPosition();
        checkAndFirePlayerLaser();
        checkAndSpawnMeteor();
        updatePlayerLasers();
        updateMeteors();
        checkCollisions();
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        drawBackground(g);
        drawPlayer(g);
        drawMeteors(g);
        drawPlayerLasers(g);
    }

    private void drawBackground(Graphics g) {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                g.drawImage(Assets.backgroundBlack, i * Assets.backgroundBlack.getWidth(),
                        (j * Assets.backgroundBlack.getHeight()) - (Assets.backgroundBlack.getHeight() - (int)backPosY), handler.getGame().getGameWindow().getFrame());
            }
        }
    }

    private void drawPlayer(Graphics g) {
        player.render(g);
    }

    private void drawPlayerLasers(Graphics g) {
        for(PlayerLaser pl : playerLasers) {
            pl.render(g);
        }
    }

    private void drawMeteors(Graphics g) {
        for(Meteor m : meteors) {
            m.render(g);
        }
    }

    private void updateBackgroundPosition() {
        backPosY = (backPosY + 1d) % Assets.backgroundBlack.getHeight();
    }

    private void firePlayerLaser() {
        playerLasers.add(new PlayerLaser(handler, player.getX() + 1, player.getY(), Assets.laserBlue01, Assets.laserBlue09, Assets.laserBlue08));
        playerLasers.add(new PlayerLaser(handler, player.getX() + player.getWidth() - 10, player.getY(), Assets.laserBlue01, Assets.laserBlue09, Assets.laserBlue08));
    }

    private void updatePlayerLasers() {
        for(PlayerLaser pl : playerLasers) {
            pl.tick();
        }
    }

    private void checkAndFirePlayerLaser() {
        if(handler.getKeyManager().space && !fireFlag) {
            firePlayerLaser();
            fireFlag = true;
        }
        if(!handler.getKeyManager().space) {
            fireFlag = false;
        }
    }

    private void checkAndSpawnMeteor() {
        if(random.nextInt(100) == 10) {
            BufferedImage meteorImage = Meteor.generateRandomMeteor(random);
            int x = random.nextInt(handler.getWidth() - meteorImage.getWidth());
            meteors.add(new Meteor(handler, x, -meteorImage.getHeight(), meteorImage));
        }
    }

    private void updateMeteors() {
        for(Meteor m : meteors) {
            m.tick();
        }
    }

    private void checkCollisions() {
        for(PlayerLaser pl : playerLasers) {
            for(Meteor m : meteors) {
                if(Utils.isColliding(pl, m)) {
                    pl.blast();
                }
            }
        }
    }
}
