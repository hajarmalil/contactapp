package com.esiea.ihm.dao;

import java.util.List;
import java.util.Map;

import com.esiea.ihm.metier.*;

public interface ObjetDao {

	public void addAddress(Address a);
	public void deleteAddress(Address a);
	public void updateAddress(Address a);
	public List<Address> getAddress(String partOfKey);
	public void addContact(Contact contact);
	public List<Contact> getAllContacts();
	public List<Contact> getContactsByLastName(String nom);
	public List<Contact> getContactsByFirstName(String prenom);
	public List<Contact> getContactsByAddress(Address Adress);
	public Contact getContactByEMAIL(String email);
	public Contact getContact(String identifiant);
	public void DeleteContact(String identifiant);
	public void UpdateContact(Contact contact);
	public void init();
	public Map<String, Contact> getContacts();
	public List<Address> getAllAddress();
	public Address getAddressByRef(String Ref);
	public Map<String, Address> getMapAdresses();
	
}
