package game;

import java.awt.event.KeyEvent;

import project.Physical;
import project.Script;
import project.Vector2;

public class NextScene extends Script{

	public void Update() {
		if(gameObject().getScene().getRunner().getKeyDown(KeyEvent.VK_ENTER)){
			gameObject().getScene().getRunner().setScene(new TestScene(gameObject().getScene().getRunner()));
		}
	}

}
