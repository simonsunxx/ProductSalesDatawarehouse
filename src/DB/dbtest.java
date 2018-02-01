package DB;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.tomcat.util.http.fileupload.IOUtils;


public class dbtest {
	static String driver="com.mysql.jdbc.Driver";
	static String url="jdbc:mysql://localhost/test?user=root&password=simon&useUnicode=true&characterEncoding=utf-8&useSSL=true";
    public static Connection getconnect()
    {
    	Connection conn=null;
    	try{
    		Class.forName(driver);
            conn=DriverManager.getConnection(url);
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return conn;
    }
	public static boolean hasRecord(String sql) {
		boolean result = false;
		Connection conn = null;
    	Statement stmt = null;
    	ResultSet rset = null;
    	try {
    		conn = getconnect();
			stmt = conn.createStatement();			
		    rset = stmt.executeQuery(sql);
		    while(rset.next()){
		    	result = true;
		    }
		} catch (SQLException e) {
			e.printStackTrace();			
		} 
		return result;
	}
	
	/**
	 * 查执行询语句，返回结果集
	 * @param SqlString
	 * @return
	 */
	public static ResultSet query(String sql) {
		Connection conn = null;
    	Statement stmt = null;
    	ResultSet rset = null;
    	try {
    		conn = getconnect();
			stmt = conn.createStatement();			
		    rset = stmt.executeQuery(sql);		    
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		return rset;
	}
	
	/**
	 * 更新数据库记录
	 * @param sql
	 * @return
	 */
	public static boolean update(String sql) {
		boolean result = false;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		try {
			conn = getconnect();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 删除数据库记录
	 * @param sql
	 * @return
	 */
	public static boolean delete(String sql) {
		boolean result = false;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		try {
			conn = getconnect();
			stmt = conn.createStatement();
			stmt.execute(sql);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
  public static void main(String[] args) {
}

}
