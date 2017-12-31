package game.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import util.*;
import state.*;

public class Game extends JPanel implements Runnable
{
	private int gameWidth;
	private int gameHeight;
	
	private Image gameImage;			  //用于更新游戏的“预备画板”
	private Thread gameThread;            //游戏主循环线程
	
	private volatile boolean running;			  //游戏是否运行标志，值为false时进入“游戏结束”状态
	private volatile State currentState;
	
	private InputHandler inputHandler;    //实例化输入工具类

	Game(int gameWidth,int gameHeight)                //含参构造函数，传入panel的宽、高
	{
		this.gameWidth = gameWidth;
		this.gameHeight = gameHeight;
		
		
		setPreferredSize(new Dimension(gameWidth, gameHeight));
		//setBackground(Color.BLACK);

		
		initInput();									//初始化工具类		
		setCurrentState(new LoadState());				//设置载入状态为开始状态
		initGame();										//初始化游戏
//		setFocusable(true);													
//		requestFocus();									//请求焦点
	}
	
	public void setCurrentState(State newState)      //设置当前状态
	{	
		System.gc();
		newState.init();									//初始化当前状态
		currentState = newState;								
		inputHandler.setCurrentState(currentState);			//在工具类中设置当前状态
	}
	
	public void initInput()
	{
		inputHandler = new InputHandler();					//实例化		
		addKeyListener(inputHandler);						//添加鼠标和键盘的监听器
		addMouseListener(inputHandler);
	}
	public void initGame()
	{	
		running = true;									  //初始化运行标志为true	
		this.requestFocus();	
		gameThread = new Thread(this,"Game Thread");		//实例化游戏循环线程	
		gameThread.start();
		
	}
	public void prepareGameImage()								//将预备画板的内容清空，以防止影响下一帧画面
	{
		if(gameImage==null)
			gameImage = createImage(gameWidth, gameHeight);
			
		Graphics g = gameImage.getGraphics();
		g.clearRect(0, 0, gameWidth, gameHeight);
	}
	
	@Override
	protected void paintComponent(Graphics g)				//绘制组件的方法
	{														//重写方法用来绘制gameImage中的内容到panel
		// TODO Auto-generated method stub
		super.paintComponent(g);
		if(gameImage!=null)
			g.drawImage(gameImage, 0, 0, null);
		
	}
	public void exit()
	{
		running = false;
	}
	@Override
	public void run()										//游戏主循环
	{
		// TODO Auto-generated method stub
		while(running)
		{
			currentState.update();							//更新每个状态的内容，计算人物坐标等
			prepareGameImage();								//清空画板内容
			currentState.render(gameImage.getGraphics());	//渲染画面
			repaint();										//此时调用paint	Component()方法，将渲染的画面绘制到panel	
						
			this.requestFocus();							//请求焦点
			try
			{
				Thread.sleep(70);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
