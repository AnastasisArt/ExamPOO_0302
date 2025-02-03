import java.lang.reflect.Array;
import java.util.ArrayList;

public class Commande {
    private int id;
    private ArrayList<Produit> produits;
    private Double prixTotal;
    private String statut;

    private Commande(CommandeBuilder builder){
        this.id = builder.id;
        this.produits = builder.produits;
        this.prixTotal = builder.prixTotal;
        this.statut = builder.statut;
    }

    @Override
    public String toString() {
        return "Commande ID : " + id + "\"" +
                "Produits : " + produits + "\"" +
                "Prix Total : " + prixTotal + "\"" +
                "Statut : " + statut;
    }

    public static class CommandeBuilder{
        private int id;
        private ArrayList<Produit> produits = new ArrayList<>();
        private Double prixTotal = 0.0;
        private String statut;

        public CommandeBuilder(int id, String statut){
            this.id= id;
            this.statut = statut;
        }

        public CommandeBuilder ajouterProduits(ArrayList<Produit> produits){
            this.produits = produits;
            return this;
        }

        public CommandeBuilder ajouterPrixTotal(Double prixTotal){
            this.prixTotal = prixTotal;
            return this;
        }

        public Commande build(){
            System.out.println("Votre commande " + id + " contenant les produits suivants : " + produits + ", a bien été enregistrée.");
                    return new Commande(this);
        }
    }
}
