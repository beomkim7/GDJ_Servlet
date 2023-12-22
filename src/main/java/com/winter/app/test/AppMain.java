package com.winter.app.test;

import java.util.List;

import javax.xml.transform.stax.StAXSource;

import com.winter.app.departments.DepartmentDAO;
import com.winter.app.regions.RegionDAO;
import com.winter.app.regions.RegionDTO;
import com.winter.app.views.View;

public class AppMain {

	public static void main(String[] args) {
		DepartmentDAO dao = new DepartmentDAO();
		RegionDAO regionDAO = new RegionDAO();
		View view = new View();
		try {
			RegionDTO regionDTO = new RegionDTO();
			regionDTO.setRegion_id(2);
			
			if(regionDTO!=null) {
				System.out.println(regionDTO.getRegion_name());
				
			}else{
				System.out.println("없는 ID");
			}
			
			
			
//			 List<RegionDTO> ar = regionDAO.getList();
//			 view.regionview(ar);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}