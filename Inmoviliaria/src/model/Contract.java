package model;

public class Contract {
	public int code;
	public int codeClient;
	public int codeProperty;
	public float value;
	public String date;
	
	public Contract(int code, int codeClient, int codeProperty, float value, String date) {
		super();
		this.code = code;
		this.codeClient = codeClient;
		this.codeProperty = codeProperty;
		this.value = value;
		this.date = date;
	}
	
	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public int getCodeClient() {
		return codeClient;
	}


	public void setCodeClient(int codeClient) {
		this.codeClient = codeClient;
	}


	public int getCodeProperty() {
		return codeProperty;
	}


	public void setCodeProperty(int codeProperty) {
		this.codeProperty = codeProperty;
	}


	public float getValue() {
		return value;
	}


	public void setValue(float value) {
		this.value = value;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public void creat() {
		
	}
	public void modify() {
		
	}
	public void remove() {
		
	}

}
