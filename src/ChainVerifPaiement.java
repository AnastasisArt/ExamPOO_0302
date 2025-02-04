public class ChainVerifPaiement implements IChaineValidation{
    private IChaineValidation suite = null;

    @Override
    public void setProchaineVerif(IChaineValidation suite) {
        this.suite = suite;
    }

    @Override
    public void traitement(Commande commande) {
        if (commande.getMoyenPaiement() == null) {
            System.out.println("La commande " + commande.getId() + " n'a pas de moyen de paiement attribuée.");
            return;
        }

        System.out.println("\n");
        commande.getMoyenPaiement().payer(commande.getPrixTotal());
        commande.setStatut(EStatut.VALIDEE);
        System.out.println("\n");
        if (suite != null) {
            suite.traitement(commande);
        }
    }

}
