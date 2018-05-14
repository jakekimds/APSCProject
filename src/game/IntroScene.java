package game;

import project.*;

public class IntroScene extends Scene{
	
	public static int score = 0;

	public IntroScene(GraphicsRunner runner) {
		super(runner);
		int down = 50;
		Text text = new Text(this);
		text.getTransform().setLocation(new Vector2(50, down));
		text.setString("Platformer 3000");
		down += 100;
		
		text = new Text(this);
		text.getTransform().setLocation(new Vector2(50, down));
		text.setString("Jake Kim");
		down += 50;
		
		text = new Text(this);
		text.getTransform().setLocation(new Vector2(50, down));
		text.setString("Press space to jump. Double jumps allowed");
		down += 50;
		
		text = new Text(this);
		text.getTransform().setLocation(new Vector2(50, down));
		text.setString("Avoid the red.");
		down += 50;
		
		text = new Text(this);
		text.getTransform().setLocation(new Vector2(50, down));
		text.setString("Press enter to play");
		down += 100;
		
		if(score > 0){
			text = new Text(this);
			text.getTransform().setLocation(new Vector2(50, down));
			text.setString("Previous Score: "+score);
			down += 50;
		}
		
		GameObject go = new GameObject(this);
		go.addScript(new NextScene());
	}
	
	

}
