import java.util.*;

class RecetteSpecifique extends RecetteBuilder {

    public String nom;
    public String type;
    public List<InterfaceGateau> ingredients;

    public RecetteSpecifique (String name, String type, List<InterfaceGateau> ingredients) {
        nom=name;
        this.type=type;
        this.ingredients=ingredients;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void buildType() {
        gateau.setType(type);
    }

    @Override
    public void buildIngredients() {
        gateau.setListeIngredients(ingredients);
    }
    
}