package game;

public class Launcher {

	public static void main(String[] args) {
		Game game = new Game(GameConstants.TITLE, GameConstants.WIDTH, GameConstants.HEIGHT);
		game.start();
	}
}
