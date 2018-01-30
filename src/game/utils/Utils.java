package game.utils;

import game.entity.Entity;
import game.gfx.Assets;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {

	public static String loadFileAsString(String path) {
		StringBuilder builder = new StringBuilder();

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while ((line = br.readLine()) != null)
				builder.append(line);

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return builder.toString();
	}

	public static int parseInt(String s) {
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static boolean isColliding(Entity a, Entity b) {
		return (a.getBounds().intersects(b.getBounds()));
	}
	public static BufferedImage getImageFor(int i) {
		switch (i) {
			case 0:
				return Assets.numeral0;
			case 1:
				return Assets.numeral1;
			case 2:
				return Assets.numeral2;
			case 3:
				return Assets.numeral3;
			case 4:
				return Assets.numeral4;
			case 5:
				return Assets.numeral5;
			case 6:
				return Assets.numeral6;
			case 7:
				return Assets.numeral7;
			case 8:
				return Assets.numeral8;
			case 9:
				return Assets.numeral9;
		}
		return null;
	}
}
