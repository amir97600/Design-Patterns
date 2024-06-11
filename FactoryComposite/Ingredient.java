public class Ingredient implements InterfaceGateau {
    public String nom;
    public float prix;

    public Ingredient (String name) {
        nom=name;
        prix=0;
    }

    public Ingredient (String name, float price) {
        nom=name;
        prix=price;
    }

    public void setPrix(float price) {
        prix=price;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return nom;
    }

    public float getPrix() {
        return prix;
    }


}