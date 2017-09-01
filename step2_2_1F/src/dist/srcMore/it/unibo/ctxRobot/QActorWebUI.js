//QActorWebUI.js
var curSpeed = "low";
var currentState = "standby";

    console.log("QActorWebUI.js : server IP= "+document.location.host);
 /*
 * WEBSOCKET
 */
    var sock = new WebSocket("ws://"+document.location.host, "protocolOne");
    sock.onopen = function (event) {
         //console.log("QActorWebUI.js : I am connected to server.....");
         document.getElementById("connection").value = 'CONNECTED';
    };
    sock.onmessage = function (event) {
        //console.log("QActorWebUI.js : "+event.data);
        //alert( "onmessage " + event);
        document.getElementById("state").value = ""+event.data;
    }
    sock.onerror = function (error) {
        //console.log('WebSocket Error %0',  error);
        document.getElementById("state").value = ""+error;
    };
    
	function send(message) {
		document.getElementById("sending").value = ""+message;
		sock.send(message);
	};
		
	function showHide(buttonPressed) {
		if(currentState=="standby" && buttonPressed=="start")
			{
	document.getElementById("takeControl").style.display="inline";
	document.getElementById("alarm").style.display="inline";
	document.getElementById("start").style.display="none";		
	currentState="reachB";	
			}
		else if(currentState=="reachB" && buttonPressed=="takecontrol")
			{
	document.getElementById("command").style.display="inline";
	document.getElementById("takeControl").style.display="none";
	document.getElementById("releaseControl").style.display="inline";
	document.getElementById("ExternalHome").style.display="inline";	
	currentState="controlTaken";			
			}
		else if(currentState=="reachB" && buttonPressed=="alarm")
			{
	document.getElementById("alarm").style.display="none";
	document.getElementById("start").style.display="inline";			
	currentState="handleAlarm";			
			}
		else if(currentState=="controlTaken" && buttonPressed=="releasecontrol")
			{
	document.getElementById("command").style.display="none";
	document.getElementById("takeControl").style.display="inline";
	document.getElementById("releaseControl").style.display="none";
	document.getElementById("ExternalHome").style.display="none";
	document.getElementById("alarm").style.display="none";		
	currentState="controlReleasedStandby";			
			}
		else if(currentState=="controlTaken" && buttonPressed=="gohome")
			{
	document.getElementById("command").style.display="none";
	document.getElementById("takeControl").style.display="inline";
	document.getElementById("releaseControl").style.display="none";
	document.getElementById("alarm").style.display="inline";		
	document.getElementById("ExternalHome").style.display="none";	
	currentState="reachB";			
			}
		else if(currentState=="controlReleasedStandby" && buttonPressed=="takecontrol")
			{
	document.getElementById("command").style.display="inline";
	document.getElementById("takeControl").style.display="none";
	document.getElementById("releaseControl").style.display="inline";
	document.getElementById("ExternalHome").style.display="inline";		
	currentState="controlTaken";			
			}
		else if(currentState=="handleAlarm" && buttonPressed=="start")
			{
	document.getElementById("takeControl").style.display="inline";
	document.getElementById("alarm").style.display="inline";
	document.getElementById("start").style.display="none";			
	currentState="reachB";			
			}
		else if(currentState=="handleAlarm" && buttonPressed=="takecontrol")
			{
	document.getElementById("command").style.display="inline";
	document.getElementById("takeControl").style.display="none";
	document.getElementById("releaseControl").style.display="inline";
	document.getElementById("ExternalHome").style.display="inline";	
	currentState="controlTaken";			
			}
	}
	
	
