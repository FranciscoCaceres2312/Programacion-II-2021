package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Occupant {
	
	private int idOccupant;
	private int dni;
	private String name;
	private int age;
	
	public Occupant(int id,int dni,String name,int age){
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
		return "\n ID: "+idOccupant+""
	            +"\n DNI: "+ dni+""
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
			System.out.println(" Inquilino añadido exitosamente");
			
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e + " Fallo al guardar los datos");
		}		
	}
	
	public static int idIncrement() {
		
		int id = 0;
		try {
			Connection conn = Singlet.getInstance();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT MAX(id_Occupant) from occupant");
			while(rs.next()) {
				id = rs.getInt(1)+1;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public static ArrayList<Occupant> getAllOccupant() {
    	ArrayList<Occupant> result = new ArrayList<Occupant>();
    	try {
			Connection conn = Singlet.getInstance();
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM occupant");
            ResultSet rs = pst.executeQuery();
            
			while(rs.next()) {
				
				Occupant occu = new Occupant(rs.getInt(1), rs.getInt("dni"),rs.getString("name"),rs.getInt("age"));
				result.add(occu);  
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	return result; 
    }
	
	public static void deleteOccupant(int id) {
		
		try {
			Connection conn = Singlet.getInstance();
			PreparedStatement st = conn.prepareStatement(" DELETE FROM occupant WHERE id_Occupant=?");
			st.setInt(1, id);
			st.executeUpdate();
			System.out.println(" Se elimino el inquilino del sistema");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	 public static String[] filterOccupant(int id) {
	    	String filter[] = new String[4];
	    	try {
				Connection conn = Singlet.getInstance();
				PreparedStatement pst = conn.prepareStatement("SELECT * FROM occupant WHERE id_occupant=?");
	            pst.setInt(1, id);
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					filter[0] = Integer.toString(rs.getInt(1));
					filter[1] = Integer.toString(rs.getInt("dni"));
					filter[2] = rs.getString("name");
					filter[3] = Integer.toString(rs.getInt("age"));
	            }
	    	}catch(SQLException e) {
				e.printStackTrace();
			}
	    	return filter;
	    }
	 public void modifyOccupant() {
	    	
	    	try {
				Connection con = Singlet.getInstance();
		
				PreparedStatement pst = con.prepareStatement("UPDATE occupant SET id_Occupant=?,dni=?,name=?,age=? WHERE id_Occupant=?");
				pst.setInt(1,idOccupant);
				pst.setInt(2,dni);
				pst.setString(3, name);
				pst.setInt(4, age);
				pst.setInt(5, idOccupant);
		        pst.executeUpdate();
		        System.out.println(" Inquilino modificado");
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Error en la coneccion a la base de datos ");
				}
	    }

}
