package project;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Sprite{
	Image image;
	
	public void setImage(Image _image){
		image = _image;
	}
	
	public void draw(Graphics window){
		window.drawImage(image, 0, 0, 0, 0, null);
	}
	
	public Image getImage(String path){
		try {
			return ImageIO.read(new File(path));
		} catch (Exception e) {
			System.out.println(path + "Failed");
		}
		return null;
	}
}
