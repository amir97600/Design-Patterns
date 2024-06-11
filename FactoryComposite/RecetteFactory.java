abstract class RecetteFactory {
    public static RecetteFactory getFactory(int num, Boulangerie maBoulangerie) {
        switch (num) {
            case 1:
            return new RecetteTypeFactory (maBoulangerie.getChoux());
            case 2:
            return new RecetteTypeFactory (maBoulangerie.getTarte());
            default:
            System.out.println("Choix non disponible, veuillez recommencer");
            return null;
        }
    }

    public abstract Recette createRecette();
}