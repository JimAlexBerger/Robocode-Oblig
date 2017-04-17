package robots;

import robocode.Robot;

public class Painbringer {

	
	public class PainBringer extends Robot{
		
		@Override
		public void run(){
			
				while(true){
					ahead(50.5);
					turnRight(90);
					fire(1);
				}
			
		}

	}
	
	
}
