package model;

public class Door
{
	private int X1=10,Y1=100,X2=600,Y2=350;;

	private int vX=7;
	
	private int isUse=-1;
	
	public Door(int x1,int y1,int x2,int y2)
	{
		this.X1=x1;
		this.Y1=y1;
		this.X2=x2;
		this.Y2=y2;
	}
	public void update()
	{
		if(isUse==1)
		{
			
			X1+=vX;
			if(X1>=650)
				vX*=-1;
			if(X1<=10)
				vX=10;
		}
		
		
	}
	public int isUse()
	{
		return isUse;
	}
	public void isUse(int u)
	{
		isUse = u;
	}
	
	public int getX1()
	{
		return X1;
	}
	public int getY1()
	{
		return Y1;
	}
	public int getX2()
	{
		return X2;
	}
	public int getY2()
	{
		return Y2;
	}
	
	

}
