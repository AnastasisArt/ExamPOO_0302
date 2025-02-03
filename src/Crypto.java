public class Crypto implements IMoyenPaiement{
    @Override
    public void payer(double montant) {
        System.out.println("Le paiement de " + montant + " a bien été reglé en cryptomonnaies");
    }
}
