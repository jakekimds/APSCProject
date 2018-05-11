package project;

import java.util.List;

public class Physics implements Updatable{
	private Physical physics;
	private Transform transform;
	private CollisionLayer physicsLayer;
	
	private boolean kinematic;
	private boolean useGravity;
	private Vector2 velocity;
	private float mass;
	private boolean didCollide = false;
	
	public Physics(Physical physics){
		this.physics = physics;
		this.transform = physics.getTransform();
		velocity = new Vector2(0,0);
		physics.getScene().addUpdatable(this);
	}

	public boolean isKinematic() {
		return kinematic;
	}

	public void setKinematic(boolean kinematic) {
		this.kinematic = kinematic;
	}

	public boolean isUseGravity() {
		return useGravity;
	}

	public void setUseGravity(boolean useGravity) {
		this.useGravity = useGravity;
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public float getMass() {
		return mass;
	}

	public void setMass(float mass) {
		this.mass = mass;
	}
	
	public void Update(){
		ApplyGravity();
		ApplyMotion();
	}
	
	public boolean willCollide(Vector2 movement){
		Vector2 oldLoc = transform.getLocation();
		Vector2 newLoc = oldLoc.add(movement);
		transform.setLocation(newLoc);
		boolean willCollide = physics.getCollider().isColliding();
		boolean oldCollide = didCollide;
		didCollide = willCollide;
		transform.setLocation(newLoc.add(movement.multiply(-1)));
		
		if(willCollide){
			return true;
		}
		return false;
	}
	
	private void ApplyGravity(){
		if(useGravity){
			velocity = velocity.add(Vector2.up().multiply(-2));
		}
	}
	private void ApplyMotion(){
		Move(velocity);
	}
	
	public void Move(Vector2 movement){
		Vector2 xMov = movement.withY(0);
		Vector2 yMov = movement.withX(0);
		Vector2 newLoc = transform.getLocation();
		if(kinematic || !willCollide(xMov)){
			newLoc = newLoc.add(xMov);
		}else{
			velocity = velocity.withX(0);
		}
		if(kinematic || !willCollide(yMov)){
			newLoc = newLoc.add(yMov);
		}else{
			velocity = velocity.withY(0);
		}
		
		transform.setLocation(newLoc);
	}
	

}
