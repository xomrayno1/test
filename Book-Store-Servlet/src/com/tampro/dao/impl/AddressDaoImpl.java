package com.tampro.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tampro.dao.AddressDao;
import com.tampro.dao.DistrictDao;
import com.tampro.dao.ProvinceDao;
import com.tampro.dao.RootDao;
import com.tampro.dao.WardDao;
import com.tampro.model.Address;
import com.tampro.model.District;
import com.tampro.model.Province;
import com.tampro.model.Ward;

public class AddressDaoImpl extends RootDao implements AddressDao{
	
	ProvinceDao provinceDao = new ProvinceDaoImpl();
	DistrictDao districtDao = new DistrictDaoImpl();
	WardDao wardDao = new WardDaoImpl();

	@Override
	public List<Address> getAddressByIdUser(int idUser) {
		String sql = "select * from address where users_id = ?  order by status desc  ";
		Connection connection = getConnection();
		PreparedStatement statement = null ; 
		try {
			statement = connection.prepareStatement(sql);			
			statement.setInt(1, idUser);
			ResultSet set = statement.executeQuery();
			List<Address> listAddress = new ArrayList<Address>();
			while(set.next()) {
				Address address = new Address();
				Province province = provinceDao.getProvinceById(set.getInt("provincial"));
				District district = districtDao.getDistrictById(set.getInt("district"));
				Ward ward = wardDao.getWardById(set.getInt("ward"));				
				address.setId(set.getInt("id"));
				address.setName(set.getString("name"));
				address.setProvince(province);
				address.setDistrict(district);
				address.setWard(ward);				
				address.setDescription(set.getString("description"));
				address.setUsers_Id(set.getInt("users_id"));
				address.setStatus(set.getInt("status"));
				address.setPhone(set.getString("phone"));
				listAddress.add(address);
			}
		
			return listAddress;
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
	public boolean addAddress(Address address) {
		String sql = "insert into address(id,name,phone,provincial,district,ward,description,users_id,status) values(?,?,?,?,?,?,?,?,?) ";
		PreparedStatement statement = null;
		Connection connection = getConnection();
		try {
			 statement = connection.prepareStatement(sql);
			statement.setInt(1, address.getId());			
			statement.setString(2, address.getName());
			statement.setString(3, address.getPhone());
			statement.setInt(4, address.getProvince().getId());
			statement.setInt(5, address.getDistrict().getId());
			statement.setInt(6, address.getWard().getId());
			statement.setString(7, address.getDescription());
			statement.setInt(8, address.getUsers_Id());
			statement.setInt(9, address.getStatus());	
			statement.executeUpdate();
			return true;
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
		return false;
	}

	@Override
	public boolean updateAddress(Address address) {
		String sql = "update address set name = ? , phone = ?,provincial = ? , district = ? , ward = ?, description = ? , status = ? where id = ? ";
		PreparedStatement statement = null;
		Connection connection = getConnection();
		try {
			 statement = connection.prepareStatement(sql);

			statement.setString(1, address.getName());
			statement.setString(2, address.getPhone());
			statement.setInt(3, address.getProvince().getId());
			statement.setInt(4, address.getDistrict().getId());
			statement.setInt(5, address.getWard().getId());
			statement.setString(6, address.getDescription());
			statement.setInt(7, address.getStatus());
			statement.setInt(8, address.getId());
			int result = statement.executeUpdate();
			if(result == 1) {
				return true;
			}
			return false;
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
		return false;
	}

	@Override
	public boolean deleteAddress(int idAddress) {
		String sql = "delete from address where id = ? ";
		PreparedStatement statement = null;
		Connection connection = getConnection();
		try {
			 statement = connection.prepareStatement(sql);
			statement.setInt(1, idAddress);
			int set = statement.executeUpdate();
			System.out.println(set);
			return true;
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
		return false;
	}

	@Override
	public Address getAddressDefaultByIdUser(int idUser) {
		String sql = "select * from address where users_id = ? and status = 1";
		PreparedStatement statement = null;
		Connection connection = getConnection();
		try {
			 statement = connection.prepareStatement(sql);
			statement.setInt(1, idUser);
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
				Province province = provinceDao.getProvinceById(set.getInt("provincial"));
				District district = districtDao.getDistrictById(set.getInt("district"));
				Ward ward = wardDao.getWardById(set.getInt("ward"));
				Address address = new Address();
				address.setId(set.getInt("id"));
				address.setName(set.getString("name"));
				address.setProvince(province);
				address.setDistrict(district);
				address.setWard(ward);	
				address.setDescription(set.getString("description"));
				address.setUsers_Id(set.getInt("users_id"));
				address.setStatus(set.getInt("status"));
				address.setPhone(set.getString("phone"));
				return address;
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
	public Address getAddressById(int id) {
		String sql = "select * from address where id = ? ";
		PreparedStatement statement = null;
		Connection connection = getConnection();
		try {
			 statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				Province province = provinceDao.getProvinceById(set.getInt("provincial"));
				District district = districtDao.getDistrictById(set.getInt("district"));
				Ward ward = wardDao.getWardById(set.getInt("ward"));
				Address address = new Address();
				address.setId(set.getInt("id"));
				address.setName(set.getString("name"));
				address.setProvince(province);
				address.setDistrict(district);
				address.setWard(ward);	
				address.setDescription(set.getString("description"));
				address.setUsers_Id(set.getInt("users_id"));
				address.setStatus(set.getInt("status"));
				address.setPhone(set.getString("phone"));
				return address;
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
	public Address getAddressByIdAddressAndidUser(int id, int idUser) {
		String sql = "select * from address where id = ? and users_id = ?";
		PreparedStatement statement = null;
		Connection connection = getConnection();
		try {
			 statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setInt(2, idUser);
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				Province province = provinceDao.getProvinceById(set.getInt("provincial"));
				District district = districtDao.getDistrictById(set.getInt("district"));
				Ward ward = wardDao.getWardById(set.getInt("ward"));
				Address address = new Address();
				address.setId(set.getInt("id"));
				address.setName(set.getString("name"));
				address.setProvince(province);
				address.setDistrict(district);
				address.setWard(ward);	
				address.setDescription(set.getString("description"));
				address.setUsers_Id(set.getInt("users_id"));
				address.setStatus(set.getInt("status"));
				address.setPhone(set.getString("phone"));
				return address;
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

}
