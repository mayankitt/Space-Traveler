package game.state;

import game.Handler;
import game.entity.PlayerLaser;
import game.entity.creature.Player;
import game.gfx.Assets;

import java.awt.*;
import java.util.ArrayList;

public class TravelState extends State {
    private ArrayList<PlayerLaser> playerLasers;
    private Player player;
    private double backPosY;
    private boolean fireFlag;

    public TravelState(Handler handler) {
        super(handler);
        player = new Player(handler, (handler.getWidth() - Assets.playerShip1_blue.getWidth()) / 2,
                handler.getHeight() - Assets.playerShip1_blue.getHeight() - 10,
                Assets.playerShip1_blue.getWidth(), Assets.playerShip1_blue.getHeight());
        playerLasers = new ArrayList<>();
    }

    @Override
    public void tick() {
        updateBackgroundPosition();

        if(handler.getKeyManager().space && !fireFlag) {
            firePlayerLaser();
            fireFlag = true;
        }
        if(!handler.getKeyManager().space) {
            fireFlag = false;
        }

        for(PlayerLaser pl : playerLasers) {
            pl.tick();
        }

        player.tick();
    }

    @Override
    public void render(Graphics g) {
        drawBackground(g);
        drawPlayer(g);
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

    private void updateBackgroundPosition() {
        backPosY = (backPosY + 1d) % Assets.backgroundBlack.getHeight();
    }

    private void firePlayerLaser() {
        playerLasers.add(new PlayerLaser(handler, player.getX() + 1, player.getY(), Assets.laserBlue01));
        playerLasers.add(new PlayerLaser(handler, player.getX() + player.getWidth() - 10, player.getY(), Assets.laserBlue01));
    }
}
