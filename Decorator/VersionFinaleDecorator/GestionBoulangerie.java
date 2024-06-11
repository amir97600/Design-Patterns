import java.io.*;

public class GestionBoulangerie {
    
    public static void main (String[] args){

	Gateau gateau = new Gateau("Choux");
	System.out.println("############ Base ############## \n"+ gateau.getNom());
	Ingredients cremeV = new Ingredients(" creme à la Vanille ");
	Ingredients chantilly = new Ingredients( " chantilly ");
	Ingredients amandes = new Ingredients(" amandes ");
	
	DecoGarniture garniture = new DecoGarniture(cremeV,gateau);
        System.out.println("############ Garniture ############## \n"+garniture.getComposition());

	DecoTopping topping1 = new DecoTopping(garniture,chantilly);
	System.out.println("############ 1er Topping ############## \n"+topping1.getComposition());

	DecoTopping topping2 = new DecoTopping(garniture,amandes);
	System.out.println("############ 2eme Topping ############## \n"+topping2.getComposition());
    }

}
