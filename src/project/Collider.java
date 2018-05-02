package project;

import java.util.List;

//Require Locatable

public class Collider implements Updatable{
	
	private Collidable collidable;
	private Transform transform;
	private CollisionLayer collisionLayer;
	
	public Collider(Collidable collidable, CollisionLayer collisionLayer){
		this.collidable = collidable;
		this.transform = collidable.getTransform();
		this.collisionLayer = collisionLayer;
	}
	
	public boolean didCollide(){
		List<Collidable> layeritems = collisionLayer.getList();
		for(int i = 0; i < layeritems.size(); i++){
			Collidable item = layeritems.get(i);
			if(item != collidable){
				if(didCollide(item)){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean didCollide(Collidable other){
		return didCollide(collidable, other);
	}
	
	public static boolean didCollide(Collidable obj, Collidable other){
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
	
	public void Update(){

	}
}
