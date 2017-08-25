%====================================================================================
% Context ctxSonar2  SYSTEM-configuration: file it.unibo.ctxSonar2.rover_wall_e_sys.pl 
%====================================================================================
context(ctxrobot, "192.168.43.101",  "TCP", "8070" ).  		 
context(ctxsonar1, "192.168.43.74",  "TCP", "8100" ).  		 
context(ctxsonar2, "localhost",  "TCP", "8090" ).  		 
%%% -------------------------------------------
qactor( sonar1 , ctxsonar1, "it.unibo.sonar1.MsgHandle_Sonar1"   ). %%store msgs 
qactor( sonar1_ctrl , ctxsonar1, "it.unibo.sonar1.Sonar1"   ). %%control-driven 
qactor( sonar2 , ctxsonar2, "it.unibo.sonar2.MsgHandle_Sonar2"   ). %%store msgs 
qactor( sonar2_ctrl , ctxsonar2, "it.unibo.sonar2.Sonar2"   ). %%control-driven 
qactor( sonarsupport , ctxrobot, "it.unibo.sonarsupport.MsgHandle_Sonarsupport"   ). %%store msgs 
qactor( sonarsupport_ctrl , ctxrobot, "it.unibo.sonarsupport.Sonarsupport"   ). %%control-driven 
qactor( usercmdsupport , ctxrobot, "it.unibo.usercmdsupport.MsgHandle_Usercmdsupport"   ). %%store msgs 
qactor( usercmdsupport_ctrl , ctxrobot, "it.unibo.usercmdsupport.Usercmdsupport"   ). %%control-driven 
%%% -------------------------------------------
%%% -------------------------------------------
qactor( rover , ctxrobot, "it.unibo.rover.MsgHandle_Rover" ). 
qactor( rover_ctrl , ctxrobot, "it.unibo.rover.Rover" ). 

