package robots;

import java.util.Observer;

public interface Robot {
	public void move(int x, int y);
	public String getName();
	public void addObserver(Observer o);
}
