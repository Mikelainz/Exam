%====================================================================================
% Context ctxRobot  SYSTEM-configuration: file it.unibo.ctxRobot.rover_wall_e_sys.pl 
%====================================================================================
context(ctxrobot, "localhost",  "TCP", "8070" ).  		 
context(ctxsonarenv, "192.168.43.101",  "TCP", "8090" ).  		 
%%% -------------------------------------------
qactor( sonar1 , ctxsonarenv, "it.unibo.sonar1.MsgHandle_Sonar1"   ). %%store msgs 
qactor( sonar1_ctrl , ctxsonarenv, "it.unibo.sonar1.Sonar1"   ). %%control-driven 
qactor( sonar2 , ctxsonarenv, "it.unibo.sonar2.MsgHandle_Sonar2"   ). %%store msgs 
qactor( sonar2_ctrl , ctxsonarenv, "it.unibo.sonar2.Sonar2"   ). %%control-driven 
qactor( roversupport , ctxrobot, "it.unibo.roversupport.MsgHandle_Roversupport"   ). %%store msgs 
qactor( roversupport_ctrl , ctxrobot, "it.unibo.roversupport.Roversupport"   ). %%control-driven 
%%% -------------------------------------------
%%% -------------------------------------------
qactor( rover , ctxrobot, "it.unibo.rover.MsgHandle_Rover" ). 
qactor( rover_ctrl , ctxrobot, "it.unibo.rover.Rover" ). 

