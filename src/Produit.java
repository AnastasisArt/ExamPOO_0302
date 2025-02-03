public class Produit {
    private int id;
    private int stock;
    private String poids;
    private String nom;
    private double prix;
    private ECategorieProduit categorie;

    public Produit(int id, int stock, String poids, String nom, double prix, ECategorieProduit categorie) {
        this.id = id;
        this.stock = stock;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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

    public void setPrix(double prix) {
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
        return "\n" + nom + "\n" +
                "Poids : " + poids + "\n" +
                "Prix : " + prix + "\n";
    }
}
