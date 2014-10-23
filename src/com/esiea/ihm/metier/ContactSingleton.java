package com.esiea.ihm.metier;

import java.util.ArrayList;
import java.util.List;

import com.esiea.ihm.dao.*;

public class ContactSingleton implements ObjetMetier{

	private static ContactSingleton instance = null;
	private List<Contact> plateforme = new ArrayList<Contact>();
	private ObjetDao dao = new ContactDaoImpl();
			
	public void setDao(ObjetDao dao) {
		this.dao = dao;
	}

	private ContactSingleton() {
		dao.init();
		this.plateforme = dao.getAllContacts();
	}
	
	public static ContactSingleton getInstance() {
		if(instance == null)
			instance = new ContactSingleton();
		return instance;
	}
	
	public Contact getContactByEmail(String email) {
		Contact contact = new Contact();
		for(Contact c : this.plateforme)
		{
			if(c.getAdresseMail().equalsIgnoreCase(email))
			{
				contact.setDateNaissance(c.getDateNaissance());
				contact.setNom(c.getNom());
				contact.setPrenom(c.getPrenom());
				contact.setAdresseMail(c.getAdresseMail());
				contact.setAdresses(c.getAdresses());
				contact.setActif(c.getActif());
			}
		}
		return contact;
	}
	
	public boolean addUser(Contact contact) {
		boolean present;
		int i = 0;
		for (int j = 0; j < this.plateforme.size() ; j++)
		{
			if (!this.plateforme.get(j).getAdresseMail().equals(contact.getAdresseMail()))
			{
				System.out.println(this.plateforme.get(j).getAdresseMail()); // To Test
				System.out.println(contact.getAdresseMail()); // To Test
				continue;
			}
			i++;
		}
		if(contact.getAdresseMail().isEmpty())
		{
			present = true;
		}
		else if (i >= 1)
		{
			present = true;
		}
		else
		{
			present = false;
			dao.addContact(contact);
			this.plateforme.add(contact);
		}
		
		return present;
	}
	
	public void deleteContact(Contact contact) {
		int i = 0;
		dao.DeleteContact(contact.getAdresseMail());
		for(int j = 0; j < this.plateforme.size(); j++)
		{
			i = j;
			if(this.plateforme.get(i).getAdresseMail().equals(contact.getAdresseMail()))
			{
				break;
			}
		}
		this.plateforme.remove(i);
	}
	
	public void updateContact(String nom, String prenom, String adresseMail, String dateNaissance, String motDePasse) {
		Contact ct = new Contact(nom, prenom, adresseMail, dateNaissance, true, motDePasse);
		dao.UpdateContact(ct);
		for(Contact c : this.plateforme)
		{
			if(c.getAdresseMail().equals(adresseMail))
			{
				System.out.println("Contact found");
				if(!nom.isEmpty())
					c.setNom(nom);
				if(!prenom.isEmpty())
					c.setPrenom(prenom);
				if(!dateNaissance.isEmpty())
					c.setDateNaissance(dateNaissance);
				if(!adresseMail.isEmpty())
					c.setAdresseMail(adresseMail);
				if(!motDePasse.isEmpty())
					c.setMotDePasse(motDePasse);
			}
		}
	}
	
	public List<Contact> getContact(Contact c) {
		List<Contact> list = new ArrayList<Contact>();
		for(Contact contact : plateforme)
		{
			if(!c.getNom().isEmpty())
			{
				if(c.getNom().equalsIgnoreCase(contact.getNom()))
					list.add(contact);
			}
			if(!c.getPrenom().isEmpty())
			{
				if(c.getPrenom().equalsIgnoreCase(contact.getPrenom()))
					list.add(contact);
			}
			if(!c.getAdresseMail().isEmpty())
			{
				if(c.getAdresseMail().equalsIgnoreCase(contact.getAdresseMail()))
					list.add(contact);
			}
			if(!c.getDateNaissance().isEmpty())
			{
				if(c.getDateNaissance().equalsIgnoreCase(contact.getDateNaissance()))
					list.add(contact);
			}
		}
		return list;
	}
	
	public List<Contact> getContacts() {
		return this.plateforme;
	}
	public void setContacts(List<Contact> contacts) {
		this.plateforme = contacts;
	}
	
	@Override
	public boolean deleteAddress(Address a) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void updateAdress(Address a, String numero, String rue, String codePostale, String ville, String pays) {
		// TODO Auto-generated method stub
	}
	@Override
	public List<Address> getAllAddresses() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Address> getAddressByStreet(String rue) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Address> getAddressByCity(String ville) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Address> getAddressByPostCode(String codePostale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAdress(String rue, String ville, String codePostale, String numero, String type, String pays) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Address> getAddress(Address adresse) {
		List<Address> add = new ArrayList<Address>();
		for(Contact c : plateforme)
		{
			for(Address a : c.getAllAddresses())
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
		}
		return add;
	}
	
	public boolean CheckPassCorrect(String email, String pass)
	{
		Boolean correct = false;
		for(Contact c : this.plateforme)
		{
			if(c.getAdresseMail().equals(email))
			{
				if((c.getMotDePasse().equals(pass)))
					correct = true;
			}
		}
		return correct;
	}

	@Override
	public Address getAddressByRef(String Ref) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllAdresses() {
		// TODO Auto-generated method stub
		
	}
	
}
