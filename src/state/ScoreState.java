package state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import game.main.GameMain;
import model.Button;
import resources.Resources;

public class ScoreState implements State
{

	public Integer time=0,count1=0,count2=0;
	public String score="A";
	public Button next,stop;
	public State nextState=null;

	@Override
	public void init()
	{
		Resources.scorem.play();
		next  = new Button(450, 560, 110, 55);
		stop  = new Button(600, 560, 110, 55);
	}
	
	@Override
	public void update()
	{
		if(time<=50&&count1==4&&count2==4)
			score="A";
		else if((time>50&&time<50)||(count1<4&&count1>1)&&(count2<4&&count2>1))
			score="B";
		else {
			score="C";
		}
		//System.out.println(score);
	}
	
	@Override
	public void render(Graphics g)
	{
		
		g.drawImage(Resources.score, 200, 50, null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("华康少女文字", Font.BOLD, 36));
		//setTime(Second);
		g.drawString(time.toString(), 550, 250);
		g.drawString(count1.toString(), 500, 380);
		g.drawString(count2.toString(), 780, 380);
		
		g.setFont(new Font("华康少女文字", Font.BOLD, 50));
		g.drawString(score, 550,500);
		if(next.isOn()==-1)
		{
			g.drawImage(Resources.next1,next.getX(),next.getY(), null);
		}
		if(next.isOn()==1)
		{
			g.drawImage(Resources.next2,next.getX(),next.getY(), null);
		}
		if(stop.isOn()==-1)
		{
			g.drawImage(Resources.stop1,stop.getX(),stop.getY(), null);
		}
		if(stop.isOn()==1)
		{
			g.drawImage(Resources.stop2,stop.getX(),stop.getY(), null);
		}
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
		if(next.getRectangle().contains(e.getPoint()))
		{
			next.setOn(1);
			Resources.click1.play();
		}

		if(stop.getRectangle().contains(e.getPoint()))
		{
			stop.setOn(1);
			Resources.click1.play();
		}
			
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		if(next.getRectangle().contains(e.getPoint()))
		{
			GameMain.sGame.setCurrentState(nextState);	
		}
		if(stop.getRectangle().contains(e.getPoint()))
		{
			GameMain.sGame.setCurrentState(new OverState());	
		}
		
	}

}
