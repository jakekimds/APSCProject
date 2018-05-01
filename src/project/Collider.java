package project;

//Require Locatable

public class Collider {
	
	private Collidable collidable;
	private Transform transform;
	
	public Collider(Collidable collidable){
		this.collidable = collidable;
		this.transform = collidable.getTransform();
	}
	
	public boolean didCollide(Collidable other){
		Transform otherTransform = other.getTransform();
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
