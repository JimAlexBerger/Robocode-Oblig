package robots;

import java.util.HashMap;
import java.util.Map;

import robocode.*;

public class Robot2 extends AdvancedRobot{
	//
	
	//Variabel for å lagre robotens status
	private RobotStatus robotStatus;
	
	//liste med motstandernes posisjon
	Map<String, double[]> fiender = new HashMap<>();

	public void run() {
	 
		//Hvert tick
	    while(true) {
	    	
	    	//Radar som kun roterer
	        turnRadarRightRadians(Double.POSITIVE_INFINITY);
	        scan();
	    }
	    
	}
	
	
	//Funkson som hvert tick oppdaterer robotens stauts
	public void onStatus(StatusEvent e) {
        this.robotStatus = e.getStatus();
    }
	
	//Funksjon som kjører når man scanner en robot
	public void onScannedRobot(ScannedRobotEvent e){
		//Vinkelen mellom roboten og fienden
		double vinkelMotFiende = e.getBearing();
		
		// Finner vinkelen 
        double vinkel = Math.toRadians(robotStatus.getHeading() + vinkelMotFiende % 360);

        // Finner koordinatene til fienden
        double[] pos = {(robotStatus.getX() + Math.sin(vinkel) * e.getDistance()), (robotStatus.getY() + Math.cos(vinkel) * e.getDistance())};
        
        //setter inn koordinatene i listen
        fiender.put(e.getName(), pos);
		
	}
	
	private void move(int dist, int dir){
		
	}
	
}


