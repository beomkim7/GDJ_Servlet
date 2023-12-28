package com.winter.app.test;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.xml.transform.stax.StAXSource;

import com.winter.app.departments.DepartmentDAO;
import com.winter.app.employees.EmployeeDAO;
import com.winter.app.employees.EmployeeDTO;
import com.winter.app.regions.RegionDAO;
import com.winter.app.regions.RegionDTO;
import com.winter.app.views.View;

public class AppMain {

	public static void main(String[] args) {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployee_id(Integer.parseInt("205"));
		employeeDTO.setFirst_name("first_name");
		employeeDTO.setLast_name("last_name");
		employeeDTO.setEmail("email");
		employeeDTO.setPhone_number("010");
				
		employeeDTO.setHire_date(Date.valueOf("2023-12-27"));
		
		employeeDTO.setJob_id("AC_MGR");
		employeeDTO.setSalary(Double.parseDouble("5000"));
		employeeDTO.setCommission_pct(4);
		employeeDTO.setManager_id(205);
		employeeDTO.setDepartment_id(10);
		
		System.out.println(employeeDTO);
		try {
			int result = employeeDAO.add(employeeDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}		
}