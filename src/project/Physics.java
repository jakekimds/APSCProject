package project;

public class Physics implements Updatable{
	private Physical physics;
	private Transform transform;
	private CollisionLayer physicsLayer;
	
	private boolean kinematic;
	private boolean useGravity;
	private Vector2 velocity;
	private float mass;
	
	public Physics(Physical physics){
		this.physics = physics;
		this.transform = physics.getTransform();
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
		Move(velocity);
	}
	
	public boolean willCollide(Vector2 movement){
		Vector2 oldLoc = transform.getLocation();
		boolean didCollide = physics.getCollider().didCollide();
		
		Vector2 newLoc = transform.getLocation().add(movement);
		transform.setLocation(newLoc);
		boolean willCollide = physics.getCollider().didCollide();
		
		if(!didCollide && willCollide){
			return true;
		}
		return false;
	}
	
	private void ApplyGravity(){
		if(useGravity){
			velocity.add(Vector2.up().multiply(-1));
		}
	}
	private void ApplyMotion(){
		Move(velocity);
	}
	
	public void Move(Vector2 movement){
		if(!kinematic && willCollide(movement)){
			velocity = Vector2.zero();
			return;
		}
		Vector2 newLoc = transform.getLocation().add(movement);
		transform.setLocation(newLoc);
	}
	

}
