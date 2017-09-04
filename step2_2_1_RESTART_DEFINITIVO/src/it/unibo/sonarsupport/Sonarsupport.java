/* Generated by AN DISI Unibo */ 
/*
This code is generated only ONCE
*/
package it.unibo.sonarsupport;
import it.unibo.is.interfaces.IOutputEnvView;
import it.unibo.qactors.QActorContext;

public class Sonarsupport extends AbstractSonarsupport { 
	private int da;
	
	public Sonarsupport(String actorId, QActorContext myCtx, IOutputEnvView outEnvView )  throws Exception{
		super(actorId, myCtx, outEnvView);		
	}
	
	public void setDa(int da) {
		this.da = da;
	}
	
	public boolean goalTest(int currentPosition, int finalPointTollerance) {
		System.out.println("[SONAR_SUPPORT] goalTest; CP="+currentPosition+", FPT="+finalPointTollerance);
		int difference = da-currentPosition;
		if ( Math.abs(difference) <= finalPointTollerance  ) 
			return true;
		else 
			return false;
	}
	
	public int chooseDirection(int currentPoint, int finalPointTollerance) {
		System.out.println("[SONAR_SUPPORT] Choosing direction: CP="+currentPoint+", FPT="+finalPointTollerance);
		int difference = da-currentPoint;
		if ( Math.abs(difference) <= finalPointTollerance  ) 
			return 0;									//stay there
		else if (difference > 0)		
			return 1;									//go DX
		else // (difference < 0)	
			return 2;									//go SX
	}
}