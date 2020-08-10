package com.tampro.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tampro.dao.ProvinceDao;
import com.tampro.dao.RootDao;
import com.tampro.model.Province;

public class ProvinceDaoImpl extends RootDao implements ProvinceDao{

	@Override
	public List<Province> getAll() {
		String sql = "select * from province ";
		Connection connection = getConnection();
		PreparedStatement statement = null ; 
		try {
			statement = connection.prepareStatement(sql);			
			ResultSet set = statement.executeQuery();
			List<Province> listProvince = new ArrayList<Province>();
			while(set.next()) {
				Province province = new Province();
				province.setCode(set.getString("_code"));
				province.setId(set.getInt("id"));
				province.setName(set.getString("_name"));
				listProvince.add(province);
			}
			return listProvince;
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
	public Province getProvinceById(int id) {
		String sql = "select * from province where id = ? ";
		Connection connection = getConnection();
		PreparedStatement statement = null ; 
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
				Province province = new Province();
				province.setCode(set.getString("_code"));
				province.setId(set.getInt("id"));
				province.setName(set.getString("_name"));
				return province;
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
	public boolean update(Province province) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(Province province) {
		// TODO Auto-generated method stub
		return false;
	}

}
