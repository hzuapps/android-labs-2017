package edu.hzuapps.androidlabs.homeworks.net1414080903104;
/*
 *实现数据库连接和释放的类 
 *代码参考javaweb应用开发教材中“数据库访问javabean的设计”
 *（未测试成功，待修改）
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class Linkdatabases {
	private static String driver ;
	private static String url ;
	private static String user ;
	private static String password ;
    private static Properties pr=new Properties();
	private Linkdatabases() {}
	static { 
	   try {pr.load(Linkdatabases.class.getClassLoader().getResourceAsStream("db.properties"));
		  driver=pr.getProperty("driver");
		  url=pr.getProperty("url");
		  user=pr.getProperty("username");
		  password=pr.getProperty("password");
		  Class.forName(driver);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	public static void free(ResultSet rs, Statement st, Connection conn) {
		try { if (rs != null) rs.close();
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			try { if (st != null) st.close();
			} catch (SQLException e) {e.printStackTrace();
			} finally {
				  if (conn != null)
				    try { conn.close();
				    } catch (SQLException e) {e.printStackTrace();
				   }
		             }
		     }
	    }

}
