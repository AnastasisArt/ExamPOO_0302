public class ChainMaster {
    private IChaineValidation premiereChaineValidation;

    public ChainMaster() {
        this.premiereChaineValidation = new ChainVerifStock();
        IChaineValidation verifPaiement = new ChainVerifPaiement();
        IChaineValidation envoiCommande = new ChainEnvoiCommande();

        this.premiereChaineValidation.setProchaineVerif(verifPaiement);
        verifPaiement.setProchaineVerif(envoiCommande);
    }

    public void traiterCommande(Commande commande) {
        this.premiereChaineValidation.traitement(commande);
    }
}
