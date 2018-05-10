package project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import game.TestScene;

public class GraphicsRunner extends Canvas implements KeyListener, Runnable {
	private boolean[] keys;
	private BufferedImage back;
	private Scene scene;
	private Drawable drawable;
	private Set<Integer> key;
	private Set<Integer> keydown;
	
	public GraphicsRunner() {
		setBackground(Color.black);
		keys = new boolean[5];
		this.addKeyListener(this);
		new Thread(this).start();
		setVisible(true);
		key = new HashSet<Integer>();
		keydown = new HashSet<Integer>();
		
		scene = new TestScene(this);
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D) window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if (back == null)
			back = (BufferedImage) (createImage(getWidth(), getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();
		
		
		
		
		//Stuff
		scene.Update();
		scene.draw(graphToBack);
		

		twoDGraph.drawImage(back, null, 0, 0);
		keydown.clear();
	}
	
	public boolean getKey(int keycode){
		return key.contains(keycode);
	}
	public boolean getKeyDown(int keycode){
		return keydown.contains(keycode);
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			keys[4] = true;
		}
		key.add(e.getKeyCode());
		keydown.add(e.getKeyCode());
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			keys[4] = false;
		}
		key.remove(e.getKeyCode());
	}

	public void keyTyped(KeyEvent e) {

	}

	public void run() {
		try {
			while (true) {
				Thread.currentThread().sleep(1000/30);
				repaint();
			}
		} catch (Exception e) {
		}
	}
}
