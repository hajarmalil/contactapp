package com.esiea.ihm.dao;

import java.util.*;

import org.apache.log4j.Logger;

import com.esiea.ihm.metier.*;

public class AddressDaoImpl implements ObjetDao {

	private Map<String, Address> adresses = new HashMap<String, Address>();
	Logger logger = Logger.getLogger(AddressDaoImpl.class);
	
	@Override
	public void addAddress(Address a) {
		adresses.put(a.getReference(), a);
	}

	@Override
	public Map<String, Address> getMapAdresses() {
		return adresses;
	}
	
	@Override
	public void deleteAddress(Address a) {
		adresses.remove(a.getReference());
	}

	@Override
	public void updateAddress(Address a) {
		adresses.put(a.getReference(), a);
	}

	@Override
	public List<Address> getAddress(String partOfKey) {
		List<Address> ad = new ArrayList<Address>();
		for(Address a : adresses.values())
		{
			if(a.getReference().contains(partOfKey))
				ad.add(a);
		}
		return ad;
	}
	
	public Address getAddressByRef(String Ref)
	{
		Address ad = new Address();
		for(Address a : adresses.values())
		{
			if(a.getReference().equals(Ref))
				ad = a;
		}
		return ad;
	}
	
	@Override
	public List<Address> getAllAddress()
	{
		Collection<Address> c = adresses.values();
		return new ArrayList<Address>(c);
	}

	@Override
	public void addContact(Contact contact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> getContactsByLastName(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> getContactsByFirstName(String prenom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> getContactsByAddress(Address Adress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact getContactByEMAIL(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact getContact(String identifiant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void DeleteContact(String identifiant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UpdateContact(Contact contact) {
		// TODO Auto-generated method stub
		
	}
	
	public void init() {
		logger.info("true Address :::");
		for(Address a : this.getAllAddress())
		{
			System.out.println(a.toString());
		}
	}

	@Override
	public Map<String, Contact> getContacts() {
		// TODO Auto-generated method stub
		return null;
	}

}
