package robots.singleton;

import java.util.Observable;
import java.util.Observer;

import robots.Robot;
import robots.RobotData;

public class SingletonRobot extends Observable implements Robot {

	private  static Robot instance  = new SingletonRobot();

	
	private SingletonRobot(){ }
	
	public static Robot getInstance(){
		return instance;
	}
	
	@Override
	public void move(int x, int y) {
		System.out.format("Robot %s has moved x: %d y: %d %n",getName(), x,y);
		RobotData robotData = new RobotData(x,y,getName());
		setChanged();
		notifyObservers(robotData);
	
	}

	@Override
	public String getName() {
		return "Singleton Robot";
	}


}
