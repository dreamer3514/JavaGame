package state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import game.main.GameMain;

public interface State
{
	public abstract void init();
	
	public abstract void update();
	
	public abstract void render(Graphics g);
	
	public abstract void onClick(MouseEvent e);
	
	public abstract void onKeyPress(KeyEvent e);
	
	public abstract void onKeyRelease(KeyEvent e);
	
//	public void setCurrentState(State newState)
//	{
//		GameMain.sGame.setCurrentState(newState);
//	}

	public abstract void mousePressed(MouseEvent e);

	public abstract void mouseReleased(MouseEvent e);
	
	
}
