<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>uplaod picture</title>
	</head>
	<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
	<body>
		<div>
			<form method="post" enctype='multipart/form-data' action="${pageContext.request.contextPath}/hang/upload">
				<input type="file" name="myfile" >
				<input type="submit" value="上传" >
			</form>
		</div>
	<script type="text/javascript">
		$(document).ready(function(){
			$("button").click(function(){
				$.ajax({url:"http://localhost:8081/TestAnnotation/hang/upload",success:function(result){
						
					$("#div1").html(result);
					}});
				});
		});
		</script>
	</body>
</html>