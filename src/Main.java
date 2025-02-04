import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Produit peintAcryl_lilas = new Produit(1234, 10,  "750ml", "Peinture mate Lilas", 38.95, ECategorieProduit.PEINTURE);
        Produit peintAcryl_rose = new Produit(1235, 10,  "750ml", "Peinture mate Rose bonbon", 38.95, ECategorieProduit.PEINTURE);
        Produit pinceauAcryl_biseaute = new Produit(2345, 20, "0.3g", "Pinceau biseauté Leonard", 3.25, ECategorieProduit.PINCEAUX);

        ArrayList<Produit> produitsCmd1 = new ArrayList<>(List.of(peintAcryl_lilas, pinceauAcryl_biseaute));
        ArrayList<Produit> produitsCmd2 = new ArrayList<>(List.of(peintAcryl_rose, peintAcryl_lilas));

        CommandeDirector director = new CommandeDirector();
        IObserver client1 = new Client();
        IObserver client2 = new Client();
        Commande commande1 = director.construireCommande(produitsCmd1, client1, EMoyenPaiement.CB);
        Commande commande2 = director.construireCommande(produitsCmd2, client2, EMoyenPaiement.CRYPTOMONNAIE);
        System.out.println(commande1);

        ChainMaster chaineValid = new ChainMaster();
        TransactionLogger logger = STransactionLogger.getInstance();
        chaineValid.traiterCommande(commande1);
        chaineValid.traiterCommande(commande2);
        logger.getHistorique();

    }
}