package project;

import java.util.ArrayList;
import java.util.List;

public class GameObject implements BaseObject {
	Scene scene;
	List<Script> scripts = new ArrayList<Script>();
	public GameObject(Scene scene){
		this.scene = scene;
	}
	
	public Scene getScene(){
		return scene;
	}
	
	public void addScript(Script script){
		
	}
}
