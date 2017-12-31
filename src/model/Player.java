package model;

import java.awt.Rectangle;
import java.awt.geom.Line2D;

public class Player
{
	public int X=0,Y=0,w,h;
	public int vX=0,vY=0;
	public int t = 1;
	public int isRun= -1;
	public int isJump = -1;
	public int isFloor = 1;
	
	public Rectangle pRectangle;
	public Rectangle rectangle;

	public int weight=1;
	public final int a =10;
	public final int b =10;
	public Player(int X, int Y,int weight,int w,int h)
	{
		this.X = X;
		this.Y = Y;
		this.w = w;
		this.h = h;
		this.weight = weight;
		
		pRectangle = new Rectangle();
		rectangle = new Rectangle(X, Y, 60, 120);
		
	}
	public void update()
	{
		//System.out.println(getY());
		if(this.isRun==-1)
		{
			vX=0;
		}
		if(this.isJump==-1&&isFloor())
		{
			vY=0;
		}
		if(this.isJump==1)
		{
			jump();		
		}
		if(!isFloor())
		{
			down();
		}
		
		
		//System.out.println(X);
		this.X+=this.vX;
		this.Y+=this.vY;
		this.pRectangle.setBounds(this.X+16, this.Y+100, w, h);
		rectangle.setBounds(X, Y, 60, 120);
		//Rectangle rec = new Rectangle(600, 350, 100, 120);
		//pLine2d.setLine(X, Y+120, X+100, Y+120);
		//System.out.println(X+","+Y);
		//if(pRectangle.intersects(rec))
		//	System.out.println("Åöµ½ÁË£¡£¡£¡£¡£¡");
		
		
	}
	//public 
	public void jump() 
	{
//		isJump(1);
		if(this.vY<=0)
			this.vY=-60+(a*t++);	
		else
		{
			this.vY=0;
			t=1;
			this.isJump=-1;
		}
		this.isFloor=-1;
		
	}
	public void down()
	{
		if(!isFloor())
		{
			vY+=b;			
		}
		this.isFloor=-1;
		
	}
	
	public boolean isFloor()
	{
		
		if((Y<=470&&X>590&&Y>420))
		{
			Y=455;
			//System.out.println("!!!!!");
			return true;
			
		}
		if(X>650&&Y>=0&&Y<=40)
		{
			Y=28;
			return true;
		}
		
		if(Y>=65&&Y<=110&&X<180)
		{
			Y=65;
			return true;
		}
		if(Y>=270&&Y<=320&&X<260)
		{
			Y=300;
			return true;
		}
			
		if(Y>=560)
		{
			Y=560;
			return true;
		} 
		if(this.isFloor==1)
		{
			return true;
		}
		
		if(this.isFloor==1)
			return true;
		return false;
	}
	public boolean isJump()
	{
		if(this.isJump==1)
			return true;
		else return false;
	}
	public void isFloor(int n)
	{
		this.isFloor = n;
	}
	public void isRun(int n)
	{
		this.isRun = n;
	}
	public void isJump(int m)
	{
		this.isJump = m;
	}
	public Rectangle getRectangle()
	{
		return this.pRectangle;
	}
	public Rectangle getRectangles()
	{
		return this.rectangle;
	}
	public int getWeight()
	{
		return this.weight;
	}
	public int getX()
	{
		return this.X;
	}
	public int getY()
	{
		return this.Y;
	}
	public void setX(int x)
	{
		this.X=x;
	}
	public void setY(int y)
	{
		this.Y=y;
	}
	public int getvX()
	{
		return this.vX;
	}
	public int getvY()
	{
		return this.vY;
	}
	public void setvX(int x)
	{
		this.vX = x;
	}
	public void setvY(int y)
	{
		this.vY = y;
	}
	
}
