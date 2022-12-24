package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import contract.IRepository;

public class Repository implements IRepository{

	public final String driver = "com.mysql.cj.jdbc.Driver";
	public final String dbhost = "jdbc:mysql:///ebs";
	public final String dbusername = "root";
	public final String dbpassword = "admin";
	@Override
	public  Statement databaseConnexion() {
        try{
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(dbhost, dbusername, dbpassword);
            return connection.createStatement();         
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public ResultSet executeQuery(String selectRequest) {
		try {
			return databaseConnexion().executeQuery(selectRequest);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int executeUpdate(String updateRequest) {
		try {
			return databaseConnexion().executeUpdate(updateRequest);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

}
