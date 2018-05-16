package game;

import java.awt.Color;

import project.*;

public class MainScene extends Scene {
	
	Sprite testObj;
	Rectangle testObj2;
	GameObject testObj3;
	
	public MainScene(GraphicsRunner runner){
		super(runner);
		Text text = new Text(this);
		text.getTransform().setLocation(new Vector2(50, 70));
		
		testObj2 = new Rectangle(this, new Vector2(50, 50), Color.blue);
		testObj2.getPhysics().setUseGravity(false);
		PlayerScript player = new PlayerScript();
		player.score = text;
		testObj2.addScript(player);
		
		testObj2 = new Rectangle(this, new Vector2(800, 50), Color.red);
		testObj2.getTransform().setLocation(new Vector2(0, 550));
		testObj2.setTag("ground");
		
		testObj2 = new Rectangle(this, new Vector2(800, 50), Color.red);
		testObj2.getTransform().setLocation(new Vector2(0, -20));
		testObj2.setTag("ground");
		
		testObj3 = new Spawner(this);
		testObj3.getTransform().setLocation(new Vector2(800, 450));
		
		testObj3 = new Spawner(this);
		((Spawner)testObj3).spawnRed = true;
		testObj3.getTransform().setLocation(new Vector2(1000, 300));
		
		testObj3 = new Spawner(this);
		testObj3.getTransform().setLocation(new Vector2(1200, 150));
	}
	
}
