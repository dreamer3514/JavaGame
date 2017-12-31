package model;

import java.awt.Rectangle;

import resources.Resources;

public class Button
{
	private int X,Y;
	private int isOn=-1;
	private Rectangle btn;
	
	public Button(int X,int Y,int w,int h)
	{
		this.X = X;
		this.Y = Y;
		btn = new Rectangle(X, Y, w, h);
	}
	public Rectangle getRectangle()
	{
		return btn;
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
		isOn = o;
	}
	public int isOn()
	{
		return isOn;
	}
	
}
