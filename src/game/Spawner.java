package game;

import java.awt.Color;
import java.util.Random;

import project.*;

public class Spawner extends GameObject implements Updatable{
	
	public int countDown = 0;
	Scene scene;
	Random random;
	int time = 0;
	float difficulty;

	public Spawner(Scene scene) {
		super(scene);
		this.scene = scene;
		scene.addUpdatable(this);
		random = new Random();
		time = 0;
		difficulty = (float)time/(time + 500);
		countDown = random.nextInt(Math.abs((int)(100 * difficulty))+1)+50;
	}

	public void Update() {
		time++;
		difficulty = (float)time/(time + 500);
		if(countDown <= 0){
			Rectangle testObj2;
			if(random.nextInt(100) <= 5){
				testObj2 = new Rectangle(scene, new Vector2(100, 20), Color.red);
				testObj2.setTag("ground");
			}else{
				testObj2 = new Rectangle(scene, new Vector2(100, 20), Color.green);
			}
			testObj2.getTransform().setLocation(getTransform().getLocation());
			testObj2.addScript(new PlatformScript());
			scene.addDrawable(testObj2);
			countDown = random.nextInt(Math.abs((int)(100 * difficulty))+1)+50;
		}
		countDown -= 1;
	}
	

}
