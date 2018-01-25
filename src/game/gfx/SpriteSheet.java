package game.gfx;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage sheet;

	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	public SpriteSheet(BufferedImage sheet, Color background) {
		this.sheet = new BufferedImage(sheet.getWidth(), sheet.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		for(int i = 0; i < sheet.getWidth(); i++) {
			for(int j = 0; j < sheet.getHeight(); j++) {
				Color c = new Color(sheet.getRGB(i, j));
				if(!c.equals(background))
					this.sheet.setRGB(i, j, c.getRGB());
			}
		}
	}

	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
	}
}
