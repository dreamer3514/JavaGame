package resources;

import java.applet.AudioClip;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JApplet;

import util.Animation;

public class Resources extends JApplet
{
	public static BufferedImage menuImage,backGround,LdownImage,RdownImage,LdownImage1,RdownImage1,
	frushBtn,frushBtnDown,door,btnOn,btnDown,end,startBtn,startBtnDown,overImage,bg1,bg2,ball,end1,
	wall,score,next1,next2,stop1,stop2,fruit1,fruit2,restart,restart1;
	
	public static BufferedImage[] runLeftImages;
	public static BufferedImage[] runRightImages;
	public static BufferedImage[] standImages;
	public static BufferedImage[] RjumpImages;
	public static BufferedImage[] LjumpImages;
	public static BufferedImage[] downImages;
	public static BufferedImage[] runLeftImages1;
	public static BufferedImage[] runRightImages1;
	public static BufferedImage[] standImages1;
	public static BufferedImage[] RjumpImages1;
	public static BufferedImage[] LjumpImages1;
	public static BufferedImage[] downImages1;
	public static BufferedImage[] pullyImages;

	
	public static Animation runLeft;
	public static Animation runRight;
	public static Animation stand;
	public static Animation Rjump;
	public static Animation Ljump;
	public static Animation runLeft1;
	public static Animation runRight1;
	public static Animation stand1;
	public static Animation Rjump1;
	public static Animation Ljump1;
	public static Animation pully;

	
	public static AudioClip bgMusic,ballm,click,click1,endm,fruit,movedoor,over,scorem;
	
