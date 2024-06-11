public class Patissier {
    private RecetteBuilder recetteBuilder;

    public void setRecetteBuilder(RecetteBuilder rb) {
        recetteBuilder=rb;
    }

    public Gateau getGateau() {
        return recetteBuilder.getGateau();
    }

    public void constructGateau() {
        recetteBuilder.createNewGateauProduct();
        recetteBuilder.buildType();
        recetteBuilder.buildIngredients();
    }

} 