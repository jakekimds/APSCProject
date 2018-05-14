package project;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import game.PlayerScript;
import project.*;

public class Sprite extends GameObject implements Drawable, Physical{
	
	private Transform transform;
	private Collider collider;
	private Physics physics;
	
	private Img image;

	public Sprite(Scene scene, String imgPath) {
		super(scene);
		image = new Img(imgPath);
		transform = new Transform(new Vector2(100, 100), image.getDimensions());
		collider = new Collider(this);
		physics = new Physics(this);
		scene.addDrawable(this);
	}
	
	public void draw(Graphics window) {
		Vector2 location = transform.getLocation();
		Vector2 dimension = transform.getDimension();
		image.draw(window, location.getX(), location.getY());
	}

	public Transform getTransform() {
		return transform;
	}

	public Collider getCollider() {
		return collider;
	}

	public Physics getPhysics() {
		return physics;
	}
}
