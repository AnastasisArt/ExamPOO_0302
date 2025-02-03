public class Client implements IObserver {
    private String statut;

    @Override
    public void majCommande(String statutCommande) {
        this.statut = statutCommande;
        System.out.println("Statut de la commande : " + statutCommande);
    }

    public String getStatutCommande() {
        return this.statut;
    }
}
