package game.state;

import game.Handler;
import game.entity.creature.Player;
import game.gfx.Assets;

import java.awt.*;

public class TravelState extends State {
    private Player player;
    private double backPosY;

    public TravelState(Handler handler) {
        super(handler);
        player = new Player(handler, (handler.getWidth() - Assets.playerShip1_blue.getWidth()) / 2,
                handler.getHeight() - Assets.playerShip1_blue.getHeight() - 10,
                Assets.playerShip1_blue.getWidth(), Assets.playerShip1_blue.getHeight());
    }

    @Override
    public void tick() {
        backPosY = (backPosY + 1d) % Assets.backgroundBlack.getHeight();
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        drawBackground(g);
        drawPlayer(g);
    }

    private void drawBackground(Graphics g) {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                g.drawImage(Assets.backgroundBlack, i * Assets.backgroundBlack.getWidth(),
                        (j * Assets.backgroundBlack.getHeight()) - (Assets.backgroundBlack.getHeight() - (int)backPosY), null);
            }
        }
    }

    private void drawPlayer(Graphics g) {
        player.render(g);
    }
}
