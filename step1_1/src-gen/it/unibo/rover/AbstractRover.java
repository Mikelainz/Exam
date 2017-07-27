/* Generated by AN DISI Unibo */ 
package it.unibo.rover;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Struct;
import alice.tuprolog.Term;
import it.unibo.qactors.QActorContext;
import it.unibo.is.interfaces.IOutputEnvView;
import it.unibo.qactors.action.ActionReceiveTimed;
import it.unibo.qactors.action.AsynchActionResult;
import it.unibo.qactors.action.IActorAction;
import it.unibo.qactors.action.IActorAction.ActionExecMode;
import it.unibo.iot.configurator.Configurator;
import it.unibo.iot.executors.baseRobot.IBaseRobot; 
import it.unibo.iot.models.sensorData.distance.IDistanceSensorData;
import it.unibo.iot.models.sensorData.impact.IImpactSensorData;
import it.unibo.iot.models.sensorData.line.ILineSensorData;
import it.unibo.iot.models.sensorData.magnetometer.IMagnetometerSensorData;
import it.unibo.iot.sensors.ISensor; 
import it.unibo.iot.sensors.ISensorObserver;
import it.unibo.iot.sensors.distanceSensor.DistanceSensor;
import it.unibo.iot.sensors.impactSensor.ImpactSensor;
import it.unibo.iot.sensors.lineSensor.LineSensor;
import it.unibo.iot.sensors.magnetometerSensor.MagnetometerSensor;
import it.unibo.qactors.action.IMsgQueue;
import it.unibo.qactors.QActorMessage;
import it.unibo.qactors.QActorUtils;


class QaRobotActor extends it.unibo.qactor.robot.RobotActor{
	public QaRobotActor(
		String name, QActorContext ctx, String worldTheoryPath,
			IOutputEnvView outEnvView, String baserobot, String defaultPlan )  throws Exception{
		super(name, ctx, "./srcMore/it/unibo/rover/plans.txt", worldTheoryPath,
		outEnvView, it.unibo.qactor.robot.RobotSysKb.setRobotBase(ctx, baserobot) , defaultPlan);
	}
}

public class AbstractRover extends QaRobotActor { 
protected AsynchActionResult aar = null;
protected boolean actionResult = true;
protected alice.tuprolog.SolveInfo sol;
//protected IMsgQueue mysupport ;  //defined in QActor
protected String planFilePath    = null;
protected String terminationEvId = "default";
protected String parg="";
protected boolean bres=false;
protected IActorAction  action;

		protected static IOutputEnvView setTheEnv(IOutputEnvView outEnvView ){
			return outEnvView;
		}


