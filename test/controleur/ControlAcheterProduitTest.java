package controleur;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur();
		controlVerifierIdentite = new ControlVerifierIdentite();
		
	}
	
	@Test
	void testControlAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit();
	}

}
