package state;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import game.main.GameMain;
import model.Button;
import model.End;
import model.Fruit;
import model.Player;
import model.Wall;
import resources.Resources;

public class Second extends PlayState implements State
{
	private Player1 p,q=null;
	private int vy=-8,y=600,x=200,isOn;
	private Wall wall = new Wall(710, 500, 30, 200);
	private Fruit[] f1 = {new Fruit(400, 500, 40, 50),new Fruit(80, 400, 40, 50),new Fruit(400, 100, 40, 50),new Fruit(250, 300, 40, 50)};
	private Fruit[] f2 = {new Fruit(600, 500, 40, 50),new Fruit(80, 500, 40, 50),new Fruit(400, 400, 40, 50),new Fruit(800, 500, 40, 50)};
	
	private Button frush = new Button(960, 320, 55, 55);
	
	private Button button = new Button(400,210,42,40);
	
	private End end=new End(900,540,500,100);
	private Rectangle moveRec = new Rectangle(200, 600, 80, 20);
	
	public class Player1 extends Player
	{
	
		public Player1(int X, int Y, int weight, int w, int h)
		{
			super(X, Y, weight, w, h);
		}
		
		
		@Override
		public boolean isFloor()
		{
			if(Y>=560)
			{
				Y=560;
				return true;
			} 
			if(Y>130&&Y<180&&X>320&&X<600)
			{
				Y=140;
				return true;
			}
			if(isFloor==1)
			{
				return true;
			}	
			return false;
		}
		
	}
	@Override
	public void init()
	{
		Resources.bgMusic.loop();
		Resources.ballm.loop();
		startTime = System.currentTimeMillis();
		p = new Player1(100,560,1,25,20);
		q = new Player1(200,560,2,55,20);
		System.out.println("游戏界面加载成功");
	}
	public void WallRender(Wall wall, Graphics g)
	{
		g.drawImage(Resources.wall, wall.getX(), wall.getRectangle().y, null);
	}
	@Override
	public void btnRender(Button b,Graphics g)
	{
		if(b.getRectangle().intersects(p.getRectangle())||b.getRectangle().intersects(q.getRectangle()))
		{
			g.drawImage(Resources.btnDown, b.getX(), b.getY(), null);
			//System.out.println("踩到了");
			wall.setOn(1);
		}
		else if(!b.getRectangle().intersects(p.getRectangle())&&!b.getRectangle().intersects(q.getRectangle()))
		{
			g.drawImage(Resources.btnOn, b.getX(), b.getY(), null);

			wall.setOn(-1);
		}
		//System.out.println(b.isOn());
		
	}
	@Override
	public void bgRender(Graphics g)
	{
		g.drawImage(Resources.bg1, 0, 0,1100,700,null);
	}
	public void endRender(End e,Graphics g)
	{
		g.drawImage(Resources.end1, e.getX1(), e.getY1(), null);
		g.drawImage(Resources.end1, e.getX2(),e.getY2(), null);
	}
	@Override
	public void render(Graphics g)
	{
		bgRender(g);
		
		ballRender(g);
		endRender(end,g);
		playerRender(p, q, g);
		btnRender(button, g);
		//btnRender(frush, g);
		//frushBtn(frush, g);
		fruitRender1(f1, g);
		fruitRender2(f2, g);
		WallRender(wall,g);
		
		//g.drawRect(end.getEnd1().x, end.getEnd1().y, end.getEnd1().width, end.getEnd1().height);
		//g.drawRect(end.getEnd2().x, end.getEnd2().y, end.getEnd2().width, end.getEnd2().height);
		//g.drawRect(wall.getRectangle().x, wall.getRectangle().y, wall.getRectangle().width, wall.getRectangle().height);
		//g.drawRect(p.getRectangles().x, p.getRectangles().y, p.getRectangles().width, p.getRectangles().height);
		for (Fruit fruit : f1)
		{
			if(fruit.getRectangle().intersects(q.getRectangles()))
			{
				if(fruit.isShow()==1)
					Resources.fruit.play();	
				fruit.setisShow(-1);
				
			}
			
				
			
		}
		for (Fruit fruit : f2)
		{
			if(fruit.getRectangle().intersects(p.getRectangles()))
			{
				if(fruit.isShow()==1)
					Resources.fruit.play();	
				fruit.setisShow(-1);
				
			}
			
				
		}
		
		if(q.getRectangle().intersects(end.getEnd2())&&p.getRectangle().intersects(end.getEnd1()))
		{
			//System.out.println("fffffffffffffffff");
			success();
			//System.out.println("!!!!");
		}
	}
	
	@Override
	public void update()
	{
		p.update();
		q.update();
		moveRecupdate();
		wallupdate();
		System.out.println(p.isFloor);

		if(moveRec.intersects(p.getRectangle()))
		{
			p.isFloor=1;
			//p.setX(moveRec.x);
			p.setY(moveRec.y-100);
		}
		else if(moveRec.intersects(q.getRectangle()))
		{
			q.isFloor=1;
			//q.setX(moveRec.x);
			q.setY(moveRec.y-100);
		}
		else {
			q.isFloor=-1;
			p.isFloor=-1;
		}
	}
	
	public void ballRender(Graphics g)
	{
		g.drawImage(Resources.ball,moveRec.x-30, moveRec.y-120, null);
		//System.out.println("666");
	}
	public void wallupdate()
	{
		if(wall.isPass()==-1)
		{
			//System.out.println("fffffffffffffffff");
			if(p.getRectangle().intersects(wall.getRectangle()))
			{
				p.setX(wall.getRectangle().x-100);
			}
			if(q.getRectangle().intersects(wall.getRectangle()))
			{
				q.setX(wall.getRectangle().x-100);
			}
		}
		if(wall.isPass()==1)
		{
			if(wall.getRectangle().y>0)
			{
				wall.getRectangle().y+=10;
			}
		}
	}
	public void moveRecupdate()
	{

//		if(moveRec.intersects(p.getRectangle())||moveRec.intersects(q.getRectangle()))
//		{
			
			y+=vy;
			if(y<=300||y>=600)
				vy*=-1;

//		}
		moveRec.setBounds(x, y, 80, 20);
//		
	}
//	
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
		Resources.bgMusic.stop();
		Resources.ballm.stop();
		endTime = System.currentTimeMillis();
		time = (int) (endTime-startTime)/1000;
		for (Fruit fruit : f1)
		{
			if(fruit.isShow()==-1)
				count1++;
		}
		for (Fruit fruit : f2)
		{
			if(fruit.isShow()==-1)
				count2++;
		}
		ScoreState scoreState = new ScoreState();
		scoreState.time = time;
		scoreState.count1 = count1;
		scoreState.count2 = count2;
		System.out.println(time+":"+count1+":"+count2);
		PlayState playState = new PlayState();
		scoreState.nextState = playState;
		GameMain.sGame.setCurrentState(scoreState);
	}
	@Override
	public void mousePressed(MouseEvent e)
	{
		if(frush.getRectangle().contains(e.getPoint()))
		{
			frush.setOn(1);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		if(frush.getRectangle().contains(e.getPoint()))
		{
			GameMain.sGame.setCurrentState(new Second());
			
		}
		
	}
	

	
}
