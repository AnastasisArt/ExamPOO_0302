public class Produit {
    private int id;
    private String nom;
    private Double prix;
    private int quantite;
    private ECategorieProduit categorie;

    public Produit(int id, String nom, Double prix, int quantite) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.quantite = 0;
    }
}
