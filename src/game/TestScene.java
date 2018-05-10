package game;

import project.*;

public class TestScene extends Scene {
	
	Sprite testObj;
	Sprite testObj2;
	
	public TestScene(GraphicsRunner runner){
		super(runner);
		testObj = new Sprite(this);
		testObj.getPhysics().setUseGravity(true);
		addDrawable(testObj);
		
		testObj2 = new Sprite(this);
		testObj2.getTransform().setLocation(new Vector2(100, 500));
		addDrawable(testObj2);
	}
	
}
