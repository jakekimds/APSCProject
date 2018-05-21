package game;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.lang.reflect.GenericArrayType;

import project.*;

public class PlayerScript extends Script {
	
	public static int countDown = 175;
	public static float speed = 6;
	public int points = 0;
	public Text score;
	
	private boolean jumped = false;
	private int jump;

	public void Update() {
		if(countDown <= 0){
			if(speed >= 6){
				//speed = 1;
			}else{
				speed *= 1.0001;
			}
			score.setString("Score: "+points);
			((Physical)gameObject()).getPhysics().setUseGravity(true);
			points++;
		}else{
			score.setString("Starting in: "+countDown);
			countDown -= speed;
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
		
		if(jumped){
			gameObject().getTransform().setLocation(gameObject().getTransform().getLocation().withY(jump));
			jumped = false;
		}
		
	}
	
public void OnCollide(BaseObject obj){
		if(obj.getTag() == "ground"){
			IntroScene.score = points;
			gameObject().getScene().backgroundColor = Color.red;
			gameObject().getScene().getRunner().setScene(new IntroScene(gameObject().getScene().getRunner()));
		}else{
			Transform transform = gameObject().getTransform();
			Transform objTransform = obj.getTransform();
			if(transform.getLocation().getY() + transform.getDimension().getY() > objTransform.getLocation().getY() || transform.getLocation().getY() < objTransform.getLocation().getY() + objTransform.getDimension().getY()){
				if(((Physical)gameObject()).getPhysics().getVelocity().getY() > 0){
					jump = (objTransform.getLocation().add(transform.getDimension().withX(0).multiply(-1)).getY());
					jumped = true;
				}else{
					jump = (objTransform.getLocation().add(objTransform.getDimension().withX(0)).getY());
					jumped = true;
				}
			}
		}
	}

}
