import java.util.ArrayList;

public class CommandeDirector {
    public Commande construireCommande(ArrayList<Produit> produits){
        return new Commande.CommandeBuilder("Commande enregistrée")
            .ajouterProduits(produits)
            .build();
    }
}
