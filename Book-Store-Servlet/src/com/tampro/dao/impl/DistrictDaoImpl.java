package com.tampro.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tampro.dao.DistrictDao;
import com.tampro.dao.RootDao;
import com.tampro.model.District;
import com.tampro.model.Ward;

public class DistrictDaoImpl extends RootDao  implements DistrictDao{

	@Override
	public List<District> getAll() {
		String sql = "select * from district ";
		Connection connection = getConnection();
		PreparedStatement statement = null ; 
		try {
			statement = connection.prepareStatement(sql);			
			ResultSet set = statement.executeQuery();
			List<District> listDistrict = new ArrayList<District>();
			while(set.next()) {
				District district = new District();
				district.setId(set.getInt("id"));
				district.setName(set.getString("_name"));
				district.setPrefix(set.getString("_prefix"));
				district.setProvinceId(set.getInt("_province_id"));
				listDistrict.add(district);
			}
			return listDistrict;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public List<District> getAllByIdProvince(int idProvince) {
		String sql = "select * from district where _province_id = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null ; 
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idProvince);
			ResultSet set = statement.executeQuery();
			List<District> listDistrict = new ArrayList<District>();
			while(set.next()) {
				District district = new District();
				district.setId(set.getInt("id"));
				district.setName(set.getString("_name"));
				district.setPrefix(set.getString("_prefix"));
				district.setProvinceId(set.getInt("_province_id"));
				listDistrict.add(district);
			}
			return listDistrict;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public District getDistrictById(int id) {
		String sql = "select * from district where id  = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null ; 
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
				District district = new District();
				district.setId(set.getInt("id"));
				district.setName(set.getString("_name"));
				district.setPrefix(set.getString("_prefix"));
				district.setProvinceId(set.getInt("_province_id"));
				return district;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(District district) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(District district) {
		// TODO Auto-generated method stub
		return false;
	}

}
