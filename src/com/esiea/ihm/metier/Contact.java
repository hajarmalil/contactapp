package com.esiea.ihm.metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;














import com.esiea.ihm.dao.*;

public class Contact implements ObjetMetier, Serializable{
	
	private String nom;
	private String prenom;
	private String adresseMail;
	private String dateNaissance;
	private String motDePasse;
	private Boolean actif;
	private List<Address> adresses = new ArrayList<Address>();
	private ObjetDao dao = new AddressDaoImpl();

	public void setDao(ObjetDao dao) { // Injection de d�pendances entre les couches metier et dao
		this.dao = dao;
	}
	

	public Contact() {
		super();
	}

	public Contact(String nom, String prenom, String adresseMail, String dateNaissance, boolean actif, String motDePasse)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.adresseMail = adresseMail;
		this.dateNaissance = dateNaissance;
		this.actif = actif;
		this.adresses = dao.getAddress(this.adresseMail);
		this.motDePasse = motDePasse;
	}

	@Override
	public void addAdress(String rue, String ville, String codePostale, String numero, String type, String pays)
	{
		int adresseSize = 0;
		if(this.adresses.isEmpty())
		{
			adresseSize = 1;
		}
		else
		{
			adresseSize = this.adresses.size()+1;
		}
		Address a = new Address(numero,rue,codePostale,ville,this.adresseMail+adresseSize,type, pays);
		adresses.add(a);
		dao.addAddress(a);
	}
	
	@Override
	public boolean deleteAddress(Address a)
	{
		boolean delete;
		int i = 0;
		for(Address n : this.adresses)
		{
			if(n.getReference().equals(a.getReference()))
			{
				adresses.remove(a);
				dao.deleteAddress(a);
				i = i + 1;
				break;
			}
		}
		if (i == 0)
			delete = false;
		else
			delete = true;
		return delete;
	}
	
	@Override
	public void deleteAllAdresses()
	{
		dao.getMapAdresses().clear();
		this.adresses.clear();
	}
	
	@Override
	public void updateAdress(Address a, String numero, String rue, String codePostale, String ville, String pays)
	{
		if(!numero.isEmpty())
			a.setNumero(numero);
		if(!rue.isEmpty())
			a.setRue(rue);
		if(!codePostale.isEmpty())
			a.setCodePostale(codePostale);
		if(!ville.isEmpty())
			a.setVille(ville);
		if(!pays.isEmpty())
			a.setPays(pays);
	}
	
	@Override
	public List<Address> getAllAddresses() 
	{
		return this.adresses;
	}

	@Override
	public List<Address> getAddressByStreet(String rue) 
	{
		List<Address> m = new ArrayList<Address>();
		for(Address a : this.adresses)
		{
			if(a.getRue().equals(rue))
				m.add(a);
		}
		return m;
	}

	@Override
	public List<Address> getAddressByCity(String ville) 
	{
		List<Address> m = new ArrayList<Address>();
		for(Address a : this.adresses)
		{
			if(a.getRue().equals(ville))
				m.add(a);
		}
		return m;
	}

	@Override
	public List<Address> getAddressByPostCode(String codePostale) 
	{
		List<Address> m = new ArrayList<Address>();
		for(Address a : this.adresses)
		{
			if(a.getRue().equals(codePostale))
				m.add(a);
		}
		return m;
	}
	
	
	public String getNom()
	{
		return nom;
	}
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	public String getPrenom()
	{
		return prenom;
	}
	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}
	public String getAdresseMail()
	{
		return this.adresseMail;
	}
	
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public void setAdresseMail(String adresseMail)
	{
		this.adresseMail = adresseMail;
	}
	public String getDateNaissance()
	{
		return this.dateNaissance;
	}
	public void setDateNaissance(String dateNaissance)
	{
		this.dateNaissance = dateNaissance;
	}
	public Boolean getActif()
	{
		return actif;
	}
	public void setActif(Boolean actif) {
		this.actif = actif;
	}
	public List<Address> getAdresses()
	{
		return adresses;
	}
	public void setAdresses(List<Address> adresses)
	{
		this.adresses = adresses;
	}
	
	@Override
	public String toString() {
		return "Contact [nom=" + nom + ", prenom=" + prenom + ", adresseMail=" + adresseMail + ", dateNaissance="
				+ dateNaissance + ", actif=" + actif + "]";
	}

	@Override
	public void updateContact(String nom, String prenom, String adresseMail, String dateNaissance, String motDePasse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteContact(Contact contact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addUser(Contact contact) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Contact> getContacts() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Contact> getContact(Contact c) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Contact getContactByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Address> getAddress(Address adresse) {
		List<Address> add = new ArrayList<Address>();
		for(Address a :this.adresses)
		{
			if(!adresse.getPays().isEmpty())
			{
				if(a.getPays().equalsIgnoreCase(adresse.getPays()))
					add.add(a);
			}
			if(!adresse.getVille().isEmpty())
			{
				if(a.getVille().equalsIgnoreCase(adresse.getVille()))
					add.add(a);
			}
			if(!adresse.getCodePostale().isEmpty())
			{
				if(a.getCodePostale().equalsIgnoreCase(adresse.getCodePostale()))
					add.add(a);
			}
			if(!adresse.getRue().isEmpty())
			{
				if(a.getRue().equalsIgnoreCase(adresse.getRue()))
					add.add(a);
			}
			if(!adresse.getNumero().isEmpty())
			{
				if(a.getNumero().equalsIgnoreCase(adresse.getNumero()))
					add.add(a);
			}
			System.out.print(a.toString());
		}
		return add;
	}


	@Override
	public boolean CheckPassCorrect(String email, String pass) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Address getAddressByRef(String Ref) {
		Address add = new Address();
		for(Address a : this.adresses)
		{
			if(a.getReference().equals(Ref))
			{
				add = a;
				break;
			}
		}
		return add;
	}
	

}
