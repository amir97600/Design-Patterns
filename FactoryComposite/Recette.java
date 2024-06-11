import java.util.*;

class Recette {

    public String nom;
    public String type;
    public List<InterfaceGateau> ingredients;

    public Recette (String name, String type, List<InterfaceGateau> ingredients) {
        nom=name;
        this.type=type;
        this.ingredients=ingredients;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public int getNombreIngredients () {
        return ingredients.size();
    }

    public InterfaceGateau getIngredient(int indice) {
        return ingredients.get(indice);
    }
    
}