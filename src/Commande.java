import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Commande implements ISubject {
    private List<IObserver> observers;
    private int id;
    private ArrayList<Produit> produits;
    private double prixTotal;
    private EStatut statut;
    private IMoyenPaiement moyenPaiement;

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

    public Commande(){
        observers = new ArrayList<>();
        produits = new ArrayList<>();
        prixTotal = 0.0;
        statut = EStatut.ENREGISTREE;
    }

    public double getPrixTotal(){
        return prixTotal;
    }

    public EStatut getStatut(){
        return statut;
    }

    //METHODES POUR OBSERVER :
    public void ajouterObserver(IObserver observer){
        observers.add(observer);
    }

    public void supprimerObserver(IObserver observer){
        observers.remove(observer);
    }

    public void notifierObserver(){
        for(IObserver observer : observers){
            observer.majCommande(statut, id);
        }
    }

    public void setStatut(EStatut statut){
        this.statut = statut;
        notifierObserver();
    }

    //CONSTRUCTEUR BUILDER
    private Commande(CommandeBuilder builder){
        this.observers = builder.observers;
        this.id = builder.id;
        this.produits = builder.produits;
        this.prixTotal = builder.prixTotal;
        this.statut = builder.statut;
        this.moyenPaiement = builder.moyenPaiement;
    }

    //toString() redéfini
    @Override
    public String toString() {
        return "Commande ID : " + id + "\n" +
                "Produits : " + produits + "\n" +
                "Prix Total : " + prixTotal + "\n" +
                "Statut : " + Utils.statutToString(statut) + "\n" +
                "Moyen de paiement : " + moyenPaiement;
    }

    //BUILDER
    public static class CommandeBuilder{
        private List<IObserver> observers = new ArrayList<>();
        private int id;
        private ArrayList<Produit> produits = new ArrayList<>();
        private double prixTotal = 0.0;
        private EStatut statut;
        private Client client;
        private IMoyenPaiement moyenPaiement;

        public CommandeBuilder(EStatut statut){
            this.id= genererId();
            this.statut = statut;
        }

        //Ajout produit avec vérif stock + appel à la fonction ajouterPrixTotal pour calculer le prix
        public CommandeBuilder ajouterProduits(ArrayList<Produit> produits){
            for(Produit produit : produits){
                if(produit.getStock() > 0){
                    this.produits.add(produit);
                    produit.setStock(produit.getStock() - 1);
                }else{
                    System.out.println("Stock insuffisant de " + produit.getNom());
                }
            }
            ajouterPrixTotal();
            return this;
        }

        public CommandeBuilder ajouterPrixTotal(){
            this.prixTotal = 0.0;
            for(Produit produit : produits){
                this.prixTotal += produit.getPrix();
            }
            return this;
        }

        public CommandeBuilder ajouterClient(Client client){
            this.client = client;
            return this;
        }

        public CommandeBuilder ajouterMoyenPaiement(EMoyenPaiement moyenPaiement){
            this.moyenPaiement = FMoyenPaiement.choisirMoyenPaiement(moyenPaiement);
            return this;
        }

        public Commande build(IObserver observer){
            this.observers.add(observer);
            if(this.client != null){
                this.client.setCommande(new Commande(this));
            }

            StringBuilder listeProduit = new StringBuilder();
            for(Produit produit : produits){
                listeProduit.append(produit.getNom()).append(", ");
            }
            System.out.println("Votre commande " + id + " contenant les produits suivants : " + listeProduit.toString() + "a bien été enregistrée.");
            return new Commande(this);
        }
    }
}
