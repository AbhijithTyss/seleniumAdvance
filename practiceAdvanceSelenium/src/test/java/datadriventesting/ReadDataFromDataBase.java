package datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDataBase {

	public static void main(String[] args) throws SQLException {
		//load or register the driver
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		//create connection to DB
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		
		//create statement
		Statement stat = conn.createStatement();
		
		//execute query
		ResultSet resultset = stat.executeQuery("select * from persons");
		while (resultset.next()) {
			System.out.println(resultset.getString(3));
		}
		//close DB connection
		conn.close();
	}
}
