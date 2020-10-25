package game;

import frame.InputHandler;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Game {

	private InputHandler ih;
	private Player p;

	public Game(Window w) {
		p = new Player();
		ih = new InputHandler();

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

		if(ih.isKeyPressed(KeyEvent.VK_SPACE)) {
			p.shoot();
		}

	}

	public void draw(Graphics g) {
		p.draw(g);
	}
}
