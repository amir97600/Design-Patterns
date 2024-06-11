import java.io.*;

public class GestionBoulangerie {
    

    public static void main (String[] args){
        Boulangerie maBoulangerie=null;
        int rep;
        int quantite;
        String nom;
        String adresse;
        Gateau gateau;
        RecetteFactory recetteFactory;
        Recette recette;
        while(true) {
            afficheMenu();
            rep=saisieEntier();
            switch (rep) {
                case 1:
                System.out.println("Veuillez donner le nom de la boulangerie");
                nom=saisieChaine();
                System.out.println("Veuillez donner l'adresse de la boulangerie");
                adresse=saisieChaine();
                maBoulangerie=new Boulangerie (nom, adresse);
                break;
                case 2:
                if (maBoulangerie!=null) {
                    System.out.println("Voulez-vous créer un gâteau à partir d'une recette ou à partir d'un gâteau déjà disponible?");
                    System.out.println("1\tA partir d'une recette");
                    System.out.println("2\tA partir d'un gâteau déjà disponible");
                    while (true) {
                        rep=saisieEntier();
                        System.out.println("Combien de gâteaux voulez-vous créer?");
                        quantite=saisieEntier();
                        if (rep==1 && maBoulangerie.getNombreRecettes()>=1){
                            System.out.println("Quelle recette voulez-vous utiliser?");
                            maBoulangerie.afficheRecettes();
                            while (true) {
                                rep=saisieEntier();
                                if (rep>=0 && rep<maBoulangerie.getNombreRecettes()) {
                                    gateau=maBoulangerie.getPatissier().createGateau(maBoulangerie.getRecette(rep));
                                    gateau.setRecette(maBoulangerie.getRecette(rep));
                                    maBoulangerie.ajouterGateau(gateau, quantite);
                                    break;
                                }
                                else {
                                    System.out.println("Choix non disponible, veuillez recommencer");
                                }
                            }
                            break;
                        }
                        else if (rep==2 && maBoulangerie.getNombreDifferentsGateaux()>=1) {
                            System.out.println("Quel gâteau voulez-vous copier?");
                            maBoulangerie.afficheGateaux();
                            while (true) {
                                rep=saisieEntier();
                                if (rep>=0 && rep<maBoulangerie.getNombreDifferentsGateaux()) {
                                    gateau=maBoulangerie.getPatissier().createGateau(maBoulangerie.getGateau(rep).getRecette());
                                    gateau.setRecette(maBoulangerie.getRecette(rep));
                                    maBoulangerie.ajouterGateau(gateau, quantite);
                                    break;
                                }
                                else {
                                    System.out.println("Choix non disponible, veuillez recommencer");
                                }
                            }
                            break;
                        }
                        else if (rep==1 || rep==2) {
                            if (rep==1) {
                                System.out.println("Veuillez d'abord créer une recette");
                            }
                            if (rep==2) {
                                System.out.println("Veuillez d'abord créer un gâteau");
                            }
                            break;
                        }
                        else {
                            System.out.println("Choix non disponible, veuillez recommencer");
                        }
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
                    System.out.println("Que voulez-vous créer?");
                    System.out.println("1\tDes choux");
                    System.out.println("2\tUne tarte");
                    rep=saisieEntier();
                    switch (rep) {
                        case 1:
                        case 2:
                        recetteFactory=RecetteFactory.getFactory(rep, maBoulangerie);
                        recette=recetteFactory.createRecette();
                        maBoulangerie.addRecette(recette);
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
                        System.out.println("Quelle recette voulez-vous supprimer?");
                        maBoulangerie.afficheRecettes();
                        while (true) {
                            rep=saisieEntier();
                            if (rep >=0 && rep <maBoulangerie.getNombreRecettes()) {
                                maBoulangerie.removeRecette(rep);
                                break;
                            }
                            else {
                                System.out.println("Choix non disponible, veuillez recommencer");
                            }
                        }
                    }
                }
                else {
                    System.out.println("Veuillez d'abord créer une boulangerie");
                }
                break;
                case 7:
                if (maBoulangerie!=null) {
                    System.out.println("Voici la liste des recettes disponibles:");
                    maBoulangerie.afficheRecettes();    
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
        System.out.println("5\tCréer une recette");
        System.out.println("6\tEnlever une recette");
        System.out.println("7\tAfficher les recettes disponibles");
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