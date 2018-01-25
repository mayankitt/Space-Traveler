package game.input;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseManager extends MouseAdapter implements MouseMotionListener {

	private Point pressLocation, currentLocation;

	public boolean mousePressed;

	public MouseManager() {
		pressLocation = new Point(0, 0);
		currentLocation = new Point(0, 0);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int button = e.getButton();
		if (button == MouseEvent.BUTTON1) {
			mousePressed = true;
			pressLocation = e.getPoint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int button = e.getButton();
		if (button == MouseEvent.BUTTON1) {
			mousePressed = false;
			pressLocation = null;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		currentLocation = e.getPoint();
	}

	public Point getMousePressLocation() {
		return pressLocation;
	}

	public Point getMouseCurrentLocation() {
		return currentLocation;
	}
}
