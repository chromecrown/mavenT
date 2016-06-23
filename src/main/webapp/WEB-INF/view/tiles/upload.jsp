<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>
<div>
file upload
	<form action="demo/upload" method="post" enctype="multipart/form-data">  
	    <div>
	        <input type="file" name="file" />
	    </div>
	    <div>
	        <input type="submit" value="Submit" />
	    </div>
	</form>
	
	<img alt="fileupload" src="upl/tj.png" />  
	<img alt="fileupload" src="${fileUrl }" />  
</div>
<script>
</script>