public class ChainEnvoiCommande implements IChaineValidation {
    private IChaineValidation suite = null;

    @Override
    public void setProchaineVerif(IChaineValidation suite) {
        this.suite = suite;
    }

    @Override
    public void traitement(Commande commande) {
        System.out.println("La commande " + commande.getId() + " va être expediée.");
        commande.setStatut(EStatut.EXPEDIEE);

        STransactionLogger.getInstance().log("La commande " + commande.getId() + " a été expédiée.");

        if (suite != null){
            suite.traitement(commande);
        }
    }
}
