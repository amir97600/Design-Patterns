import java.util.*;

public class Patissier {
    private GateauComposite gateau=null;
    private List<String> listeIngredientsDispo=new ArrayList<String>();
    private List<String> listeIngredientsChoisis=new ArrayList<String>();
    private String[] elements={"base","garniture","topping"};

    
    public Patissier() {
    }

    public GateauComposite faireGateau(String[][] ingredients, float[][] prix) {
        gateau=new GateauComposite();
        gateau.add(new Ingredient(ingredients[0][0], prix[0][0])); // Ajout de la base du gâteau
        int rep=0;
        for (int i=1;i<ingredients.length;i++) {
            listeIngredientsDispo.clear();
            listeIngredientsChoisis.clear();
            for (int j=0;j<ingredients[i].length;j++) {
                listeIngredientsDispo.add(ingredients[i][j]);
            }
            while (listeIngredientsDispo.size()>0){
                System.out.println("Que voulez-vous ajouter comme "+elements[i]+" à votre gâteau: \""+gateau.getNom()+"\" ?");
                for (int k=0;k<listeIngredientsDispo.size();k++) {
                System.out.println(Integer.toString(k)+"\t"+listeIngredientsDispo.get(k));
                }
                rep=GestionBoulangerie.saisieEntier();
                if (rep>=0 && rep<listeIngredientsDispo.size()) {
                    listeIngredientsChoisis.add(listeIngredientsDispo.get(rep));
                    listeIngredientsDispo.remove(rep);
                    if (listeIngredientsDispo.size()>0 && i==2) {
                        System.out.println("Voulez-vous ajouter un autre ingrédient comme "+elements[i]+" ?");
                        System.out.println("0\tNon");
                        System.out.println("1\tOui");
                        while (true) {
                            rep=GestionBoulangerie.saisieEntier();
                            if (rep==0 || rep ==1) {
                                break;
                            }
                            else {
                                System.out.println("Choix non disponible, veuillez recommencer");
                            }
                        }
                        if (rep==0) {
                            break;
                        }
                    }
                    else {
                        break;
                    }
                }
                else {
                    System.out.println("Choix non disponible, veuillez recommencer");
                }
            }
            if (listeIngredientsChoisis.size()==1) {
                for (int l=0;l<ingredients[i].length;l++) {
                    if (listeIngredientsChoisis.contains(ingredients[i][l])) {
                        gateau.add(new Ingredient(ingredients[i][l],prix[i][l]));
                    }
                }
            }
            else {
                GateauComposite newComposite=new GateauComposite();
                for (int l=0;l<ingredients[i].length;l++) {
                    if (listeIngredientsChoisis.contains(ingredients[i][l])) {
                        newComposite.add(new Ingredient(ingredients[i][l],prix[i][l]));
                    }
                }
                gateau.add(newComposite);
            }
        }
        return gateau;
    } 
}