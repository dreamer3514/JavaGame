package state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import game.main.GameMain;
import model.Button;
import resources.Resources;

public class OverState implements State
{

	private Button restart =new Button(500, 600, 110, 55);
	@Override
	public void init()
	{
		Resources.over.play();
		
	}

	@Override
	public void update()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g)
	{
		g.drawImage(Resources.overImage, 200, 200, null);
		if(restart.isOn()==-1)
			g.drawImage(Resources.restart, restart.getX(), restart.getY(), null);
		if(restart.isOn()==1)
			g.drawImage(Resources.restart1, restart.getX(), restart.getY(), null);

			
		
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
		if(restart.getRectangle().contains(e.getPoint()))
		{
			restart.setOn(1);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		if(restart.getRectangle().contains(e.getPoint()))
		{
			Resources.click.play();
			//setCurrentState(new PlayState());
			//GameMain.sGame.setCurrentState(new PlayState());
			GameMain.sGame.setCurrentState(new MenuState());
			
		}
		
	}
}
