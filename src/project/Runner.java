package project;

import javax.swing.JFrame;
import java.awt.Component;

public class Runner extends JFrame
{
	private static final int WIDTH = 1024;
	private static final int HEIGHT = 768;

	public Runner()
	{
		super("STARFIGHTER");
		setSize(WIDTH,HEIGHT);

		GraphicsRunner theGame = new GraphicsRunner();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
	}

	public static void main( String args[] )
	{
		Runner run = new Runner();
	}
}