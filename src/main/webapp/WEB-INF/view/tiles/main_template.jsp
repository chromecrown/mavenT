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
  
<script  src="resource/js/jquery-2.1.1.js"></script>
<script  src="resource/js/zTree/jquery.ztree.core.js"></script>
<script src="resource/js/zTree/jquery.ztree.excheck.js"></script>
<script src="resource/js/zTree/jquery.ztree.exedit.js"></script>
<script src="resource/js/sco/sco.message.js"></script>
<script src="resource/js/sco/sco.modal.js"></script>
<script src="resource/js/sco/sco.confirm.js"></script>


<link rel="stylesheet" href="resource/css/zTree/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" href="resource/css/zTree/metroStyle/metroStyle.css" type="text/css">
<link rel="stylesheet" href="resource/css/sco/scojs.css" type="text/css">
<link rel="stylesheet" href="resource/css/sco/sco.message.css" type="text/css">

<title>Main</title>  
<style type="text/css">  
    body{  
        background-color: #FFFACD;  
    }  
</style>  
</head>  
<body>  
    <t:insertAttribute name="top"/>
    <t:insertAttribute name="menu"/>
    <t:insertAttribute name="content"/>  
</body>  
</html>