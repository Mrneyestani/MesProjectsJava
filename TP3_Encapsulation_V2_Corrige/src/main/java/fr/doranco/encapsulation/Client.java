package fr.doranco.encapsulation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Client {

	private String nom;
	private String prenom;
	private List<Compte> comptes;
	
	public Client(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		this.comptes = new ArrayList<Compte>();
	}
	
	public void afficherSoldes() {
		System.out.println(" => Client : " + nom + " " + prenom);
		int num = 1;
		// boucle classique utilisant les objets
		for (Compte compte : comptes) {
			System.out.println("      -> Compte " + num++ + " : " + compte.getSolde());
		}
		
		// boucle utilisant l'index
//		for (int i = 0; i < comptes.size(); i++) {
//			System.out.println(" -> compte : " + num++ + " : " + comptes.get(i).getSolde());
//		}
		
		// boucle utilisant l'iterator
//		for (Iterator iterator = comptes.iterator(); iterator.hasNext();) {
//			Compte compte = (Compte) iterator.next();
//			System.out.println("      -> Compte " + num++ + " : " + compte.getSolde());
//		}
		
		// boucle utilisant les expressions Lambda
//		comptes.forEach(c -> System.out.println("      -> Compte " + num++ + " : " + compte.getSolde()));
		
		// boucle utilisant l'API stream
//		comptes.stream().forEach(c -> System.out.println("      -> Compte : " + c.getSolde()));
		
		//boucle utilisant l'API stream
		//permet de n'afficher que les comptes dont le solde est > 100
//		comptes.stream().filter(c -> c.getSolde() > 100).forEach(c -> System.out.println("      -> Compte : " + c.getSolde()));
	}
	
	public void bouclerComptes() {
		for (Compte compte : comptes) {
			compte.boucler();
		}
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

	public List<Compte> getComptes() {
		return comptes;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + "]";
	}

}