	public static void load() throws FileNotFoundException, IOException
	{
		runLeftImages = new BufferedImage[8];
		runRightImages = new BufferedImage[8];
		standImages = new BufferedImage[8];
		RjumpImages = new BufferedImage[3];
		LjumpImages = new BufferedImage[3];
		runLeftImages1 = new BufferedImage[8];
		runRightImages1 = new BufferedImage[8];
		standImages1= new BufferedImage[8];
		RjumpImages1 = new BufferedImage[3];
		LjumpImages1 = new BufferedImage[3];
		pullyImages = new BufferedImage[20];
		

		backGround = ImageIO.read(new FileInputStream("src\\resources\\bg.png"));
		LdownImage = ImageIO.read(new FileInputStream("src\\resources\\Ldown.png"));
		LdownImage1 = ImageIO.read(new FileInputStream("src\\resources\\Ldown1.png"));
		frushBtn = ImageIO.read(new FileInputStream("src\\resources\\frushBtn.png"));
		frushBtnDown = ImageIO.read(new FileInputStream("src\\resources\\frushBtnDown.png"));
		RdownImage = ImageIO.read(new FileInputStream("src\\resources\\Rdown.png"));
		RdownImage1 = ImageIO.read(new FileInputStream("src\\resources\\Rdown1.png"));
		door = ImageIO.read(new FileInputStream("src\\resources\\door.png"));
		btnOn = ImageIO.read(new FileInputStream("src\\resources\\btnOn.png"));
		btnDown = ImageIO.read(new FileInputStream("src\\resources\\btnDown.png"));
		end = ImageIO.read(new FileInputStream("src\\resources\\End.png"));
		startBtn = ImageIO.read(new FileInputStream("src\\resources\\startBtn.png"));
		startBtnDown = ImageIO.read(new FileInputStream("src\\resources\\startBtnDown.png"));
		menuImage = ImageIO.read(new FileInputStream("src\\resources\\menu.png"));
		overImage = ImageIO.read(new FileInputStream("src\\resources\\overImage.png"));
		bg1 = ImageIO.read(new FileInputStream("src\\resources\\bg1.png"));
		ball = ImageIO.read(new FileInputStream("src\\resources\\ball.png"));
		end1 = ImageIO.read(new FileInputStream("src\\resources\\end1.png"));
		wall = ImageIO.read(new FileInputStream("src\\resources\\wall.png"));
		score = ImageIO.read(new FileInputStream("src\\resources\\score.png"));
		next1 = ImageIO.read(new FileInputStream("src\\resources\\next1.png"));
		next2 = ImageIO.read(new FileInputStream("src\\resources\\next2.png"));
		stop1 = ImageIO.read(new FileInputStream("src\\resources\\stop1.png"));
		stop2 = ImageIO.read(new FileInputStream("src\\resources\\stop2.png"));
		fruit1 = ImageIO.read(new FileInputStream("src\\resources\\fruit1.png"));
		fruit2 = ImageIO.read(new FileInputStream("src\\resources\\fruit2.png"));
		restart = ImageIO.read(new FileInputStream("src\\resources\\restart.png"));
		restart1 = ImageIO.read(new FileInputStream("src\\resources\\restart1.png"));
		
		bgMusic = JApplet.newAudioClip(new File("src\\resources\\music\\bgMusic.wav").toURI().toURL());
		ballm = JApplet.newAudioClip(new File("src\\resources\\music\\ball.wav").toURI().toURL());
		click = JApplet.newAudioClip(new File("src\\resources\\music\\click.wav").toURI().toURL());
		click1 = JApplet.newAudioClip(new File("src\\resources\\music\\click1.wav").toURI().toURL());
		endm = JApplet.newAudioClip(new File("src\\resources\\music\\end.wav").toURI().toURL());
		fruit = JApplet.newAudioClip(new File("src\\resources\\music\\fruit.wav").toURI().toURL());
		movedoor = JApplet.newAudioClip(new File("src\\resources\\music\\movedoor.wav").toURI().toURL());
		over = JApplet.newAudioClip(new File("src\\resources\\music\\over.wav").toURI().toURL());
		scorem = JApplet.newAudioClip(new File("src\\resources\\music\\score.wav").toURI().toURL());
		for(int i=1;i<=8;i++)
		{
			runLeftImages[i-1] = ImageIO.read(new FileInputStream("src\\resources\\leftImages\\"+i+".png"));
			//System.out.println(i);
		}
		for(int j=1;j<=8;j++)
		{
			runRightImages[j-1] = ImageIO.read(new FileInputStream("src\\resources\\rightImages\\"+j+".png"));
//			System.out.println(runRightImages[1].getWidth());
//			System.out.println(runRightImages[1].getHeight());
		}
		for(int n=1;n<=8;n++)
		{
			standImages[n-1] = ImageIO.read(new FileInputStream("src\\resources\\standImages\\"+n+".png"));
			//System.out.println(n);
		}
		for(int n=1;n<=3;n++)
		{
			RjumpImages[n-1] = ImageIO.read(new FileInputStream("src\\resources\\RjumpImages\\"+n+".png"));
			//System.out.println(n);
		}
		for(int n=1;n<=3;n++)
		{
			LjumpImages[n-1] = ImageIO.read(new FileInputStream("src\\resources\\LjumpImages\\"+n+".png"));
			//System.out.println(n);
		}
		for(int i=1;i<=8;i++)
		{
			runLeftImages1[i-1] = ImageIO.read(new FileInputStream("src\\resources\\leftImages1\\"+i+".png"));
			//System.out.println(i);
		}
		for(int j=1;j<=8;j++)
		{
			runRightImages1[j-1] = ImageIO.read(new FileInputStream("src\\resources\\rightImages1\\"+j+".png"));
//			System.out.println(runRightImages[1].getWidth());
//			System.out.println(runRightImages[1].getHeight());
		}
		for(int n=1;n<=8;n++)
		{
			standImages1[n-1] = ImageIO.read(new FileInputStream("src\\resources\\standImages1\\"+n+".png"));
			//System.out.println(n);
		}
		for(int n=1;n<=3;n++)
		{
			RjumpImages1[n-1] = ImageIO.read(new FileInputStream("src\\resources\\RjumpImages1\\"+n+".png"));
			//System.out.println(n);
		}
		for(int n=1;n<=3;n++)
		{
			LjumpImages1[n-1] = ImageIO.read(new FileInputStream("src\\resources\\LjumpImages1\\"+n+".png"));
			//System.out.println(n);
		}
		
		
		for(int n=1;n<=20;n++)
		{
			pullyImages[n-1] = ImageIO.read(new FileInputStream("src\\resources\\pullyImages\\"+n+".png"));
			System.out.println(n);
		}
		
		runLeft = new Animation(runLeftImages);
		runRight = new Animation(runRightImages);
		stand = new Animation(standImages);
		Rjump = new Animation(RjumpImages);
		Ljump = new Animation(LjumpImages);
		
		runLeft1 = new Animation(runLeftImages1);
		runRight1 = new Animation(runRightImages1);
		stand1 = new Animation(standImages1);
		Rjump1 = new Animation(RjumpImages1);
		Ljump1 = new Animation(LjumpImages1);
		
		
		//door = new Animation(doorImages);
		
		pully = new Animation(pullyImages);
	}

}
