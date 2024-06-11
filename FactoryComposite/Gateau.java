import java.util.*;

public class Gateau implements InterfaceGateau {  
    String nom;
    float prix;
    private List<InterfaceGateau> ingredients = new ArrayList<InterfaceGateau>();
    Recette recette=null;
    
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

    public void add(InterfaceGateau ingredient) {
        ingredients.add(ingredient);
    }

    public void remove(InterfaceGateau ingredient) {
        ingredients.remove(ingredient);
    }

    public void setRecette (Recette recette) {
        this.recette=recette;
    }

    public Recette getRecette() {
        return recette;
    }

    @Override
    public String getDescription() {
        String nomComplet=nom;
        for (InterfaceGateau I : ingredients) {
            nomComplet+=" "+I.getDescription();
        }
        return nomComplet;
    }

    @Override
    public float getPrix() {
        float prixTotal=prix;
        for (InterfaceGateau I : ingredients) {
            prixTotal+=I.getPrix();
        }
        return prixTotal;
    }

}