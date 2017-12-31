package state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.xml.crypto.Data;

import org.omg.PortableInterceptor.SUCCESSFUL;

import game.main.GameMain;
import model.Button;
import model.Door;
import model.End;
import model.Fruit;
import model.Player;
import model.Pulley;
import resources.Resources;
import util.Animation;

public class PlayState implements State
{

	private Player p,q = null;
	private Pulley pulley = new Pulley(470, 200);
	private Door movedoor = new Door(10,15,800,430);
	private Button button = new Button(820, 105,42,40);
	
	private Button frush = new Button(960, 620, 55, 55);
	
	private End end	 = new End(10, 282, 900, 20);
	private Fruit[] f1 = {new Fruit(700, 400, 40, 50),new Fruit(200, 450, 40, 50),new Fruit(170, 100, 40, 50),new Fruit(350, 300, 40, 50)};
	private Fruit[] f2 = {new Fruit(600, 500, 40, 50),new Fruit(80, 500, 40, 50),new Fruit(170, 300, 40, 50),new Fruit(800, 40, 40, 50)};
	public int time,count1,count2=0;
	public long startTime,endTime;
	
	@Override
	public void init()
	{
		Resources.bgMusic.play();
		p = new Player(100,560,1,25,20);
		q = new Player(200,560,2,55,20);
		System.out.println("游戏界面加载成功");
		
		startTime = System.currentTimeMillis();
	}
	
	
	@Override
	public void update()
	{
		
		p.update();
		q.update();
		movedoor.update();
		pulley.update();
		//
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
		
		
		//传送门
		if(p.getX()>790&&p.getX()<820&&p.getY()>440&&p.getY()<480)
		{
			
				Resources.movedoor.play();
				p.setX(movedoor.getX1());
				p.setY(movedoor.getY1());
						
		}
		if(q.getX()>790&&q.getX()<820&&q.getY()>440&&q.getY()<480)
		{
				Resources.movedoor.play();
				q.setX(movedoor.getX1());
				q.setY(movedoor.getY1());
						
		}
				
		//按钮  踩到后移动转送门（永久开启）
		if(p.getRectangle().intersects(button.getRectangle())||q.getRectangle().intersects(button.getRectangle()))
		{
			movedoor.isUse(1);
		}
		
		
		//到达目的地
		if(p.getRectangle().intersects(end.getEnd1())&&q.getRectangle().intersects(end.getEnd2()))
		{
			Resources.endm.play();
			success();
		}
		
		//滑轮逻辑
		if(pulley.getlRectangle().intersects(p.getRectangle()))
		{
			p.isFloor(1);
			p.setY(pulley.getlRectangle().y-100);
			pulley.setisOnLeft(1);
			//pulley.setlweight(p.getWeight());		
		}
		else
		{
			p.isFloor(-1);
			pulley.setisOnLeft(-1);
		}
		if(pulley.getrRectangle().intersects(p.getRectangle()))
		{
			p.isFloor(1);
			p.setY(pulley.getrRectangle().y-100);
			pulley.setisOnRight(1);
			//pulley.setrweight(p.getWeight());
		}
		else
		{
			//p.isFloor(-1);
			pulley.setisOnRight(-1);
		}
		if(pulley.getlRectangle().intersects(q.getRectangle()))
		{
			q.isFloor(1);
			q.setY(pulley.getlRectangle().y-100);
			pulley.setisOnLeft(2);
			
		}
		else if(!pulley.getlRectangle().intersects(q.getRectangle())&&!pulley.getlRectangle().intersects(p.getRectangle()))
		{
			q.isFloor(-1);
			pulley.setisOnLeft(-2);
		}
		if(pulley.getrRectangle().intersects(q.getRectangle()))
		{
			q.isFloor(1);
			q.setY(pulley.getrRectangle().y-100);
			pulley.setisOnRight(2);
		}
		else if(!pulley.getrRectangle().intersects(q.getRectangle())&&!pulley.getrRectangle().intersects(p.getRectangle()))
		{
			//q.isFloor(-1);
			pulley.setisOnRight(-2);
		}
		
		switch (pulley.getisOnLeft())
		{
			case 1 :
				pulley.setlweight(p.getWeight());
				break;
			case 2 :
				pulley.setlweight(q.getWeight());
				break;
			case -1:
				pulley.setlweight(0);
				break;
			case -2:
				pulley.setlweight(0);
				break;	
			default :
				break;
		}
		switch (pulley.getisOnRight())
		{
			case 1 :
				pulley.setrweight(p.getWeight());
				break;
			case 2 :
				pulley.setrweight(q.getWeight());
				break;
			case -1:
				pulley.setrweight(0);
				break;
			case -2:
				pulley.setrweight(0);
				break;	
			default :
				break;
		}
		
		//System.out.println(pulley.getlweight()+"...."+pulley.getrweight());
		//System.out.println(pulley.getisOnLeft()+"...."+pulley.getisOnRight());
	}

