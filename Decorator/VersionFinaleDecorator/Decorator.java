abstract class Decorator{

    protected Gateau gateau;
    
    public Decorator(Ingredients ingredient,Gateau gateau){
	this.gateau = gateau;
	gateau.setNom(gateau.getNom()+ingredient.getNom());
	

    }

    public Decorator(Decorator decorateur,Ingredients ingredient){
	String ajout = decorateur.getComposition();
	this.gateau = decorateur.getGateau();
	this.gateau.setNom(ajout);
	gateau.setNom(gateau.getNom()+ingredient.getNom());

    }

    public String getComposition(){
        return this.gateau.getNom();
    }

    public Gateau getGateau(){
	return this.gateau;
    }

}
