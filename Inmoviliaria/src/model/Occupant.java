package model;

public class Occupant {
	public int DNI;
	public String name;
	public int age;
	
	public Occupant(int DNI,String name,int age){
		this.DNI = DNI;
		this.name = name;
		this.age = age;
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
	public String toString() {
		return "\n DNI: "+ DNI+""
				+ "\n Nombre: "+name+""
				+ "\n Edad: "+age+"";

	}
}
