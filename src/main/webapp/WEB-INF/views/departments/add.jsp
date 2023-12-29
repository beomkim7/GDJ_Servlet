<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>departments add</h1>
	<form action="./addProcess.jsp">
		<div>
			매장번호<input type="text"   name="department_id">
		</div>
		<div>
			매장이름<input type="text" name="department_name">
		</div>
		<div>
			팀장번호<input type="text"  name="manager_id">
		</div>
		<div>
			위치번호<input type="text" name="location_id">
		</div>
		<button>추가</button>
	</form>
	
	
</body>
</html>

