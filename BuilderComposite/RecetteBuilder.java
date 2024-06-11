abstract class RecetteBuilder {
    protected Gateau gateau;

    public Gateau getGateau() {
        return gateau;
    }

    public void createNewGateauProduct() {
        gateau=new Gateau();
    }

    public abstract void buildType();
    public abstract void buildIngredients();
}