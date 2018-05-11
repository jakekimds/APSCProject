package project;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Scene{
	CollisionLayer collisionLayer = new CollisionLayer();
	List<Updatable> updatables = new ArrayList<Updatable>();
	List<Drawable> drawables = new ArrayList<Drawable>();
	public Color backgroundColor = Color.BLACK;
	private GraphicsRunner runner;
	
	public Scene(GraphicsRunner runner){
		this.runner = runner;
	}
	
	public void addUpdatable(Updatable updatable){
		updatables.add(updatable);
	}
	public void addCollidable(Collidable collidable){
		collisionLayer.add(collidable);
	}
	
	public void addDrawable(Drawable drawable){
		drawables.add(drawable);
	}
	
	public CollisionLayer getCollisionLayer(){
		return collisionLayer;
	}
	
	public void Update(){
		for(int i = 0; i < updatables.size(); i++){
			updatables.get(i).Update();
		}
	}
	
	public GraphicsRunner getRunner(){
		return runner;
	}
	
	public Color getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public void draw(Graphics window){
		window.setColor(backgroundColor);
		window.fillRect(0, 0, Runner.WIDTH, Runner.HEIGHT);
		for(Drawable drawable : drawables){
			drawable.draw(window);
		}
	}
}
