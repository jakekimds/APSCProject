package game;

import project.*;

public class PlatformScript extends Script{
	public void Update() {
		int speed = 5;
		gameObject().getTransform().setLocation(gameObject().getTransform().getLocation().add(Vector2.right().multiply((int)(-speed * PlayerScript.speed))));
	}

}
