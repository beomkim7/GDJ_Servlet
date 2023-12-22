package com.winter.app.regions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.Region;

import com.winter.app.util.DBConnector;

public class RegionDAO {
	
	public RegionDTO getDetail(RegionDTO regionDTO)throws Exception{
		Connection con = DBConnector.getConnector();
		
		String sql = "SELECT * FROM REGIONS WHERE REGION_ID=? and dfd=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, regionDTO.getRegion_id());
		
		ResultSet rs = st.executeQuery();
		
		RegionDTO resultDTO=null;
		
		if(rs.next()) {
			resultDTO = new RegionDTO();
			resultDTO.setRegion_id(rs.getInt("REGION_ID")); 
			resultDTO.setRegion_name(rs.getString("REGION_NAME")); 
		}return resultDTO;
	}
	
	public List<RegionDTO> getList() throws Exception{
		//1. driver를 메모리에 로딩(객체 생성)
		
				Connection con = DBConnector.getConnector();
				
				String sql = "SELECT * FROM REGIONS";
				
				PreparedStatement st = con.prepareStatement(sql);
				
				ResultSet rs = st.executeQuery();
				
				List<RegionDTO> ar = new ArrayList<RegionDTO>();
				
				
				while(rs.next()) {
					
					RegionDTO regionDTO = new RegionDTO();
					int n = rs.getInt("RESION_ID");
					
					regionDTO.setRegion_id(n);
					regionDTO.setRegion_name(rs.getString("REGION_NAME"));
					
					ar.add(regionDTO);
					
				}
					
				DBConnector.disConnect(rs, st, con);
				return ar;
			
		}
	}

