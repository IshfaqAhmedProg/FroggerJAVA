

import java.util.*;
public class Road {
	
	public final static int right=1,left=0;
	int y,direction;
	double speed;
	ArrayList<RoadItems> roaditems =new ArrayList<RoadItems>();
	
	public Road(double speed,int direction,int y)
	{
		this.speed=speed;
		this.direction=direction;
		this.y=y;
		
	}
	public int getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public double getSpeed() {
        return speed;
    }

    public ArrayList<RoadItems> getRoadItems() {
        return roaditems;
    }

    void update() {
        for (RoadItems roadItem : roaditems) {
            roadItem.update();
        }
    }

}
