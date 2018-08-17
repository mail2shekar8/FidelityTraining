package robots;


import observers.RobotObserver;
import robots.Robot;
import robots.SimpleRobot;
import robots.factory.RobotFactory;

public class Driver {

	public static void main(String[] args) {

		
		System.out.printf("The total distance moved is x: %d,  y: %d %n",		
				RobotObserver.getTotalX(),
				RobotObserver.getTotalY());
		

		Robot robotOne =    RobotFactory.createRobot();

			
		RobotObserver robotObserver = new RobotObserver();
		
		robotOne.addObserver(robotObserver);

		
		robotOne.move(10,20);
		
		robotOne.move(12,30);

		System.out.printf("The total distance moved is x: %d,  y: %d %n",		
				RobotObserver.getTotalX(),
				RobotObserver.getTotalY());
		
		
		
		
		
		
		
	}

}
