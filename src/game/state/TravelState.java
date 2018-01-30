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
    private int score = 0;
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
        if(player.getHealth() <= 0) {
            handler.getGame().setCurrentState(handler.getGame().getMainMenuState());
        }
    }

    @Override
    public void render(Graphics g) {
        drawBackground(g);
        drawPlayer(g);
        drawMeteors(g);
        drawPlayerLasers(g);
        drawLife(g);
        drawScore(g);
    }

    private void drawBackground(Graphics g) {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                g.drawImage(Assets.backgroundBlack, i * Assets.backgroundBlack.getWidth(),
                        (j * Assets.backgroundBlack.getHeight()) - (Assets.backgroundBlack.getHeight() - (int)backPosY), handler.getGame().getGameWindow().getFrame());
            }
        }
    }

    private void drawLife(Graphics g) {
        int pad = 40;
        g.drawImage(Assets.playerLife1_blue, pad, pad, handler.getGame().getGameWindow().getFrame());
        g.drawImage(Assets.numeralX, 60 + Assets.playerLife1_blue.getWidth(), pad, handler.getGame().getGameWindow().getFrame());
        g.drawImage(Assets.numeral3, 80 + Assets.playerLife1_blue.getWidth() + Assets.numeralX.getWidth(), pad, handler.getGame().getGameWindow().getFrame());
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

    private void drawScore(Graphics g) {
        if(score == 0) {
            g.drawImage(Assets.numeral0,handler.getWidth() - 40, 40, handler.getGame().getGameWindow().getFrame());
        }
        int t = score;
        int w = 0;
        while(t > 0) {
            int r = t % 10;
            t = t / 10;
            BufferedImage img = Utils.getImageFor(r);
            g.drawImage(img,handler.getWidth() - 40 - w, 40, handler.getGame().getGameWindow().getFrame());
            w += img.getWidth() + 10;
        }
    }

    private void updateBackgroundPosition() {
        backPosY = (backPosY + 1d) % Assets.backgroundBlack.getHeight();
    }

    private void firePlayerLaser() {
        playerLasers.add(new PlayerLaser(handler, player.getX() + 1, player.getY(), Assets.laserBlue01, Assets.laserBlue09, Assets.laserBlue08, Assets.fire01));
        playerLasers.add(new PlayerLaser(handler, player.getX() + player.getWidth() - 10, player.getY(), Assets.laserBlue01, Assets.laserBlue09, Assets.laserBlue08, Assets.fire01));
    }

    private void updatePlayerLasers() {
        ArrayList<PlayerLaser> toRemove = new ArrayList<>();
        for(PlayerLaser pl : playerLasers) {
            pl.tick();
            if(!pl.isVisible())
                toRemove.add(pl);
        }
        for(PlayerLaser pl : toRemove) {
            playerLasers.remove(pl);
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
        ArrayList<Meteor> toRemove = new ArrayList<>();
        for(Meteor m : meteors) {
            m.tick();
            if(!m.isVisible())
                toRemove.add(m);
        }
        for(Meteor m : toRemove) {
            if(!m.isAlive()) {
                score += (m.getWidth() * m.getHeight() / 10);
            }
            meteors.remove(m);
        }
    }

    private void checkCollisions() {
        for(PlayerLaser pl : playerLasers) {
            for(Meteor m : meteors) {
                if(m.isAlive() && Utils.isColliding(pl, m)) {
                    pl.blast();
                    m.damage(10);
                }
            }
        }
        for(Meteor m : meteors) {
            if(m.isAlive() && Utils.isColliding(player, m)) {
                player.damage(m.getHealth());
                m.damage(player.getHealth());
            }
        }
    }
}
