package frame;

import java.util.HashMap;
import java.util.Map;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

	private Map<Integer, Boolean> pressedKeys;

	public InputHandler() {
		pressedKeys = new HashMap<>();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		pressedKeys.put(e.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		pressedKeys.put(e.getKeyCode(), false);
	}

	public boolean isKeyPressed(int key) {
		return pressedKeys.getOrDefault(key, false);
	}
}
