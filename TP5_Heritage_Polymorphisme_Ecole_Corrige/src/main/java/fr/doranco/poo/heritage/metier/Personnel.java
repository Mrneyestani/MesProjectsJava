package fr.doranco.poo.heritage.metier;

public class Personnel extends EPFLien {
	
    private String labo;
    private int salaire;

    public Personnel(String nom, int annee, String labo, int salaire) {
        super(nom, annee);
        this.labo = labo;
        this.salaire = salaire;
    }

    public void afficher() {
        super.afficher();
        System.out.println("   Laboratoire : " + getLabo());
        System.out.println("   Salaire : " + getSalaire());
    }

    public String getLabo() {
        return labo;
    }

    public int getSalaire() {
        return salaire;
    }
}