package contactos;

import java.util.ArrayList;

public class ContactBook {

	private String name;
	private ArrayList<Contact> contacts;
	
	public ContactBook() {
		contacts = new ArrayList<Contact>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void addContact (Contact c) {
		contacts.add(c);
		
		return ;
	}
	public void delContact (Contact c) {
		contacts.remove(c);
		return;
	}
	public boolean getIsTheContact (Contact c) {
		
		return false;
	}
	@Override
	public String toString() {
		String cas = " ";
		for (int i=0;i<contacts.size();i++) {
			cas = cas +contacts.get(i).toString();
		}	
			
		return "El nombre de la Libreta de contactos es: "+ this.name+" "+cas;
	
	}
}
