package game;

import frame.Window;
import game.enitties.Entity;

import java.awt.*;

public class Player extends Entity {

	private float x  = Window.width / 2;
	private int y = Window.height - 80;

	private int mx = 0;

	public void setMX(int mx) {
		this.mx = mx;
	}

	public void shoot() {

	}

	public void update(long dt) {
		x += mx * dt / 3.0f;
		System.out.println(mx + " " + dt);
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval((int)x - 16, y - 16, 32, 32);
	}
}
