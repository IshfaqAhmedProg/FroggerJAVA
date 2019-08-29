

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;



@SuppressWarnings("serial")
public class GamePanel extends JPanel implements KeyListener,Runnable{

	public static int Height = 450;
	public static int Width = 700;
	@SuppressWarnings("unused")
	private CollisionDetector check;
	
	BufferedImage car1_L,car1_R,car2_L,car2_R,van_L,van_R,truck_L,truck_R,frog_L,frog_R,frog_U,frog_D,live;
	MainGame event;
	
	public GamePanel()
	{
		setSize(Width,Height);
		this.check= new CollisionDetector();
		this.setFocusable(true);
		reset();
		Thread T;
		try {
			T=new Thread(this);
			T.start();
		}catch(Exception e)
		{
			e.printStackTrace();
			System.exit(-2);
		}
		try {
			car1_L= ImageIO.read(new File("images/car1_L.png"));
			car1_R= ImageIO.read(new File("images/car1_R.png"));
			car2_L= ImageIO.read(new File("images/car2_L.png"));
			car2_R= ImageIO.read(new File("images/car2_R.png"));
			van_L= ImageIO.read(new File("images/van_L.png"));
			van_R= ImageIO.read(new File("images/van_R.png"));
			truck_L= ImageIO.read(new File("images/truck_L.png"));
			truck_R= ImageIO.read(new File("images/truck_R.png"));
			frog_L= ImageIO.read(new File("images/frog_L.png"));
			frog_R= ImageIO.read(new File("images/frog_R.png"));
			frog_U= ImageIO.read(new File("images/frog_U.png"));
			frog_D= ImageIO.read(new File("images/frog_D.png"));
			live =ImageIO.read(new File("images/frog_U.png"));
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		addKeyListener(this);
	}
	public void keyReleased(KeyEvent e)
	{
		
	}
	public void keyPressed(KeyEvent e)
	{
		if (OptionPanel.LEFT==false) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				if ((event.getPlayer().getY() - 40) > 30) {
					event.getPlayer().setY(event.getPlayer().getY() - 40);
					event.getPlayer().setDirection(Frog.up);
				}
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				if ((event.getPlayer().getY() + 40) < getHeight() - 100) {
					event.getPlayer().setY(event.getPlayer().getY() + 40);
					event.getPlayer().setDirection(Frog.down);
				}
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if ((event.getPlayer().getX() - 30) > 0) {
					event.getPlayer().setX(event.getPlayer().getX() - 40);
					event.getPlayer().setDirection(Frog.left);
				}
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if ((event.getPlayer().getX() + 40) < getWidth() - 30) {
					event.getPlayer().setX(event.getPlayer().getX() + 40);
					event.getPlayer().setDirection(Frog.right);
				}
			} 
		}
		else 
		{
			if (e.getKeyCode() == KeyEvent.VK_W) {
				if ((event.getPlayer().getY() - 40) > 30) {
					event.getPlayer().setY(event.getPlayer().getY() - 40);
					event.getPlayer().setDirection(Frog.up);
				}
			} else if (e.getKeyCode() == KeyEvent.VK_S) {
				if ((event.getPlayer().getY() + 40) < getHeight() - 100) {
					event.getPlayer().setY(event.getPlayer().getY() + 40);
					event.getPlayer().setDirection(Frog.down);
				}
			} else if (e.getKeyCode() == KeyEvent.VK_A) {
				if ((event.getPlayer().getX() - 30) > 0) {
					event.getPlayer().setX(event.getPlayer().getX() - 40);
					event.getPlayer().setDirection(Frog.left);
				}
			} else if (e.getKeyCode() == KeyEvent.VK_D) {
				if ((event.getPlayer().getX() + 40) < getWidth() - 30) {
					event.getPlayer().setX(event.getPlayer().getX() + 40);
					event.getPlayer().setDirection(Frog.right);
				}
			}
		}
	}
	public void keyTyped(KeyEvent e)
	{
		
	}
	public void run()
	{
		while(true)
		{
			update();
			repaint();
			try {
				if(MainGame.dead)
				{
					GOPanel gameover;
					gameover= new GOPanel(0);
					gameover.setBounds(0,0,Width,Height);
					gameover.setBackground(Color.WHITE);
					this.getParent().getParent().add(gameover,0,0);
					Thread.sleep(1000000000000000000L);
				}
				if (MainGame.win)
				{
					GWPanel gamewon;
					gamewon=new GWPanel(true,0);
					gamewon.setBounds(0,0,Width,Height);
					this.getParent().getParent().add(gamewon,0,0);
					Thread.sleep(1000000000000000000L);
				}
			}catch (Exception e){
				System.err.println("error");
			}
		}
			
		}
	public void paint(Graphics g)
	{
		g.setColor(Color.green);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.white);
        g.drawLine(0, 75, getWidth(), 75);
        g.drawLine(0, 275, getWidth(), 275);
        //road
        g.setColor(Color.GRAY);
        g.fillRect(0, 76, getWidth(), 199);
        //bottom
        g.setColor(Color.BLACK);
        g.fillRect(0, getHeight() - 100, getWidth(), 300);
        //yellow lines
        g.setColor(Color.yellow);
        for (int y = 116; y < 264; y += 39) {
            for (int x = 10; x < getWidth() - 10; x += 90) {
                g.fillRect(x, y, 60, 4);
            }
        }
        //text
        g.setColor(Color.darkGray);
        g.setFont(new Font("Arial", Font.CENTER_BASELINE, 40));
        g.drawString("Lives:", 10, getHeight() - 15);
        //lives
        for (int i = 0; i < event.getLives(); i++) {
            g.drawImage(live, 130 + i * 60, getHeight() - 42,null);
        }
        g.setColor(Color.YELLOW);
        g.drawString("Score: ",340,getHeight()-15);
        String l= Integer.toString(1000-RunVehicle.scoreh);
        g.drawString(l, 470, getHeight()-15);

        switch (event.getPlayer().getDirection()) { //draw frog based on direction
        case Frog.up:
            g.drawImage(frog_U, event.getPlayer().getX(), event.getPlayer().getY(), null);
            break;
        case Frog.down:
            g.drawImage(frog_D, event.getPlayer().getX(), event.getPlayer().getY(), null);
            break;
        case Frog.left:
            g.drawImage(frog_L, event.getPlayer().getX(), event.getPlayer().getY(), null);
            break;
        case Frog.right:
            g.drawImage(frog_R, event.getPlayer().getX(), event.getPlayer().getY(), null);
            break;
        }
        for (RunVehicle rv : event.getVehicleLanes()) //all car lanes
        {
            for (int p = 0; p < rv.roaditems.size(); p++) //each car in that lane
            {
                if (rv.roaditems.get(p).getDirection() == Road.right && rv.roaditems.get(p).getType() == Vehicle.car1) {
                    g.drawImage(car1_R, (int) rv.roaditems.get(p).getX(), (int) rv.roaditems.get(p).getY(), null);
                } else if (rv.roaditems.get(p).getDirection() == Road.left && rv.roaditems.get(p).getType() == Vehicle.car1) {
                    g.drawImage(car1_L, (int) rv.roaditems.get(p).getX(), (int) rv.roaditems.get(p).getY(), null);
                } else if (rv.roaditems.get(p).getDirection() == Road.right && rv.roaditems.get(p).getType() == Vehicle.car2) {
                    g.drawImage(car2_R, (int) rv.roaditems.get(p).getX(), (int) rv.roaditems.get(p).getY(), null);
                } else if (rv.roaditems.get(p).getDirection() == Road.left && rv.roaditems.get(p).getType() == Vehicle.car2) {
                    g.drawImage(car2_L, (int) rv.roaditems.get(p).getX(), (int) rv.roaditems.get(p).getY(), null);
                } else if (rv.roaditems.get(p).getDirection() == Road.left && rv.roaditems.get(p).getType() == Vehicle.truck) {
                    g.drawImage(truck_L, (int) rv.roaditems.get(p).getX(), (int) rv.roaditems.get(p).getY(), null);
                } else if (rv.roaditems.get(p).getDirection() == Road.right && rv.roaditems.get(p).getType() == Vehicle.truck) {
                    g.drawImage(truck_R, (int) rv.roaditems.get(p).getX(), (int) rv.roaditems.get(p).getY(), null);
                } else if (rv.roaditems.get(p).getDirection() == Road.left && rv.roaditems.get(p).getType() == Vehicle.van) {
                    g.drawImage(van_L, (int) rv.roaditems.get(p).getX(), (int) rv.roaditems.get(p).getY(), null);
                } else if (rv.roaditems.get(p).getDirection() == Road.right && rv.roaditems.get(p).getType() == Vehicle.van) {
                    g.drawImage(van_R, (int) rv.roaditems.get(p).getX(), (int) rv.roaditems.get(p).getY(), null);
                }
            }
        }
	}
	void update() {
        event.update();
    }

    void reset() {
        this.event = new MainGame();
    }
}
