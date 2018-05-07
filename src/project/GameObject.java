package project;

import java.util.ArrayList;
import java.util.List;

public class GameObject{
	Scene scene;
	List<Script> scripts = new ArrayList<Script>();
	public GameObject(Scene scene){
		this.scene = scene;
	}
	
	public Scene getScene(){
		return scene;
	}
	
	public void addScript(Script script){
		script.Start(this);
		scripts.add(script);
		scene.addUpdatable(script);
	}
}
