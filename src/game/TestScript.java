package game;
import project.*;

import project.Script;

public class TestScript extends Script {

	public void Update() {
		
		gameObject().getTransform().setLocation(gameObject().getTransform().getLocation().add(Vector2.up()));
		
	}

}
