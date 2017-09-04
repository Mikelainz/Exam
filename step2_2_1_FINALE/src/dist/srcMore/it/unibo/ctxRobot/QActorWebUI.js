//QActorWebUI.js
var curSpeed = "low";
	
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
	function exhibitionControl() {
	document.getElementById("command").style.display="inline";
	document.getElementById("releaseControl").style.display="inline";
	document.getElementById("takeControl").style.display="none";
	document.getElementById("ExternalHome").style.display="inline"
	}

	function hideControl() {
	document.getElementById("command").style.display="none";
	document.getElementById("releaseControl").style.display="none";
	document.getElementById("takeControl").style.display="inline";	
	document.getElementById("ExternalHome").style.display="none";
	}