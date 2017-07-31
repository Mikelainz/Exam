%====================================================================================
% Context ctxRobot  SYSTEM-configuration: file it.unibo.ctxRobot.rover_wall_e_sys.pl 
%====================================================================================
context(ctxrobot, "localhost",  "TCP", "8070" ).  		 
%%% -------------------------------------------
qactor( sonar2 , ctxrobot, "it.unibo.sonar2.MsgHandle_Sonar2"   ). %%store msgs 
qactor( sonar2_ctrl , ctxrobot, "it.unibo.sonar2.Sonar2"   ). %%control-driven 
%%% -------------------------------------------
%%% -------------------------------------------
qactor( rover , ctxrobot, "it.unibo.rover.MsgHandle_Rover" ). 
qactor( rover_ctrl , ctxrobot, "it.unibo.rover.Rover" ). 

