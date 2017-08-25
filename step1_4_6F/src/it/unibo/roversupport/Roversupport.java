/* Generated by AN DISI Unibo */ 
/*
This code is generated only ONCE
*/
package it.unibo.roversupport;


import it.unibo.is.interfaces.IOutputEnvView;
import it.unibo.qactors.QActorContext;

public class Roversupport extends AbstractRoversupport { 
	private int da;
	private int finalPointTollerance;
	
	public Roversupport(String actorId, QActorContext myCtx, IOutputEnvView outEnvView )  throws Exception{
		super(actorId, myCtx, outEnvView);
	}
	
	public void setConfigValues(int da, int finalPointTollerance) {
		this.da = da;
		this.finalPointTollerance = finalPointTollerance;
		System.out.println("DA and FTP: "+da+", "+finalPointTollerance);
	}
	
	public boolean goalTest(int currentPosition) {
		int difference = da-currentPosition;
		if ( Math.abs(difference) <= finalPointTollerance  ) 
			return true;
		else 
			return false;
	}
}
