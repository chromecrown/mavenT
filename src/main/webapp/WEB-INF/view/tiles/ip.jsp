<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>
<div>
    <table id="tblIP" class="table table-striped table-bordered table-hover"></table>
</div>
<script>
     //load menu data
     function loadCnt(){
     	var argObj = {};
     	$.ajax({
 			type:"POST",
 			url:"ip/cnt",
 			data:argObj,
 			dataType:"text",
 	  		beforeSend:function(XMLHttpRequest){
 	      	},
 		   	success:function(data,status){
 	      		//$.scojs_message("get cnt success", $.scojs_message.TYPE_OK);
 		   		if(data > 0){
	 		   	    initTblIP();
 		   		}
 		   	},
 	      	complete:function(XMLHttpRequest,status){
 	      	},
 	      	error:function(){
 	      		$.scojs_message("error msg", $.scojs_message.TYPE_ERROR);
 	      	}
       });
     }
     //loadData();
     $(document).ready(function(){
    	 loadCnt();
     });
     
   //初始化IP数据显示表格
 	function initTblIP(tblID,url,obj){
	   var url = "ip/pageLst";
	   var obj = new Object();
	   $("#tblIP").dataTable({
		    "bFilter": false,
		    "bAutoWidth": true, 
		 	"bDeferRender":true, 
		 	"bStateSave":false,
		 	"iScrollLoadGap":100,
		 	"sPaginationType" : "full_numbers",
		 	//"sAjaxDataProp" : "aData",
		 	"bDestroy" : true,
		 	"bProcessing" : true,
		 	"lengthMenu": [[5,10,100,200,1000], [5,10,100,200,1000]],
       		"sAjaxSource" : url,
       		"bServerSide" : true,
       		"sServerMethod":"POST",
       		"fnServerParams": function ( aoData ) {
    	     //aoData.push({"name":"multi_ip","value":val});
    	     if(obj.length>0){
    	         for(var i =0;i<obj.length;i = i+1){
    	             aoData.push(obj[i]);
    	         }
    	     }
       	   },
	       "aoColumns" :[ 
	         	{"mDataProp" : "id","sTitle":"序列"},
	         	{"mDataProp" : "ip","sTitle":"IP"},
	         	{"mDataProp" : "day","sTitle":"获取日期"},
	         	{"mDataProp" : "inOut","sTitle":"内外网"},
	         	{"mDataProp" : "src","sTitle":"来源"},
	         	{"mDataProp" : "insertTime","sTitle":"插入时间"}
	        ],
	        "fnCreatedRow":function(nRow,aData,iDisplayIndex){
	               var day = aData["day"];
	               var dayHtml = moment(day).format("YYYY-MM-DD");
	        	    $("td:eq(2)",nRow).html(dayHtml);
	        	    
	               var insertTime = aData["insertTime"];
	               var insertTimeHtml = moment(insertTime).format("YYYY-MM-DD HH:mm:ss");
	        	    $("td:eq(5)",nRow).html(insertTimeHtml);
	        	    
				    return nRow;
			 },
		 	//在每一个表格draw事件发生前调用该函数
		 	"fnPreDrawCallback":function(){
		 	 },
		 	//表格被初始化后调用
		 	"initComplete":function(){
		 	 },
		 	//当draw事件发生时调用
		 	"fnDrawCallback":function(){
		 	 },
		         "oLanguage" : objLang
			});
 	} //end function initTable
</script>