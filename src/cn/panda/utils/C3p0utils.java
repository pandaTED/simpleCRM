package cn.panda.utils;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0utils {
	
//	private DataSource ds;
//	private static C3p0utils pool;

//	private C3p0utils() {
	static DataSource	ds = new ComboPooledDataSource();
//	}

/*	public static final C3p0utils getInstance() {
		if (pool == null) {
			try {
				pool = new C3p0utils();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pool;
	}
*/
	public static   Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}