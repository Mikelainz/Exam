/* Generated by AN DISI Unibo */ 
package it.unibo.rover;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import it.unibo.is.interfaces.IOutputEnvView;
import it.unibo.qactors.QActorContext;

public class Rover extends AbstractRover { 
	private int rotationTimeRight;
	private int rotationTimeLeft;
	private int searchTimeForward;
	private int senseTimeFixedObstacle;
	private int attemptRight;
	
	public Rover(String actorId, QActorContext myCtx, IOutputEnvView outEnvView ) throws Exception{
		super(actorId,myCtx,outEnvView ,it.unibo.qactors.QActorUtils.robotBase );
		this.attemptRight = 0;
		this.readConfigurations();
	}

	private void readConfigurations() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("configurations.txt"));
		StringTokenizer st;
		String line;
		while((line=br.readLine())!=null && !line.trim().isEmpty()) {
			st = new StringTokenizer(line, ":");
			//Delete first token
			System.out.println(st.nextToken()+line);
			if(line.startsWith("rotationTimeRight")) this.rotationTimeRight = Integer.parseInt(st.nextToken().trim());
			else if(line.startsWith("rotationTimeLeft")) this.rotationTimeLeft = Integer.parseInt(st.nextToken().trim());
			else if(line.startsWith("searchTimeForward")) this.searchTimeForward = Integer.parseInt(st.nextToken().trim());
			else if(line.startsWith("senseTimeFixedObstacle")) this.senseTimeFixedObstacle = Integer.parseInt(st.nextToken().trim());
		}
		br.close();
	}
	
	public void createRobotUnity() {
		createSimulatedActor("Prefabs/CustomActor", (float)-33.7, 0, 10, 0, 0, 0, 0);
	}
	
	public int getRotationTimeRight() {
		return rotationTimeRight;
	}

	public int getRotationTimeLeft() {
		return rotationTimeLeft;
	}

	public int getSearchTimeForward() {
		return searchTimeForward;
	}

	public int getSenseTimeFixedObstacle() {
		return senseTimeFixedObstacle;
	}
	
	public int getAttemptRightTotalTime() {
		System.out.println("tempo totale: " + this.attemptRight*this.searchTimeForward);
		return this.attemptRight*this.searchTimeForward;
	}

	public void setAttemptRight(int attemptRight) {
		this.attemptRight = attemptRight;
	}
	
	public void incAttemptRight() {
		this.attemptRight++;
		System.out.println("attempt right: " + this.attemptRight);
	}

	
}