package util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import state.*;

public class InputHandler implements MouseListener,KeyListener
{
	public State currentState;

	public void setCurrentState(State currentState)
	{
		this.currentState = currentState;
	}
	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub		
	}
	@Override
	public void keyPressed(KeyEvent e)
	{
		currentState.onKeyPress(e);
	
		// TODO Auto-generated method stub		
	}
	@Override
	public void keyReleased(KeyEvent e)
	{
		currentState.onKeyRelease(e);
		// TODO Auto-generated method stub		
	}
	@Override
	public void mouseClicked(MouseEvent e)
	{
		currentState.onClick(e);
		System.out.println("µã»÷Êó±ê");
		// TODO Auto-generated method stub		
	}
	@Override
	public void mousePressed(MouseEvent e)
	{
		currentState.mousePressed(e);
		
	}
	@Override
	public void mouseReleased(MouseEvent e)
	{
		currentState.mouseReleased(e);
		
	}
	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
