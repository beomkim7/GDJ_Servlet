package com.winter.app.departments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.regions.RegionDTO;
import com.winter.app.util.DBConnector;

public class DepartmentDAO {
	
	//Insert
	public int add(DepartmentDTO departmentDTO) throws Exception {
		
		Connection con = DBConnector.getConnector();
		
		String sql = "INSERT INTO DEPARTMENTS VALUE (?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, departmentDTO.getDepartment_id());
		st.setString(2, departmentDTO.getDepartment_name());
		st.setInt(3, departmentDTO.getManager_id());
		st.setInt(4, departmentDTO.getLocation_id());
		
		
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}
	
	//getDetail, 부서번호로 부서정보 조회
	public DepartmentDTO getDetail(DepartmentDTO departmentDTO)throws Exception{
		
		
		Connection con = DBConnector.getConnector();
		
		String sql = "SELECT * FROM DEPARTMENTS WHERE department_id=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, departmentDTO.getDepartment_id());
		
		ResultSet rs = st.executeQuery();
		
		DepartmentDTO resultDTO=null;
		
		if(rs.next()) {
			resultDTO = new DepartmentDTO();
			resultDTO.setDepartment_id(rs.getInt("department_id")); 
			resultDTO.setDepartment_name(rs.getString("department_name")); 
			resultDTO.setDepartment_name(rs.getString("manager_id")); 
			resultDTO.setDepartment_name(rs.getString("location_id")); 
		}return resultDTO;
		
	}
	
	public List<DepartmentDTO> getList() throws Exception {
		
		List<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();
		//DB접속 후 부서테이블의모든 정보를 출력
		Connection con = DBConnector.getConnector();
		
		String sql ="SELECT * FROM DEPARTMENTS";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			
			DepartmentDTO departmentDTO = new DepartmentDTO();
			
			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setManager_id(rs.getInt("MANAGER_ID"));
						
			
			ar.add(departmentDTO);
			
		}
		
		DBConnector.disConnect(rs, st, con);
		return ar;
	}

}
