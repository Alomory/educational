public class Task2 {
	public static void main(String[] args) {
		Fan fan0 = new Fan();
		System.out.println(fan0);
		Fan fan1 = new Fan(Fan.FAST, "red", 10);
		fan1.flip();
		Fan fan2 = new Fan(Fan.MED, "blue", 5);
		System.out.println(fan2);
	}
}

class Fan {
	final static int SLOW = 1, MED = 2, FAST = 3;
	private int speed;
	private String color;
	private double radius;
	private boolean isOn = false;

	public Fan() { 
		speed = SLOW;
		color = "white";
		radius = 1;
	}

	public Fan(int speed, String color, double radius) {
		this.speed = speed;
		this.color = color;
		this.radius = radius;
	}

	public void flip() {
		isOn = !isOn;
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "This " + color + " fan with radius of " 
			+ radius + " is " 
			+ ((isOn) ? "on" : "off") 
			+ " and spinning " + 
			((speed == 3) ? "fast" : 
			 (speed == 2) ? "moderate" : 
			 (speed == 1) ? "slow" : "indefinetely");
	}
}



