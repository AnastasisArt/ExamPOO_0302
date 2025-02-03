import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Commande {
    private int id;
    private ArrayList<Produit> produits;
    private Double prixTotal;
    private String statut;

    public static int genererId(){
        SimpleDateFormat format = new SimpleDateFormat("ddMMyy");
        String date = format.format(new Date());

        int numRandom = (int) (Math.random() * 900) + 100;
        String randomString = String.valueOf(numRandom);
        String nId = date + randomString;

        int idGenere = Integer.parseInt(nId);
        return idGenere;
    }

    private Commande(CommandeBuilder builder){
        this.id = builder.id;
        this.produits = builder.produits;
        this.prixTotal = builder.prixTotal;
        this.statut = builder.statut;
    }

    @Override
    public String toString() {
        return "Commande ID : " + id + "\n" +
                "Produits : " + produits + "\n" +
                "Prix Total : " + prixTotal + "\n" +
                "Statut : " + statut;
    }

    public static class CommandeBuilder{
        private int id;
        private ArrayList<Produit> produits = new ArrayList<>();
        private Double prixTotal = 0.0;
        private String statut;

        public CommandeBuilder(String statut){
            this.id= genererId();
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
