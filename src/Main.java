public class Main {
    public static void main(String[] args) {
        Produit peintAcryl_lilas = new Produit(1234, 20, "750ml", "Peinture mate Lilas", 38.95, ECategorieProduit.PEINTURE);
        System.out.println(peintAcryl_lilas.toString());

        CommandeDirector director = new CommandeDirector();
        Commande commande1 = director.construireCommande();
        System.out.println(commande1);


    }
}