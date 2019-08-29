
public class Vehicle extends RoadItems{
	
	public static final int truck=0,car1=1,car2=2,van=3;
	
	Vehicle(double speed,double x,double y,int direction,int type)
	{
		super(speed,x,y,direction,type);
	}
	public int getWidth() {
		if (type == car1)
            return 40;
        if (type == car2)
            return 40;
        if (type == truck)
            return 120;
        if (type == van)
            return 80;
        return 0;
    }
}
