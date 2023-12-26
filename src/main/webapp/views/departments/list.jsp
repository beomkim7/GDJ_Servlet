<%@page import="com.winter.app.departments.DepartmentDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.winter.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DepartmentDAO departmentDAO = new DepartmentDAO();
	List<DepartmentDTO> ar = departmentDAO.getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	<thead>
		<th>1</th>
		<th>2</th>
		<th>3</th>
		<th>4</th>
	</thead>
	<tbody>
	<%for(DepartmentDTO departmentDTO : ar){ %>
		<tr>
			<td><%= departmentDTO.getDepartment_id() %><td>
			<td><%= departmentDTO.getDepartment_name() %><td>
			<td><%= departmentDTO.getManager_id() %><td>
			<td><%= departmentDTO.getLocation_id() %><td>
			
					
			
		</tr>
		<%} %>	
	</tbody>
	</table>
</body>
</html>

