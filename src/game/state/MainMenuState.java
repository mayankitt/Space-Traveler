package game.state;

import game.Handler;
import game.gfx.Assets;

import java.awt.*;

public class MainMenuState extends State {

    private double backPosY;

    public MainMenuState(Handler handler) {
        super(handler);
        backPosY = 0;
    }

    @Override
    public void tick() {
        if(handler.getKeyManager().enter) {
            handler.getGame().setCurrentState(handler.getGame().getTravelState());
        }
        backPosY = (backPosY + 0.05d) % Assets.backgroundBlack.getHeight();
    }

    @Override
    public void render(Graphics g) {
        drawBackground(g);
        drawMenu(g);
    }

    private void drawBackground(Graphics g) {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                g.drawImage(Assets.backgroundBlack, i * Assets.backgroundBlack.getWidth(),
                        (j * Assets.backgroundBlack.getHeight()) - (Assets.backgroundBlack.getHeight() - (int)backPosY), handler.getGame().getGameWindow().getFrame());
            }
        }
    }

    private void drawMenu(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawString("Press 'Enter' to start the game", 300, 500);
    }
}
