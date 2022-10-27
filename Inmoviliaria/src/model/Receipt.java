package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Receipt {
	
	private String receiptCode;
	private int id_Property;
	private String date;
	private int iva;
	private float price;
	public SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
	public Receipt(String receiptCode, int property,int iva, float price) {
		this.receiptCode = receiptCode;
		this.id_Property = property;
		this.date = dateString();
		this.iva = iva;
		this.price = price;
	}
	public Receipt(String receiptCode, int property, String date, int iva, float price) {
		this.receiptCode = receiptCode;
		this.id_Property = property;
		this.date = date;
		this.iva = iva;
		this.price = price;
	}
	public String dateString() {
		Date date = new Date();
		return sdf.format(date);
	}
	
	public static String id_Receipt() {
		String result = java.util.UUID.randomUUID().toString().toUpperCase().substring(0, 10);
		return result;
	}
	
	public String getReceiptCode() {
		return receiptCode;
	}
	public void setReceiptCode(String receiptCode) {
		this.receiptCode = receiptCode;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
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
		Receipt other = (Receipt) obj;
		if (id_Property != other.id_Property)
			return false;
		if (receiptCode == null) {
			if (other.receiptCode != null)
				return false;
		} else if (!receiptCode.equals(other.receiptCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Receipt [receiptCode=" + receiptCode + ", property=" + id_Property + ", date=" + date + ", iva=" + iva
				+"%"+ ", price=" + price + "]";
	}
	
	public void addReceipt() {
		try {
			Connection conn = Singlet.getInstance();
			
			PreparedStatement pst = conn.prepareStatement("INSERT INTO receipt Values(?,?,?,?,?)");
		    pst.setString(1, receiptCode);
		    pst.setInt(2, id_Property);
		    pst.setString(3, date);
		    pst.setInt(4, iva);
		    pst.setFloat(5, price);
		    pst.executeUpdate();
		    System.out.println(" Recibo generado exitosamente");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print(" Fallo al guardar los datos del recibo ");
		}
	}
	public static ArrayList<Receipt> getAllReceipt(){
		ArrayList<Receipt> receipts = new ArrayList<Receipt>();
		Connection conn;
		try {
			conn = Singlet.getInstance();
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM receipt ORDER BY date desc");
	        ResultSet rs = pst.executeQuery();
            while(rs.next()) {
				
				Receipt receip = new Receipt(rs.getString("receiptCode"), rs.getInt("id_Property"),rs.getString("date"),rs.getInt("iva"),rs.getFloat("price"));
                receipts.add(receip);            
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return receipts;
	}

}
