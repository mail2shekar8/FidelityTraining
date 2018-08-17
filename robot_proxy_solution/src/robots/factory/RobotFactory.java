package robots.factory;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import profile.Profile;
import profile.Profile.TimeUnit;
import profile.Profiler;
import robots.Robot;
import robots.SimpleRobot;

public class RobotFactory {

	public static Robot createRobot() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		Robot robot = new SimpleRobot("R2D2");
		if(robot.getClass().isAnnotationPresent(Profile.class)){
			Profile annotation = robot.getClass().getAnnotation(Profile.class);
			TimeUnit timeUnit =  null;
			for (Method annotationMethod : annotation.getClass().getMethods()) {
				if ("timeUnits".equals(annotationMethod.getName())) {
					timeUnit = annotation.timeUnits();
					break;
				}
			}
			
			Profiler profiler = new Profiler(robot, timeUnit);
			robot = (Robot)Proxy.newProxyInstance(profiler.getClass().getClassLoader(), 
									new Class[]{Robot.class}, profiler);
		}
		return robot;
	}
}
