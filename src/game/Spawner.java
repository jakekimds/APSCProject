package game;

import java.awt.Color;
import java.util.Random;

import project.*;

public class Spawner extends GameObject implements Updatable{
	
	public int countDown = 0;
	Scene scene;
	Random random;

	public Spawner(Scene scene) {
		super(scene);
		this.scene = scene;
		scene.addUpdatable(this);
		random = new Random();
	}

	public void Update() {
		if(countDown <= 0){
			Rectangle testObj2 = new Rectangle(scene, new Vector2(100, 20), Color.green);
			testObj2.getTransform().setLocation(getTransform().getLocation());
			testObj2.addScript(new ObstacleScript());
			scene.addDrawable(testObj2);
			countDown = random.nextInt(50)+50;
		}
		countDown -= 1;
	}
	

}
