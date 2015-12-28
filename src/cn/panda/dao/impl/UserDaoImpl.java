package cn.panda.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cn.panda.dao.UserDao;
import cn.panda.domain.User.User;
import cn.panda.exception.DaoException;
import cn.panda.utils.JdbcUtils;

public class UserDaoImpl implements UserDao {
	
	
	/**
	 * 添加用户
	 */
	@Override
	public void addUser(User user) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into crm_user(user_id,user_name,user_loginName,user_password,user_email,user_registerDate) values(?,?,?,?,?,?)";
			st = conn.prepareStatement(sql);
			st.setString(1, UUID.randomUUID().toString());
			st.setString(2, user.getName());
			st.setString(3, user.getLoginName());
			st.setString(4, user.getPassword());
			st.setString(5, user.getEmail());
			st.setTimestamp(6,new java.sql.Timestamp(System.currentTimeMillis()));
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	/**
	 * 删除用户
	 */
	@Override
	public void deleteUser(String id) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from crm_user where user_id=?";
			st = conn.prepareStatement(sql);
			st.setString(1, id);
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	/**
	 * 修改用户
	 */
	@Override
	public void updateUser(User user) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update crm_user set user_name=? user_password=? user_email=?  where id =?";
			st = conn.prepareStatement(sql);
			st.setString(1, user.getName());
			st.setString(2, user.getPassword());
			st.setString(3, user.getEmail());
			st.setString(4, user.getId());
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	
	/**
	 * 根据id查找用户
	 */
	@Override
	public User findUser(String id) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from crm_user where user_id =?";
			st = conn.prepareStatement(sql);
			st.setString(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setId(id);
				user.setEmail(rs.getString("user_email"));
				user.setLoginName(rs.getString("user_loginName"));
				user.setName(rs.getString("user_name"));
				user.setPassword(rs.getString("user_password"));
				user.setRegisterDate(rs.getTimestamp("user_registerDate"));
				return user;
			}else{
				System.out.println("用户未找到");
				return null;
			}
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	/**
	 * 根据loginName查找用户
	 * 功能：防止loginName重复注册
	 */
	@Override
	public User findUserByLoginName(String loginName) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from crm_user where user_loginName =?";
			st = conn.prepareStatement(sql);
			st.setString(1, loginName);
			rs = st.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getString("user_id"));
				user.setEmail(rs.getString("user_email"));
				user.setLoginName(loginName);
				user.setName(rs.getString("user_name"));
				user.setPassword(rs.getString("user_password"));
				user.setRegisterDate(rs.getTimestamp("user_registerDate"));
				return user;
			}else{
				System.out.println("loginName未找到，用户可以以此登录名注册");
				return null;
			}
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	
	/**
	 * 列出所有用户
	 */
	@Override
	public List<User> listUser() {		//获取所有用户 startindex是起始查询处 itemPerPageNum是每页显示多少
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from crm_user";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			List<User> list = new ArrayList<User>();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getString("user_id"));
				user.setEmail(rs.getString("user_email"));
				user.setLoginName(rs.getString("user_loginName"));
				user.setName(rs.getString("user_name"));
				user.setPassword(rs.getString("user_password"));
				user.setRegisterDate(rs.getTimestamp("user_registerDate"));
				list.add(user);
				}
			return list;
			}catch (Exception e) {
				throw new DaoException(e);
			} finally {
				JdbcUtils.release(conn, st, rs);
			}
	}
	
	
	/**
	 * 用户登录时验证用户名和密码
	 */
	public User login(String loginName,String password){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from crm_user where user_loginName =? and user_password = ?";
			st = conn.prepareStatement(sql);
			st.setString(1, loginName);
			st.setString(2, password);
			rs = st.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getString("user_id"));
				user.setEmail(rs.getString("user_email"));
				user.setLoginName(rs.getString("user_loginName"));
				user.setName(rs.getString("user_name"));
				user.setPassword(rs.getString("user_password"));
				user.setRegisterDate(rs.getTimestamp("user_registerDate"));
				return user;
			}else{
				System.out.println("用户未找到");
				return null;
			}
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}
}
