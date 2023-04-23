package fr.doranco.poo.heritage.metier;

public class EtudiantRegulier extends Etudiant {
	
    private double prope1;

    public EtudiantRegulier(String nom, int annee, String section, double prope1) {
        super(nom, annee, section);
        this.prope1 = prope1;
    }

    public void afficher() {
        System.out.println("Etudiant regulier:");
        super.afficher();
        System.out.println("   Prope I : " + getPrope1());
    }

    public double getPrope1() {
        return prope1;
    }
}
