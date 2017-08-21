%====================================================================================
% Context ctxRobot  SYSTEM-configuration: file it.unibo.ctxRobot.rover_wall_e_sys.pl 
%====================================================================================
context(ctxrobot, "192.168.0.3",  "TCP", "8070" ).  		 
context(ctxsonarenv, "localhost",  "TCP", "8090" ).  		 
%%% -------------------------------------------
qactor( sonar2 , ctxsonarenv, "it.unibo.sonar2.MsgHandle_Sonar2"   ). %%store msgs 
qactor( sonar2_ctrl , ctxsonarenv, "it.unibo.sonar2.Sonar2"   ). %%control-driven 
%%% -------------------------------------------
%%% -------------------------------------------
qactor( rover , ctxrobot, "it.unibo.rover.MsgHandle_Rover" ). 
qactor( rover_ctrl , ctxrobot, "it.unibo.rover.Rover" ). 

