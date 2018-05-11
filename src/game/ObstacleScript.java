package game;

import project.*;

public class ObstacleScript extends Script{
	public void Update() {
		gameObject().getTransform().setLocation(gameObject().getTransform().getLocation().add(Vector2.right().multiply(-5)));
	}

}
