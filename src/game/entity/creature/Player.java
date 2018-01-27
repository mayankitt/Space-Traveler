package game.entity.creature;

import game.Handler;
import game.gfx.Assets;

import java.awt.*;

public class Player extends Creature {
    public Player(Handler handler, int x, int y, int width, int height) {
        super(handler, x, y, width, height);
    }

    @Override
    public void tick() {
        if(handler.getKeyManager().up && !handler.getKeyManager().down) {
            setyMove(-1.0f);
        }
        else if(!handler.getKeyManager().up && handler.getKeyManager().down) {
            setyMove(1.0f);
        }
        else {
            setyMove(0f);
        }
        if(handler.getKeyManager().left && !handler.getKeyManager().right) {
            setxMove(-1.0f);
        }
        else if(!handler.getKeyManager().left && handler.getKeyManager().right) {
            setxMove(1.0f);
        }
        else {
            setxMove(0f);
        }
        move();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.playerShip1_blue, (int)getX(), (int)getY(), null);
    }
}
