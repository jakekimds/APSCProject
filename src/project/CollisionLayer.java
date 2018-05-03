package project;

import java.util.List;

public class CollisionLayer {
	private List<Collidable> memberObjects;
	
	public void add(Collidable objectToAdd){
		memberObjects.add(objectToAdd);
	}
	
	public List<Collidable> getList(){
		return memberObjects;
	}
}
