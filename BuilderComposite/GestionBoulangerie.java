import java.util.*;
import java.io.*;

public class GestionBoulangerie {
    

    public static void main (String[] args){
        Boulangerie maBoulangerie=null;
        int rep;
        int nombre;
        String nom;
        String type;
        String adresse;
        Gateau gateau;
        List<InterfaceGateau> ingredients=new ArrayList<InterfaceGateau>();
        RecetteSpecifique recetteSpecifique=null;
        RecetteBuilder recetteBuilder;
        Boolean gateauOK;
        while(true) {
            afficheMenu();
            rep=saisieEntier();
            switch (rep) {
                case 1:
                if (maBoulangerie==null) {
                    System.out.println("Veuillez donner le nom de la boulangerie");
                    nom=saisieChaine();
                    System.out.println("Veuillez donner l'adresse de la boulangerie");
                    adresse=saisieChaine();
                    maBoulangerie=new Boulangerie (nom, adresse);
                }
                else {
                    System.out.println("Une boulangerie existe déjà");
                }
                break;
                case 2:
                if (maBoulangerie!=null) {
                    System.out.println("Comment voulez-vous créer votre gâteau?");
                    System.out.println("1\tA partir d'une recette");
                    System.out.println("2\tA partir d'un gâteau déjà disponible");
                    rep=saisieEntier();
                    System.out.println("Combien de gâteaux voulez-vous créer?");
                    nombre=saisieEntier();
                    gateauOK=false;
                    switch (rep) {
                        case 1:
                        if (maBoulangerie.getNombreRecettes()>=1) {
                            System.out.println("Quelle recette voulez-vous utiliser?");
                            maBoulangerie.afficheRecette();
                            while (true) {
                                rep=saisieEntier();
                                if (rep >=0 && rep<maBoulangerie.getNombreRecettes()) {
                                    recetteSpecifique=maBoulangerie.getRecette(rep);
                                    gateauOK=true;
                                    break;
                                }
                                else {
                                    System.out.println("Choix indisponible, veuillez recommencer");
                                }
                            }
                        }
                        else {
                            System.out.println("Il n'y a pas de recettes disponibles dans la boulangerie");
                        }
                        break;
                        case 2:
                        if (maBoulangerie.getNombreDifferentsGateaux()>=1) {
                            System.out.println("Quel gâteau voulez-vous recopier?");
                            maBoulangerie.afficheGateaux();
                            while (true){
                                rep=saisieEntier();
                                if (rep >=0 && rep<maBoulangerie.getNombreDifferentsGateaux()) {
                                        recetteSpecifique=maBoulangerie.getGateau(rep).getRecette();
                                        gateauOK=true;
                                        break;
                                }
                                else {
                                    System.out.println("Choix indisponible, veuillez recommencer");
                                }
                            }
                        }
                        break;
                        default:
                        System.out.println("Choix non disponible veuillez recommencer");
                    }
                    if (gateauOK==true) {
                        recetteBuilder=recetteSpecifique;
                        maBoulangerie.getPatissier().setRecetteBuilder(recetteBuilder);
                        maBoulangerie.getPatissier().constructGateau();
                        gateau=maBoulangerie.getPatissier().getGateau();
                        gateau.setRecette(recetteSpecifique);
                        maBoulangerie.ajouterGateau(gateau, nombre);
                    }
                    else {
                        System.out.println("Veuillez d'abord créer une recette et/ou un gâteau");
                    }
                }    
                else {
                    System.out.println("Veuillez d'abord créer une boulangerie");
                }
                break;
                case 3:
                if (maBoulangerie!=null) {
                    if (maBoulangerie.getNombreDifferentsGateaux()>0) {
                        System.out.println("Quel gâteau voulez-vous enlever?");
                        maBoulangerie.afficheGateaux();
                        while (true) {
                            rep=saisieEntier();
                            if (rep >=0 && rep < maBoulangerie.getNombreDifferentsGateaux()) {
                                maBoulangerie.enleverGateau(rep);
                                break;
                            }
                            else {
                                System.out.println("Choix non disponible, veuillez recommencer");
                            }
                        }
                    }
                    else {
                        System.out.println("Il n'y a pas de gâteaux disponibles dans la boulangerie");
                    }
                }
                else {
                    System.out.println("Veuillez d'abord créer une boulangerie");
                }
                break;
                case 4:
                if (maBoulangerie!=null) {
                    System.out.println("Voici les gâteaux disponibles dans la boulangerie:");
                    maBoulangerie.afficheGateaux();
                }
                else {
                    System.out.println("Veuillez d'abord créer une boulangerie");
                }
                break;
                case 5:
                if (maBoulangerie!=null) {
                    System.out.println("Quelle recette voulez-vous créer?");
                    System.out.println("1\tUne recette de choux");
                    System.out.println("2\tUne recette de tarte");
                    rep=saisieEntier();
                    switch (rep) {
                        case 1:
                        type=maBoulangerie.getChoux()[0];
                        nom=type;
                        ingredients.clear();
                        for (int i=1;i<maBoulangerie.getChoux().length;i++) {
                            System.out.println("Voulez vous des choux "+maBoulangerie.getChoux()[i]+" ?");
                            System.out.println("1\tOui");
                            System.out.println("2\tNon");
                            rep=saisieEntier();
                            if (rep==1) {
                                ingredients.add(new Ingredient(maBoulangerie.getChoux()[i]));
                                nom+=" "+maBoulangerie.getChoux()[i];
                            }
                        }
                        recetteSpecifique = new RecetteSpecifique(nom, type, ingredients);
                        maBoulangerie.ajouterRecette(recetteSpecifique);
                        break;
                        case 2:
                        type=maBoulangerie.getTarte()[0];
                        nom=type;
                        ingredients.clear();
                        for (int i=1;i<maBoulangerie.getTarte().length;i++) {
                            System.out.println("Voulez vous une tarte "+maBoulangerie.getTarte()[i]+" ?");
                            System.out.println("1\tOui");
                            System.out.println("2\tNon");
                            rep=saisieEntier();
                            if (rep==1) {
                                ingredients.add(new Ingredient(maBoulangerie.getTarte()[i]));
                                nom+=" "+maBoulangerie.getTarte()[i];
                            }
                        }
                        recetteSpecifique = new RecetteSpecifique(nom, type, ingredients);
                        maBoulangerie.ajouterRecette(recetteSpecifique);
                        break;
                        default:
                        System.out.println("Choix non disponible, veuillez recommencer");
                    }    
                }
                else {
                    System.out.println("Veuillez d'abord créer une boulangerie");
                }
                break;
                case 6:
                if (maBoulangerie!=null) {
                    if (maBoulangerie.getNombreRecettes()>=1) {
                        System.out.println("Quelle recette voulez-vous enlever?");
                        maBoulangerie.afficheRecette();
                        while(true) {
                            rep=saisieEntier();
                            if (rep >=0 && rep <maBoulangerie.getNombreRecettes()) {
                                maBoulangerie.enleverRecette(rep);
                                break;
                            }
                            else {
                                System.out.println("Choix non disponible, veuillez recommencer");
                            }
                        }
                    }
                    else {
                        System.out.println("Il n'y a pas de recettes disponibles dans la boulangerie");
                    }
                }
                else {
                    System.out.println("Veuillez d'abord créer une boulangerie");
                }
                break;
                case 7:
                if (maBoulangerie!=null) {
                    System.out.println("Voici les recettes disponibles dans la boulangerie");
                    maBoulangerie.afficheRecette();
                }
                else {
                    System.out.println("Veuillez d'abord créer une boulangerie");
                }
                break;
                case 0:
                System.exit(0);
                default:
                System.out.println("Choix non disponible, veuillez recommencer");
            }
        }
    }

    public static void afficheMenu() {
        System.out.println("Que voulez-vous faire?");
        System.out.println("1\tCréer une boulangerie");
        System.out.println("2\tAjouter un gâteau");
        System.out.println("3\tEnlever un gâteau");
        System.out.println("4\tVoir les gâteaux disponibles dans la boulangerie");
        System.out.println("5\tAjouter une recette");
        System.out.println("6\tEnlever une recette");
        System.out.println("7\tVoir les recettes disponibles dans la boulangerie");
        System.out.println("0\tSortir du programme");
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