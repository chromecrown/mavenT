<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>
<div>
file upload
	<form action="demo/upload" method="post" enctype="multipart/form-data">  
	    <input type="file" name="file" /> <input type="submit" value="Submit" />
	</form>
	
	<img alt="fileupload" src="${fileUrl }" />  
</div>
<script>
</script>