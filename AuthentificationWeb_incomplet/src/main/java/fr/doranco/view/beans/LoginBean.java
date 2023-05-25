package fr.doranco.view.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "loginbean")
public class LoginBean {

	
	public String seConnecter() {
		
		return "";
	}
	
	public String retour() {
		
		return "accueil.xhtml";
	}
}
