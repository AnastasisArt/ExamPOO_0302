public class Client implements IObserver {
    private Commande commande;
    private IMoyenPaiement moyenPaiement;

    @Override
    public void majCommande(EStatut statut, int id) {
        System.out.println("Statut de la commande " + id + " : " + Utils.statutToString(statut));
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setMoyenPaiement(IMoyenPaiement moyenPaiement) {
        this.moyenPaiement = moyenPaiement;
    }

    public void payerCommande() {
        if (commande.getStatut().equals(EStatut.ENREGISTREE)) {
            moyenPaiement.payer(commande.getPrixTotal());
            commande.setStatut(EStatut.VALIDEE);
        } else {
            System.out.println("La commande a déjà été reglée.");
        }
    }
};
