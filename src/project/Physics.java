package project;

public class Physics implements Updatable{
	private Physical physics;
	private Transform transform;
	private PhysicsLayer physicsLayer;
	
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
		//TODO: add stuff
	}
	

}
