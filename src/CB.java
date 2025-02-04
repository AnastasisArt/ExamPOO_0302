public class CB implements IMoyenPaiement {
    @Override
    public void payer(double montant) {
        System.out.println("Le paiement de " + montant + " a bien été reglé par carte bancaire.");
    }

    @Override
    public String toString() {
        return "Carte Bancaire";
    }
}
