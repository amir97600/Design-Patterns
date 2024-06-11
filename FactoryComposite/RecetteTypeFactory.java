import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class RecetteTypeFactory extends RecetteFactory {

    private String nom="";
    private String type="";
    private ArrayList<InterfaceGateau> ingredients=new ArrayList<InterfaceGateau>();
    private int rep=0;
    
    public RecetteTypeFactory(String[] ingredientsPossibles) {
        type=ingredientsPossibles[0];
        nom=type;
        for (int i=1;i<ingredientsPossibles.length;i++) {
            System.out.println("Voulez-vous votre gâteau "+ingredientsPossibles[i]+" ?");
            System.out.println("1.\tOui");
            System.out.println("2.\tNon");
            while (true) {
                rep=saisieEntier();
                if (rep==1) {
                    ingredients.add(new Ingredient(ingredientsPossibles[i]));
                    nom+=" "+ingredientsPossibles[i];
                    break;
                }
                if (rep==2) {
                    break;
                }
                else {
                    System.out.println("Choix non disponible, veuillez recommencer");
                }
            }
        }
    }

    @Override
    public Recette createRecette() {
        return new Recette(nom, type, ingredients);
    }

    public int saisieEntier() {
        try {
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            String chaine= buff.readLine();
            int entier=Integer.parseInt(chaine);
            return entier;
        }
        catch (IOException e) {
            System.out.println("Erreur lors de la saisie"+e);
            return -1;
        }
    }
}