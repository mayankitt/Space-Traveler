package game.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage beam0, beam1, beam2, beam3, beam4, beam5, beam6, beamLong1, beamLong2,
			bold_silver, bolt_bronze, bolt_gold,
			buttonBlue, buttonGreen, buttonRed, buttonYellow,
			cockpitBlue_0, cockpitBlue_1, cockpitBlue_2, cockpitBlue_3, cockpitBlue_4, cockpitBlue_5, cockpitBlue_6, cockpitBlue_7,
			cockpitGreen_0, cockpitGreen_1, cockpitGreen_2, cockpitGreen_3, cockpitGreen_4, cockpitGreen_5, cockpitGreen_6, cockpitGreen_7,
			cockpitRed_0, cockpitRed_1, cockpitRed_2, cockpitRed_3, cockpitRed_4, cockpitRed_5, cockpitRed_6, cockpitRed_7,
			cockpitYellow_0, cockpitYellow_1, cockpitYellow_2, cockpitYellow_3, cockpitYellow_4, cockpitYellow_5, cockpitYellow_6, cockpitYellow_7,
			cursor, enemyBlack1, enemyBlack2, enemyBlack3, enemyBlack4, enemyBlack5,
			enemyBlue1, enemyBlue2, enemyBlue3, enemyBlue4, enemyBlue5,
			enemyGreen1, enemyGreen2, enemyGreen3, enemyGreen4, enemyGreen5,
			enemyRed1, enemyRed2, enemyRed3, enemyRed4, enemyRed5,
			engine1, engine2, engine3, engine4, engine5,
			fire00, fire01, fire02, fire03, fire04, fire05, fire06, fire07, fire08, fire09, fire10,
			fire11, fire12, fire13, fire14, fire15, fire16, fire17, fire18, fire19,
			gun00, gun01, gun02, gun03, gun04, gun05, gun06, gun07, gun08, gun09, gun10,
			laserBlue01, laserBlue02, laserBlue03, laserBlue04, laserBlue05, laserBlue06, laserBlue07, laserBlue08,
			laserBlue09, laserBlue10, laserBlue11, laserBlue12, laserBlue13, laserBlue14, laserBlue15, laserBlue16,
			laserGreen01, laserGreen02, laserGreen03, laserGreen04, laserGreen05, laserGreen06, laserGreen07, laserGreen08,
			laserGreen09, laserGreen10, laserGreen11, laserGreen12, laserGreen13, laserGreen14, laserGreen15, laserGreen16,
			laserRed01, laserRed02, laserRed03, laserRed04, laserRed05, laserRed06, laserRed07, laserRed08,
			laserRed09, laserRed10, laserRed11, laserRed12, laserRed13, laserRed14, laserRed15, laserRed16,
			meteorBrown_big1, meteorBrown_big2, meteorBrown_big3, meteorBrown_big4, meteorBrown_med1, meteorBrown_med3,
			meteorBrown_small1, meteorBrown_small2, meteorBrown_tiny1, meteorBrown_tiny2,
			meteorGrey_big1, meteorGrey_big2, meteorGrey_big3, meteorGrey_big4, meteorGrey_med1, meteorGrey_med2,
			meteorGrey_small1, meteorGrey_small2, meteorGrey_tiny1, meteorGrey_tiny2,
			numeral0, numeral1, numeral2, numeral3, numeral4, numeral5, numeral6, numeral7, numeral8, numeral9, numeralX,
			pill_blue, pill_green, pill_red, pill_yellow,
			playerLife1_blue, playerLife1_green, playerLife1_orange, playerLife1_red,
			playerLife2_blue, playerLife2_green, playerLife2_orange, playerLife2_red,
			playerLife3_blue, playerLife3_green, playerLife3_orange, playerLife3_red,
			playerShip1_blue, playerShip1_damage1, playerShip1_damage2, playerShip1_damage3,
			playerShip1_green, playerShip1_orange, playerShip1_red,
			playerShip2_blue, playerShip2_damage1, playerShip2_damage2, playerShip2_damage3,
			playerShip2_green, playerShip2_orange, playerShip2_red,
			playerShip3_blue, playerShip3_damage1, playerShip3_damage2, playerShip3_damage3,
			playerShip3_green, playerShip3_orange, playerShip3_red,
			powerupBlue, powerupBlue_bolt, powerupBlue_shield, powerupBlue_star,
			powerupGreen, powerupGreen_bolt, powerupGreen_shield, powerupGreen_star,
			powerupRed, powerupRed_bolt, powerupRed_shield, powerupRed_star,
			powerupYellow, powerupYellow_bolt, powerupYellow_shield, powerupYellow_star,
			scratch1, scratch2, scratch3, shield1, shield2, shield3, shield_bronze, shield_gold, shield_silver,
			speed, star1, star2, star3, star_bronze, star_gold, star_silver, things_bronze, things_gold, things_silver,
			turretBase_big, turretBase_small, ufoBlue, ufoGreen, ufoRed, ufoYellow,
			wingBlue_0, wingBlue_1, wingBlue_2, wingBlue_3, wingBlue_4, wingBlue_5, wingBlue_6, wingBlue_7,
			wingGreen_0, wingGreen_1, wingGreen_2, wingGreen_3, wingGreen_4, wingGreen_5, wingGreen_6, wingGreen_7,
			wingRed_0, wingRed_1, wingRed_2, wingRed_3, wingRed_4, wingRed_5, wingRed_6, wingRed_7,
			wingYellow_0, wingYellow_1, wingYellow_2, wingYellow_3, wingYellow_4, wingYellow_5, wingYellow_6, wingYellow_7;

	public static BufferedImage backgroundBlack, backgroundBlue,backgroundDarkPurple,backgroundPurple;

	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/images/sheet.png"));
		beam0 = sheet.crop(143, 377, 43, 31);
		beam1 = sheet.crop(327, 644, 40, 20);
		beam2 = sheet.crop(262, 907, 38, 31);
		beam3 = sheet.crop(396, 384, 29, 29);
		beam4 = sheet.crop(177, 496, 41, 17);
		beam5 = sheet.crop(186, 377, 40, 25);
		beam6 = sheet.crop(120, 688, 43, 23);
		beamLong1 = sheet.crop(828, 943, 15, 67);
		beamLong2 = sheet.crop(307, 309, 25, 64);
		bold_silver = sheet.crop(810, 837, 19, 30);
		bolt_bronze = sheet.crop(810, 467, 19, 30);
		bolt_gold = sheet.crop(809, 437, 19, 30);
		buttonBlue = sheet.crop(0, 78, 222, 39);
		buttonGreen = sheet.crop(0, 117, 222, 39);
		buttonRed = sheet.crop(0, 0, 222, 39);
		buttonYellow = sheet.crop(0, 39, 222, 39);
		cockpitBlue_0 = sheet.crop(586, 0, 51, 75);
		cockpitBlue_1 = sheet.crop(736, 862, 40, 40);
		cockpitBlue_2 = sheet.crop(684, 67, 42, 56);
		cockpitBlue_3 = sheet.crop(336, 384, 60, 61);
		cockpitBlue_4 = sheet.crop(637, 0, 47, 67);
		cockpitBlue_5 = sheet.crop(627, 144, 48, 75);
		cockpitBlue_6 = sheet.crop(684, 0, 42, 67);
		cockpitBlue_7 = sheet.crop(737, 542, 41, 71);
		cockpitGreen_0 = sheet.crop(576, 225, 51, 75);
		cockpitGreen_1 = sheet.crop(734, 977, 40, 40);
		cockpitGreen_2 = sheet.crop(696, 659, 42, 56);
		cockpitGreen_3 = sheet.crop(346, 234, 60, 61);
		cockpitGreen_4 = sheet.crop(627, 219, 47, 67);
		cockpitGreen_5 = sheet.crop(694, 364, 42, 67);
		cockpitGreen_6 = sheet.crop(737, 471, 41, 71);
		cockpitGreen_7 = sheet.crop(602, 525, 48, 75);
		cockpitRed_0 = sheet.crop(535, 75, 51, 75);
		cockpitRed_1 = sheet.crop(351, 982, 40, 40);
		cockpitRed_2 = sheet.crop(718, 197, 42, 56);
		cockpitRed_3 = sheet.crop(520, 661, 60, 61);
		cockpitRed_4 = sheet.crop(647, 857, 47, 67);
		cockpitRed_5 = sheet.crop(605, 707, 48, 75);
		cockpitRed_6 = sheet.crop(736, 795, 42, 67);
		cockpitRed_7 = sheet.crop(736, 329, 41, 71);
		cockpitYellow_0 = sheet.crop(726, 80, 40, 40);
		cockpitYellow_1 = sheet.crop(247, 309, 60, 61);
		cockpitYellow_2 = sheet.crop(637, 67, 47, 67);
		cockpitYellow_3 = sheet.crop(607, 782, 48, 75);
		cockpitYellow_4 = sheet.crop(696, 262, 42, 67);
		cockpitYellow_5 = sheet.crop(736, 400, 41, 71);
		cockpitYellow_6 = sheet.crop(734, 921, 42, 56);
		cockpitYellow_7 = sheet.crop(600, 375, 51, 75);
		cursor = sheet.crop(797, 173, 30, 33);
		enemyBlack1 = sheet.crop(423, 728, 93, 84);
		enemyBlack2 = sheet.crop(120, 604, 104, 84);
		enemyBlack3 = sheet.crop(144, 156, 103, 84);
		enemyBlack4 = sheet.crop(518, 325, 82, 84);
		enemyBlack5 = sheet.crop(346, 150, 97, 84);
		enemyBlue1 = sheet.crop(425, 468, 93, 84);
		enemyBlue2 = sheet.crop(143, 293, 104, 84);
		enemyBlue3 = sheet.crop(222, 0, 103, 84);
		enemyBlue4 = sheet.crop(518, 409, 82, 84);
		enemyBlue5 = sheet.crop(421, 814, 97, 84);
		enemyGreen1 = sheet.crop(425, 552, 93, 84);
		enemyGreen2 = sheet.crop(133, 412, 104, 84);
		enemyGreen3 = sheet.crop(224, 496, 103, 84);
		enemyGreen4 = sheet.crop(518, 493, 82, 84);
		enemyGreen5 = sheet.crop(408, 907, 97, 84);
		enemyRed1 = sheet.crop(425, 384, 93, 84);
		enemyRed2 = sheet.crop(120, 520, 104, 84);
		enemyRed3 = sheet.crop(224, 580, 103, 84);
		enemyRed4 = sheet.crop(520, 577, 82, 84);
		enemyRed5 = sheet.crop(423, 644, 97, 84);
		engine1 = sheet.crop(224, 907, 38, 23);
		engine2 = sheet.crop(163, 688, 42, 28);
		engine3 = sheet.crop(644, 1002, 27, 22);
		engine4 = sheet.crop(144, 240, 49, 45);
		engine5 = sheet.crop(133, 496, 44, 24);
		fire00 = sheet.crop(827, 125, 16, 40);
		fire01 = sheet.crop(828, 206, 14, 31);
		fire02 = sheet.crop(827, 663, 14, 32);
		fire03 = sheet.crop(829, 437, 14, 34);
		fire04 = sheet.crop(831, 0, 14, 31);
		fire05 = sheet.crop(834, 299, 14, 31);
		fire06 = sheet.crop(835, 502, 14, 31);
		fire07 = sheet.crop(835, 330, 14, 31);
		fire08 = sheet.crop(827, 867, 16, 40);
		fire09 = sheet.crop(811, 663, 16, 40);
		fire10 = sheet.crop(812, 206, 16, 40);
		fire11 = sheet.crop(835, 395, 14, 31);
		fire12 = sheet.crop(835, 533, 14, 32);
		fire13 = sheet.crop(835, 361, 14, 34);
		fire14 = sheet.crop(831, 31, 14, 31);
		fire15 = sheet.crop(829, 471, 14, 31);
		fire16 = sheet.crop(828, 268, 14, 31);
		fire17 = sheet.crop(828, 237, 14, 31);
		fire18 = sheet.crop(827, 165, 16, 41);
		fire19 = sheet.crop(812, 246, 16, 41);
		gun00 = sheet.crop(827, 907, 16, 36);
		gun01 = sheet.crop(810, 867, 17, 33);
		gun02 = sheet.crop(829, 611, 14, 36);
		gun03 = sheet.crop(809, 796, 20, 41);
		gun04 = sheet.crop(827, 84, 16, 41);
		gun05 = sheet.crop(423, 0, 21, 41);
		gun06 = sheet.crop(810, 900, 17, 38);
		gun07 = sheet.crop(829, 796, 14, 41);
		gun08 = sheet.crop(848, 263, 10, 47);
		gun09 = sheet.crop(809, 611, 20, 52);
		gun10 = sheet.crop(808, 961, 20, 52);
		laserBlue01 = sheet.crop(856, 421, 9, 54);
		laserBlue02 = sheet.crop(841, 647, 13, 37);
		laserBlue03 = sheet.crop(856, 57, 9, 37);
		laserBlue04 = sheet.crop(835, 565, 13, 37);
		laserBlue05 = sheet.crop(858, 475, 9, 37);
		laserBlue06 = sheet.crop(835, 752, 13, 37);
		laserBlue07 = sheet.crop(856, 775, 9, 37);
		laserBlue08 = sheet.crop(596, 961, 48, 46);
		laserBlue09 = sheet.crop(434, 325, 48, 46);
		laserBlue10 = sheet.crop(740, 724, 37, 37);
		laserBlue11 = sheet.crop(698, 795, 38, 37);
		laserBlue12 = sheet.crop(835, 695, 13, 57);
		laserBlue13 = sheet.crop(856, 869, 9, 57);
		laserBlue14 = sheet.crop(842, 206, 13, 57);
		laserBlue15 = sheet.crop(849, 480, 9, 57);
		laserBlue16 = sheet.crop(843, 62, 13, 54);
		laserGreen01 = sheet.crop(740, 686, 37, 38);
		laserGreen02 = sheet.crop(843, 116, 13, 57);
		laserGreen03 = sheet.crop(855, 173, 9, 57);
		laserGreen04 = sheet.crop(848, 565, 13, 37);
		laserGreen05 = sheet.crop(854, 639, 9, 37);
		laserGreen06 = sheet.crop(845, 0, 13, 57);
		laserGreen07 = sheet.crop(849, 364, 9, 57);
		laserGreen08 = sheet.crop(848, 738, 13, 37);
		laserGreen09 = sheet.crop(856, 94, 9, 37);
		laserGreen10 = sheet.crop(843, 426, 13, 54);
		laserGreen11 = sheet.crop(849, 310, 9, 54);
		laserGreen12 = sheet.crop(843, 602, 13, 37);
		laserGreen13 = sheet.crop(858, 0, 9, 37);
		laserGreen14 = sheet.crop(193, 240, 48, 46);
		laserGreen15 = sheet.crop(443, 182, 48, 46);
		laserGreen16 = sheet.crop(760, 192, 37, 37);
		laserRed01 = sheet.crop(858, 230, 9, 54);
		laserRed02 = sheet.crop(843, 977, 13, 37);
		laserRed03 = sheet.crop(856, 602, 9, 37);
		laserRed04 = sheet.crop(843, 940, 13, 37);
		laserRed05 = sheet.crop(856, 983, 9, 37);
		laserRed06 = sheet.crop(843, 903, 13, 37);
		laserRed07 = sheet.crop(856, 131, 9, 37);
		laserRed08 = sheet.crop(580, 661, 48, 46);
		laserRed09 = sheet.crop(602, 600, 48, 46);
		laserRed10 = sheet.crop(738, 650, 37, 36);
		laserRed11 = sheet.crop(737, 613, 37, 37);
		laserRed12 = sheet.crop(843, 846, 13, 57);
		laserRed13 = sheet.crop(856, 812, 9, 57);
		laserRed14 = sheet.crop(843, 789, 13, 57);
		laserRed15 = sheet.crop(856, 926, 9, 57);
		laserRed16 = sheet.crop(848, 684, 13, 54);
		meteorBrown_big1 = sheet.crop(224, 664, 101, 84);
		meteorBrown_big2 = sheet.crop(0, 520, 120, 98);
		meteorBrown_big3 = sheet.crop(518, 810, 89, 82);
		meteorBrown_big4 = sheet.crop(327, 452, 98, 96);
		meteorBrown_med1 = sheet.crop(651, 447, 43, 43);
		meteorBrown_med3 = sheet.crop(237, 452, 45, 40);
		meteorBrown_small1 = sheet.crop(406, 234, 28, 28);
		meteorBrown_small2 = sheet.crop(778, 587, 29, 26);
		meteorBrown_tiny1 = sheet.crop(346, 814, 18, 18);
		meteorBrown_tiny2 = sheet.crop(399, 814, 16, 15);
		meteorGrey_big1 = sheet.crop(224, 748, 101, 84);
		meteorGrey_big2 = sheet.crop(0, 618, 120, 98);
		meteorGrey_big3 = sheet.crop(516, 728, 89, 82);
		meteorGrey_big4 = sheet.crop(327, 548, 98, 96);
		meteorGrey_med1 = sheet.crop(674, 219, 43, 43);
		meteorGrey_med2 = sheet.crop(282, 452, 45, 40);
		meteorGrey_small1 = sheet.crop(406, 262, 28, 28);
		meteorGrey_small2 = sheet.crop(396, 413, 29, 26);
		meteorGrey_tiny1 = sheet.crop(364, 814, 18, 18);
		meteorGrey_tiny2 = sheet.crop(602, 646, 16, 15);
		numeral0 = sheet.crop(367, 644, 19, 19);
		numeral1 = sheet.crop(205, 688, 19, 19);
		numeral2 = sheet.crop(406, 290, 19, 19);
		numeral3 = sheet.crop(580, 707, 19, 19);
		numeral4 = sheet.crop(386, 644, 19, 19);
		numeral5 = sheet.crop(628, 646, 19, 19);
		numeral6 = sheet.crop(671, 1002, 19, 19);
		numeral7 = sheet.crop(690, 1004, 19, 19);
		numeral8 = sheet.crop(709, 1004, 19, 19);
		numeral9 = sheet.crop(491, 215, 19, 19);
		numeralX = sheet.crop(382, 814, 17, 17);
		pill_blue = sheet.crop(674, 262, 22, 21);
		pill_green = sheet.crop(573, 989, 22, 21);
		pill_red = sheet.crop(222, 108, 22, 21);
		pill_yellow = sheet.crop(222, 129, 22, 21);
		playerLife1_blue = sheet.crop(482, 358, 33, 26);
		playerLife1_green = sheet.crop(535, 150, 33, 26);
		playerLife1_orange = sheet.crop(777, 327, 33, 26);
		playerLife1_red = sheet.crop(775, 301, 33, 26);
		playerLife2_blue = sheet.crop(465, 991, 37, 26);
		playerLife2_green = sheet.crop(391, 991, 37, 26);
		playerLife2_orange = sheet.crop(428, 991, 37, 26);
		playerLife2_red = sheet.crop(502, 991, 37, 26);
		playerLife3_blue = sheet.crop(777, 385, 32, 26);
		playerLife3_green = sheet.crop(778, 469, 32, 26);
		playerLife3_orange = sheet.crop(777, 712, 32, 26);
		playerLife3_red = sheet.crop(777, 443, 32, 26);
		playerShip1_blue = sheet.crop(211, 941, 99, 75);
		playerShip1_damage1 = sheet.crop(112, 941, 99, 75);
		playerShip1_damage2 = sheet.crop(247, 234, 99, 75);
		playerShip1_damage3 = sheet.crop(247, 159, 99, 75);
		playerShip1_green = sheet.crop(237, 377, 99, 75);
		playerShip1_orange = sheet.crop(247, 84, 99, 75);
		playerShip1_red = sheet.crop(224, 832, 99, 75);
		playerShip2_blue = sheet.crop(112, 791, 112, 75);
		playerShip2_damage1 = sheet.crop(0, 866, 112, 75);
		playerShip2_damage2 = sheet.crop(0, 791, 112, 75);
		playerShip2_damage3 = sheet.crop(0, 716, 112, 75);
		playerShip2_green = sheet.crop(112, 866, 112, 75);
		playerShip2_orange = sheet.crop(112, 716, 112, 75);
		playerShip2_red = sheet.crop(0, 941, 112, 75);
		playerShip3_blue = sheet.crop(325, 739, 98, 75);
		playerShip3_damage1 = sheet.crop(323, 832, 98, 75);
		playerShip3_damage2 = sheet.crop(310, 907, 98, 75);
		playerShip3_damage3 = sheet.crop(325, 664, 98, 75);
		playerShip3_green = sheet.crop(346, 75, 98, 75);
		playerShip3_orange = sheet.crop(336, 309, 98, 75);
		playerShip3_red = sheet.crop(325, 0, 98, 75);
		powerupBlue = sheet.crop(696, 329, 34, 33);
		powerupBlue_bolt = sheet.crop(539, 989, 34, 33);
		powerupBlue_shield = sheet.crop(777, 679, 34, 33);
		powerupBlue_star = sheet.crop(776, 895, 34, 33);
		powerupGreen = sheet.crop(774, 613, 34, 33);
		powerupGreen_bolt = sheet.crop(766, 80, 34, 33);
		powerupGreen_shield = sheet.crop(776, 862, 34, 33);
		powerupGreen_star = sheet.crop(651, 490, 34, 33);
		powerupRed = sheet.crop(491, 182, 34, 33);
		powerupRed_bolt = sheet.crop(775, 646, 34, 33);
		powerupRed_shield = sheet.crop(776, 928, 34, 33);
		powerupRed_star = sheet.crop(774, 977, 34, 33);
		powerupYellow = sheet.crop(774, 761, 34, 33);
		powerupYellow_bolt = sheet.crop(740, 761, 34, 33);
		powerupYellow_shield = sheet.crop(482, 325, 34, 33);
		powerupYellow_star = sheet.crop(607, 857, 34, 33);
		scratch1 = sheet.crop(325, 814, 21, 16);
		scratch2 = sheet.crop(423, 41, 21, 16);
		scratch3 = sheet.crop(346, 295, 16, 12);
		shield1 = sheet.crop(0, 412, 133, 108);
		shield2 = sheet.crop(0, 293, 143, 119);
		shield3 = sheet.crop(0, 156, 144, 137);
		shield_bronze = sheet.crop(797, 143, 30, 30);
		shield_gold = sheet.crop(797, 113, 30, 30);
		shield_silver = sheet.crop(778, 824, 30, 30);
		speed = sheet.crop(858, 284, 7, 108);
		star1 = sheet.crop(628, 681, 25, 24);
		star2 = sheet.crop(222, 84, 25, 24);
		star3 = sheet.crop(576, 300, 24, 24);
		star_bronze = sheet.crop(778, 794, 31, 30);
		star_gold = sheet.crop(778, 557, 31, 30);
		star_silver = sheet.crop(778, 527, 31, 30);
		things_bronze = sheet.crop(778, 495, 32, 32);
		things_gold = sheet.crop(777, 411, 32, 32);
		things_silver = sheet.crop(777, 353, 32, 32);
		turretBase_big = sheet.crop(310, 982, 41, 41);
		turretBase_small = sheet.crop(808, 301, 26, 26);
		ufoBlue = sheet.crop(444, 91, 91, 91);
		ufoGreen = sheet.crop(434, 234, 91, 91);
		ufoRed = sheet.crop(444, 0, 91, 91);
		ufoYellow = sheet.crop(505, 898, 91, 91);
		wingBlue_0 = sheet.crop(647, 924, 45, 78);
		wingBlue_1 = sheet.crop(738, 253, 37, 72);
		wingBlue_2 = sheet.crop(805, 0, 26, 84);
		wingBlue_3 = sheet.crop(600, 450, 51, 75);
		wingBlue_4 = sheet.crop(692, 924, 42, 80);
		wingBlue_5 = sheet.crop(596, 892, 51, 69);
		wingBlue_6 = sheet.crop(694, 847, 42, 74);
		wingBlue_7 = sheet.crop(675, 134, 43, 83);
		wingGreen_0 = sheet.crop(650, 525, 45, 78);
		wingGreen_1 = sheet.crop(775, 229, 37, 72);
		wingGreen_2 = sheet.crop(809, 527, 26, 84);
		wingGreen_3 = sheet.crop(535, 0, 51, 75);
		wingGreen_4 = sheet.crop(694, 431, 42, 80);
		wingGreen_5 = sheet.crop(525, 251, 51, 69);
		wingGreen_6 = sheet.crop(695, 511, 42, 74);
		wingGreen_7 = sheet.crop(655, 764, 43, 83);
		wingRed_0 = sheet.crop(809, 712, 26, 84);
		wingRed_1 = sheet.crop(768, 0, 37, 72);
		wingRed_2 = sheet.crop(600, 300, 51, 75);
		wingRed_3 = sheet.crop(698, 715, 42, 80);
		wingRed_4 = sheet.crop(586, 75, 51, 69);
		wingRed_5 = sheet.crop(718, 123, 42, 74);
		wingRed_6 = sheet.crop(653, 681, 43, 83);
		wingRed_7 = sheet.crop(651, 286, 45, 78);
		wingYellow_0 = sheet.crop(650, 603, 45, 78);
		wingYellow_1 = sheet.crop(760, 120, 37, 72);
		wingYellow_2 = sheet.crop(809, 353, 26, 84);
		wingYellow_3 = sheet.crop(576, 150, 51, 75);
		wingYellow_4 = sheet.crop(726, 0, 42, 80);
		wingYellow_5 = sheet.crop(525, 182, 51, 69);
		wingYellow_6 = sheet.crop(695, 585, 42, 74);
		wingYellow_7 = sheet.crop(651, 364, 43, 83);
		backgroundBlack = ImageLoader.loadImage("/images/black.png");
		backgroundBlue = ImageLoader.loadImage("/images/blue.png");
		backgroundDarkPurple = ImageLoader.loadImage("/images/darkPurple.png");
		backgroundPurple = ImageLoader.loadImage("/images/purple.png");
	}
}
