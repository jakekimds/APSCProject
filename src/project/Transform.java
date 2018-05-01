package project;

public class Transform {
	private Vector2 location;
	private Vector2 dimension;
	
	public void set(Vector2 location, Vector2 dimension){
		this.location = location;
		this.dimension = dimension;
	}

	public Vector2 getLocation() {
		return location;
	}

	public void setLocation(Vector2 location) {
		this.location = location;
	}

	public Vector2 getDimension() {
		return dimension;
	}

	public void setDimension(Vector2 dimension) {
		this.dimension = dimension;
	}
	
}
