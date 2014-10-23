package com.esiea.ihm.metier;

import java.util.List;

public interface ObjetMetier {

	public void addAdress(String rue, String ville, String codePostale, String numero, String type, String pays);
	public boolean deleteAddress(Address a);
	public void updateAdress(Address a, String numero, String rue, String codePostale, String ville, String pays);
	public List<Address> getAllAddresses();
	public List<Address> getAddressByStreet(String rue);
	public List<Address> getAddressByCity(String ville);
	public List<Address> getAddressByPostCode(String codePostale);
	public void updateContact(String nom, String prenom, String adresseMail, String dateNaissance, String motDePasse);
	public void deleteContact(Contact contact);
	public boolean addUser(Contact contact);
	public List<Contact> getContacts();
	public List<Contact> getContact(Contact c);
	public Contact getContactByEmail(String email);
	public List<Address> getAddress(Address adresse);
	public boolean CheckPassCorrect(String email, String pass);
	public Address getAddressByRef(String Ref);
	public void deleteAllAdresses();
	
}