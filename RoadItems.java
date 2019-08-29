

import java.awt.*;

public class RoadItems {
	
	double speed,x,y;
	int direction,type;
	public static Rectangle bb;
	
	@SuppressWarnings("static-access")
	public RoadItems(double speed,double x,double y,int direction,int type)
	{
		this.speed=speed;
		this.y=y;
		this.x=x;
		this.direction=direction;
		this.type=type;
        this.bb = new Rectangle((int) x + 3, (int) y + 5, getWidth() - 5, 29);

	}
	@SuppressWarnings("static-access")
	public double getX() {
        this.bb = new Rectangle( (int) x + 3, (int) this.y + 5, this.getWidth() - 5,29);
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    int getWidth() {
        return 40;
    }

    public int getType() {
        return type;
    }

    void update() {
        if (direction == Road.right)
            setX(x + speed);
        else if (direction == Road.left)
            setX(x - speed);
    }

    public Rectangle getBB(){
        this.bb = new Rectangle( (int)x+3, (int)this.y+5, this.getWidth()-5,29);
        return this.bb;
    }

}
