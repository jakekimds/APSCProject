package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Text extends GameObject implements Drawable {

	String string;
	int size = 30;
	
	public Text(Scene scene) {
		super(scene);
		string = "";
		scene.addDrawable(this);
	}
	
	public void setString(String str){
		string = str;
	}
	
	public void setFontSize(int size){
		this.size = size;
	}
	
	public void draw(Graphics window){
		window.setFont(new Font(Font.DIALOG, Font.BOLD, size));
		window.setColor(Color.BLUE);
		window.drawString(string, getTransform().getLocation().getX(), getTransform().getLocation().getY());
	}

}
