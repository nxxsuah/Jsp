<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>file</title>
	</head>
	<body>
		<h3>파일 페이지</h3>
		<%
			// response 헤더 Content-Type 값을 파일로 
			// 클라이언트가 다운로드 받을 수 있도록 해줌
			response.setHeader("Content-Type", "application/octet-stream");			
		
		%>
		
	</body>
</html>