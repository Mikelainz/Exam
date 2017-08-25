package it.unibo.rover;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class SingletonConfigurations {

	private int rotationTimeRight;
	private int rotationTimeLeft;
	private int searchTimeForward;
	private int senseTimeFixedObstacle;
	private int finalPointTollerance;
	private int obstacleDistance;
	
	private static SingletonConfigurations instance;
	
	private SingletonConfigurations() throws IOException {
		this.readConfigurations();
	}
	
	public static SingletonConfigurations getInstance() throws IOException {
		if(instance==null) instance = new SingletonConfigurations();
		return instance;
	}
	
	private void readConfigurations() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("configurations.txt"));
		StringTokenizer st;
		String line;
		while((line=br.readLine())!=null && !line.trim().isEmpty()) {
			st = new StringTokenizer(line, ":");
			//Delete first token
			st.nextToken();
			System.out.println(line);
			if(line.startsWith("rotationTimeRight")) this.rotationTimeRight = Integer.parseInt(st.nextToken().trim());
			else if(line.startsWith("rotationTimeLeft")) this.rotationTimeLeft = Integer.parseInt(st.nextToken().trim());
			else if(line.startsWith("searchTimeForward")) this.searchTimeForward = Integer.parseInt(st.nextToken().trim());
			else if(line.startsWith("senseTimeFixedObstacle")) this.senseTimeFixedObstacle = Integer.parseInt(st.nextToken().trim());
			else if(line.startsWith("finalPointTollerance")) this.finalPointTollerance = Integer.parseInt(st.nextToken().trim());
			else if(line.startsWith("obstacleDistance")) this.obstacleDistance = Integer.parseInt(st.nextToken().trim());
		}
		br.close();
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

	public int getFinalPointTollerance() {
		return finalPointTollerance;
	}

	public int getObstacleDistance() {
		return obstacleDistance;
	}
}
