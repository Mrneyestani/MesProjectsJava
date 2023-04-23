package fr.doranco.exemple2;

public class Main2 {

	public static void main(String[] args) {

		Mere m1 = new Mere();
		m1.methode();
		
		Mere m2 = new Fille();
		m2.methode();
		
		Fille f = new Fille();
		f.methode();
		
	}

}
