import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Commande implements ISubject {
    private List<IObserver> observers;
    private int id;
    private ArrayList<Produit> produits;
    private double prixTotal;
    private String statut;

    //Fonction de génération d'ID de commande
    public static int genererId(){
        SimpleDateFormat format = new SimpleDateFormat("ddMMyy");
        String date = format.format(new Date());

        int numRandom = (int) (Math.random() * 900) + 100;
        String randomString = String.valueOf(numRandom);
        String nId = date + randomString;

        int idGenere = Integer.parseInt(nId);
        return idGenere;
    }

    //METHODES POUR OBSERVER :
    public Commande(){
        observers = new ArrayList<>();
    }

    public void ajouterObserver(IObserver observer){
        observers.add(observer);
    }

    public void supprimerObserver(IObserver observer){
        observers.remove(observer);
    }

    public void notifierObserver(){
        for(IObserver observer : observers){
            observer.majCommande(statut);
        }
    }

    public void setStatut(String statut){
        this.statut = statut;
        notifierObserver();
    }

    //CONSTRUCTEUR BUILDER
    private Commande(CommandeBuilder builder){
        this.id = builder.id;
        this.produits = builder.produits;
        this.prixTotal = builder.prixTotal;
        this.statut = builder.statut;
    }

    //toString() redéfini
    @Override
    public String toString() {
        return "Commande ID : " + id + "\n" +
                "Produits : " + produits + "\n" +
                "Prix Total : " + prixTotal + "\n" +
                "Statut : " + statut;
    }

    //BUILDER
    public static class CommandeBuilder{
        private int id;
        private ArrayList<Produit> produits = new ArrayList<>();
        private double prixTotal = 0.0;
        private String statut;

        public CommandeBuilder(String statut){
            this.id= genererId();
            this.statut = statut;
        }

        public CommandeBuilder ajouterProduits(ArrayList<Produit> produits){
            this.produits = produits;
            return this;
        }

        public CommandeBuilder ajouterPrixTotal(double prixTotal){
            this.prixTotal = prixTotal;
            return this;
        }

        public Commande build(){
            System.out.println("Votre commande " + id + " contenant les produits suivants : " + produits + ", a bien été enregistrée.");
                    return new Commande(this);
        }
    }
}
