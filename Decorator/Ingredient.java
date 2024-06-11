public class Ingredient extends GateauDecorator {
    public String nom;
    public float prix;

    public Ingredient (InterfaceGateau newGateau, String name) {
        super(newGateau);
        nom=name;
        prix=0;
    }

    public Ingredient (InterfaceGateau newGateau, String name, float price) {
        super(newGateau);
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
        return tempGateau.getDescription() + " " + nom;
    }

    public float getPrix() {
        return tempGateau.getPrix() + prix;
    }


}