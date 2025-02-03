public class Produit {
    private int id;
    private int quantite;
    private String poids;
    private String nom;
    private Double prix;
    private ECategorieProduit categorie;

    public Produit(int id, int quantite, String poids, String nom, Double prix, ECategorieProduit categorie) {
        this.id = id;
        this.quantite = 0;
        this.poids = poids;
        this.nom = nom;
        this.prix = prix;
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public ECategorieProduit getCategorie() {
        return categorie;
    }

    public void setCategorie(ECategorieProduit categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Produit : " + nom + "\n" +
                "Quantite : " + poids + "\n" +
                "Prix : " + prix;
    }
}
