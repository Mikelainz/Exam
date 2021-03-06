/* Generated by AN DISI Unibo */ 
package it.unibo.ctxRobot;
import it.unibo.qactors.QActorContext;
import java.io.InputStream;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Term;
import alice.tuprolog.Var;
 
import it.unibo.is.interfaces.IBasicEnvAwt;
import it.unibo.is.interfaces.IIntent;
import it.unibo.is.interfaces.IOutputEnvView;
import it.unibo.system.SituatedSysKb;

public class MainCtxRobot   {
private IBasicEnvAwt env; 
private it.unibo.qactor.robot.RobotActor robot; 
 
 	
/*
* ----------------------------------------------
* MAIN
* ----------------------------------------------
*/
 
	public static void main(String[] args) throws Exception{
			IOutputEnvView outEnvView = SituatedSysKb.standardOutEnvView;
			it.unibo.qactors.QActorUtils.setRobotBase("wall_e" );  
		    String webDir = "./srcMore/it/unibo/ctxRobot";
			QActorContext.initQActorSystem(
				"ctxrobot", "./srcMore/it/unibo/ctxRobot/rover_wall_e_sys.pl", 
				"./srcMore/it/unibo/ctxRobot/sysRules.pl", outEnvView,webDir, false);
 	}
 	
}
