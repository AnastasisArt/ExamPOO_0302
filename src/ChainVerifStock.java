public class ChainVerifStock implements IChaineValidation {
    private IChaineValidation suite = null;

    @Override
    public void setProchaineVerif(IChaineValidation suite) {
        this.suite = suite;
    }

    @Override
    public void traitement(Commande commande){
        for(Produit produit : commande.getProduits()){
            if (produit.getStock() < 0){
                System.out.println(produit.getNom() + " n'est plus en stock.");
                return;
            }
        }
        if (suite != null){
            suite.traitement(commande);
        }
    }
}
