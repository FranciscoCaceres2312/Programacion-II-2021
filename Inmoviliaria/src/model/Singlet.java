package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singlet {

	static Connection conection;
	
	public static Connection getInstance() throws SQLException{
		if(conection == null) {
	
			conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inmobiliaria","fran","");
			
		
		}
		return conection;
	}
}
