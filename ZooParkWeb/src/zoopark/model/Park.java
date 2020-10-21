package zoopark.model;

import java.io.Serializable;


public class Park implements Serializable {
	private static final long serialVersionUID = 1L;
	
	String name;
	int cod;
	String location;
	String opening;
	String closure;
	
	public Park() {
		name="";
		cod=-1;
		location="";
		opening="";
		closure="";
	}
	public Park(String pName, int pCode,String pLocation,String pOp,String pCl) {
		name=pName;
		cod=pCode;
		location=pLocation;
		opening=pOp;
		closure=pCl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOpening() {
		return opening;
	}

	public void setOpening(String opening) {
		this.opening = opening;
	}

	public String getClosure() {
		return closure;
	}

	public void setClosure(String closure) {
		this.closure = closure;
	}
	
	public boolean equals(Object other) {
		return (this.getCod() == ((Park)other).getCod());
	}
	
	public String toString() {
		return name + " (" + cod +") " + location + ","+ opening + "," + closure ;
	}
	

}
