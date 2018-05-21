package project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import game.PlayerScript;
import project.*;

public class Rectangle extends GameObject implements Drawable, Physical{
	
	private Transform transform;
	private Collider collider;
	private Physics physics;
	private Image img;

	Color color;

	public Rectangle(Scene scene, Vector2 dimensions, Color col) {
		super(scene);
		transform = new Transform(new Vector2(100, 100), dimensions);
		collider = new Collider(this);
		physics = new Physics(this);
		color = col;
		scene.addDrawable(this);
		setImage("img.png");
	}
	
	public void draw(Graphics window) {
		Vector2 location = transform.getLocation();
		Vector2 dimension = transform.getDimension();
		int x = dimension.getX();
		int y = dimension.getY();
		
		window.drawImage(img, location.getX(), location.getY() , x, y, null);
//		window.setColor(color);
//		window.fillRect(location.getX(), location.getY(), dimension.getX(), dimension.getY());
	}
	
	public void setImage(String path){
		try {
			img = ImageIO.read(new File(path));
		} catch (Exception e) {
			System.out.println("Image Exception");
		}
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
