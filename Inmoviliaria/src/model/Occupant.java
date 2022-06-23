package model;

public class Occupant {
	public int code;
	public int DNI;
	public String name;
	public int age;
	public String sex;
	public String birthday;
	
	public Occupant(int code, int DNI,String name,int age, String sex, String birthday){
		this.code = code;
		this.DNI = DNI;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.birthday = birthday;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void creat() {
		
	}
	public void modify() {
		
	}
	public void remove() {
		
	}

}
