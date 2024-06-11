public class Ingredients {  
   private String nom;
   private float prix;
    
    public Ingredients(String name) {
        nom=name;
        prix=0;
    }

    public Ingredients(String name, float price) {
        nom=name;
        prix=price;
    }

    public String getNom() {
        return nom;
    }

    public void setPrix(float price) {
        prix=price;
    }
    
    public float getPrix() {
        return prix;
    }

}