	@Override
	public void render(Graphics g)
	{
		bgRender( g);
//		
		playerRender(p,q, g);
		
		doorRender(movedoor, g);
		
		pullyRender(pulley,g);
		endRender(end,g);
		btnRender(button, g);
		frushBtn(frush,g);
		
		fruitRender1(f1, g);
		fruitRender2(f2, g);
		//g.drawRect(frush.getX(), frush.getY(), frush.getRectangle().width, frush.getRectangle().height);
		if(q.getRectangle().intersects(end.getEnd2())&&p.getRectangle().intersects(end.getEnd1()))
		{
			success();
			//System.out.println("!!!!");
		}
		
		//g.drawRect(q.getRectangle().x, q.getRectangle().y, q.getRectangle().width, q.getRectangle().height);
		//g.drawRect(p.getRectangle().x, p.getRectangle().y, p.getRectangle().width, p.getRectangle().height);
		
	}
	public void fruitRender1(Fruit[] f,Graphics g)
	{
		for (Fruit fruit : f)
		{
			if(fruit.isShow()==1)
				g.drawImage(Resources.fruit1, fruit.getX(), fruit.getY(), null);
		}
	}
	public void fruitRender2(Fruit[] f,Graphics g)
	{
		for (Fruit fruit : f)
		{
			if(fruit.isShow()==1)
				g.drawImage(Resources.fruit2, fruit.getX(), fruit.getY(), null);
		}
	}
	public void btnRender(Button b,Graphics g)
	{
		if(b.getRectangle().intersects(p.getRectangle())||b.getRectangle().intersects(q.getRectangle()))
		{
			g.drawImage(Resources.btnDown, b.getX(), b.getY(), null);
			//System.out.println("踩到了");
			movedoor.isUse(1);
		}
		else if(!b.getRectangle().intersects(p.getRectangle())&&!b.getRectangle().intersects(q.getRectangle()))
		{
			g.drawImage(Resources.btnOn, b.getX(), b.getY(), null);
			movedoor.isUse(-1);
		}
		System.out.println(b.isOn());
		
	}
	public void bgRender(Graphics g)
	{
		g.drawImage(Resources.backGround, 0, 0, 1100,700,null);
		
	}
	public void endRender(End e,Graphics g)
	{
		g.drawImage(Resources.end, e.getX1(), e.getY1(), null);
		g.drawImage(Resources.end, e.getX2(),e.getY2(), null);
	}
	
	public void pullyRender(Pulley p,Graphics g)
	{
		Resources.pully.render(g, pulley.getlX()-35, pulley.getlY()-55);
		Resources.pully.render(g, pulley.getrX()-35, pulley.getrY()-55);
	}
	
	public void doorRender(Door d,Graphics g)
	{
			//Resources.door.render(g, d.getX2(), d.getY2());
			//Resources.door.render(g, d.getX1(), d.getY1());
		g.drawImage(Resources.door,d.getX2(),d.getY2(), null);
		g.drawImage(Resources.door,d.getX1(),d.getY1(), null);
	}
	public void playerRender(Player p,Player q,Graphics g)
	{
		if(p.getvX()>0&&(!p.isJump())&&(p.isFloor()))
			Resources.runRight.render(g, p.getX(), p.getY());
		if(p.getvX()<0&&(!p.isJump())&&(p.isFloor()))
			Resources.runLeft.render(g, p.getX(), p.getY());
		if(p.getvX()==0&&(!p.isJump()))
			Resources.stand.render(g, p.getX(), p.getY());
		if(p.isJump()&&p.getvX()>0)
			Resources.Rjump.render(g, p.getX(), p.getY());
		if(p.isJump()&&p.getvX()==0)
			Resources.Rjump.render(g, p.getX(), p.getY());
		if(p.isJump()&&p.getvX()<0)
			Resources.Ljump.render(g, p.getX(), p.getY());
		if(!p.isFloor()&&!p.isJump()&&p.getvX()>0)
			g.drawImage(Resources.RdownImage,p.getX(), p.getY(), null);
		if(!p.isFloor()&&!p.isJump()&&p.getvX()<0)
			g.drawImage(Resources.LdownImage,p.getX(), p.getY(), null);
		//
		if(q.getvX()>0&&(!q.isJump())&&(q.isFloor()))
			Resources.runRight1.render(g, q.getX(), q.getY());
		if(q.getvX()<0&&(!q.isJump())&&(q.isFloor()))
			Resources.runLeft1.render(g, q.getX(), q.getY());
		if(q.getvX()==0&&(!q.isJump()))
			Resources.stand1.render(g, q.getX(), q.getY());
		if(q.isJump()&&q.getvX()>0)
			Resources.Rjump1.render(g, q.getX(), q.getY());
		if(q.isJump()&&q.getvX()==0)
			Resources.Rjump1.render(g, q.getX(), q.getY());
		if(q.isJump()&&q.getvX()<0)
			Resources.Ljump1.render(g, q.getX(), q.getY());
		if(!q.isFloor()&&!q.isJump()&&q.getvX()>0)
			g.drawImage(Resources.RdownImage1,q.getX(), q.getY(), null);
		if(!q.isFloor()&&!q.isJump()&&q.getvX()<0)
			g.drawImage(Resources.LdownImage1,q.getX(), q.getY(), null);		
		
	}
	public void frushBtn(Button f,Graphics g)
	{
		if(frush.isOn()==-1)
		{
			g.drawImage(Resources.frushBtn, frush.getX(), frush.getY(), null);
		}
		if(frush.isOn()==1)
		{
			g.drawImage(Resources.frushBtnDown, f.getX(), f.getY(), null);
			//setCurrentState(new PlayState());
		}
	}
	//角色死亡，游戏结束
	public void over()
	{
		GameMain.sGame.setCurrentState(new OverState());
	}
	
	//成功到达
	public void success()
	{
		Resources.bgMusic.stop();
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
		scoreState.time = time ;
		scoreState.count1= count1;
		scoreState.count2 = count2;
		scoreState.nextState = new OverState();
		GameMain.sGame.setCurrentState(scoreState);
	}
	
	public int getTime()
	{
		return time;
	}
	public int getCount1()
	{
		return count1;
	}
	 public int getCount2()
	{
		return count2;
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
	public void onClick(MouseEvent e)
	{


		
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
			GameMain.sGame.setCurrentState(new PlayState());
			
		}
		
	}

}
