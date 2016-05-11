<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>  
<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="resource/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="resource/js/zTree/jquery.ztree.core.js"></script>

<link rel="stylesheet" href="resource/css/zTree/zTreeStyle/zTreeStyle.css" type="text/css">
<title>Main</title>  
<style type="text/css">  
    body{  
        background-color: green;  
    }  
</style>  
</head>  
<body>  
    <t:insertAttribute name="top"/>
    <t:insertAttribute name="menu"/>
    <t:insertAttribute name="content"/>  
</body>  
</html>