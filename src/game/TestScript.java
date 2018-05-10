package game;
import java.awt.event.KeyEvent;

import project.*;

import project.Script;

public class TestScript extends Script {

	public void Update() {
		if(gameObject().getScene().getRunner().getKey(KeyEvent.VK_W)){
			gameObject().getTransform().setLocation(gameObject().getTransform().getLocation().add(Vector2.up()));
		}
		
	}

}
