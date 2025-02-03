public class FMoyenPaiement implements IFMoyenPaiement {
    public static IMoyenPaiement choisirMoyenPaiement(EMoyenPaiement moyenPaiement) {
        switch(moyenPaiement){
            case CB->{
                return new CB();
            }
            case PAYPAL->{
                return new PayPal();
            }
            case CRYPTOMONNAIE-> {
                return new Crypto();
            }
        }
        return null;
    }
}
