package project;

import java.util.ArrayList;
import java.util.List;

public class GameObject implements BaseObject, Transformable{
	Scene scene;
	List<Script> scripts = new ArrayList<Script>();
	Transform transform;
	
	public GameObject(Scene scene){
		this.scene = scene;
		transform = new Transform(new Vector2(100, 100), new Vector2(100, 100));
	}
	
	public Scene getScene(){
		return scene;
	}
	
	public void addScript(Script script){
		script.Start(this);
		scripts.add(script);
		scene.addUpdatable(script);
	}
	
	public Transform getTransform() {
		return transform;
	}
}
