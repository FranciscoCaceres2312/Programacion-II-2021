package model;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Contract implements Serializable{
	public String id_Contract;
	public String startDate;
	public String endDate;
	public int lapso;
	public String id_Occupant;
	public String id_Property;
	public Occupant ocupant;
	public Property property;

	public Contract(String id_Contract, int startYear, int startMonth, int startDay, int lapso, String occupant,
			String id_Property) {
		this.id_Contract = id_Contract;
		this.startDate = prepareDate(startYear, startMonth -1, startDay);
		this.endDate = prepareDate(startYear, startMonth + lapso, startDay);
		this.lapso = lapso;
		this.id_Occupant = occupant;
		this.id_Property = id_Property;
	}
	public Contract(String startDate, String endDate, int lapso, Property prop, Occupant occu) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.lapso = lapso;
		this.ocupant = occu;
		this.property = prop;
		
	}

	public static String idContract() {
		String result = java.util.UUID.randomUUID().toString().toUpperCase().substring(0, 5);
		return result;
	}

	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
	Calendar calendar = new GregorianCalendar();

	public String prepareDate(int year, int month, int day) {
		Date date;
		calendar.set(year, month, day);
		date = calendar.getTime();
		String result = sdf.format(date);
		return result;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getId_Contract() {
		return id_Contract;
	}
	public void setId_Contract(String id_Contract) {
		this.id_Contract = id_Contract;
	}
	public String getId_Occupant() {
		return id_Occupant;
	}
	public void setId_Occupant(String id_Occupant) {
		this.id_Occupant = id_Occupant;
	}
	public Occupant getOcupant() {
		return ocupant;
	}
	public void setOcupant(Occupant ocupant) {
		this.ocupant = ocupant;
	}
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getLapso() {
		return lapso;
	}

	public void setLapso(int lapso) {
		this.lapso = lapso;
	}


	public String getId_Property() {
		return id_Property;
	}

	public void setId_Property(String id_Property) {
		this.id_Property = id_Property;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contract other = (Contract) obj;
		if (id_Contract != other.id_Contract)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return 
				"\n Fecha Inicio=" + startDate+"\n Fecha Fin=" + endDate+ "\n Lapso de Contrato= "+ lapso +
				"\n inquilino : " + ocupant + "\n Inmueble : " + property;
	}

}
