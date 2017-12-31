package util;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation                                 //Animation类  用于循环更新帧列图
{
	private BufferedImage[] images;
	private int i = 0;

	public Animation(BufferedImage[] images)		//传入帧列图数组
	{
		this.images = images;
	}
	
	public void render(Graphics g,int x,int y)		//传入Graphics对象 在x,y处更新图像
	{	
		g.drawImage(images[i++], x, y, null);
		//System.out.println(i);
		if(i==images.length)
			i=0;
	}
	
}
