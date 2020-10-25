package game.enitties;

import game.Game;

import java.awt.*;

public class Bullet extends Entity {

	private float x, y;
	private Game game;

	public Bullet(Game game, int x, int y) {
		this.game = game;
		this.x = x;
		this.y = y;
	}

	@Override
	public void update(long dt) {
		y -= dt / 5.0f;

		if(y < 0) {
			game.removeBullet(this);
		}

		for(Enemy e: game.getEnemies()) {
			if(calculateDistanceBetweenPoints(x, y, e.getX(), e.getY()) < 15 + 5) {
				game.removeBullet(this);
				game.removeEnemy(e);
				break;
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval((int)x - 4, (int)y - 4, 8, 8);
	}

	public static double calculateDistanceBetweenPoints(double x1, double y1, double x2, double y2) {
		return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
	}
}
