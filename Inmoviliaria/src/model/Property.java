package model;
import java.io.Serializable;

public class Property implements Serializable, Comparable<Property>{
	
	public String id;
	public String cadastralNumber;
	public String direction;
	public int postcard;
	public float price;
	public String estate;
	
	public Property(String id,String cadastralNumber, String direction, int postcard, float price) {
		this.id = id;
		this.cadastralNumber = cadastralNumber;
		this.direction = direction;
		this.postcard = postcard;
		this.price = price;
	}
	
	public static String idProperty() {
		String result = java.util.UUID.randomUUID().toString().toUpperCase().substring(0, 5);
		return result;
	}
    
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cadastralNumber == null) ? 0 : cadastralNumber.hashCode());
		return result;
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
		return "\n Numero Catastral: "+ cadastralNumber+""
				+ "\n Dirección: "+direction+""
				+ "\n Codigo Postal: "+postcard+""
				+ "\n Valor: "+price;
	}

	@Override
	public int compareTo(Property o) {
		
		return cadastralNumber.compareTo(o.getCadastralNumber());
	}
   
}
