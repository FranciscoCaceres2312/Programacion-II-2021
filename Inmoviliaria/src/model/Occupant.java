package model;

import java.util.ArrayList;

public class Occupant {
	public int id;
	public int DNI;
	public String name;
	public int age;
	
	public Occupant(int id, int DNI,String name,int age){
		this.id = id;
		this.DNI = DNI;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
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
		if (DNI != other.DNI)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\n ID: "+ id+""
				+ "\n DNI: "+ DNI+""
				+ "\n Nombre: "+name+""
				+ "\n Edad: "+age+"";

	}
	
	public static int idIncrement() {
		ArrayList<Occupant> occupant = new ArrayList<Occupant>();
		int result = 0;
		occupant.addAll(Model.getListOccupant());
		result = occupant.size();
		result ++;
		return result;
	}
	
}
