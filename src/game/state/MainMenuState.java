package game.state;

import game.Handler;
import game.gfx.Assets;
import game.utils.Utils;

import javax.swing.*;
import java.awt.*;

public class MainMenuState extends State {
    private static final Color RED = new Color(127, 0, 0);
    private static final Color BLUE = new Color(0, 0, 127);
    private static final String NEW_GAME = "New Game";
    private static final String LOAD_GAME = "Load Game";
    private static final String HIGH_SCORES = "High Scores";
    private static final String EXIT = "Exit";
    private static final int MENU_MARGIN = 60;
    private static final int MENU_PADDING_X = 30;
    private static final int MENU_PADDING_Y = 25;

    private final int xPos, yPos ,menuWidth, menuHeight;
    private double backPosY;

    public MainMenuState(Handler handler) {
        super(handler);
        backPosY = 0;
        JFrame frame = handler.getGame().getGameWindow().getFrame();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Cursor c = tk.createCustomCursor(Assets.cursor, new Point(0, 0), "img");
        xPos = (handler.getWidth() - Assets.buttonBlue.getWidth()) / 2;
        yPos = handler.getHeight() / 2;
        menuHeight = Assets.buttonBlue.getHeight();
        menuWidth = Assets.buttonBlue.getWidth();
        frame.setCursor(c);
    }

    @Override
    public void tick() {
        if(handler.getKeyManager().enter || handler.getMouseManager().mousePressed) {
            Point p = handler.getMouseManager().getMouseCurrentLocation();
            if(Utils.isIn(p, xPos, yPos, menuWidth, menuHeight)) {
                handler.getGame().setCurrentState(handler.getGame().getTravelState());
            }

            if(Utils.isIn(p, xPos, MENU_MARGIN + yPos, menuWidth, menuHeight)) {


            }

            if(Utils.isIn(p, xPos, (2 * MENU_MARGIN) + yPos, menuWidth, menuHeight)) {

            }

            if(Utils.isIn(p, xPos, (3 * MENU_MARGIN) + yPos, menuWidth, menuHeight)) {
                handler.getGame().stop();
            }
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
        g.setFont(handler.getGame().getCustomFont());
        Point p = handler.getMouseManager().getMouseCurrentLocation();

        if(Utils.isIn(p, xPos, yPos, menuWidth, menuHeight)) {
            g.drawImage(Assets.buttonRed, xPos, yPos, handler.getGame().getGameWindow().getFrame());
            g.setColor(RED);
        } else {
            g.drawImage(Assets.buttonBlue, xPos, yPos, handler.getGame().getGameWindow().getFrame());
            g.setColor(BLUE);
        }
        g.drawString(NEW_GAME, xPos + MENU_PADDING_X, yPos + MENU_PADDING_Y);

        if(Utils.isIn(p, xPos, MENU_MARGIN + yPos, menuWidth, menuHeight)) {
            g.drawImage(Assets.buttonRed, xPos, MENU_MARGIN + yPos, handler.getGame().getGameWindow().getFrame());
            g.setColor(RED);

        } else {
            g.drawImage(Assets.buttonBlue, xPos, MENU_MARGIN + yPos, handler.getGame().getGameWindow().getFrame());
            g.setColor(BLUE);
        }
        g.drawString(LOAD_GAME, xPos + MENU_PADDING_X, MENU_MARGIN + yPos + MENU_PADDING_Y);

        if(Utils.isIn(p, xPos, (2 * MENU_MARGIN) + yPos, menuWidth, menuHeight)) {
            g.drawImage(Assets.buttonRed, xPos, (2 * MENU_MARGIN) + yPos, handler.getGame().getGameWindow().getFrame());
            g.setColor(RED);
        } else {
            g.drawImage(Assets.buttonBlue, xPos, (2 * MENU_MARGIN) + yPos, handler.getGame().getGameWindow().getFrame());
            g.setColor(BLUE);
        }
        g.drawString(HIGH_SCORES, xPos + MENU_PADDING_X, (2 * MENU_MARGIN) + yPos + MENU_PADDING_Y);

        if(Utils.isIn(p, xPos, (3 * MENU_MARGIN) + yPos, menuWidth, menuHeight)) {
            g.drawImage(Assets.buttonRed, xPos, (3 * MENU_MARGIN) + yPos, handler.getGame().getGameWindow().getFrame());
            g.setColor(RED);
        } else {
            g.drawImage(Assets.buttonBlue, xPos, (3 * MENU_MARGIN) + yPos, handler.getGame().getGameWindow().getFrame());
            g.setColor(BLUE);
        }
        g.drawString(EXIT, xPos + MENU_PADDING_X, (3 * MENU_MARGIN) + yPos + MENU_PADDING_Y);
    }
}
