package game;

import project.*;

public class IntroScene extends Scene{

	public IntroScene(GraphicsRunner runner) {
		super(runner);
		int down = 50;
		Text text = new Text(this);
		text.getTransform().setLocation(new Vector2(50, down));
		text.setString("Platformer 3000");
		addDrawable(text);
		down += 50;
		
		text = new Text(this);
		text.getTransform().setLocation(new Vector2(50, down));
		text.setString("Jake Kim");
		addDrawable(text);
		down += 50;
		
		text = new Text(this);
		text.getTransform().setLocation(new Vector2(50, down));
		text.setString("Press space to jump");
		addDrawable(text);
		down += 50;
		
		text = new Text(this);
		text.getTransform().setLocation(new Vector2(50, down));
		text.setString("Avoid the red.");
		addDrawable(text);
		down += 50;
		
		text = new Text(this);
		text.getTransform().setLocation(new Vector2(50, down));
		text.setString("Press enter to play");
		addDrawable(text);
		down += 50;
		
		GameObject go = new GameObject(this);
		go.addScript(new NextScene());
	}
	
	

}
