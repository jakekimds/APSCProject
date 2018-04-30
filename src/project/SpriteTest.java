package project;
//© A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class SpriteTest{
	private Image[] images;
	private final int numberOfFrames;
	private int frameNumber;
	
	public SpriteTest(String prefixPath, int numFrames, int startFrame, int endFrame){
		numberOfFrames = endFrame-startFrame+1;
		images = new Image[numberOfFrames];
		for(int i = 0; i < images.length; i++){
			images[i] = loadImage(prefixPath+(String.format("%02d", i+startFrame))+".png");
		}
	}
	
	public void Update(){
		frameNumber ++;
		frameNumber %= numberOfFrames;
	}
	
	public Image loadImage(String path){
		try {
			return ImageIO.read(new File(path));
		} catch (Exception e) {
			//feel free to do something here
			System.out.println(path);
		}
		return null;
	}
	public void draw(Graphics window) {
		window.drawImage(images[frameNumber], 0,0, 165, 292, null);
	}
}
