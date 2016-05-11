<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>  
<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Insert title here</title>  
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