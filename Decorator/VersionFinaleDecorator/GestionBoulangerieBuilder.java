import java.io.*;
import java.util.*;

public class GestionBoulangerieBuilder {
    

    public static void main (String[] args){
        int rep = 0;
        String recette;
        Patissier patissier= new Patissier("Paul");
	Gateau gateau;
	ArrayList<String> Recette = new ArrayList<String>();
        while(true) {
            afficheMenu();
	    while(rep == 0){
            recette=saisieChaine();
	    Recette.add(recette);
	    System.out.println("\n 0\tAjouter un élement\n");
	    System.out.println("\n 1\tArreter \n");
	    rep = saisieEntier();
	    }

	    patissier.faireGateau(Recette);
	    gateau = patissier.donnerGateau();
	    System.out.println("\n"+gateau.getNom());
	    break;
	    
	}
    }
        
     

    public static void afficheMenu() {
        System.out.println("###############################");
        System.out.println("\n Entrez une recette : \n");
    }
    
    public static String saisieChaine(){
        try {
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            String chaine= buff.readLine();
            return chaine;
        }
        catch (IOException e) {
            System.out.println("Erreur lors de la saisie"+e);
            return null;
        }
    }

    public static int saisieEntier() {
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
