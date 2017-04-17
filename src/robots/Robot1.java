package robots;

import java.util.*;
import robocode.*;
import robocode.util.*;

public class Robot1 extends AdvancedRobot{
	
	static LinkedHashMap<String, Double> enemyHashMap;
	static double scanDir;
	static Object sought;
	 
	public void run() {
	    scanDir = 1;
	    enemyHashMap = new LinkedHashMap<String, Double>(5, 2, true);
	 
	    // ...
	 
	    while(true) {
	        setTurnRadarRightRadians(scanDir * Double.POSITIVE_INFINITY);
	        scan();
	    }
	}
	 
	public void onRobotDeath(RobotDeathEvent e) {
	    enemyHashMap.remove(e.getName());
	    sought = null;
	}
	 
	public void onScannedRobot(ScannedRobotEvent e) {
	    String name = e.getName();
	    LinkedHashMap<String, Double> ehm = enemyHashMap;
	    out.println(e.getName());
	    out.println(enemyHashMap.toString());
	 
	    ehm.put(name, getHeadingRadians() + e.getBearingRadians());
	 
	    if ((name == sought || sought == null) && ehm.size() == getOthers()) {
		scanDir = Utils.normalRelativeAngle(ehm.values().iterator().next()
	            - getRadarHeadingRadians());
	        sought = ehm.keySet().iterator().next();
	    }
	 
	}

}
