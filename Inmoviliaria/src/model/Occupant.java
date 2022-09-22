package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
*/
public class Occupant {
	
	private int idOccupant;
	private int dni;
	private String name;
	private int age;
	
	public Occupant(int id, int dni,String name,int age){
		this.idOccupant = id;
		this.dni = dni;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return idOccupant;
	}
	
	public void setId(int id) {
		this.idOccupant = id;
	}
	public int getDNI() {
		return dni;
	}

	public void setDNI(int dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Occupant other = (Occupant) obj;
		if (dni != other.dni)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\n DNI: "+ dni+""
				+ "\n Nombre: "+name+""
				+ "\n Edad: "+age+"";

	}
	
	public void addOccupant() {
			
		try {
			Connection con = Singlet.getInstance();
		
			PreparedStatement pst = con.prepareStatement("INSERT INTO occupant VALUES(?,?,?,?)");
			pst.setInt(1,idOccupant);				
			pst.setInt(2,dni);
			pst.setString(3,name);
			pst.setInt(4,age);		
			pst.executeUpdate();
			
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e + ".........................ffff");
		}		
	}
	
	public static int idIncrement() {
		
		int id = 0;
		try {
			Connection conn = Singlet.getInstance();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT MAX(id_Occupant) from occupant");
			while(rs.next()) {
				id = rs.getInt(1);
			}
            System.out.println(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

}
