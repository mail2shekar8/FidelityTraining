package robots.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import robots.Robot;

public class GroupRobot implements Robot {

	private List<Robot> group = new ArrayList<Robot>();
	private String name;
	
	public GroupRobot(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	
	public void addRobot(Robot robot){
		group.add(robot);
	}
		
	@Override
	public void move(int x, int y) {
		for(Robot robot: group){
			robot.move(x, y);
		}
	}

	@Override
	public void addObserver(Observer o) {
		for(Robot robot: group){
			robot.addObserver(o);
		}
	}

}
