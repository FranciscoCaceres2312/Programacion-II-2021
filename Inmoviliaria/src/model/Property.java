package model;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Property implements Serializable{
	public int id;
	public String cadastralNumber;
	public String direction;
	public int postcard;
	public float price;
	
	public Property(int id,String cadastralNumber, String direction, int postcard, float price) {
		this.id = id;
		this.cadastralNumber = cadastralNumber;
		this.direction = direction;
		this.postcard = postcard;
		this.price = price;
	}
	
    public static int idIncrement() {
		
		int result = 0;
		try {
			Connection conn = Singlet.getInstance();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT MAX(id_Occupant) from occupant");
			while(rs.next()) {
				result = rs.getInt(1) + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
    
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getCadastralNumber() {
		return cadastralNumber;
	}
	
	public void setCadastralNumber(String cadastralNumber) {
		this.cadastralNumber = cadastralNumber;
	}
	
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getPostcard() {
		return postcard;
	}

	public void setPostcard(int postcard) {
		this.postcard = postcard;
	}

	public float getprice() {
		return price;
	}

	public void setValue(float price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Property other = (Property) obj;
		if (cadastralNumber == null) {
			if (other.cadastralNumber != null)
				return false;
		} else if (!cadastralNumber.equals(other.cadastralNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\n ID: "+id+""
				+ "\n Numero Catastral: "+ cadastralNumber+""
				+ "\n Dirección: "+direction+""
				+ "\n Codigo Postal: "+postcard+""
				+ "\n Valor: "+price;
	}

    public void addProperty() {
		
		try {
			Connection con = Singlet.getInstance();
	
			PreparedStatement pst = con.prepareStatement("INSERT INTO property VALUES(?,?,?,?,?)");
			pst.setInt(1,10);
			pst.setString(2,cadastralNumber);
			pst.setString(3,direction);
			pst.setInt(4,postcard);
			pst.setFloat(5,price);
	        pst.executeUpdate();
		
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error en la coneccion a la base de datos ");
		}
		
	}
    
    public static ArrayList<Property> getAllProperties() {
    	ArrayList<Property> result = new ArrayList<Property>();
    	try {
			Connection conn = Singlet.getInstance();
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM property");
            ResultSet rs = pst.executeQuery();
            
			while(rs.next()) {
				
				Property prop = new Property(rs.getInt("id_Property"), rs.getString("cadastralNumber"),rs.getString("direction"),rs.getInt("postcard"),rs.getFloat("price"));
                result.add(prop);            
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	return result; 
    }
    public static String[] filterProperty(int id) {
    	String filter[] = new String[5];
    	try {
			Connection conn = Singlet.getInstance();
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM property WHERE id_Property=?");
            pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				filter[0] = Integer.toString(rs.getInt(1));
				filter[1] = rs.getString("cadastralNumber");
				filter[2] = rs.getString("direction");
				filter[3] = Integer.toString(rs.getInt("postcard"));
				filter[4] = Float.toString(rs.getFloat("price"));
            }
    	}catch(SQLException e) {
			e.printStackTrace();
		}
    	return filter;
    }
    
    public void modifyProperty() {
    	
    	try {
			Connection con = Singlet.getInstance();
	
			PreparedStatement pst = con.prepareStatement("UPDATE property SET id_Property=?,cadastralNumber=?,direction=?,postcard=?,price=? WHERE id_Property=?");
			pst.setInt(1,id);
			pst.setString(2,cadastralNumber);
			pst.setString(3, direction);
			pst.setInt(4, postcard);
			pst.setFloat(5,price);
			pst.setInt(6, id);
	        pst.executeUpdate();
		
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error en la coneccion a la base de datos ");
			}
    }
    
	public static void deleteProperty(int id) {
		
		try {
			Connection conn = Singlet.getInstance();
			PreparedStatement st = conn.prepareStatement(" DELETE FROM property WHERE id_Property=?");
			st.setInt(1, id);
			st.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
