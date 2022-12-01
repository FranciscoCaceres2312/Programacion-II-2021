package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Receipt implements Serializable{
	
	private String receiptCode;
	private String id_Property;
	private String date;
	private int iva;
	private float price;
	public SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
	public Receipt(String receiptCode, String property,int iva, float price) {
		this.receiptCode = receiptCode;
		this.id_Property = property;
		this.date = dateString();
		this.iva = iva;
		this.price = price;
	}
	public Receipt(String receiptCode, String property, String date, int iva, float price) {
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
	public String getIdProperty() {
		return id_Property;
	}
	public void setIdProperty(String id_Property){
		this.id_Property = id_Property;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getIva() {
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
}
