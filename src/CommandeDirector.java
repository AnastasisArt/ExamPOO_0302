import java.util.ArrayList;

public class CommandeDirector {
    public Commande construireCommande(ArrayList<Produit> produits, IObserver observer) {
        return new Commande.CommandeBuilder(EStatut.ENREGISTREE)
            .ajouterProduits(produits)
            .build(observer);
    }
}
