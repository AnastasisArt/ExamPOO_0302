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

        if (suite != null){
            suite.traitement(commande);
        }
    }
}
