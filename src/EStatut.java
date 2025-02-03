public enum EStatut {
    ENREGISTREE("Enregistrée"), VALIDEE("Validée"), EXPEDIEE("Expediée"), LIVREE("Livrée"), ANNULEE("Annulée");

    private final String nomStatut;
    EStatut(String nomStatut) {
        this.nomStatut = nomStatut;
    }

    //Redéfinition pour gérer l'affichage
    @Override
    public String toString() {
        return nomStatut;
    }
}
