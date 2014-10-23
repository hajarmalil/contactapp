package com.esiea.ihm.metier;

import java.io.Serializable;

public class Address implements Serializable{

	private String numero;
	private String rue;
	private String codePostale;
	private String ville;
	private String reference;
	private String type;
	private String pays;
	
	
	public Address() {
		super();
	}

	public Address(String numero, String rue, String codePostale, String ville, String reference, String type, String pays) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostale = codePostale;
		this.ville = ville;
		this.reference = reference;
		this.type = type;
		this.pays = pays;
	}
	
	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostale() {
		return codePostale;
	}
	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}

	@Override
	public String toString() {
		return "Address [numero=" + numero + ", rue=" + rue + ", ville=" + ville + ", codePostale=" + codePostale + "]";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
