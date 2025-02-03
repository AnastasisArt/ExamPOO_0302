import java.util.ArrayList;

public class CommandeDirector {
    public Commande construireCommande(){
        return new Commande.CommandeBuilder("Commande enregistrée")
                .ajouterProduits(new ArrayList<Produit>())
                .ajouterPrixTotal(0.0)
                .build();
    }
}
