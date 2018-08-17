package main;

import java.lang.reflect.InvocationTargetException;

import robots.Robot;
import robots.factory.RobotFactory;

public class Driver {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Robot robot = RobotFactory.createRobot();
		robot.move(100,200);;
		
	}

}
