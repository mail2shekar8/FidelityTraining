package robots;

public class RobotData {
	private int x;
	private int y;
	private String name;
	
	public RobotData(int x, int y, String name) {
		this.x = x;
		this.y = y;
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getName() {
		return name;
	}
	
	public String toString(){
		return String.format("Robot %s has moved x: %d, y: %d %n", name, x, y);
	}

}
