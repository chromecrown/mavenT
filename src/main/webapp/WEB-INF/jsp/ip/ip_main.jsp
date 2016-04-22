<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IP信息</title>
</head>
<body>
<div>
    <ul>
        <li><span>ID:</span>${ip.id}</li>
        <li><span>inOut:</span><em>${ip.inOut}</em></li>
        <li><span>HostIP:</span><em>${ip.hostip}</em></li>
    </ul>
</div>
</body>
</html>