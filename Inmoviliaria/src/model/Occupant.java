package model;

import java.io.Serializable;

public class Occupant implements Serializable, Comparable<Occupant>{
	
	private String idOccupant;
	private int dni;
	private String name;
	private int age;
	
	public Occupant(String id,int dni,String name,int age){
		this.idOccupant = id;
		this.dni = dni;
		this.name = name;
		this.age = age;
	}
	public static String idOccupant() {
		String result = java.util.UUID.randomUUID().toString().toUpperCase().substring(0, 5);
		return result;
	}

	public String getId() {
		return idOccupant;
	}
	
	public void setId(String id) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dni;
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
	@Override
	public int compareTo(Occupant o) {
		
		return idOccupant.compareTo(o.getId());
	}
	
}
