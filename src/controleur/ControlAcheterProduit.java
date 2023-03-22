package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean habitantVillage(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
	private Gaulois[] gauloisVendeurs(String produit) {
		Gaulois[] gaulois = village.rechercherVendeursProduit(produit);
		return gaulois;
	}
	
	public String[] vendeursProduit(String produit) {
		Gaulois[] gauloisVendeurs = gauloisVendeurs(produit);
		if (gauloisVendeurs == null) {
			return  new String[0];
		}
		String[] vendeurs = new String[gauloisVendeurs.length];
		for (int i = 0; i<gauloisVendeurs.length;i++) {
			vendeurs[i] = gauloisVendeurs[i].getNom();
		}
		return vendeurs;
	}
	
	public Etal etalVendeur(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
	}
	
	private Etal trouverVendeur(Gaulois gaulois) {
		return village.rechercherEtal(gaulois);
	}
	
	
	public int acheterProduit(int quantite,int commercantChoisis, String Produit, String Acheteur) {
		Gaulois[] vendeurs = gauloisVendeurs(Produit);
		Gaulois vendeurChoisis = vendeurs[commercantChoisis];
		Etal etal = trouverVendeur(vendeurChoisis);
		int quantiteEtal = etal.getQuantite();
		if (quantiteEtal == 0) {
			System.out.println(Acheteur + " veut acheter " + quantite + Produit + ", malheureusement il n'y en a plus !");
		}else if (quantiteEtal < quantite){
			System.out.println(Acheteur + " veut acheter " + quantite + Produit + ", malheureusement " + vendeurChoisis.getNom() + " n'en a plus que "
					+ quantiteEtal + ". " + Acheteur + " achète tout le stock de " + vendeurChoisis.getNom() + ".");
		}else {
			System.out.println(Acheteur + " achète " + quantite + Produit + " à " + vendeurChoisis.getNom() + ".");
		}
		return etal.acheterProduit(quantite);
	}
}
