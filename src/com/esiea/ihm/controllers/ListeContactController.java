package com.esiea.ihm.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.esiea.ihm.metier.Address;
import com.esiea.ihm.metier.Contact;
import com.esiea.ihm.metier.ContactSingleton;
import com.esiea.ihm.metier.ObjetMetier;

@Controller
public class ListeContactController {
	
	@Autowired
	private ObjetMetier metier = ContactSingleton.getInstance();

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("contact", new Contact());
		model.addAttribute("nb", metier.getContacts().size());
		return "home";
	}
	
	@RequestMapping(value="/contacts")
	public String contacts(Model model) {
		model.addAttribute("contact", new Contact());
		model.addAttribute("nb", metier.getContacts().size());
		model.addAttribute("liste", metier.getContacts());
		return "contacts";
	}
	
	@RequestMapping(value="/addc")
	public String addC(Model model) {
		model.addAttribute("contact", new Contact());
		model.addAttribute("nb", metier.getContacts().size());
		return "addContact";
	}
	
	@RequestMapping(value="/saveContact")
	public String saveC(Contact contact, @RequestParam("confirmP")String confirmP, Model model) {
		boolean present;
		model.addAttribute("contact", new Contact());
		if((contact.getMotDePasse().isEmpty()) || (contact.getMotDePasse().length() < 6))
			return "passC2";
		if((confirmP.isEmpty()) || (!confirmP.equals(contact.getMotDePasse())))
			return "passC";
		present = metier.addUser(contact);
		if (present == true)
		{
			model.addAttribute("nb", metier.getContacts().size());
			return "ContactExists";
		}
		else
		{
			model.addAttribute("nb", metier.getContacts().size());
			return "successC";
		}
	}
	
	@RequestMapping(value="/search")
	public String searchC(Model model) {
		model.addAttribute("contact", new Contact());
		model.addAttribute("nb", metier.getContacts().size());
		return "searchC";
	}
	
	@RequestMapping(value="/searchContact")
	public String searchContact(Contact contact, Model model) {
		model.addAttribute("contact", new Contact());
		model.addAttribute("liste", metier.getContact(contact));
		model.addAttribute("nbc", metier.getContact(contact).size());
		model.addAttribute("nb", metier.getContacts().size());
		return "resultC";
	}
	
	@RequestMapping(value="/access")
	public String access(String idc, Model model) {
		model.addAttribute("contact", new Contact());
		model.addAttribute("ct", metier.getContactByEmail(idc));
		model.addAttribute("nb", metier.getContacts().size());
		return "accessC";
	}
	
	@RequestMapping(value="/addresslist")
	public String addresslist(String adc, Model model) {
		model.addAttribute("contact", new Contact());
		model.addAttribute("ct", metier.getContactByEmail(adc));
		model.addAttribute("nb", metier.getContacts().size());
		return "liste";
	}
	
	@RequestMapping(value="/searchA")
	public String searchA(Model model) {
		model.addAttribute("adresse", new Address());
		model.addAttribute("nb", metier.getContacts().size());
		return "searchA";
	}
	
	@RequestMapping(value="/searchadd")
	public String searchadd(Address add, Model model) {
		model.addAttribute("adresse", new Address());
		model.addAttribute("list", metier.getAddress(add));
		model.addAttribute("nba", metier.getAddress(add).size());
		model.addAttribute("nb", metier.getContacts().size());
		return "resultA";
	}
	
	@RequestMapping(value="/signin")
	public String signin(Model model) {
		model.addAttribute("contact", new Contact());
		model.addAttribute("nb", metier.getContacts().size());
		return "signIn";
	}
	
	@RequestMapping(value="/login")
	public String login( @RequestParam("email")String email,  @RequestParam("pass")String pass, Model model, HttpSession session) {
		Boolean correct = metier.CheckPassCorrect(email, pass);
		model.addAttribute("nb", metier.getContacts().size());
		if(correct == true)
		{
			session.setAttribute("email", email);
			session.setAttribute("password", pass);
			return userPage(model, session);
		}
		else
		{
			return "passIn";
		}
	}
	
	@RequestMapping(value="/userPage")
	public String userPage(Model model, HttpSession session) {
		String email = (String) session.getAttribute("email");
		model.addAttribute("email", email);
		if(email == null)
		{
			return "signIn";
		}
		else
		{
			model.addAttribute("ct", metier.getContactByEmail(email));
			model.addAttribute("list", metier.getContactByEmail(email).getAllAddresses());
			if(metier.getContactByEmail(email).getAllAddresses() == null)
			{
				model.addAttribute("nbl", 0);
			}
			else
			{
				model.addAttribute("nbl", metier.getContactByEmail(email).getAllAddresses().size());
			}
			return "userPage";
		}
	}
	
	@RequestMapping(value="/contact")
	public String getProfil(Model model, HttpSession session) {
		String email = (String) session.getAttribute("email");
		model.addAttribute("email", email);
		if(email == null)
		{
			return "signIn";
		}
		else
		{
			model.addAttribute("contact", new Contact());
			model.addAttribute("ct", metier.getContactByEmail(email));
			if(metier.getContactByEmail(email).getAllAddresses() == null)
			{
				model.addAttribute("nbl", 0);
			}
			else
			{
				model.addAttribute("nbl", metier.getContactByEmail(email).getAllAddresses().size());
			}
			return "profil";
		}
	}
	
	@RequestMapping(value="/profilmod")
	public String profilmod(Model model, HttpSession session) {
		String email = (String) session.getAttribute("email");
		model.addAttribute("email", email);
		if(email == null)
		{
			return "signIn";
		}
		else
		{
			model.addAttribute("contact", new Contact());
			model.addAttribute("ct", metier.getContactByEmail(email));
			if(metier.getContactByEmail(email).getAllAddresses() == null)
			{
				model.addAttribute("nbl", 0);
			}
			else
			{
				model.addAttribute("nbl", metier.getContactByEmail(email).getAllAddresses().size());
			}
			return "profilmod";
		}
	}
	
	@RequestMapping(value="/updateContact")
	public String updateContact(Contact contact, @RequestParam("confirmP")String confirmP, HttpSession session, Model model) {
		String email = (String) session.getAttribute("email");
		model.addAttribute("email", email);
		if(email == null)
		{
			return "signIn";
		}
		else
		{
			model.addAttribute("contact", new Contact());
			model.addAttribute("ct", metier.getContactByEmail(email));
			if(metier.getContactByEmail(email).getAllAddresses() == null)
			{
				model.addAttribute("nbl", 0);
			}
			else
			{
				model.addAttribute("nbl", metier.getContactByEmail(email).getAllAddresses().size());
			}
			if((!contact.getMotDePasse().isEmpty()) && (contact.getMotDePasse().length() < 6))
			{
				return "passCc2";
			}
			else if(!confirmP.equals(contact.getMotDePasse()))
			{
				return "passCc";
			}
			else
			{
				metier.updateContact(contact.getNom(), contact.getPrenom(), email, contact.getDateNaissance(), contact.getMotDePasse());
				return "updateContact";
			}
		}
	}
	
	@RequestMapping(value="/listAdd")
	public String getlistAddress(HttpSession session, Model model) {
		String email = (String) session.getAttribute("email");
		model.addAttribute("email", email);
		if(email == null)
		{
			return "signIn";
		}
		else
		{
			model.addAttribute("ct", metier.getContactByEmail(email));
			model.addAttribute("list", metier.getContactByEmail(email).getAllAddresses());
			if(metier.getContactByEmail(email).getAllAddresses() == null)
			{
				model.addAttribute("nbl", 0);
			}
			else
			{
				model.addAttribute("nbl", metier.getContactByEmail(email).getAllAddresses().size());
			}
			return "listAdd";
		}
	}
	
	@RequestMapping(value="/updateAddress")
	public String updateAddress(HttpSession session, String ref, Model model) {
		String email = (String) session.getAttribute("email");
		model.addAttribute("email", email);
		if(email == null)
		{
			return "signIn";
		}
		else
		{
			model.addAttribute("adresse", new Address());
			model.addAttribute("ad", metier.getContactByEmail(email).getAddressByRef(ref));
			model.addAttribute("ct", metier.getContactByEmail(email));
			if(metier.getContactByEmail(email).getAllAddresses() == null)
			{
				model.addAttribute("nbl", 0);
			}
			else
			{
				model.addAttribute("nbl", metier.getContactByEmail(email).getAllAddresses().size());
			}
			return "updateAddress";
		}
	}
	
	@RequestMapping(value="/saveAddress")
	public String saveAddress(Address adresse, HttpSession session, String ref, Model model) {
		String email = (String) session.getAttribute("email");
		model.addAttribute("email", email);
		if(email == null)
		{
			return "signIn";
		}
		else
		{
			model.addAttribute("adresse", new Address());
			model.addAttribute("ad", metier.getContactByEmail(email).getAddressByRef(ref));
			model.addAttribute("ct", metier.getContactByEmail(email));
			if(metier.getContactByEmail(email).getAllAddresses() == null)
			{
				model.addAttribute("nbl", 0);
			}
			else
			{
				model.addAttribute("nbl", metier.getContactByEmail(email).getAllAddresses().size());
			}
			Address a = metier.getContactByEmail(email).getAddressByRef(ref);
			metier.getContactByEmail(email).updateAdress(a, adresse.getNumero(), adresse.getRue(), adresse.getCodePostale(), adresse.getVille(), adresse.getPays());
			return "successUpAdd";
		}
	}
	
	@RequestMapping(value="/deleteAddress")
	public String deleteAddress(HttpSession session, String ref, Model model) {
		String email = (String) session.getAttribute("email");
		model.addAttribute("email", email);
		if(email == null)
		{
			return "signIn";
		}
		else
		{
			model.addAttribute("adresse", new Address());
			model.addAttribute("ad", metier.getContactByEmail(email).getAddressByRef(ref));
			model.addAttribute("ct", metier.getContactByEmail(email));
			//Address ad = metier.getContactByEmail(email).getAddressByRef(ref);
			//metier.getContactByEmail(email).deleteAddress(ad);
			if(metier.getContactByEmail(email).getAllAddresses() == null)
			{
				model.addAttribute("nbl", 0);
			}
			else
			{
				model.addAttribute("nbl", metier.getContactByEmail(email).getAllAddresses().size());
			}
			return "confirmDelet";
		}
	}
	
	@RequestMapping(value="/confirmDelet")
	public String confirmDelet(HttpSession session, String ref, Model model) {
		String email = (String) session.getAttribute("email");
		model.addAttribute("email", email);
		if(email == null)
		{
			return "signIn";
		}
		else
		{
			model.addAttribute("adresse", new Address());
			model.addAttribute("ad", metier.getContactByEmail(email).getAddressByRef(ref));
			model.addAttribute("ct", metier.getContactByEmail(email));
			Address ad = metier.getContactByEmail(email).getAddressByRef(ref);
			metier.getContactByEmail(email).deleteAddress(ad);
			if(metier.getContactByEmail(email).getAllAddresses() == null)
			{
				model.addAttribute("nbl", 0);
			}
			else
			{
				model.addAttribute("nbl", metier.getContactByEmail(email).getAllAddresses().size());
			}
			return "listAdd";
		}
	}
	
	@RequestMapping(value="/addAddress")
	public String addAddress(HttpSession session, Model model) {
		String email = (String) session.getAttribute("email");
		model.addAttribute("email", email);
		model.addAttribute("adresse", new Address());
		if(email == null)
		{
			return "signIn";
		}
		else
		{
			model.addAttribute("ct", metier.getContactByEmail(email));
			if(metier.getContactByEmail(email).getAllAddresses() == null)
			{
				model.addAttribute("nbl", 0);
			}
			else
			{
				model.addAttribute("nbl", metier.getContactByEmail(email).getAllAddresses().size());
			}
			return "addAddress";
		}
	}
	
	@RequestMapping(value="/saveNewAddress")
	public String saveNewAddress(Address adresse, HttpSession session, Model model) {
		String email = (String) session.getAttribute("email");
		model.addAttribute("email", email);
		model.addAttribute("adresse", new Address());
		if(email == null)
		{
			return "signIn";
		}
		else
		{
			model.addAttribute("ct", metier.getContactByEmail(email));
			metier.getContactByEmail(email).addAdress(adresse.getRue(), adresse.getVille(), adresse.getCodePostale(), adresse.getNumero(), adresse.getType(), adresse.getPays());
			if(metier.getContactByEmail(email).getAllAddresses() == null)
			{
				model.addAttribute("nbl", 0);
			}
			else
			{
				model.addAttribute("nbl", metier.getContactByEmail(email).getAllAddresses().size());
			}
			return "listAdd";
		}
	}
	
	@RequestMapping(value="/searchAddress")
	public String searchAddress(HttpSession session, Model model) {
		model.addAttribute("adresse", new Address());
		String email = (String) session.getAttribute("email");
		model.addAttribute("email", email);
		if(email == null)
		{
			return "signIn";
		}
		else
		{
			if(metier.getContactByEmail(email).getAllAddresses() == null)
			{
				model.addAttribute("nbl", 0);
			}
			else
			{
				model.addAttribute("nbl", metier.getContactByEmail(email).getAllAddresses().size());
			}
			return "findAdd";
		}
	}
	
	@RequestMapping(value="/findAdd")
	public String findAdd(Address addresse, HttpSession session, Model model) {
		String email = (String) session.getAttribute("email");
		model.addAttribute("email", email);
		model.addAttribute("adresse", new Address());
		if(email == null)
		{
			return "signIn";
		}
		else
		{
			model.addAttribute("list", metier.getContactByEmail(email).getAddress(addresse));
			if(metier.getContactByEmail(email).getAddress(addresse) == null)
			{
				model.addAttribute("nba", 0);
			}
			else
			{
				model.addAttribute("nba", metier.getContactByEmail(email).getAddress(addresse).size());
			}
			if(metier.getContactByEmail(email).getAllAddresses() == null)
			{
				model.addAttribute("nbl", 0);
			}
			else
			{
				model.addAttribute("nbl", metier.getContactByEmail(email).getAllAddresses().size());
			}
			return "searchAddress";
		}
	}
	
	@RequestMapping(value="/ConfirmDeleteAccount")
	public String deleteProfil(HttpSession session, Model model){
		model.addAttribute("contact", new Contact());
		String email = (String) session.getAttribute("email");
		model.addAttribute("email", email);
		model.addAttribute("adresse", new Address());
		if(email == null)
		{
			return "signIn";
		}
		else
		{
			return "ConfirmDeleteAccount";
		}
	}
	
	@RequestMapping(value="/deleteAccount")
	public String deleteAccount(HttpSession session, Contact contact, Model model, @RequestParam("confirmP")String confirmP){
		model.addAttribute("contact", new Contact());
		String password = (String) session.getAttribute("password");
		String email = (String) session.getAttribute("email");
		model.addAttribute("email", email);
		model.addAttribute("adresse", new Address());
		if(email == null)
		{
			return "signIn";
		}
		else
		{
			if(password.equals(confirmP))
			{
				metier.getContactByEmail(email).deleteAllAdresses();
				metier.deleteContact(metier.getContactByEmail(email));
				session.invalidate();
				model.addAttribute("nb", metier.getContacts().size());
				return "signIn";
			}
			else
			{
				return "wrongPass";
			}
		}
		
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session, Model model){
		session.invalidate();
		return "signIn";
	}
	
}
