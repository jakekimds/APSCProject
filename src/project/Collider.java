package project;

import java.awt.Color;
import java.util.List;

//Require Locatable

public class Collider{
	
	private Collidable collidable;
	private Transform transform;
	private CollisionLayer collisionLayer;
	
	public Collider(Collidable collidable){
		this.collidable = collidable;
		this.transform = collidable.getTransform();
		this.collisionLayer = collidable.getScene().getCollisionLayer();
		collidable.getScene().addCollidable(collidable);
	}
	
	public boolean isColliding(){
		List<Collidable> layeritems = collisionLayer.getList();
		for(int i = 0; i < layeritems.size(); i++){
			Collidable item = layeritems.get(i);
			if(item != collidable){
				if(isColliding(item)){
					List<Script> scripts = collidable.getScripts();
					for(int k = 0; k < scripts.size(); k++){
						scripts.get(k).OnCollide(item);
					}
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isColliding(Collidable other){
		return isColliding(collidable, other);
	}
	
	public static boolean isColliding(Collidable obj, Collidable other){
		Transform otherTransform = other.getTransform();
		Transform transform = obj.getTransform();
		Vector2 thisDimension = transform.getDimension();
		Vector2 thisLocation = transform.getLocation();
		Vector2 otherDimension = otherTransform.getDimension();
		Vector2 otherLocation = otherTransform.getLocation();
		
		if (thisLocation.getX() < otherLocation.getX() + otherDimension.getX() && thisLocation.getX() + thisDimension.getX() > otherLocation.getX()
				&& thisLocation.getY() < otherLocation.getY() + otherDimension.getY() && thisLocation.getY() + thisDimension.getY() > otherLocation.getY()) {
			return true;
		}
		return false;
	}
}
