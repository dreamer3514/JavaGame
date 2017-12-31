package model;

import java.awt.Rectangle;

public class Wall
{

	private int X,Y;
	private int isPass=-1;
	private Rectangle wall;
	
	public Wall(int X,int Y,int w,int h)
	{
		this.X = X;
		this.Y = Y;
		wall = new Rectangle(X, Y, w, h);
	}
	public Rectangle getRectangle()
	{
		return wall;
	}
	public int getX()
	{
		return X;
	}
	public int getY()
	{
		return Y;
	}
	public void setOn(int o)
	{
		isPass = o;
	}
	public int isPass()
	{
		return isPass;
	}
}
