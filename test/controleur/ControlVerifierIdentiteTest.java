package controleur;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Chef abraracourcix;
	private ControlEmmenager controlEmmenager;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlEmmenager = new ControlEmmenager(village);
		
		
	}
	
	@Test
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertNotNull(controlVerifierIdentite,"Constructeur ne renvoie pas null");
	}
	
	@Test
	void testverifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlEmmenager.ajouterGaulois("Obelix", 5);
		assertTrue(controlVerifierIdentite.verifierIdentite("Abraracourcix"));
		assertTrue(controlVerifierIdentite.verifierIdentite("Obelix"));
		assertFalse(controlVerifierIdentite.verifierIdentite("Asterix"));
	}

}
