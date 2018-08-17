package robots;

import java.util.Observable;


public class SimpleRobot extends Observable implements Robot {

	private String name;
	
	public SimpleRobot(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public void move(int x, int y) {
		System.out.format("Robot %s has moved x: %d y: %d %n",name, x,y);
		RobotData robotData = new RobotData(x,y,name);
		setChanged();
		notifyObservers(robotData);
	}

}
