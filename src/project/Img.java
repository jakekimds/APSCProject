package project;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Img {
	BufferedImage img;
	Vector2 dimensions;
	
	public Img(String path){
		setImage(path);
	}
	
	public Vector2 getDimensions(){
		System.out.println(dimensions);
		return dimensions;
	}
	
	public void setImage(String path){
		try {
			img = ImageIO.read(new File(path));
			dimensions = new Vector2(img.getWidth(), img.getHeight());
		} catch (Exception e) {
			System.out.println("Image Exception");
		}
	}
	
	public void draw(Graphics window, int x, int y){
		window.drawImage(img, x, y, dimensions.getX(), dimensions.getY(), null);
	}
}
