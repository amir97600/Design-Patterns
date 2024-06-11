public class Gateau implements InterfaceGateau {  
    String nom;
    float prix;
    
    public Gateau(String name) {
        nom=name;
        prix=0;
    }

    public Gateau(String name, float price) {
        nom=name;
        prix=price;
    }

    public String getNom() {
        return nom;
    }

    public void setPrix(float price) {
        prix=price;
    }

    @Override
    public String getDescription() {
        return nom;
    }

    @Override
    public float getPrix() {
        return prix;
    }

}