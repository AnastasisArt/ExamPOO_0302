public class Utils {
    public static String statutToString(EStatut statut) {
        return switch (statut) {
            case ENREGISTREE -> "Enregistrée";
            case VALIDEE -> "Validée";
            case EXPEDIEE -> "Expédiée";
            case LIVREE -> "Livrée";
            case ANNULEE -> "Annulée";
        };
    }
}
