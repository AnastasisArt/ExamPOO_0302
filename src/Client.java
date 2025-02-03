public class Client implements IObserver {
    private EStatut statut;

    @Override
    public void majCommande(EStatut statut) {
        this.statut = statut;
        System.out.println("Statut de la commande : " + statut);
    }

    public EStatut getStatutCommande() {
        return this.statut;
    }
}
