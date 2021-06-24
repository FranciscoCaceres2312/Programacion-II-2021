package contactos;

public class Contact {

	private String name;
	private String email;
	private String mobil;
	private boolean topList;

	public Contact(String name, String email, String mobil, boolean topList) {
		super();
		this.name = name;
		this.email = email;
		this.mobil = mobil;
		this.topList = topList;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobil() {
		return mobil;
	}
	public void setMobil(String mobil) {
		this.mobil = mobil;
	}
	public boolean getTopList() {
		return topList;
	}
	public void setTopList(boolean topList) {
		this.topList = topList;
	}
	@Override
	public String toString() {
		return "\n name: "+name+"\n email: "+email+"\n phone number: "+mobil+
				"\n ¿Pertenece a la Top List?  "+topList;
	}
	@Override
	public boolean equals(Object obj) {
		Contact other = (Contact) obj;
		return (other.email==email);
	}
}	
