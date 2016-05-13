<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<base href="<%=basePath%>">
  
<script src="resource/js/jquery-2.1.1.js"></script>
<script src="resource/js/zTree/jquery.ztree.core.js"></script>
<script src="resource/js/zTree/jquery.ztree.excheck.js"></script>
<script src="resource/js/zTree/jquery.ztree.exedit.js"></script>
<script src="resource/js/sco/sco.message.js"></script>
<script src="resource/js/sco/sco.modal.js"></script>
<script src="resource/js/sco/sco.confirm.js"></script>
<script src="resource/js/dataTable/jquery.dataTables.min.js"></script>


<link rel="stylesheet" href="resource/css/zTree/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" href="resource/css/zTree/metroStyle/metroStyle.css" type="text/css">
<link rel="stylesheet" href="resource/css/sco/scojs.css" type="text/css">
<link rel="stylesheet" href="resource/css/sco/sco.message.css" type="text/css">
<link rel="stylesheet" href="resource/css/dataTable/jquery.dataTables.min.css" type="text/css">

<title>Main</title>  
<style type="text/css">  
    body{  
        background-color: #FFFACD;  
    }
    .top{
        float:left;
    }
    .nav{
        float:left;
    }
</style>  
</head>  
<body>
    <div class="top">
	    <t:insertAttribute name="top"/>
    </div>
    <div class="nav">
        <t:insertAttribute name="menu"/>
    </div>
    <div class="nav">
        <t:insertAttribute name="content"/>  
    </div>
</body>
<script>
	var objLang = new Object();
	objLang.sProcessing = "正在加载中,请稍后......";
	//objLang.sProcessing = "<img src='resource/img/loading.gif' />";
	objLang.sLengthMenu = "每页显示 _MENU_ 条记录";
	objLang.sZeroRecords = "没有查找到数据!";
	objLang.sEmptyTable = "没有查找到符合条件的数据!";
	objLang.sInfo = "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录";
	objLang.sInfoEmpty = "显示0到0条记录";
	objLang.sInfoFiltered = "数据表中共为 _MAX_ 条记录";
	objLang.sSearch = "搜索";
	
	var objPage = new Object();
	objPage.sFirst="首页";
	objPage.sPrevious="上一页";
	objPage.sNext="下一页";
	objPage.sLast="末页";
	objLang.oPaginate = objPage;
	
	/**
	 **获取yyyy-MM-dd格式的日期字符串
	**/
	function get_today_str() {
		var date_obj = new Date();
		var year = date_obj.getFullYear();
		var month = date_obj.getMonth() + 1;
		var day = date_obj.getDate();
		var str_date = "" + year + "-" + ((month <= 9) ? ("0" + month) : month)
				+ "-" + ((day <= 9) ? ("0" + day) : day);
		return str_date;
	}

	//获取当前日期时间字符串
	function get_datetime_str() {
		var date_obj = new Date();
		var datetime_str = getJSFormateDate(date_obj);
		return datetime_str;
	}

	//获取当前日期时间之前1小时的时间字符串
	function get_datetimeBefore1Housr_str() {

		//1小时的毫秒数
		var hour1 = Number(3600000);
		//今天日期的毫秒表示
		var todayMili = new Date().getTime();
		//1小时前的日期毫秒数
		var hourBefore1 = todayMili - hour1;
		var datetimeHourBefore1 = new Date(hourBefore1);
		var str_date = getJSFormateDate(datetimeHourBefore1);
		return str_date;
	}

	/** 获取日期的yyyy-MM-dd HH:mm:ss格式
	 **传入参数为js日期的Date类型
	 **/
	function getJSFormateDate(nDate) {
		var yyyy = nDate.getFullYear();
		var MM = nDate.getMonth() + 1;
		var dd = nDate.getDate();
		var HH = nDate.getHours();
		var mm = nDate.getMinutes();
		var ss = nDate.getSeconds();
		return new String(yyyy + "-" + (MM <= 9 ? ("0" + MM) : MM) + "-"
				+ (dd <= 9 ? ("0" + dd) : dd) + " "
				+ (HH <= 9 ? ("0" + HH) : HH) + ":"
				+ (mm <= 9 ? ("0" + mm) : mm) + ":"
				+ (ss <= 9 ? ("0" + ss) : ss));
	}
	
	/** 
	 **获取指定表单的数据
	 **传入参数为form表单ID
	 **返回键值对格式的参数对象,如obj.id=idVal
	 **/
	function getArgObj(formID){
		var argObj = new Object();
		var x = $("#"+formID).serializeArray();
		$.each(x, function(i, field){
			var name = field.name;
			var val = field.value;
			argObj[name] = val;
		});
		return argObj;
	}
	
	/** 
	 **获取指定表单的数据
	 **传入参数为form表单ID
	 **返回键值对格式对象数组
	 **[{"name":"id","value":"idValue"},{}]
	 **/
	function getArgObj2(formID){
		var argArray = new Array();
		var x = $("#"+formID).serializeArray();
		$.each(x, function(i, field){
			var argObj = new Object();
			argObj["name"] = field.name;
			argObj["value"] = field.value;
			argArray.push(argObj);
		});
		return argArray;
	}
</script> 
</html>