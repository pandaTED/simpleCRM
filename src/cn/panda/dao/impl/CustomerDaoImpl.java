package cn.panda.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cn.panda.dao.CustomerDao;
import cn.panda.domain.Customer.Customer;
import cn.panda.domain.User.RequestResult;
import cn.panda.domain.User.User;
import cn.panda.exception.DaoException;
import cn.panda.utils.JdbcUtils;

/**
 * Created by 运鹏 on 2015/10/31 0031.
 */
public class CustomerDaoImpl implements CustomerDao {

	
	public void add(Customer c,String userId) {     //增加客户
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into crm_customer (customer_id,customer_name,customer_gender,customer_birthday,customer_cellphone,customer_email,customer_type,customer_description,customer_user_id) values(?,?,?,?,?,?,?,?,?)";
			st = conn.prepareStatement(sql);
			st.setString(1, UUID.randomUUID().toString());
			st.setString(2, c.getName());
			st.setString(3, c.getGender());
			st.setDate(4, new java.sql.Date(c.getBirthday().getTime()));
			st.setString(5, c.getCellphone());
			st.setString(6, c.getEmail());
			st.setString(7, c.getType());
			st.setString(8, c.getDescription());
			st.setString(9,userId);
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}

	}

	public void update(Customer c) {     //更新客户
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update crm_customer set customer_name=?,customer_gender=?,customer_birthday=?,customer_cellphone=?,customer_email=?,customer_type=?,customer_description=? where customer_id =?";
			st = conn.prepareStatement(sql);
			st.setString(1, c.getName());
			st.setString(2, c.getGender());
			st.setDate(3, new java.sql.Date(c.getBirthday().getTime()));
			st.setString(4, c.getCellphone());
			st.setString(5, c.getEmail());
			st.setString(6, c.getType());
			st.setString(7, c.getDescription());
			st.setString(8, c.getId());
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}


	
	public void delete(String id) {     //删除客户
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from crm_customer where customer_id=?";
			st = conn.prepareStatement(sql);
			st.setString(1, id);
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}



	@SuppressWarnings("resource")
	public Customer find(String id) {       //查询客户
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String customer_user_id = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from crm_customer where customer_id =?";
			st = conn.prepareStatement(sql);
			st.setString(1, id);
			rs = st.executeQuery();
			Customer c = new Customer();
			if (rs.next()) {
				c.setId(id);
				c.setBirthday(rs.getDate("customer_birthday"));
				c.setCellphone(rs.getString("customer_cellphone"));
				c.setDescription(rs.getString("customer_description"));
				c.setEmail(rs.getString("customer_email"));
				c.setGender(rs.getString("customer_gender"));
				c.setName(rs.getString("customer_name"));
				c.setType(rs.getString("customer_type"));
				customer_user_id = rs.getString("customer_user_id");
				}
			
				String sql1 = "select * from crm_user where user_id =?";
				st = conn.prepareStatement(sql1);
				st.setString(1, customer_user_id);
				rs = st.executeQuery();
				if (rs.next()) {
					User user = new User();
					user.setId(customer_user_id);
					user.setEmail(rs.getString("user_email"));
					user.setLoginName(rs.getString("user_loginName"));
					user.setName(rs.getString("user_name"));
					user.setPassword(rs.getString("user_password"));
					user.setRegisterDate(rs.getTimestamp("user_registerDate"));
					c.setUser(user);
				}
			return c;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	
	@SuppressWarnings("resource")
	public RequestResult getResult(int startindex,int itemPerPageNum,String customer_user_id) {		//获取所有客户
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		RequestResult requestResult = new RequestResult();
		
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from crm_customer where customer_user_id=? limit ?,?";
			st = conn.prepareStatement(sql);
			st.setString(1,customer_user_id);
			st.setInt(2, startindex);
			st.setInt(3, itemPerPageNum);
			rs = st.executeQuery();
			List<Customer> list = new ArrayList<Customer>();
			while (rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getString("customer_id"));
				c.setBirthday(rs.getDate("customer_birthday"));
				c.setCellphone(rs.getString("customer_cellphone"));
				c.setDescription(rs.getString("customer_description"));
				c.setEmail(rs.getString("customer_email"));
				c.setGender(rs.getString("customer_gender"));
				c.setName(rs.getString("customer_name"));
				c.setType(rs.getString("customer_type"));
				list.add(c);
			}
			
			requestResult.setCustomerList(list);
			sql = "select count(*) from crm_customer where customer_user_id=?";
			st = conn.prepareStatement(sql);
			st.setString(1, customer_user_id);
			rs = st.executeQuery();
			if(rs.next()){
			int itemNum = rs.getInt(1);
			requestResult.setItemNum(itemNum);
			}
			return requestResult;

		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	public List<Customer> customers_user(String customer_user_id){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from crm_customer where customer_user_id=?";
			st = conn.prepareStatement(sql);
			st.setString(1,customer_user_id);
			rs = st.executeQuery();
			List<Customer> list = new ArrayList<Customer>();
			while (rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getString("customer_id"));
				c.setBirthday(rs.getDate("customer_birthday"));
				c.setCellphone(rs.getString("customer_cellphone"));
				c.setDescription(rs.getString("customer_description"));
				c.setEmail(rs.getString("customer_email"));
				c.setGender(rs.getString("customer_gender"));
				c.setName(rs.getString("customer_name"));
				c.setType(rs.getString("customer_type"));
				list.add(c);
			}
		return list;
	} catch (Exception e) {
		throw new DaoException(e);
	} finally {
		JdbcUtils.release(conn, st, rs);
	}
	}
}
