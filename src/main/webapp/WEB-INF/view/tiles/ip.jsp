<div>
    <table id="tblIP" class="table table-striped table-bordered table-hover"></table>
</div>
<script>
     //load menu data
     function loadData(){
     	var argObj = {};
     	$.ajax({
 			type:"POST",
 			url:"ip/pageLst",
 			data:argObj,
 			dataType:"text",
 	  		beforeSend:function(XMLHttpRequest){
 	      	},
 		   	success:function(data,status){
 	      		$.scojs_message("information load success", $.scojs_message.TYPE_OK);
 		   		console.log("return type of data-=>"+data);
 		   	},
 	      	complete:function(XMLHttpRequest,status){
 	      	},
 	      	error:function(){
 	      		$.scojs_message("information msg", $.scojs_message.TYPE_ERROR);
 	      	}
       });
     }
     loadData();
     
   //初始化IP数据显示表格
 	function init_tbl_IPInfo(tblID,url,obj){
 		$("#"+tblID).dataTable({
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
          	{"mDataProp" : "ip","sTitle":"邮箱"},
          	{"mDataProp" : "day","sTitle":"获取日期"},
          	{"mDataProp" : "inOut","sTitle":"内外网"},
          	{"mDataProp" : "src","sTitle":"来源"},
          	{"mDataProp" : "insertTime","sTitle":"插入时间"}
         ],
         "fnCreatedRow":function(nRow,aData,iDisplayIndex){
         	    //$("td:eq(7)",nRow).html(row7);
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
 		 		$(".orgClass").each(function(i,v){
 		 			qryOrgInfo(this);//查询指定编码组织
 		 		});
 		 	},
          "oLanguage" : objLang
 		});
 	} //end function initTable
</script>