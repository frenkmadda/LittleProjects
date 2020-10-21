package zoopark.model;

import java.io.Serializable;

public class Utente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	private String IDRuolo;
	private String nome;
	private String cognome;
	private boolean haveTicket;
	
	public Utente() {
		haveTicket=false;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	public boolean getHaveTicket() {
		return haveTicket;
	}
	public void setHaveTicket(boolean ticket){
		haveTicket=ticket;
	}


	public String getIDRuolo() {
		return IDRuolo;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setIDRuolo(String iDRuolo) {
		IDRuolo = iDRuolo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	
	
}

