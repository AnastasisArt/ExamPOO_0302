public class PayPal implements IMoyenPaiement{
    @Override
    public void payer(double montant) {
        System.out.println("Le paiement de " + montant + " a bien été reglé par PayPal.");
    }

    @Override
    public String toString() {
        return "Paypal";
    }
}
