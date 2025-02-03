import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Produit peintAcryl_lilas = new Produit(1234, 10,  "750ml", "Peinture mate Lilas", 38.95, ECategorieProduit.PEINTURE);
        System.out.println(peintAcryl_lilas.toString() + "\n");
        Produit pinceauAcryl_biseaute = new Produit(2345, 20, "0.3g", "Pinceau biseauté Leonard", 3.25, ECategorieProduit.PINCEAUX);

        ArrayList<Produit> produits = new ArrayList<>();
        produits.add(peintAcryl_lilas);
        produits.add(pinceauAcryl_biseaute);

        CommandeDirector director = new CommandeDirector();
        Commande commande1 = director.construireCommande(produits);

        System.out.println(commande1.toString());


    }
}