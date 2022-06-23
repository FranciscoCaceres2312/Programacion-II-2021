package model;

public class Property {
	public int code;
	public String direction;
	public int postcard;
	public float value;
	
	public Property(int code, String direction, int postcard, float value) {
		super();
		this.code = code;
		this.direction = direction;
		this.postcard = postcard;
		this.value = value;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getPostcard() {
		return postcard;
	}

	public void setPostcard(int postcard) {
		this.postcard = postcard;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public void creat() {
		
	}
	public void modify() {
		
	}
	public void remove() {
		
	}

}
