package observers;

import java.util.Observable;
import java.util.Observer;

import robots.RobotData;

public class RobotObserver implements Observer {

	private static int totalX, totalY;
	@Override
	public void update(Observable robot, Object data) {
		RobotData robotData = (RobotData)data;
		totalX += robotData.getX();
		totalY += robotData.getY();
		System.out.printf("RobotObserver has heard that: %s", robotData);
	}

	
	public static int getTotalX(){
		return totalX;
	}
	
	public static int getTotalY(){
		return totalY;
	}

}
