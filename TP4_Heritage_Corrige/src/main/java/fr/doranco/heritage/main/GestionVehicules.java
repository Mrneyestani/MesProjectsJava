package fr.doranco.heritage.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import fr.doranco.heritage.enums.MarqueAvionEnum;
import fr.doranco.heritage.enums.MarqueVoitureEnum;
import fr.doranco.heritage.enums.TypeMoteurAvionEnum;
import fr.doranco.heritage.metier.Avion;
import fr.doranco.heritage.metier.Vehicule;
import fr.doranco.heritage.metier.Voiture;

public class GestionVehicules {

	public static void main(String[] args) {

		try {
			List<Vehicule> vehicules = new ArrayList<Vehicule>();

			Voiture v1 = new Voiture(MarqueVoitureEnum.FIAT.getValue(), 2005, 5000.0f, 2.5f, (byte) 5, 120, 120000);

			Voiture v2 = new Voiture(MarqueVoitureEnum.PORSCHE.getValue(), 1999, 81300, 6.5f, (byte) 2, 280, 250000);

			Avion a1 = new Avion(MarqueAvionEnum.CESSNA.getValue(), 1982, 1230673.90f, 250,
					TypeMoteurAvionEnum.HELICES.getValue());

			Avion a2 = new Avion(MarqueAvionEnum.NAIN_CONNU.getValue(), 1993, 4321098.00f, 1300,
					TypeMoteurAvionEnum.REACTION.getValue());

			vehicules.add(v1);
			vehicules.add(v2);
			vehicules.add(a1);
			vehicules.add(a2);

			Calendar calendar = Calendar.getInstance();
			int annee = calendar.get(Calendar.YEAR);
			for (Vehicule v : vehicules) {
				v.calculerPrix(annee);
				v.afficher();
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
