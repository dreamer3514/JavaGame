package state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import game.main.GameMain;
import model.Player;
import state.Second.Player1;

public class Third extends PlayState implements State
{
	private Player2 p,q=null;
	public class Player2 extends Player
	{

		public Player2(int X, int Y, int weight, int w, int h)
		{
			super(X, Y, weight, w, h);
		}
		@Override
		public boolean isFloor()
		{
			return true;
			
		}
		
	}
	@Override
	public void init()
	{
		p = new Player2(100,560,1,25,20);
		q = new Player2(200,560,2,55,20);
		System.out.println("游戏界面加载成功");
	}
	@Override
	public void bgRender(Graphics g)
	{
		
	}
	
	@Override
	public void render(Graphics g)
	{
		playerRender(p, q, g);
	}
	
	@Override
	public void update()
	{
		p.update();
		q.update();
	}
	
	@Override
	public void onKeyPress(KeyEvent e)
	{
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			p.setvX(-15);
			p.isRun(1);
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			p.setvX(15);
			p.isRun(1);
		}	
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{			
			p.isJump(1);
		}
		if(e.getKeyCode()==KeyEvent.VK_A)
		{
			q.setvX(-15);
			q.isRun(1);
		}
		if(e.getKeyCode()==KeyEvent.VK_D)
		{
			q.setvX(15);
			q.isRun(1);
		}	
		if(e.getKeyCode()==KeyEvent.VK_W)
		{			
			q.isJump(1);
		}
	}
	
	@Override
	public void onKeyRelease(KeyEvent e)
	{
		if((e.getKeyCode()==KeyEvent.VK_LEFT)||(e.getKeyCode()==KeyEvent.VK_RIGHT))	
		{
			p.isRun(-1);			
		}
		if((e.getKeyCode()==KeyEvent.VK_A)||(e.getKeyCode()==KeyEvent.VK_D))	
		{
			q.isRun(-1);			
		}
	}
	
	@Override
	public void success()
	{
		GameMain.sGame.setCurrentState(new Third());
	}
}
