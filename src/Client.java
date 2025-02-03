public class Client implements IObserver {
    private Commande commande;

    @Override
    public void majCommande(EStatut statut, int id) {
        System.out.println("Statut de la commande " + id + " : " + statut);
    }

    public Commande getCommande() {
        return commande;
    }
}
