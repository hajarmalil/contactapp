package com.esiea.ihm.dao;

import java.util.*;

import org.apache.log4j.Logger;

import com.esiea.ihm.metier.*;

public class ContactDaoImpl implements ObjetDao {
	
	private Map<String, Contact> contacts = new HashMap<String, Contact>();
	Logger logger = Logger.getLogger(AddressDaoImpl.class);
	
	public Map<String, Contact> getContacts() {
		return contacts;
	}

	@Override
	public void addContact(Contact contact) 
	{
		contacts.put(contact.getAdresseMail(), contact);
	}

	@Override
	public List<Contact> getAllContacts() 
	{
		Collection<Contact> c = contacts.values();
		return new ArrayList<Contact>(c);
	}

	@Override
	public List<Contact> getContactsByLastName(String nom) 
	{
		List<Contact> c = new ArrayList<Contact>();
		for(Contact n : contacts.values())
			if(n.getNom().equals(nom))
				c.add(n);
		return c;
	}

	@Override
	public Contact getContact(String identifiant) 
	{
		return contacts.get(identifiant);
	}

	@Override
	public void DeleteContact(String identifiant) 
	{
		contacts.remove(identifiant);
	}

	@Override
	public void UpdateContact(Contact contact) 
	{
		contacts.put(contact.getAdresseMail(), contact);
	}

	@Override
	public List<Contact> getContactsByFirstName(String prenom) 
	{
		List<Contact> c = new ArrayList<Contact>();
		for(Contact n : contacts.values())
		{
			if(n.getPrenom().equals(prenom))
				c.add(n);
		}
		return c;
	}

	@Override
	public List<Contact> getContactsByAddress(Address adresse) 
	{
		List<Contact> n = new ArrayList<Contact>();
		for(Contact m : contacts.values())
		{
			for(Address a : m.getAdresses())
				if(adresse.equals(a))
					n.add(m);
		}
		return n;
	}

	@Override
	public Contact getContactByEMAIL(String email) 
	{
		Contact m = null;
		for(Contact c : contacts.values())
		{
			if(c.getAdresseMail().equals(email))
				m = c;
		}
		return m;
	}

	@Override
	public void addAddress(Address a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAddress(Address a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAddress(Address a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Address> getAddress(String partOfKey) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Address> getAllAddress()
	{
		return null;
	}
	
	@Override
	public void init() {
		logger.info("true Contact :::");
		Contact c1 = new Contact("Malil", "Hajar", "malil@et.esiea.fr", "14 - 01 - 1991", true, "testeur1");
		addContact(c1);
		c1.addAdress("Victore HUGO", "Paris", "9420", "21", "Domicile", "France");
		c1.addAdress("Clémenceau", "Courbevoie", "91200", "12", "travail", "France");
		Contact c2 = new Contact("Gonzalez", "Alban", "gonzalez@et.esiea.fr", "14 - 01 - 1991", true, "testeur1");
		addContact(c2);
		c2.addAdress("Marat", "Ivry-sur-seine", "94200", "81", "Domicile", "France");
		c2.addAdress("Maurice Thorez", "Ivry-sur-seine", "94200", "54", "Facturation", "France");
		Contact c3 = new Contact("Kodjo", "Anna", "kodjo@et.esiea.fr", "14 - 01 - 1991", true, "testeur1");
		addContact(c3);
		c3.addAdress("Robespierre", "Ivry-sur-seine", "94200", "86", "Travail", "France");
	}

	@Override
	public Address getAddressByRef(String Ref) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Address> getMapAdresses() {
		// TODO Auto-generated method stub
		return null;
	}

}
