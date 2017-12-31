package model;

import java.awt.Rectangle;
import java.security.KeyStore.PrivateKeyEntry;

public class End
{
	private int X1,Y1,X2,Y2;
	
	private Rectangle end1,end2;
	
	public End(int x1,int y1,int x2,int y2)
	{
		this.X1=x1;
		this.Y1=y1;
		this.X2=x2;
		this.Y2=y2;
		end1 = new Rectangle(x1+15, y1, 150, 150);
		end2 = new Rectangle(x2+15, y2, 150, 150);
	}
	public int getX1()
	{
		return X1;
	}
	public int getX2()
	{
		return X2;
	}
	public int getY1()
	{
		return Y1;
	}
	public int getY2()
	{
		return Y2;
	}
	public Rectangle getEnd1()
	{
		return end1;
	}
	public Rectangle getEnd2()
	{
		return end2;
	}
	

}
