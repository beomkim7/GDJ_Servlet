package com.winter.app.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.winter.app.util.DBConnector;

public class EmployeeDAO {
	//사원 추가
	public int add(EmployeeDTO employeeDTO)throws Exception {
		Connection con = DBConnector.getConnector();
		
		String sql = "SELECT * INSERT INTO EMPLOYEES"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, employeeDTO.getDepartment_id());
		st.setString(2, employeeDTO.getFirst_name());
		st.setString(3, employeeDTO.getLast_name());
		st.setString(4, employeeDTO.getEmail());
		st.setString(5, employeeDTO.getPhone_number());
		st.setDate(6, employeeDTO.getHire_date());
		st.setString(7, employeeDTO.getJob_id());
		st.setDouble(8, employeeDTO.getSalary());
		st.setDouble(9, employeeDTO.getCommission_pct());
		st.setInt(10, employeeDTO.getManager_id());
		st.setInt(11, employeeDTO.getDepartment_id());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}
	
	//사원 급여의 합계
	public  Map getSalary() throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		Connection con = DBConnector.getConnector();
		
		String sql = "SELECT SUM(SALARY) S , count(employee_id) FROM EMPLOYEES";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		int sum = rs.getInt("S");
		int count = rs.getInt(2);
		
		map.put("count", count);
		map.put("sum", sum);
		
		DBConnector.disConnect(rs, st, con);
		
		return map;
	}
	
	
	//하나 조회
	public EmployeeDTO getDetail(EmployeeDTO employeeDTO) throws Exception{
		Connection con = DBConnector.getConnector();
		
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, employeeDTO.getEmployee_id());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
		}else {
			employeeDTO=null;
		}
		DBConnector.disConnect(rs, st, con);
		return employeeDTO;
	}
	
	//전체 조회
	public ArrayList<EmployeeDTO> getList() throws Exception {
		//배열, List, Set, Map
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		
		//1. 정보 선언 2. DB 연결
		 Connection con = DBConnector.getConnector();
		
		//3. SQL(Query)문 생성
		String sql = "SELECT * FROM EMPLOYEES";
		 
		//4. 미리 전송
		PreparedStatement st = con .prepareStatement(sql);
				
		//5. ? 값 세팅
		
		//6. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
						
		}
		//7. 연결 해제
		DBConnector.disConnect(rs, st, con);
		
		return ar;
		
	}
}
