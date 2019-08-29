public class MainGame {
	
	public static final int PLAYING=0,PLAYER_WIN=2,MAX_TIME=80;
	public static boolean dead=false,win=false;
	public static final int fx=320,fy=275;
	public static final int CarLaneY=75;
	
	int status,lives,startTime;
	boolean reachedMiddle;
	Frog player;
	RunVehicle[] vehiclelanes;
	
	public MainGame()
	{
		status = MainGame.PLAYING;
		reachedMiddle=false;
		lives=3;
		player=new Frog(fx,fy);
		
		vehiclelanes= new RunVehicle[5];
		
		for(int i=0;i<vehiclelanes.length;i++)
		{
			if(i%2==0)
			{
				vehiclelanes[i]=new RunVehicle(0.2,Road.right,CarLaneY+i*40);
			}
			else
			{
				vehiclelanes[i]=new RunVehicle(0.2,Road.left,CarLaneY+i*40);
			}
		}
		for(int time=0;time<1000;time++)
		{
			update();
		}
	}
	void update()
	{
		for (int u = 0; u < vehiclelanes.length; u++)
            vehiclelanes[u].update();
        for (int y = 0; y < vehiclelanes.length; y++)
            runChecks();
	}
	public void checkWinStatus()
	{
		if(this.player.getY()<75)
		{
			win=true;
		}
	}
	public void runChecks()
	{
		vehicleCheck();
		checkWinStatus();
	}
	public void vehicleCheck()
	{
		if (CollisionDetector.CollisionDetector(this.getPlayer(), this.getVehicleLanes())) {
            playerDeath();
        }
	}
	public void playerDeath()
	{
		lives--;
        if (lives > 0) {
            player.setX(fx);
            player.setY(fy);
        }
        else {
            dead = true;
        }
	}
	public Frog getPlayer()
	{
		return player;
	}
	public RunVehicle[] getVehicleLanes()
	{
		return vehiclelanes;
	}
	public int getStatus() 
	{
	    return status;
	}
	public int getLives()
	{
	    return lives;
	}
}
