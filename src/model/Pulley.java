package model;

import java.awt.Rectangle;

public class Pulley
{
	private Rectangle lRectangle,rRectangle;
	private int lWeight=0,rWeight=0;
	private int x,y,vy=8;
	private int X1,X2,Y1,Y2;
	private int isOnLeft=-1,isOnRight=-1;
	public Pulley(int x,int y)
	{
		this.x=x;
		this.y=y;
		X1=x-150;
		X2=x+50;
		Y1=y+20;
		Y2=y+280;
		lRectangle = new Rectangle(X1, Y1, 100, 50);
		rRectangle = new Rectangle(X2, Y2, 100, 50);
	}
	public void update()
	{

		if(lWeight<0)
			lWeight=0;
		if(rWeight<0)
			rWeight=0;
		if(lWeight>rWeight)
		{
			Y1+=vy;
			Y2 = 700-Y1;
			lRectangle.setLocation(X1, Y1);
			rRectangle.setLocation(X2,Y2);
			//vy+=1;
		}
		if(lWeight<rWeight)
		{
			Y1-=vy;
			Y2 = 700-Y1;
			lRectangle.setLocation(X1, Y1);
			rRectangle.setLocation(X2, Y2);
			//vy+=1;
		}
			
		
	}
	public int getisOnLeft()
	{
		return isOnLeft;
	}
	public int getisOnRight()
	{
		return isOnRight;
	}
	public void setisOnLeft(int l)
	{
		isOnLeft = l;
	}
	public void setisOnRight(int r)
	{
		isOnRight = r;
	}
	public void setlweight(int l)
	{
		lWeight = l;
	}
	public void setrweight(int r)
	{
		rWeight = r;
	}
	public int getlweight()
	{
		return lWeight;
	}
	public int getrweight()
	{
		return rWeight;
	}
	
	public Rectangle getlRectangle()
	{
		return lRectangle;
	}
	public Rectangle getrRectangle()
	{
		return rRectangle;
	}
	public int getlX()
	{
		return X1;
	}
	public int getlY()
	{
		return Y1;
	}
	public int getrX()
	{
		return X2;
	}
	public int getrY()
	{
		return Y2;
	}
	
}
