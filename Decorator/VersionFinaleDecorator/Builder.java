public class Builder{

    private Gateau gateau;
    private Ingredients ingredient;
    private DecoGarniture garniture;
    private DecoTopping topping;

    public Builder(String choix){
	this.gateau = new Gateau(choix);
    }

    public void Garniture(String element){
	ingredient = new Ingredients(element);
	garniture = new DecoGarniture(ingredient,gateau);
    }

    public void Topping(String element){
	ingredient = new Ingredients(element);
	topping = new DecoTopping(garniture,ingredient);
    }

    public Gateau donnerGateau(){
	return gateau;
    }

}
