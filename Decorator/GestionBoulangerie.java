import java.io.*;

public class GestionBoulangerie {
    

    public static void main (String[] args){
        Boulangerie maBoulangerie=null;
        int rep;
        String nom;
        String adresse;
        InterfaceGateau gateau;
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
                    System.out.println("Que voulez-vous créer?");
                    System.out.println("1\tDes choux");
                    System.out.println("2\tUne tarte");
                    rep=saisieEntier();
                    switch (rep) {
                        case 1:
                        gateau=new Gateau(maBoulangerie.getChoux()[0]);
                        for (int i=1;i<maBoulangerie.getChoux().length;i++) {
                            System.out.println("Voulez vous des choux "+maBoulangerie.getChoux()[i]+" ?");
                            System.out.println("1\tOui");
                            System.out.println("2\tNon");
                            rep=saisieEntier();
                            if (rep==1) {
                                gateau=new Ingredient(gateau,maBoulangerie.getChoux()[i]);
                            }
                        }
                        maBoulangerie.ajouterGateau(gateau);
                        System.out.println("Le gâteau "+gateau.getDescription()+" a bien été créé et ajouté dans la boulangerie");
                        break;
                        case 2:
                        gateau=new Gateau(maBoulangerie.getTarte()[0]);
                        for (int i=1;i<maBoulangerie.getTarte().length;i++) {
                            System.out.println("Voulez vous une tarte "+maBoulangerie.getTarte()[i]+" ?");
                            System.out.println("1\tOui");
                            System.out.println("2\tNon");
                            rep=saisieEntier();
                            if (rep==1) {
                                gateau=new Ingredient(gateau,maBoulangerie.getTarte()[i]);
                            }
                        }
                        maBoulangerie.ajouterGateau(gateau);
                        System.out.println("Le gâteau "+gateau.getDescription()+" a bien été créé et ajouté dans la boulangerie");
                        break;
                        default:
                        System.out.println("Choix non disponible, veuillez recommencer");
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