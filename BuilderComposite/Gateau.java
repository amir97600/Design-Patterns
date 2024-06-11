import java.util.*;

public class Gateau implements InterfaceGateau {  
    private String type="";
    private float prix=0;
    private List<InterfaceGateau> ingredients = new ArrayList<InterfaceGateau>();
    private RecetteSpecifique recette=null;
    
    public void setType(String type) {
        this.type=type;
    }

    public void setListeIngredients(List<InterfaceGateau> ingredients) {
        this.ingredients=ingredients;
    }

    public void setRecette (RecetteSpecifique recette) {
        this.recette=recette;
    }

    public RecetteSpecifique getRecette() {
        return recette;
    }

    public String getType() {
        return type;
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

    @Override
    public String getDescription() {
        String nomComplet=type;
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