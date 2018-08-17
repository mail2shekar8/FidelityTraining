package profile;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import profile.Profile.TimeUnit;

public class Profiler implements InvocationHandler {

	private Object target;
	private TimeUnit timeUnit;
	
	public Profiler(Object target, TimeUnit timeUnit){
		this.target = target;
		this.timeUnit = timeUnit;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] arguments)throws Throwable{
		
			long start = System.nanoTime();
			Object result = method.invoke(target, arguments);
			long end = System.nanoTime();
	
			switch(timeUnit){
			
			case MILLISECS:
				System.out.format("Method %s took %d ms to run%n%n", method.getName(), ((end-start)/100000));
				break;
				
			case SECONDS:
				System.out.format("Method %s took %f seconds to run%n%n", method.getName(), ((end-start)/1000000000.0));
				break;
			}
			return result;
	}

}
