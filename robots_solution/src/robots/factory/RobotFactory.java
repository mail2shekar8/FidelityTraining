package robots.factory;
import robots.Robot;
import robots.SimpleRobot;
import robots.composite.GroupRobot;
import robots.singleton.SingletonRobot;


public class RobotFactory {

	private int noRobotsCreated;
	
	 private RobotFactory(){
		
	 }

	 public static Robot createRobot(){
		
		
		SimpleRobot robotOne = new SimpleRobot("Robot One");
		SimpleRobot robotTwo = new SimpleRobot("Robot Two");
		SimpleRobot robotThree = new SimpleRobot("Robot Three");

		
		GroupRobot groupRobot= new GroupRobot("Group Robot");
		groupRobot.addRobot(robotOne);
		groupRobot.addRobot(robotTwo);
		groupRobot.addRobot(robotThree);
		return SingletonRobot.getInstance();
	//	return groupRobot;
		
	//	return new SimpleRobot("fred");
	}
}
