<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Java后端WebSocket的Tomcat实现</title>
</head>
<div>
    Welcome to demo web worker
    <p>Count numbers :<output id="result"></output></p>
    <button onclick="startWorker()">start worker</button>
    <button onclick="stopWorker()">stop worker</button>
    <hr/>
</div>

<script type="text/javascript">
	if(typeof(Worker)!=="undefined")
	{
		console.log("support web worker object");
	}
	else
	{
		console.log("browser does not support worker object");
	}
	var w;
	function startWorker(){
		if(typeof(Worker)!==undefined){
			if(typeof(w) == "undefined"){
				w = new Worker("resource/js/this/demo_worker.js")
			}
			w.onmessage = function(event){
				document.getElementById("result").innerHTML = event.data;
			};
		}else{
			document.getElementById("result").innerHTML = "Sorry,your browser does not support web workers...";
		}
	} //end function startWorker
	
	function stopWorker(){
		w.terminate();
	}
</script>
</html>