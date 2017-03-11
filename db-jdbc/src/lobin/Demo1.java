package lobin;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

public class Demo1 {
	private String url = "jdbc:mysql://192.168.31.102:3306/ssm";
	private String user = "admin";
	private String password = "123";

	@Test
	public void test1() throws SQLException {
		Driver driver = new com.mysql.jdbc.Driver();
		Properties props = new Properties();
		props.setProperty("user", user);
		props.setProperty("password", password);
		Connection conn = driver.connect(url, props);
		System.out.println(conn);
	}

	@Test
	public void test2() throws SQLException {
		Driver driver = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(driver);
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println(conn);
	}

	@Test
	public void test3() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println(conn);
	}

	@Test
	public void test4() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, password);
		Statement stat = conn.createStatement();
		String sql = "INSERT book(NAME,number) VALUES('jdbc',5)";
		int res = stat.executeUpdate(sql);
		System.out.println(res);
	}
	@Test
	public void test5() throws Exception{
		Connection conn=JdbcUtil.getConnection();
		Statement stat=conn.createStatement();
		String sql="select * from book";
		ResultSet rs=stat.executeQuery(sql);
		while(rs.next()){
			int id=rs.getInt(1);
			String name=rs.getString("name");
			int des=rs.getInt(3);
			System.out.println(id+name+des);
		}
	}
	@Test
	public void test6() throws Exception{
		Connection conn=JdbcUtil.getConnection();		
		String sql="INSERT book(NAME,number) VALUES(?,?)";
		PreparedStatement stat=conn.prepareStatement(sql);
		stat.setString(1, "prep");
		stat.setInt(2, 10);
		int rs=stat.executeUpdate();
		System.out.println(rs);
	}
}
