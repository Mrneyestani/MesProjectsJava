package fr.doranco.jsf.vue.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.doranco.jsf.dao.IUserDao;
import fr.doranco.jsf.dao.UserDao;
import fr.doranco.jsf.entity.Adresse;
import fr.doranco.jsf.entity.User;
import fr.doranco.jsf.utils.Dates;

@ManagedBean(name = "userBean")

public class UserBean {
	
	private String nom;
	private String prenom;
	private Date dateNaissance;
	@ManagedProperty(name = "genre", value = "Homme")
	private String genre;
	private String email;
	private String password;
	private String confiramationPassword;
	private String niveauDeService;
	@ManagedProperty(value = "#{adresseBean}")
	private AdresseBean adresseBean;
	private String telephone ;
	private String fonctionActuelle ;
	private String nbAnneesExperience; 
	@ManagedProperty(name = "disponible", value = "oui")
	private String disponible;
	private static List<String> langagesSouhaites = new ArrayList<String>();
	private static List<User> userList = new ArrayList<User>();
	
	
	static {
		
		User user = new User("Leclerc","Benoit", Dates.convertStringToDate("27/10/1977"), 
				"homme", "benoit@doranco.fr", "test","medium","0623659831", "caissier", "2", "oui");
		
		Adresse adresse = new Adresse("12", "Rue de Paris", "Lyon", "69000");
		user.getAdresses().add(adresse);
		
		adresse = new Adresse("3", "Avenue Charles Degaule", "Paris", "75000");
		user.getAdresses().add(adresse);

		user.getLangagesSouhaites().add("Java");
		user.getLangagesSouhaites().add("PHP");
		
		userList.add(user);
		
		user = new User("Paul", "Andrieux", Dates.convertStringToDate("12/06/1965"), 
				"homme", "paulandrieux@doranco.fr", "test","medium", "0623659831",
				"caissier","5", "oui");
		userList.add(user);
		
		user = new User("Laura", "Treich", Dates.convertStringToDate("07/10/1987"), 
				"femme", "laura@doranco.fr", "test","medium", "0623659831",
				"caissier","8", "oui");
		userList.add(user);
		
		user = new User("Nathalie", "Tango", Dates.convertStringToDate("17/07/1980"), 
				"femme", "nathalie@doranco.fr","test","premium", "0623659831",
				"caissier","7", "oui");
		userList.add(user);
	}
	
	public UserBean() {
		
	}

	public String seConnecter() {


		System.out.println("email = " + email);
		System.out.println("password = " + password);

		return "";// return "page.xhtml";
	}
	
public void ajouterUser() {
		
		try {
			User user = new User(this.nom, this.prenom ,this.dateNaissance);
			final IUserDao myUserDao = new UserDao();
			myUserDao.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
 	}
	
	public void addUserz() {
		try {
			User user = new User(this.nom, this.prenom, this.dateNaissance, 
					this.genre,this.email, this.password, this.niveauDeService, this.telephone,
					this.fonctionActuelle,this.nbAnneesExperience, this.disponible);
			
			if (password.equals(confiramationPassword)) {
			langagesSouhaites.forEach(lang -> user.getLangagesSouhaites().add(lang));
			adresseBean.getAdresses().forEach(a -> user.getAdresses().add(a));
			
			userList.add(user);
			System.out.println(user);
			
			initialize();
			}else {
				System.out.println("La confirmation de password n'est pas correct!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void deleteUser(User user) {
		userList.remove(user);
	}
	
	private void initialize() {
		this.nom = "";
		this.prenom = "";
		this.dateNaissance = null;
		this.email = "";
		this.genre = "Homme";
		this.niveauDeService = "Basic";
		this.nbAnneesExperience = "";
				
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
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
	
	

	public String getConfiramationPassword() {
		return confiramationPassword;
	}
	
	

	public void setConfiramationPassword(String confiramationPassword) {
		this.confiramationPassword = confiramationPassword;
	}

	public String getNiveauDeService() {
		return niveauDeService;
	}

	public void setNiveauDeService(String niveauDeService) {
		this.niveauDeService = niveauDeService;
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

	
	public String getNbAnneesExperience() {
		return nbAnneesExperience;
	}

	public void setNbAnneesExperience(String nbAnneesExperience) {
		this.nbAnneesExperience = nbAnneesExperience;
	}

	public String getDisponible() {
		return disponible;
	}

	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}


	public List<String> getLangagesSouhaites() {
		return langagesSouhaites;
	}

	public void setLangagesSouhaites(List<String> langagesSouhaites) {
		UserBean.langagesSouhaites = langagesSouhaites;
	}

	public List<User> getUserList() {
		return userList;
	}

	public AdresseBean getAdresseBean() {
		return adresseBean;
	}

	public void setAdresseBean(AdresseBean adresseBean) {
		this.adresseBean = adresseBean;
	}

	@Override
	public String toString() {
		return "UserBean2 [nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", genre=" + genre
				+ ", email=" + email + ", password=" + password + ", niveauDeService=" + niveauDeService
				+ ", telephone=" + telephone + ", fonctionActuelle=" + fonctionActuelle + ", disponible=" + disponible
				+ "]";
	}


}

	