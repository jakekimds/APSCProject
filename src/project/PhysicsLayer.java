package project;

import java.util.List;

public class PhysicsLayer {
	private List<Physics> memberObjects;
	
	public void updateAll(){
		for(int i = 0; i < memberObjects.size(); i++){
			memberObjects.get(i).Update();
		}
	}
	
	public void add(Physics objectToAdd){
		memberObjects.add(objectToAdd);
	}
}
