package fr.doranco.jsf.vue.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.doranco.jsf.entity.Adresse;
import fr.doranco.jsf.entity.User;
import fr.doranco.jsf.entity.User2;
import fr.doranco.jsf.model.dao.IUserDao;
import fr.doranco.jsf.model.dao.UserDao;
import fr.doranco.jsf.utils.Dates;

@ManagedBean(name = "userbean")
public class UserBean {

	@ManagedProperty(name = "nom", value = "DUPONT")
	private String nom;

	@ManagedProperty(name = "prenom", value = "Michel")
	private String prenom;

	@ManagedProperty(name = "dateDeNaissance", value = "07/02/2023")
	private String dateDeNaissance;

	@ManagedProperty(name = "genre", value = "homme")
	private String genre;

	@ManagedProperty(name = "email", value = "dupont.michel@doranco.fr")
	private String email;

	private String password;

	private String niveauDeService;

	@ManagedProperty(value = "#{adressebean}")
	private AdresseBean adresseBean;

	@ManagedProperty(name = "telephone", value = "0753567898")
	private String telephone;

	private String fonctionActuelle;

	@ManagedProperty(name = "disponible", value = "oui")
	private String disponible;

	//private String langagesSouhaite;
	
	private String[] langagesSouhaite;
	
	public String[] getLangagesSouhaite() {
		return langagesSouhaite;
	}

	public void setLangagesSouhaite(String[] langagesSouhaite) {
		this.langagesSouhaite = langagesSouhaite;
	}
	
	public String getSelectedValueString() {
        return Arrays.toString(langagesSouhaite);
      }

	public String checkSelectedValue() {
		return "success";
		}
	
	/*
	 * private String[] selectedValue;
 
	public String[] getSelectedValue() {
		return selectedValue;
	}
 
	public void setSelectedValue(String[] selectedValue) {
		this.selectedValue = selectedValue;
	}
 
	public String getSelectedValueString() {
          return Arrays.toString(selectedValue);
        }
 
	public String checkSelectedValue() {
		return "success";
	}
	 * */

	

	public UserBean() {
	}

	/*
	 * public User(String nom, String prenom, Date dateDeNaissance, String genre,
	 * String email, String password,String niveauDeService
	 */
	private static List<User> usersList = new ArrayList<User>(Arrays.asList(
			new User("Benoit", "Leclerc", Dates.convertStringToDate("27/10/1977"), "homme", "benoit@doranco.fr", "test",
					"medium", null, null, null, null),
			new User("Paul", "Andrieux", Dates.convertStringToDate("12/06/1965"), "homme", "paulandrieux@doranco.fr",
					"test", "medium", null, null, null, null),
			new User("Laura", "Treich", Dates.convertStringToDate("07/10/1987"), "femme", "laura@doranco.fr", "test",
					"medium", null, null, null, null),
			new User("Nathalie", "Tango", Dates.convertStringToDate("17/07/1980"), "femme", "nathalie@doranco.fr",
					"test", "premium", null, null, null, null)));

	public String seConnecter() {

		System.out.println("email = " + email);
		System.out.println("password = " + password);

		return ""; // return "page.xhtml";
	}
	
	public void ajouterUser() {
		
		try {
			User2 user = new User2(this.nom, this.prenom ,Dates.convertStringToDate(this.dateDeNaissance));
			final IUserDao myUserDao = new UserDao();
			myUserDao.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
 	}
	
	public void ajouterUserZ() {
		try {
			User user = new User(this.nom, this.prenom, Dates.convertStringToDate(this.dateDeNaissance), this.genre,
					this.email, this.password, this.niveauDeService, this.telephone, this.fonctionActuelle,
					this.disponible, this.getSelectedValueString());
			
			
			for (Adresse a : adresseBean.getAdresses()) {
				user.getAdresses().add(a);
				//System.out.println(" adresse -> " + a);
			}
		//	adresseBean.getAdresses().forEach(a -> user.getAdresses().add(a));
			System.out.println(user);
			usersList.add(user);
			//System.out.println(" adresse = user-> " +user.getAdresses());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteAction(User user) {
		usersList.remove(user);
	}

	public String getNom() {
		return nom;
	};

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNiveauDeService() {
		return niveauDeService;
	}

	public void setNiveauDeService(String niveauDeService) {
		this.niveauDeService = niveauDeService;
	}

	public List<User> getUsersList() {
		return usersList;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFonctionActuelle() {
		return fonctionActuelle;
	}

	public void setFonctionActuelle(String fonctionActuelle) {
		this.fonctionActuelle = fonctionActuelle;
	}

	public String getDisponible() {
		return disponible;
	}

	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}

	

	public AdresseBean getAdresseBean() {
		return adresseBean;
	}

	public void setAdresseBean(AdresseBean adresseBean) {
		this.adresseBean = adresseBean;
	}

}
