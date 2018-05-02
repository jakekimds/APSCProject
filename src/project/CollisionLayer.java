package project;

import java.util.List;

public class CollisionLayer {
	private List<Collidable> memberObjects;
	
	public void updateAll(){
		for(int i = 0; i < memberObjects.size(); i++){
			memberObjects.get(i).getCollider().Update();
		}
	}
	
	public void add(Collidable objectToAdd){
		memberObjects.add(objectToAdd);
	}
	
	public List<Collidable> getList(){
		return memberObjects;
	}
}
