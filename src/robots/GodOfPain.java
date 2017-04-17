package robots;

import robocode.Robot;

public class GodOfPain extends Robot {

	@Override
	public void run() {

		while (true) {
			ahead(50.5);
			turnRight(90);
			fire(1);
		} //// hei jim

	}
}
