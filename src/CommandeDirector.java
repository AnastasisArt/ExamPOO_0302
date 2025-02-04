import java.util.ArrayList;

public class CommandeDirector {
    public Commande construireCommande(ArrayList<Produit> produits, IObserver observer, EMoyenPaiement moyenPaiement) {
        Client client = (Client) observer;
        return new Commande.CommandeBuilder(EStatut.ENREGISTREE)
                .ajouterProduits(produits)
                .ajouterClient(client)
                .ajouterMoyenPaiement(moyenPaiement)
                .build(observer);
    }
}
