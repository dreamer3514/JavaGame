package state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.xml.stream.events.StartDocument;

import game.main.GameMain;
import model.Button;
import resources.Resources;

public class MenuState implements State
{

	Button start = new Button(400, 400, 260, 100);
	
	@Override
	public void init()
	{
		System.out.println("≤Àµ•");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update()
	{
		//setCurrentState(new PlayState());
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void render(Graphics g)
	{
		g.drawImage(Resources.menuImage, 0, 0,1100,700, null);
		if(start.isOn()==-1)
		{
			g.drawImage(Resources.startBtn,start.getX(),start.getY(), null);
		}
		if(start.isOn()==1)
		{
			g.drawImage(Resources.startBtnDown,start.getX(),start.getY(), null);
		}
	
	}

	@Override
	public void onClick(MouseEvent e)
	{
		
		
		//System.out.println(" Û±Í");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyPress(KeyEvent e)
	{
		//System.out.println("º¸≈Ã");
		//System.out.println(e.getKeyChar());
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
		if(start.getRectangle().contains(e.getPoint()))
		{
			start.setOn(1);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		if(start.getRectangle().contains(e.getPoint()))
		{
			Resources.click.play();
			//setCurrentState(new PlayState());
			//GameMain.sGame.setCurrentState(new PlayState());
			GameMain.sGame.setCurrentState(new Second());
			
		}
		
	}

}
