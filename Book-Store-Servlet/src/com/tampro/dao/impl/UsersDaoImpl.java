package com.tampro.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tampro.dao.RootDao;
import com.tampro.dao.UsersDao;
import com.tampro.model.Users;

public class UsersDaoImpl extends RootDao implements UsersDao{

	@Override
	public Users getUserBylogin(String username, String password) {
		
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "select * from users where users_Username = ? and users_Password = ?  and users.status = 1";
		
		try {
			connection = getConnection();
			 statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Users users = new Users();
				users.setId(rs.getInt("users_id"));
				users.setName(rs.getString("users_Name"));
				users.setEmail(rs.getString("users_Email"));
				users.setPassWord(rs.getString("users_Password"));
				users.setUserName(rs.getString("users_Username"));
				users.setPhone(rs.getString("users_Phone"));
				users.setRole(rs.getString("role"));
				users.setCreate_Date(rs.getDate("create_date"));
				users.setModify_Date(rs.getDate("modify_date"));
				users.setStatus(rs.getInt("status"));
				return users;
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
	public Users getUserByUsername(String username) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "select * from users where users_Username = ? ";
		
		try {
			connection = getConnection();
			 statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Users users = new Users();
				users.setId(rs.getInt("users_id"));
				users.setName(rs.getString("users_Name"));
				users.setCreate_Date(rs.getDate("create_date"));
				users.setModify_Date(rs.getDate("modify_date"));
				users.setEmail(rs.getString("users_Email"));
				users.setPassWord(rs.getString("users_Password"));
				users.setUserName(rs.getString("users_Username"));
				users.setPhone(rs.getString("users_Phone"));
				users.setRole(rs.getString("role"));
				users.setStatus(rs.getInt("status"));
				return users;
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
	public List<Users> getAllUsers() {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "select * from users ";
		
		try {
			connection = getConnection();
			 statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			List<Users> listUser = new ArrayList<Users>();
			while(rs.next()) {
				Users users = new Users();
				users.setId(rs.getInt("users_id"));
				users.setName(rs.getString("users_Name"));
				users.setEmail(rs.getString("users_Email"));
				users.setPassWord(rs.getString("users_Password"));
				users.setUserName(rs.getString("users_Username"));
				users.setPhone(rs.getString("users_Phone"));
				users.setRole(rs.getString("role"));
				users.setCreate_Date(rs.getDate("create_date"));
				users.setModify_Date(rs.getDate("modify_date"));
				users.setStatus(rs.getInt("status"));
				listUser.add(users);
				
			}
			return listUser;
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
	public boolean deleteUserById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(Users users) {
		PreparedStatement statement = null;
		Connection connection = null;
		String sql = "update users set  users_Password = ?,users_Name = ?,users_Phone= ?,users_Email = ? ,role = ? ,modify_date = ? ,status = ? where users_id = ?";
	try {
		connection = getConnection();
		statement = connection.prepareStatement(sql);
		
		statement.setString(1, users.getPassWord());
		statement.setString(2, users.getName());
		statement.setString(3, users.getPhone());
		statement.setString(4, users.getEmail());
		statement.setString(5, users.getRole());
		statement.setDate(6, users.getModify_Date());
		statement.setInt(7, users.getStatus());
		statement.setInt(8, users.getId());
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
	public boolean addUser(Users users) {
		String sql = "INSERT INTO users (users_Username,users_Password,users_Name,users_Phone,users_Email,role,create_date,modify_date,status) VALUES(?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			connection = RootDao.getConnection();
			 statement  = connection.prepareStatement(sql);
			statement.setString(1,users.getUserName());
			statement.setString(2,users.getPassWord());
			statement.setString(3,users.getName());
			statement.setString(4,users.getPhone());
			statement.setString(5,users.getEmail());
			statement.setString(6,users.getRole());
			statement.setDate(7,users.getCreate_Date());
			statement.setDate(8,users.getModify_Date());
			statement.setInt(9, users.getStatus());
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
	public Users getUserById(int id) {
		PreparedStatement statement = null;
		Connection connection = null;
		String sql = "select * from users where users_id = ? ";
		
		try {
			connection = getConnection();
			 statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Users users = new Users();
				users.setId(rs.getInt("users_id"));
				users.setName(rs.getString("users_Name"));
				users.setCreate_Date(rs.getDate("create_date"));
				users.setModify_Date(rs.getDate("modify_date"));
				users.setEmail(rs.getString("users_Email"));
				users.setPassWord(rs.getString("users_Password"));
				users.setUserName(rs.getString("users_Username"));
				users.setPhone(rs.getString("users_Phone"));
				users.setRole(rs.getString("role"));
				users.setStatus(rs.getInt("status"));
				return users;
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
	public Users getUserByEmail(String email) {
		
		PreparedStatement statement = null;
		Connection connection = null;
		String sql = "select * from users where users_Email = ? ";
		
		try {
			connection = getConnection();
			 statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Users users = new Users();
				users.setId(rs.getInt("users_id"));
				users.setName(rs.getString("users_Name"));
				users.setCreate_Date(rs.getDate("create_date"));
				users.setModify_Date(rs.getDate("modify_date"));
				users.setEmail(rs.getString("users_Email"));
				users.setPassWord(rs.getString("users_Password"));
				users.setUserName(rs.getString("users_Username"));
				users.setPhone(rs.getString("users_Phone"));
				users.setRole(rs.getString("role"));
				users.setStatus(rs.getInt("status"));
				return users;
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
	
	public static void main(String[] args) {
//		Users users = new Users();
//		users.setEmail("xomrayno1@gmail.com");
//		users.setName("Nguyễn Chí Tâm ");
//		users.setUserName("xomrayno2");
//		users.setPhone("12345678910");
//		users.setPassWord("123232");
//		
//		UsersDao usersDao = new UsersDaoImpl();
//		usersDao.addUser(users);
	}

	@Override
	public List<Users> getAllUsers(int start, int end) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "SELECT * FROM `users` ORDER BY `users_id` DESC limit ?,? ";
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, start);
			statement.setInt(2, end);
			ResultSet rs = statement.executeQuery();
			List<Users> listUser = new ArrayList<Users>();
			while(rs.next()) {
				Users users = new Users();
				users.setId(rs.getInt("users_id"));
				users.setName(rs.getString("users_Name"));
				users.setEmail(rs.getString("users_Email"));
				users.setPassWord(rs.getString("users_Password"));
				users.setUserName(rs.getString("users_Username"));
				users.setPhone(rs.getString("users_Phone"));
				users.setRole(rs.getString("role"));
				users.setCreate_Date(rs.getDate("create_date"));
				users.setModify_Date(rs.getDate("modify_date"));
				users.setStatus(rs.getInt("status"));
				listUser.add(users);				
			}
			return listUser;
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
	public List<Users> getAllUsersBySearch(String name,String role) {
		Connection connection = null;
		PreparedStatement statement = null;
		StringBuilder builder = new StringBuilder("select * from users where 1 = 1 ");
		
		
		
		try {
			connection = getConnection();
			
			 if(!name.isEmpty()) {
				 builder.append("and users.users_Username like '%"+name+"%' ");
			 }
			 if(!role.isEmpty()) {
				 builder.append("and role = '"+role+"' ");
			 }
			 builder.append(" order by users_id desc");
			 statement = connection.prepareStatement(builder.toString());
			ResultSet rs = statement.executeQuery();
			List<Users> listUser = new ArrayList<Users>();
			while(rs.next()) {
				Users users = new Users();
				users.setId(rs.getInt("users_id"));
				users.setName(rs.getString("users_Name"));
				users.setEmail(rs.getString("users_Email"));
				users.setPassWord(rs.getString("users_Password"));
				users.setUserName(rs.getString("users_Username"));
				users.setPhone(rs.getString("users_Phone"));
				users.setRole(rs.getString("role"));
				users.setCreate_Date(rs.getDate("create_date"));
				users.setModify_Date(rs.getDate("modify_date"));
				users.setStatus(rs.getInt("status"));
				listUser.add(users);
				
			}
			return listUser;
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
	public List<Users> getAllUsersBySearchPagi(String name,String role, int start, int end) {
		Connection connection = null;
		PreparedStatement statement = null;
		StringBuilder builder = new StringBuilder("select * from users where 1 = 1 ");
		
		
		try {
			connection = getConnection();
			if(!name.isEmpty()) {
				 builder.append("and users.users_Username like '%"+name+"%' ");
			 }
			 if(!role.isEmpty()) {
				 builder.append("and role = '"+role+"' ");
			 }
			 builder.append(" order by users_id desc limit ? ,?");
			 statement = connection.prepareStatement(builder.toString());
			 statement.setInt(1, start);
			 statement.setInt(2, end);
			ResultSet rs = statement.executeQuery();
			List<Users> listUser = new ArrayList<Users>();
			while(rs.next()) {
				Users users = new Users();
				users.setId(rs.getInt("users_id"));
				users.setName(rs.getString("users_Name"));
				users.setEmail(rs.getString("users_Email"));
				users.setPassWord(rs.getString("users_Password"));
				users.setUserName(rs.getString("users_Username"));
				users.setPhone(rs.getString("users_Phone"));
				users.setRole(rs.getString("role"));
				users.setCreate_Date(rs.getDate("create_date"));
				users.setModify_Date(rs.getDate("modify_date"));
				users.setStatus(rs.getInt("status"));
				listUser.add(users);
				
			}
			return listUser;
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
