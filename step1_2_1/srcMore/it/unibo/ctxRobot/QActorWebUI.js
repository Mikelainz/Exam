//QActorWebUI.js
var curSpeed = "high";
	
console.log("QActorWebUI.js : server IP= "+document.location.host);
 /*
 * WEBSOCKET
 */
    var sock = new WebSocket("ws://"+document.location.host, "protocolOne");
    sock.onopen = function (event) {
         //console.log("QActorWebUI.js : I am connected to server.....");
         //document.getElementById("connection").value = 'CONNECTED';
    };
	
    sock.onmessage = function (event) {
        //console.log("QActorWebUI.js : "+event.data);
        //alert( "onmessage " + event);
        //document.getElementById("state").value = ""+event.data;
    }
	
    sock.onerror = function (error) {
        //console.log('WebSocket Error %0',  error);
        //document.getElementById("state").value = ""+error;
    };
    
//	function setSpeed(val){
//		curSpeed = val;
//		document.getElementById("speed").value = curSpeed;
//	}
	
	function send(message) {
		//document.getElementById("sending").value = ""+message;
		sock.send(message);
	};
