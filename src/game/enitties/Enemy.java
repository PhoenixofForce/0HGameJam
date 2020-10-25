package game.enitties;

import frame.Window;
import game.Game;

import java.awt.*;

public class Enemy extends Entity {

	private int mx = -1;
	private float x, y;

	private Game game;

	public Enemy(Game game, int x, int y) {
		this.game = game;

		this.x = x;
		this.y = y;
	}

	@Override
	public void update(long dt) {
		x += mx * dt / 4.5f;

		if(x <= 16) {
			y += 15;
			mx = 1;
			x = 17;
		} else if(x >= Window.width - 16){
			y += 15;
			mx = -1;
			x = Window.width - 16;
		}

		if(y > Window.height - 10) {
			game.removeEnemy(this);
			game.removeLive();
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval((int)x - 16, (int)y - 16, 32, 32);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
}
