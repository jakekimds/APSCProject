package game;

import project.*;

public class TestScene extends Scene {
	
	TestObj testObj;
	TestObj testObj2;
	
	public TestScene(){
		testObj = new TestObj(this);
		addDrawable(testObj);
		testObj.getPhysics().setUseGravity(true);
		
		testObj2 = new TestObj(this);
		testObj2.getTransform().setLocation(new Vector2(100, 500));
		addDrawable(testObj2);
	}
	
}
