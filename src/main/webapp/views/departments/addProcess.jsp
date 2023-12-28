<%@page import="com.winter.app.departments.DepartmentDTO"%>
<%@page import="com.winter.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DepartmentDAO departmentDAO = new DepartmentDAO();
	DepartmentDTO departmentDTO = new DepartmentDTO();
	
	String did = request.getParameter("department_id");
	String dname = request.getParameter("department_name");
	String mid = request.getParameter("manager_id");
	String lid = request.getParameter("location_id");
		
	departmentDTO.setDepartment_id(Integer.parseInt(did));
	departmentDTO.setDepartment_name(dname);
	departmentDTO.setManager_id(Integer.parseInt(mid));
	departmentDTO.setLocation_id(Integer.parseInt(lid));
	
	int result = departmentDAO.add(departmentDTO);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Process</h1>
	
	<script type="text/javascript">
		let result = <%= result%>;
		if(result>0){
			alert("성공");
		}else{
			alert("실패");
		}
		
		window.location.href="./list.jsp";
		
	</script>	
</body>
</html>


	<!-- private int department_id;
	private String department_name;
	private int manager_id;
	private int location_id; -->