package game.main;

import javax.swing.JFrame;


//import Resources.Resources;

public class GameMain
{
	private static final String GAME_TITLE = "JavaGame";			//´°¿Ú±êÌâ
	private static final int GAME_WIDTH = 1100;
	private static final int GMAE_HEIGHT = 700;
	
	public static Game sGame;
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame(GAME_TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);
		frame.setVisible(true);
		
		sGame = new Game(GAME_WIDTH, GMAE_HEIGHT);
		frame.add(sGame);
		frame.pack();
		
		frame.setVisible(true);
//		frame.setFocusable(true);
//		frame.requestFocus();	
		//frame.setIconImage(Resources.iconimage);
	}
}
