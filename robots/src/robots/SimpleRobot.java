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
	public  void move(int x, int y) {
		// TODO Auto-generated method stub
		System.out.format("Robot %s is moving: x %d y: %d %n",name, x,y);	
	}

}
