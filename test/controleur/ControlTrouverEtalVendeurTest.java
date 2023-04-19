package controleur;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private Village village;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		
		
		
	}
	
	@Test
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur,"Constructeur ne renvoie pas null");
	}

	@Test
	void testTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		Gaulois asterix = new Gaulois("Asterix",3);
		village.installerVendeur(asterix, "fleur", 2);
		assertEquals(controlTrouverEtalVendeur.trouverEtalVendeur("Asterix").getVendeur(),"Asterix");
		assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur("Asterix"),"TrouverEtalVendeur ne revoie pas null");
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine"));

	}
}
