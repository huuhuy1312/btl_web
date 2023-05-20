package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ConnectToDataBase {
	public ConnectToDataBase() {
		
	}
	public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/shoppingweb";
			String user = "root";
			String password = "huyhuyhuy1312";
			return DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException |SQLException e) {
			return null;
		}
		
	}
	public void excuteSql(String sql) throws Exception{
		Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
	}
	public ResultSet selectData(String sql) throws Exception{
		Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		return resultSet;
	}
	

}
