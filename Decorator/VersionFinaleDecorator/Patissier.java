import java.util.*;

public class Patissier{

    private String nom;
    private Builder builder;
    
    public Patissier(String nom){

	this.nom = nom;
    }

    public void faireGateau(ArrayList<String> Recette)
    {
	int i = 0;
	
	for (String recette : Recette){  
	    if (i == 0){
		System.out.println("\n ############ Base ##########\n");
		    this.builder = new Builder(recette);
		}
	    
	    else if (i == 1){
		System.out.println("\n ############ Garniture ##########\n");
	this.builder.Garniture(recette);
		}
	    else{
		System.out.println(String.format("\n ############ Topping %d ##########\n",i-1));
	this.builder.Topping(recette);
	    }

	    i++;

	}
	
    }

    public Gateau donnerGateau(){
	return builder.donnerGateau();
    }
    
}
