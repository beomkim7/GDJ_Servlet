<%@page import="com.winter.app.departments.DepartmentDTO"%>
<%@page import="com.winter.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
DepartmentDAO dao = new DepartmentDAO();
DepartmentDTO dto = new DepartmentDTO();

int id = Integer.parseInt(request.getParameter("department_id"));
String name = request.getParameter("department_name");
int man = Integer.parseInt(request.getParameter("manager_id"));
int loc = Integer.parseInt(request.getParameter("location_id"));

dto.setDepartment_id(id);
dto.setDepartment_name(name);
dto.setManager_id(man);
dto.setLocation_id(loc);

dto = dao.getDetail(dto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>department detail</h1>
	<h3><%= dto.getDepartment_name() %></h3>
</body>
</html> 




<!-- 
private int department_id;
	private String department_name;
	private int manager_id;
	private int location_id; -->