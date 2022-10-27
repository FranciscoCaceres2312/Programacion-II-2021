package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Contract {
	public String id_Contract;
	public String startDate;
	public String endDate;
	public int lapso;
	public int id_Occupant;
	public int id_Property;

	public Contract(String id_Contract, int startYear, int startMonth, int startDay, int lapso, int occupant,
			int id_Property) {
		this.id_Contract = id_Contract;
		this.startDate = prepareDate(startYear, startMonth -1, startDay);
		this.endDate = prepareDate(startYear, startMonth + lapso, startDay);
		this.lapso = lapso;
		this.id_Occupant = occupant;
		this.id_Property = id_Property;
	}

	public static String id_Contract() {
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

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getLapso() {
		return lapso;
	}

	public void setLapso(int lapso) {
		this.lapso = lapso;
	}


	public int getId_Property() {
		return id_Property;
	}

	public void setId_Property(int id_Property) {
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
		return "Contract [id_Contract=" + id_Contract + ", start date=" + startDate + ", end date=" + endDate
				+ ", lapso= " + lapso + ", id_Occupant=" + id_Occupant + ", id_Property=" + id_Property + "]";
	}

	public void addContract() {

		try {
			Connection con = Singlet.getInstance();

			PreparedStatement pst = con.prepareStatement("INSERT INTO contract VALUES(?,?,?,?,?,?)");
			pst.setString(1, id_Contract);
			pst.setString(2, startDate);
			pst.setString(3, endDate);
			pst.setInt(4, lapso);
			pst.setInt(5, id_Occupant);
			pst.setInt(6, id_Property);
			pst.executeUpdate();
			System.out.println(" Contrato creado exitosamente");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e + " Fallo al guardar los datos");
		}
	}

	public static ArrayList<Contract> getAllContracts() {
		ArrayList<Contract> result = new ArrayList<Contract>();
		String[] contract = new String[6];
		try {
			Connection conn = Singlet.getInstance();
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM contract");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				contract[0] = rs.getString("id_Contract");
				contract[1] = rs.getString("startDate");
				System.out.println(contract[1]);
				contract[2] = rs.getString("endDate");
				contract[3] = Integer.toString(rs.getInt("lapso"));
				contract[4] = Integer.toString(rs.getInt("id_Occupant"));
				contract[5] = Integer.toString(rs.getInt("id_Property"));
				int yearStart = Integer.parseInt(contract[1].substring(0, 3));
				int monthStart = Integer.parseInt(contract[1].substring(5, 6));
				int dayStart = Integer.parseInt(contract[1].substring(8));

				Contract contt = new Contract(contract[0], yearStart, monthStart, dayStart,
						Integer.parseInt(contract[3]),Integer.parseInt(contract[4]), Integer.parseInt(contract[5]));

				result.add(contt);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return result;
	}

}
