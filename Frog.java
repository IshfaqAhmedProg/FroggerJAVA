

import java.awt.*;
public class Frog {
		
	public static final int left=0,right=1,up=2,down=3,WIDTH=22;
	private int x,y,direction;
	private Rectangle bb;
	
	public Frog(int x, int y)
	{
		direction=up;
		this.x=x;
		this.y=y;
		this.bb=new Rectangle(this.x+7,this.y+9,24,24);
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public int getDirection()
	{
		return direction;
	}
	public Rectangle getBB()
	{
		return this.bb;
	}
	public void setX(int x)
	{
		this.x=x;
		this.bb=new Rectangle(this.x+7,this.y+9,24,24);
	}
	public void setY(int y)
	{
		this.y=y;
		this.bb=new Rectangle(this.x+7,this.y+9,24,24);
	}
	public void setDirection(int direction)
	{
		this.direction=direction;
	}
	public int getHitX() {
        return x + 9;
    }
}
