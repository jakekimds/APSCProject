package project;

import java.util.ArrayList;
import java.util.List;

public class GameObject implements BaseObject, Transformable{
	Scene scene;
	List<Script> scripts = new ArrayList<Script>();
	Transform transform;
	String tag;
	
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
	public List<Script> getScripts(){
		return scripts;
	}
	
	public Transform getTransform() {
		return transform;
	}
	
	public String getTag(){
		return tag;
	}
	
	public void setTag(String tag){
		this.tag = tag;
	}
}
