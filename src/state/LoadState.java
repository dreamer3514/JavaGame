package state;

import java.awt.Graphics;
import resources.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import game.main.GameMain;
public class LoadState implements State
{

	@Override
	public void init()
	{
		try
		{
			Resources.load();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("‘ÿ»Î≥…π¶");					
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update()
	{
		GameMain.sGame.setCurrentState(new MenuState());
		//setCurrentState(new MenuState());
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyPress(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyRelease(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
