package com.tampro.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tampro.dao.RootDao;
import com.tampro.dao.WardDao;
import com.tampro.model.Province;
import com.tampro.model.Ward;

public class WardDaoImpl extends RootDao implements WardDao{

	@Override
	public List<Ward> getAll() {
		String sql = "select * from ward ";
		Connection connection = getConnection();
		PreparedStatement statement = null ; 
		try {
			statement = connection.prepareStatement(sql);			
			ResultSet set = statement.executeQuery();
			List<Ward> listWard = new ArrayList<Ward>();
			while(set.next()) {
				Ward ward = new Ward();
				ward.setId(set.getInt("id"));
				ward.setName(set.getString("_name"));
				ward.setPrefix(set.getString("_prefix"));
				ward.setProvinceId(set.getInt("_province_id"));
				ward.setDistrictId(set.getInt("_district_id"));
				listWard.add(ward);
			}
			return listWard;
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
	public List<Ward> getAllByIdProvince(int idProvince) {
		String sql = "select * from ward  where  _province_id = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null ; 
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idProvince);
			ResultSet set = statement.executeQuery();
			List<Ward> listWard = new ArrayList<Ward>();
			while(set.next()) {
				Ward ward = new Ward();
				ward.setId(set.getInt("id"));
				ward.setName(set.getString("_name"));
				ward.setPrefix(set.getString("_prefix"));
				ward.setProvinceId(set.getInt("_province_id"));
				ward.setDistrictId(set.getInt("_district_id"));
				listWard.add(ward);
			}
			return listWard;
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
	public List<Ward> getAllByIdDistrict(int idDistrict) {
		String sql = "select * from ward  where  _district_id = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null ; 
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idDistrict);
			ResultSet set = statement.executeQuery();
			List<Ward> listWard = new ArrayList<Ward>();
			while(set.next()) {
				Ward ward = new Ward();
				ward.setId(set.getInt("id"));
				ward.setName(set.getString("_name"));
				ward.setPrefix(set.getString("_prefix"));
				ward.setProvinceId(set.getInt("_province_id"));
				ward.setDistrictId(set.getInt("_district_id"));
				listWard.add(ward);
			}
			return listWard;
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
	public List<Ward> getAllByIdDistrictAndIdProvince(int idProvince, int idDistrict) {
		String sql = "select * from ward  where  _district_id = ? and  _province_id = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null ; 
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idDistrict);
			statement.setInt(2, idProvince);
			ResultSet set = statement.executeQuery();
			List<Ward> listWard = new ArrayList<Ward>();
			while(set.next()) {
				Ward ward = new Ward();
				ward.setId(set.getInt("id"));
				ward.setName(set.getString("_name"));
				ward.setPrefix(set.getString("_prefix"));
				ward.setProvinceId(set.getInt("_province_id"));
				ward.setDistrictId(set.getInt("_district_id"));
				listWard.add(ward);
			}
			return listWard;
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
	public Ward getWardById(int id) {
		String sql = "select * from ward  where  id = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null ; 
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
				Ward ward = new Ward();
				ward.setId(set.getInt("id"));
				ward.setName(set.getString("_name"));
				ward.setPrefix(set.getString("_prefix"));
				ward.setProvinceId(set.getInt("_province_id"));
				ward.setDistrictId(set.getInt("_district_id"));
				return ward;
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
	public boolean update(Ward ward) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(Ward ward) {
		// TODO Auto-generated method stub
		return false;
	}

}
