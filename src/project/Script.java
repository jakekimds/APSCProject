package project;

public abstract class Script implements Updatable{
	
	GameObject gameObject;
	
	public void Start(GameObject gameObject){
		this.gameObject = gameObject;
	}
	
	public GameObject gameObject(){
		return gameObject;
	}
	
	public void OnCollide(BaseObject obj){
		
	}
	
	public abstract void Update();
}
