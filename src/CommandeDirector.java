public class CommandeDirector {
    public Commande construireCommande(){
        //---------------A FAIRE : Création d'un math random pour l'ID
        return new Commande.CommandeBuilder(1234, "Commande enregistrée").build();
    }
}
