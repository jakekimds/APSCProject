package game;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.lang.reflect.GenericArrayType;

import project.*;

public class TestScript extends Script {
	
	public int countDown = 150;
	public int points = 0;
	public Text score;

	public void Update() {
		score.setString(""+points);
		if(countDown <= 0){
			((Physical)gameObject()).getPhysics().setUseGravity(true);
			points++;
		}else{
			countDown --;
			return;
		}
		if(gameObject().getScene().getRunner().getKey(KeyEvent.VK_D)){
			gameObject().getTransform().setLocation(gameObject().getTransform().getLocation().add(Vector2.right().multiply(10)));
		}
		if(gameObject().getScene().getRunner().getKey(KeyEvent.VK_A)){
			gameObject().getTransform().setLocation(gameObject().getTransform().getLocation().add(Vector2.right().multiply(-10)));
		}
		if(gameObject().getScene().getRunner().getKeyDown(KeyEvent.VK_SPACE)){
			((Physical)gameObject()).getPhysics().setVelocity((Vector2.up().multiply(30)));
		}
		
	}
	
public void OnCollide(BaseObject obj){
		if(obj.getTag() == "ground"){
			System.out.println("dfsd");
			gameObject().getScene().backgroundColor = Color.red;
			gameObject().getScene().getRunner().setScene(new IntroScene(gameObject().getScene().getRunner()));
		}
	}

}
