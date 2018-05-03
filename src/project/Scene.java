package project;

import java.util.ArrayList;
import java.util.List;

public class Scene {
	CollisionLayer collisionLayer = new CollisionLayer();
	List<Updatable> updatables = new ArrayList<Updatable>();
	
	public void addUpdatable(Updatable updatable){
		updatables.add(updatable);
	}
	public void addCollidable(Collidable collidable){
		collisionLayer.add(collidable);
	}
	
	public CollisionLayer getCollisionLayer(){
		return collisionLayer;
	}
	
	public void Update(){
		for(Updatable updatable : updatables){
			updatable.Update();
		}
	}
}
