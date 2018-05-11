package game;

import java.awt.Color;

import project.*;

public class TestScene extends Scene {
	
	Sprite testObj;
	Rectangle testObj2;
	GameObject testObj3;
	
	public TestScene(GraphicsRunner runner){
		super(runner);
		Text text = new Text(this);
		text.getTransform().setLocation(new Vector2(50, 50));
		addDrawable(text);
		
		testObj2 = new Rectangle(this, new Vector2(50, 50), Color.blue);
		testObj2.getPhysics().setUseGravity(false);
		TestScript player = new TestScript();
		player.score = text;
		testObj2.addScript(player);
		addDrawable(testObj2);
		
		testObj2 = new Rectangle(this, new Vector2(800, 50), Color.red);
		testObj2.getTransform().setLocation(new Vector2(0, 550));
		testObj2.setTag("ground");
		addDrawable(testObj2);
		
		testObj2 = new Rectangle(this, new Vector2(800, 50), Color.red);
		testObj2.getTransform().setLocation(new Vector2(0, -20));
		testObj2.setTag("ground");
		addDrawable(testObj2);
		
		testObj3 = new Spawner(this);
		testObj3.getTransform().setLocation(new Vector2(800, 450));
		
		testObj3 = new Spawner(this);
		testObj3.getTransform().setLocation(new Vector2(1000, 300));
		
		testObj3 = new Spawner(this);
		testObj3.getTransform().setLocation(new Vector2(1200, 150));
	}
	
}
