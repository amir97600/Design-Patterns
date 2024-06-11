import java.util.*;

public class Patisserie {

    private Patissier patissier;
    private ArrayList<Integer> nombreGateaux= new ArrayList<Integer>();
    private ArrayList<Integer> nombreIngredients= new ArrayList<Integer>();
    private ArrayList<Gateau> stockGateau = new ArrayList<Gateau>();
    private ArrayList<Ingredients> stockIngredients = new ArrayList<Ingredients>();

    public Patisserie(){
	this.patissier = new Patissier("Paul");
    }

    public void addGateau(Gateau gateau,Integer quantite){
	this.stockGateau.add(gateau);
	this.nombreGateaux.add(quantite);
    }

    public void addIngredients(Ingredients ingredients,Integer quantite){
	this.stockIngredients.add(ingredients);
	this.nombreIngredients.add(quantite);
    }

}
