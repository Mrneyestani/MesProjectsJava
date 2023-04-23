package fr.doranco.poo.heritage.metier;

public class Secretaire extends Personnel {
	
    public Secretaire(String nom, int annee, String labo, int salaire) {
        super(nom, annee, labo, salaire);
    }

    public void afficher() {
        System.out.println("Secretaire:");
        super.afficher();
    }
}