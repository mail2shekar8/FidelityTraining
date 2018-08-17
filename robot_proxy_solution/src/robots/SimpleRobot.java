package robots;

import java.util.Observable;

import profile.Profile;
import profile.Profile.TimeUnit;


@Profile(timeUnits=TimeUnit.SECONDS)
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
	}

}
