<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>
<ul id="nav"></ul>
<script>
    $(document).ready(function(){
    	getNaviMenuLst();
    });
    function getNaviMenuLst(){
		$.ajax({
			type:"POST",
			url:"manage/getNaviMenuLst",
			data:{},
			dataType:"text",
				beforeSend:function(XMLHttpRequest){
		  	},
		   	success:function(data,status){
		   		var jData = $.parseJSON(data);
		   		//console.log("getNaviMenuLst==>"+JSON.stringify(jData));
		   		$.each(jData,function(i,v){
		   			var urlStr = v.url;
		   			var nameStr = v.name;
		   			var targetStr = v.target;
		   			var liStr = "<li><a href='" + urlStr + "' target='" +
		   			    targetStr + "'>" + nameStr + "</a></li>";
		   			$("#nav").append(liStr);
		   		});
		      	//$.scojs_message("编辑成功", $.scojs_message.TYPE_OK);
		   	},
		  	error:function(){
		  		$.scojs_message("load menu data error", $.scojs_message.TYPE_ERROR);
		  	}
		});
    }
</script>