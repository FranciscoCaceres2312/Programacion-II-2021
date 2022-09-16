package model;
import java.io.Serializable;

public class Property implements Serializable{

	public String cadastralNumber;
	public String direction;
	public int postcard;
	public float price;
	
	public Property(String cadastralNumber, String direction, int postcard, float price) {
		this.cadastralNumber = cadastralNumber;
		this.direction = direction;
		this.postcard = postcard;
		this.price = price;
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
		return "\n Numero Catastral: "+ cadastralNumber+""
				+ "\n Dirección: "+direction+""
				+ "\n Codigo Postal: "+postcard+""
				+ "\n Valor: "+price;
	}

	
}
