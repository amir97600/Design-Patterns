public class Gateau {  
   private String nom;
   private float prix;
    
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

    public void setNom(String nom){
	this.nom=nom;
    }

    public void setPrix(float price) {
        prix=price;
    }
    
    public float getPrix() {
        return prix;
    }

}
