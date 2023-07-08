package dao;

import model.Login;
import java.sql.*;
import ConnectionManager.ConnectionManager;
public class LoginDAO {
	
	public boolean validate(Login login) throws ClassNotFoundException, SQLException
	{
		//1.user input
		String username = login.getUsername();
		String password = login.getPassword();
		
		//2.Connect and JDBC
		ConnectionManager conm = new ConnectionManager();
		Connection con = conm.establishConnection();
		
		//Statement class declare--> create, update,delete,get
		Statement st = con.createStatement();
		
		// ResultSet class 
		ResultSet rs = st.executeQuery("select * from login");
		
		//check username and password
		while(rs.next())
		{
		if(username.equals(rs.getString("username")) && password.equals(rs.getString("password")))
				{
			conm.closeConnection();
		       	return true;
			
				}
	     }
     	{
	     conm.closeConnection();
	      return false;
    	}
 				
	}
}