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
	
	private Image gameImage;			  //���ڸ�����Ϸ�ġ�Ԥ�����塱
	private Thread gameThread;            //��Ϸ��ѭ���߳�
	
	private volatile boolean running;			  //��Ϸ�Ƿ����б�־��ֵΪfalseʱ���롰��Ϸ������״̬
	private volatile State currentState;
	
	private InputHandler inputHandler;    //ʵ�������빤����

	Game(int gameWidth,int gameHeight)                //���ι��캯��������panel�Ŀ���
	{
		this.gameWidth = gameWidth;
		this.gameHeight = gameHeight;
		
		
		setPreferredSize(new Dimension(gameWidth, gameHeight));
		//setBackground(Color.BLACK);

		
		initInput();									//��ʼ��������		
		setCurrentState(new LoadState());				//��������״̬Ϊ��ʼ״̬
		initGame();										//��ʼ����Ϸ
//		setFocusable(true);													
//		requestFocus();									//���󽹵�
	}
	
	public void setCurrentState(State newState)      //���õ�ǰ״̬
	{	
		System.gc();
		newState.init();									//��ʼ����ǰ״̬
		currentState = newState;								
		inputHandler.setCurrentState(currentState);			//�ڹ����������õ�ǰ״̬
	}
	
	public void initInput()
	{
		inputHandler = new InputHandler();					//ʵ����		
		addKeyListener(inputHandler);						//������ͼ��̵ļ�����
		addMouseListener(inputHandler);
	}
	public void initGame()
	{	
		running = true;									  //��ʼ�����б�־Ϊtrue	
		this.requestFocus();	
		gameThread = new Thread(this,"Game Thread");		//ʵ������Ϸѭ���߳�	
		gameThread.start();
		
	}
	public void prepareGameImage()								//��Ԥ�������������գ��Է�ֹӰ����һ֡����
	{
		if(gameImage==null)
			gameImage = createImage(gameWidth, gameHeight);
			
		Graphics g = gameImage.getGraphics();
		g.clearRect(0, 0, gameWidth, gameHeight);
	}
	
	@Override
	protected void paintComponent(Graphics g)				//��������ķ���
	{														//��д������������gameImage�е����ݵ�panel
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
	public void run()										//��Ϸ��ѭ��
	{
		// TODO Auto-generated method stub
		while(running)
		{
			currentState.update();							//����ÿ��״̬�����ݣ��������������
			prepareGameImage();								//��ջ�������
			currentState.render(gameImage.getGraphics());	//��Ⱦ����
			repaint();										//��ʱ����paint	Component()����������Ⱦ�Ļ�����Ƶ�panel	
						
			this.requestFocus();							//���󽹵�
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
