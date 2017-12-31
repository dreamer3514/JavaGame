package util;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation                                 //Animation��  ����ѭ������֡��ͼ
{
	private BufferedImage[] images;
	private int i = 0;

	public Animation(BufferedImage[] images)		//����֡��ͼ����
	{
		this.images = images;
	}
	
	public void render(Graphics g,int x,int y)		//����Graphics���� ��x,y������ͼ��
	{	
		g.drawImage(images[i++], x, y, null);
		//System.out.println(i);
		if(i==images.length)
			i=0;
	}
	
}