	public AbstractRover(String actorId, QActorContext myCtx, IOutputEnvView outEnvView ,String baserobot)  throws Exception{
		super(actorId, myCtx,  
		"./srcMore/it/unibo/rover/WorldTheory.pl",
		setTheEnv( outEnvView ) ,baserobot , "init");		
		this.planFilePath = "./srcMore/it/unibo/rover/plans.txt";
		//Plan interpretation is done in Prolog
		//if(planFilePath != null) planUtils.buildPlanTable(planFilePath);
 	}
	@Override
	protected void doJob() throws Exception {
		String name  = getName().replace("_ctrl", "");
		mysupport = (IMsgQueue) QActorUtils.getQActor( name ); 
 		initSensorSystem();
		boolean res = init();
		//println(getName() + " doJob " + res );
		QActorContext.terminateQActorSystem(this);
	} 
	/* 
	* ------------------------------------------------------------
	* PLANS
	* ------------------------------------------------------------
	*/
    public boolean init() throws Exception{	//public to allow reflection
    try{
    	int nPlanIter = 0;
    	//curPlanInExec =  "init";
    	boolean returnValue = suspendWork;		//MARCHH2017
    while(true){
    	curPlanInExec =  "init";	//within while since it can be lost by switchlan
    	nPlanIter++;
    		temporaryStr = "\"Rover STARTS\"";
    		println( temporaryStr );  
    		if( ! planUtils.switchToPlan("handlecommands").getGoon() ) break;
    		//delay
    		aar = delayReactive(6000000,"" , "");
    		if( aar.getInterrupted() ) curPlanInExec   = "init";
    		if( ! aar.getGoon() ) break;
    		temporaryStr = "\"rover ENDS\"";
    		println( temporaryStr );  
    break;
    }//while
    return returnValue;
    }catch(Exception e){
       //println( getName() + " plan=init WARNING:" + e.getMessage() );
       QActorContext.terminateQActorSystem(this); 
       return false;  
    }
    }
    public boolean handlecommands() throws Exception{	//public to allow reflection
    try{
    	int nPlanIter = 0;
    	//curPlanInExec =  "handlecommands";
    	boolean returnValue = suspendWork;		//MARCHH2017
    while(true){
    	curPlanInExec =  "handlecommands";	//within while since it can be lost by switchlan
    	nPlanIter++;
    		temporaryStr = "\"rover waits for user commands\"";
    		println( temporaryStr );  
    		//senseEvent
    		aar = planUtils.senseEvents( 10000,"usercmd","execRobotCommand",
    		"" , "",ActionExecMode.synch );
    		if( ! aar.getGoon() || aar.getTimeRemained() <= 0 ){
    			//println("			WARNING: sense timeout");
    			addRule("tout(senseevent,"+getName()+")");
    		}
    		if( planUtils.repeatPlan(nPlanIter,0).getGoon() ) continue;
    break;
    }//while
    return returnValue;
    }catch(Exception e){
       //println( getName() + " plan=handlecommands WARNING:" + e.getMessage() );
       QActorContext.terminateQActorSystem(this); 
       return false;  
    }
    }
    public boolean execRobotCommand() throws Exception{	//public to allow reflection
    try{
    	int nPlanIter = 0;
    	//curPlanInExec =  "execRobotCommand";
    	boolean returnValue = suspendWork;		//MARCHH2017
    while(true){
    	curPlanInExec =  "execRobotCommand";	//within while since it can be lost by switchlan
    	nPlanIter++;
    		printCurrentEvent(false);
    		temporaryStr = "\"CESCOCESCO1111\"";
    		println( temporaryStr );  
    		//onEvent
    		if( currentEvent.getEventId().equals("usercmd") ){
    		 		String parg = "printingTheCommandInQActorWall_e(CMD)";
    		 		/* Print */
    		 		parg =  updateVars( Term.createTerm("usercmd(robotgui(CMD))"), Term.createTerm("usercmd(CMD)"), 
    		 			    		  					Term.createTerm(currentEvent.getMsg()), parg);
    		 			if( parg != null ) println( parg );  
    		 }
    		//onEvent
    		if( currentEvent.getEventId().equals("usercmd") ){
    		 		//println("WARNING: variable substitution not yet implmented " ); 
    		 		//right
    		 		//if( ! execRobotMove("execRobotCommand","right",100,0,5000, "" , "") ) break;
    		 		    aar = execRobotMove("execRobotCommand","right",100,0,5000, "" , "");
    		 		    if( aar.getInterrupted() ){
    		 		    	curPlanInExec   = "execRobotCommand";
    		 		    	if( ! aar.getGoon() ) break;
    		 		    } 			
    		 }
    		temporaryStr = "\"CESCOCESCO2222\"";
    		println( temporaryStr );  
    		returnValue = continueWork;  
    break;
    }//while
    return returnValue;
    }catch(Exception e){
       //println( getName() + " plan=execRobotCommand WARNING:" + e.getMessage() );
       QActorContext.terminateQActorSystem(this); 
       return false;  
    }
    }
    /* 
    * ------------------------------------------------------------
    * SENSORS
    * ------------------------------------------------------------
    */
    protected void initSensorSystem(){		
    	try {
    		String goal = "consult( \"./src/it/unibo/rover/sensorTheory.pl\" )";
    		SolveInfo sol = QActorUtils.solveGoal( goal ,pengine );
    		if( ! sol.isSuccess() ){
    			//println( "avatar initSensorSystem attempt to load sensorTheory "  );
    			goal = "consult( \"./sensorTheory.pl\" )";
    			QActorUtils.solveGoal( pengine, goal  );
    			//println( "avatar initSensorSystem= "  +  aar.getResult() );
    		}
    		addSensorObservers();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    /*
    //COMPONENTS
     RobotComponent motorleft 
     RobotComponent motorright 
    sensor distanceFront  todo  
    Composed component motors
    */
    protected void addSensorObservers(){
    	for (ISensor<?> sensor : Configurator.getInstance().getSensors()) {
    		//println( "rover sensor= "  + sensor.getDefStringRep() );
    		//println( "rover sensor class= "  + sensor.getClass().getName() );
        	if( sensor instanceof DistanceSensor){
        		DistanceSensor sensorDistance  = (DistanceSensor) sensor;
        		ISensorObserver<IDistanceSensorData> obs = new SensorObserver<IDistanceSensorData>(this,outEnvView);
        //		println( "avatar add observer to  "  + sensorDistance.getDefStringRep() );
        		sensorDistance.addObserver(  obs  ) ;
        	}
        	if( sensor instanceof LineSensor){
        		LineSensor sensorLine = (LineSensor) sensor;
         		ISensorObserver<ILineSensorData> obs = new SensorObserver<ILineSensorData>(this,outEnvView);
        //		println( "avatar add observer to  "  + sensorLine.getDefStringRep() );
        		sensorLine.addObserver(  obs  ) ;
        	}
         	if( sensor instanceof MagnetometerSensor){
        		MagnetometerSensor sensorMagneto = (MagnetometerSensor) sensor;
         		ISensorObserver<IMagnetometerSensorData> obs = new SensorObserver<IMagnetometerSensorData>(this,outEnvView);
        //		println( "avatar add observer to  "  + sensorMagneto.getDefStringRep() );
        		sensorMagneto.addObserver(  obs  ) ;
        	}
    		if( sensor instanceof ImpactSensor){
    			ImpactSensor sensorImpact = (ImpactSensor) sensor;
    			ISensorObserver<IImpactSensorData> obs = new SensorObserver<IImpactSensorData>(this,outEnvView);
    	//		println( "avatar add observer to  "  + sensorMagneto.getDefStringRep() );
    			sensorImpact.addObserver(  obs  ) ;
    		}
    	}		
    }	
    
 
	/* 
	* ------------------------------------------------------------
	* APPLICATION ACTIONS
	* ------------------------------------------------------------
	*/
	/* 
	* ------------------------------------------------------------
	* QUEUE  
	* ------------------------------------------------------------
	*/
	    protected void getMsgFromInputQueue(){
//	    	println( " %%%% getMsgFromInputQueue" ); 
	    	QActorMessage msg = mysupport.getMsgFromQueue(); //blocking
//	    	println( " %%%% getMsgFromInputQueue continues with " + msg );
	    	this.currentMessage = msg;
	    }
  }
