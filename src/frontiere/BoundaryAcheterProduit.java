package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.habitantVillage(nomAcheteur)) {
			System.out.println("Je regrette vous ne pouvez acheter ou vendre au marche puisque vous n'êtes pas un habitant.");
		}else {
			System.out.println("Quel produit voulez-vous acheter ?");
			String produit = scan.nextLine();
			String[] vendeursProduit = controlAcheterProduit.vendeursProduit(produit);
			if (vendeursProduit.length == 0) {
				System.out.println("Aucun vendeur ne vend ce produit.");
			}else {
				System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + "?");
				for (int i = 0; i<vendeursProduit.length;i++) {
					System.out.println(i + " - " + vendeursProduit[i]);
				}
				int commercantChoisis = scan.nextInt();
				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + vendeursProduit[commercantChoisis]);
				System.out.println("Bonjour " + nomAcheteur);
				System.out.println("Combien de " + produit + "voulez-vous acheter ?");
				int valeurAcheter = scan.nextInt();
				controlAcheterProduit.acheterProduit(valeurAcheter, commercantChoisis, produit, nomAcheteur);
				
			}
		}
	}
}
