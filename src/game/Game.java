package game;

import frame.InputHandler;
import game.enitties.Bullet;
import game.enitties.Enemy;

import java.util.ArrayList;
import java.util.List;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Game {

	private InputHandler ih;
	private Player p;

	private List<Enemy> enemies;
	private List<Bullet> bullets;

	private int lives = 10;

	public Game(Window w) {
		p = new Player(this);
		ih = new InputHandler(this);

		enemies = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			enemies.add(new Enemy(this, frame.Window.width/10 * i + frame.Window.width / 20, (int) (32 + (Math.random() * 10))));
			enemies.add(new Enemy(this, frame.Window.width/10 * i, (int) (96 + (Math.random() * 10))));
		}

		bullets = new ArrayList<>();

		w.addKeyListener(ih);
	}

	public void update(long dt) {
		int mx = 0;
		if(ih.isKeyPressed(KeyEvent.VK_A))
			mx -= 1;
		if(ih.isKeyPressed(KeyEvent.VK_D))
			mx += 1;

		p.setMX(mx);
		p.update(dt);

		if(ih.isKeyPressed(32)) {
			p.shoot();
		}


		for(int i = 0; i < enemies.size(); i++) enemies.get(i).update(dt);
		for(int i = 0; i < bullets.size(); i++) bullets.get(i).update(dt);
	}

	public void draw(Graphics g) {
		p.draw(g);
		for(int i = 0; i < enemies.size(); i++) enemies.get(i).draw(g);
		for(int i = 0; i < bullets.size(); i++) bullets.get(i).draw(g);

		g.setColor(Color.WHITE);
		g.drawString("Lives: " + lives, 16, 32);
	}

	public void spawnBullet(Bullet b) {
		bullets.add(b);
	}

	public void removeEnemy(Enemy e) {
		enemies.remove(e);
		if(lives < 0 || enemies.size() == 0) {
			System.exit(0);
		}
	}

	public void removeBullet(Bullet bullet) {
		bullets.remove(bullet);
	}

	public List<Enemy> getEnemies() {
		return enemies;
	}

	public void removeLive() {
		lives --;
		if(lives < 0 || enemies.size() == 0) {
			System.exit(0);
		}
	}
}
