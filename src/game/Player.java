package game;

import frame.Window;
import game.enitties.Bullet;
import game.enitties.Entity;

import java.awt.*;

public class Player extends Entity {

	private long lastShoot = 750;
	private long shootCooldown = 750;

	private float x  = Window.width / 2;
	private int y = Window.height - 80;

	private int mx = 0;

	private Game game;

	public Player(Game game) {
		this.game = game;
	}

	public void setMX(int mx) {
		this.mx = mx;
	}

	public void shoot() {
		if(lastShoot >= shootCooldown) {
			lastShoot -= shootCooldown;
			game.spawnBullet(new Bullet(game, (int) (x - 16), y));
		}
	}

	public void update(long dt) {
		x += mx * dt / 3.0f;
		lastShoot += dt;
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval((int)x - 16, y - 16, 32, 32);
	}
}
