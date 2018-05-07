package game;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

import project.*;

public class TestObj extends GameObject implements Drawable, Physical{
	
	private Transform transform;
	private Collider collider;
	private Physics physics;
	
	private Image image;

	public TestObj(Scene scene) {
		super(scene);
		transform = new Transform(new Vector2(100, 100), new Vector2(100, 100));
		collider = new Collider(this);
		physics = new Physics(this);
		image = loadImage("images/GrantSprites/sprite_00.png");
	}
	
	public Image loadImage(String path){
		try {
			return ImageIO.read(new File(path));
		} catch (Exception e) {
			System.out.println("Image Exception");
			return null;
		}
	}
	
	public void draw(Graphics window) {
		Vector2 location = transform.getLocation();
		Vector2 dimension = transform.getDimension();
		window.drawImage(image, location.getX(), location.getY(), dimension.getX(), dimension.getY(), null);
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
