public class RunVehicle extends Road {
	
	public static int scoreh=0;
	public RunVehicle(double speed,int direction,int y)
	{
		super(speed,direction,y);
	}
	void update()
	{
		super.update();
        int cart = (int) (Math.random() * 4);
        int length;
        System.out.println("ilength= "+roaditems.size());
        switch (cart) {
            case Vehicle.truck: 
                length = 120;
                break;
            case Vehicle.van: 
                length = 80;
                break;
            default: 
                length = 40;
                break;
        }
			if (scoreh<300) {
				if (direction == right) {
					int location = -120 - (int) (Math.random() * 4) - length;
					if (roaditems.size() == 0) {
						scoreh++;
						roaditems.add(new Vehicle(speed, location, y, right, (int) (Math.random() * 4)));
					}
					System.out.println("rlength= " + roaditems.size());
					for (int i = 0; i < roaditems.size(); i++) {
						if (roaditems.get(i).getDirection() == left && roaditems.get(i).getX() < -20)
							roaditems.remove(i);
					}
					System.out.println("rlength2= " + roaditems.size());
					if ((int) roaditems.get(roaditems.size() - 1).getX()
							+ roaditems.get(roaditems.size() - 1).getWidth() > 0) {

						Vehicle newVehicle = new Vehicle(speed, location, y, right, cart);
						newVehicle.setX(location - newVehicle.getWidth());
						roaditems.add(newVehicle);
						scoreh++;
					}
					System.out.println("rlength3= " + roaditems.size());
				} else if (direction == left) {
					int location = 700 + (int) (Math.random() * 4) + length;
					if (roaditems.size() == 0) {
						scoreh++;
						roaditems.add(new Vehicle(speed, location, y, left, (int) (Math.random() * 4)));
					}
					System.out.println("llength= " + roaditems.size());
					for (int i = 0; i < roaditems.size(); i++) {
						if (roaditems.get(i).getDirection() == right && roaditems.get(i).getX() > 720)
							roaditems.remove(i);
					}
					System.out.println("llength2= " + roaditems.size());
					if ((int) roaditems.get(roaditems.size() - 1).getX()
							+ roaditems.get(roaditems.size() - 1).getWidth() < 700) {
						scoreh++;
						roaditems.add(new Vehicle(speed, location, y, left, cart));
					}
					System.out.println("llength3= " + roaditems.size());

				} 
			} 
			else
			{
				MainGame.dead=true;
			}
	
    
	}
}
