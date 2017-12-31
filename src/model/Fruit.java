package model;

import java.awt.Rectangle;

public class Fruit
{
	private int X,Y;
	private int isShow=1;
	
	private Rectangle fruit=null;
	
	public Fruit(int X,int Y,int w,int h)
	{
		this.X = X;
		this.Y = Y;
		fruit = new Rectangle(X, Y, w, h);
	}
	public Rectangle getRectangle()
	{
		return fruit;
		
	}
	public int getX()
	{
		return X;
	}
	public int getY()
	{
		return Y;
	}
	public void setisShow(int s)
	{
		isShow = s;
	}
	public int isShow()
	{
		return isShow;
	}
}
