package com.tampro.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.tampro.dao.OrderDao;
import com.tampro.dao.RootDao;
import com.tampro.dao.UsersDao;
import com.tampro.model.Orders;
import com.tampro.model.Users;

public class OrderDaoImpl  extends RootDao implements OrderDao{
	
	UsersDao userDao = new UsersDaoImpl();

	@Override
	public boolean add(Orders orders) {
		String sql ="INSERT INTO ORDERS(order_TotalPrice,order_Date,user_id,status,address_id) VALUES(?,?,?,?,?)";
		
		Connection connection = null;
		PreparedStatement statement = null;		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, orders.getTotalPrice());
			statement.setDate(2, orders.getDate());
			statement.setInt(3, orders.getUsers().getId());
			statement.setInt(4, orders.getStatus());
			statement.setInt(5, orders.getIdAddress());
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
	public boolean update(Orders orders) {
		String sql ="UPDATE ORDERS SET order_TotalPrice = ? ,order_Date = ?, user_id = ? ,status = ? , address_id = ? WHERE order_id = ?";
		
		Connection connection = null;
		PreparedStatement statement = null;		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, orders.getTotalPrice());
			statement.setDate(2, orders.getDate());
			statement.setInt(3, orders.getUsers().getId());
			statement.setInt(4, orders.getStatus());
			statement.setInt(5, orders.getIdAddress());
			statement.setInt(6, orders.getId());
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
	public boolean delete(int  id) {
		String sql = "delete from ORDERS where order_id = ?";
		Connection connection = null;
		PreparedStatement statement = null;		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			

			statement.setInt(1, id);
			
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
	public List<Orders> getAllOrder() {
		String sql = "select * from orders order by order_id desc";
		Connection connection = null;
		PreparedStatement statement = null;		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();
			List<Orders> listOrder = new ArrayList<Orders>();
			while(rs.next()) {
				Orders orders  = new Orders();
				Users user = userDao.getUserById(rs.getInt("user_id"));
				orders.setId(rs.getInt("order_id"));
				orders.setTotalPrice(rs.getInt("order_TotalPrice"));
				orders.setDate(rs.getDate("order_Date"));
				orders.setUsers(user);
				orders.setStatus(rs.getInt("status"));
				orders.setIdAddress(rs.getInt("address_id"));
				listOrder.add(orders);
			}
			return listOrder;
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
	public Orders getOrdersById(int id) {
		String sql = "select * from orders where order_id = ?";
		Connection connection = null;
		PreparedStatement statement = null;		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			

			statement.setInt(1, id);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				Orders orders  = new Orders();
				Users user = userDao.getUserById(rs.getInt("user_id"));
				orders.setId(rs.getInt("order_id"));
				orders.setTotalPrice(rs.getInt("order_TotalPrice"));
				orders.setDate(rs.getDate("order_Date"));
				orders.setUsers(user);
				orders.setStatus(rs.getInt("status"));
				orders.setIdAddress(rs.getInt("address_id"));
				return orders;
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
	public int addOrder(Orders orders) {
		String sql ="INSERT INTO ORDERS(order_TotalPrice,order_Date,user_id,status,address_id) VALUES(?,?,?,?,?)";
		
		Connection connection = null;
		PreparedStatement statement = null;		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, orders.getTotalPrice());
			statement.setDate(2, orders.getDate());
			statement.setInt(3, orders.getUsers().getId());
			statement.setInt(4, orders.getStatus());
			statement.setInt(5, orders.getIdAddress());
			statement.executeUpdate();
			ResultSet set = statement.getGeneratedKeys();
			while(set.next()) {
				int id = set.getInt(1);
				return id;
			}

			
			return 0;
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
		
		return 0;
	}

	@Override
	public List<Orders> getAllOrder(int start, int end) {
		String sql = "select * from orders order by status desc,order_id desc limit ?,?";
		Connection connection = null;
		PreparedStatement statement = null;		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			

			statement.setInt(1, start);
			statement.setInt(2, end);
			ResultSet rs = statement.executeQuery();
			List<Orders> listOrder = new ArrayList<Orders>();
			while(rs.next()) {
				Orders orders  = new Orders();
				Users user = userDao.getUserById(rs.getInt("user_id"));
				orders.setId(rs.getInt("order_id"));
				orders.setTotalPrice(rs.getInt("order_TotalPrice"));
				orders.setDate(rs.getDate("order_Date"));
				orders.setUsers(user);
				orders.setStatus(rs.getInt("status"));
				orders.setIdAddress(rs.getInt("address_id"));
				listOrder.add(orders);
			}
			return listOrder;
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
	public List<Orders> getAllOrderByIdUser(int idUser) {
		String sql = "select * from  orders where user_id = ? order by order_id desc";
		Connection connection = null;
		PreparedStatement statement = null;		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idUser);
			ResultSet rs = statement.executeQuery();
			List<Orders> listOrder = new ArrayList<Orders>();
			while(rs.next()) {
				Orders orders  = new Orders();
				Users user = userDao.getUserById(rs.getInt("user_id"));
				orders.setId(rs.getInt("order_id"));
				orders.setTotalPrice(rs.getInt("order_TotalPrice"));
				orders.setDate(rs.getDate("order_Date"));
				orders.setUsers(user);
				orders.setStatus(rs.getInt("status"));
				orders.setIdAddress(rs.getInt("address_id"));
				listOrder.add(orders);
			}
			return listOrder;
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
	public List<Orders> getAllOrderByIdUser(int idUser, int start, int end) {
		String sql = "select * from  orders where user_id = ? order by status desc,order_id desc limit ?,?";
		Connection connection = null;
		PreparedStatement statement = null;		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idUser);
			statement.setInt(2, start);
			statement.setInt(3, end);
			ResultSet rs = statement.executeQuery();
			List<Orders> listOrder = new ArrayList<Orders>();
			while(rs.next()) {
				Orders orders  = new Orders();
				Users user = userDao.getUserById(rs.getInt("user_id"));
				orders.setId(rs.getInt("order_id"));
				orders.setTotalPrice(rs.getInt("order_TotalPrice"));
				orders.setDate(rs.getDate("order_Date"));
				orders.setUsers(user);
				orders.setStatus(rs.getInt("status"));
				orders.setIdAddress(rs.getInt("address_id"));
				listOrder.add(orders);
			}
			return listOrder;
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
	public List<Orders> getAllStatistical(int start, int end) {
		String sql = "select od.order_id,od.order_TotalPrice,od.order_Date,users.users_Username,users.users_Email"
				+ ",address.name,pr._name as Province,dt._name as District , od.status from orders od "
				+ " inner join address on address_id = address.id "
				+ "inner join 	users ON user_id = users.users_id "
				+ " inner join province pr on pr.id = address.provincial"
				+ " inner join district dt on dt.id = address.district limit ?,?";
		
		Connection connection = null;
		PreparedStatement statement = null;		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);			
			statement.setInt(1, start);
			statement.setInt(2, end);
			ResultSet rs = statement.executeQuery();
			List<Orders> listOrder = new ArrayList<Orders>();
			while(rs.next()) {
				Orders orders  = new Orders();
				Users user = userDao.getUserById(rs.getInt("user_id"));
				orders.setId(rs.getInt("order_id"));
				orders.setTotalPrice(rs.getInt("order_TotalPrice"));
				orders.setDate(rs.getDate("order_Date"));
				orders.setUsers(user);
				orders.setStatus(rs.getInt("status"));
				orders.setIdAddress(rs.getInt("address_id"));
				listOrder.add(orders);
			}
			return listOrder;
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
	public List<Orders> getAlStatistical() {
		String sql = "select od.order_id,od.order_TotalPrice,od.order_Date,users.users_Username,users.users_Email"
				+ ",address.name,pr._name as Province,dt._name as District , od.status from orders od "
				+ " inner join address on address_id = address.id "
				+ "inner join 	users ON user_id = users.users_id "
				+ " inner join province pr on pr.id = address.provincial"
				+ " inner join district dt on dt.id = address.district";
		Connection connection = null;
		PreparedStatement statement = null;		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);			
			ResultSet rs = statement.executeQuery();
			List<Orders> listOrder = new ArrayList<Orders>();
			while(rs.next()) {
				Orders orders  = new Orders();
				Users user = userDao.getUserById(rs.getInt("user_id"));
				orders.setId(rs.getInt("order_id"));
				orders.setTotalPrice(rs.getInt("order_TotalPrice"));
				orders.setDate(rs.getDate("order_Date"));
				orders.setUsers(user);
				orders.setStatus(rs.getInt("status"));
				orders.setIdAddress(rs.getInt("address_id"));
				listOrder.add(orders);
			}
			return listOrder;
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
	public List<Orders> getAllOrderByStatus(int status) {
		String sql = "select * from  orders where status = ?  ";
		Connection connection = null;
		PreparedStatement statement = null;		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, status);
			
			ResultSet rs = statement.executeQuery();
			List<Orders> listOrder = new ArrayList<Orders>();
			while(rs.next()) {
				Orders orders  = new Orders();
				Users user = userDao.getUserById(rs.getInt("user_id"));
				orders.setId(rs.getInt("order_id"));
				orders.setTotalPrice(rs.getInt("order_TotalPrice"));
				orders.setDate(rs.getDate("order_Date"));
				orders.setUsers(user);
				orders.setStatus(rs.getInt("status"));
				orders.setIdAddress(rs.getInt("address_id"));
				listOrder.add(orders);
			}
			return listOrder;
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
	public List<Orders> getAllOrderByStatusPagi(int status, int start, int end) {
		String sql = "select * from  orders where status = ? order by order_id desc limit ?,?";
		Connection connection = null;
		PreparedStatement statement = null;		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, status);
			statement.setInt(2, start);
			statement.setInt(3, end);
			ResultSet rs = statement.executeQuery();
			List<Orders> listOrder = new ArrayList<Orders>();
			while(rs.next()) {
				Orders orders  = new Orders();
				Users user = userDao.getUserById(rs.getInt("user_id"));
				orders.setId(rs.getInt("order_id"));
				orders.setTotalPrice(rs.getInt("order_TotalPrice"));
				orders.setDate(rs.getDate("order_Date"));
				orders.setUsers(user);
				orders.setStatus(rs.getInt("status"));
				orders.setIdAddress(rs.getInt("address_id"));
				listOrder.add(orders);
			}
			return listOrder;
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
	public boolean checkOrderIdAddress(int idAddress) {
		String sql = "select * from  orders where address_id =?  ";
		Connection connection = null;
		PreparedStatement statement = null;		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idAddress);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				return true;
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
		
		return false;
	}

}
