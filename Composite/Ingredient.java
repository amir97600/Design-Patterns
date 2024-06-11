public class Ingredient extends GateauComposant {
    public String nom;
    public float prix;

    public Ingredient(String name) {
        nom=name;
        prix=0;
    }

    public Ingredient(String name, float price) {
        nom=name;
        prix=price;
    }

    String getNom() {
        return nom;
    }

    float getPrix() {
        return prix;
    }
}