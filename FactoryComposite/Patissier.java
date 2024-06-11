public class Patissier {
    
    public Gateau createGateau (Recette recette) {
        Gateau gateau=new Gateau(recette.getType());
        for (int i=0;i<recette.getNombreIngredients();i++) {
            gateau.add(recette.getIngredient(i));
        }
        return gateau;
    }
} 