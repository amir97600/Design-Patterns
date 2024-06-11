import java.util.ArrayList;

public class Boulangerie
{
    private String nom;
    private String adresse;
    private Patissier patissier;
    private ArrayList<InterfaceGateau> gateaux;
    private ArrayList<Integer> quantite;
    private ArrayList<RecetteSpecifique> recettes;
    private String[] choux={"Choux","à la crème vanille","à la crème chocolat","avec chantilly","avec noisettes grillées","avec amandes grillées"};
    private String[] tarte={"Tarte","aux pommes","aux abricots","avec meringue","avec noisettes grillées","avec amandes grillées"};

    public Boulangerie(String name, String address) {
        nom=name;
        adresse=address;
        patissier=new Patissier();
        gateaux=new ArrayList<InterfaceGateau>();
        quantite=new ArrayList<Integer>();
        recettes=new ArrayList<RecetteSpecifique>(); 
    }

    public void ajouterGateau(InterfaceGateau gateau) {
        for (int i=0;i<gateaux.size();i++) {
            if (gateaux.get(i).getDescription().equals(gateau.getDescription())) {
                quantite.set(i,quantite.get(i)+1);
                return;
            }
        }
        gateaux.add(gateau);
        quantite.add(1);
    }

    public void ajouterGateau(InterfaceGateau gateau, int num) {
        for (int i=0;i<gateaux.size();i++) {
            if (gateaux.get(i).getDescription().equals(gateau.getDescription())) {
                quantite.set(i,quantite.get(i)+num);
                return;
            }
        }
        gateaux.add(gateau);
        quantite.add(num);
    }

    public void ajouterGateau(int indice, int num) {
        quantite.set(indice,quantite.get(indice)+num);   
    }

    public void enleverGateau(int indice) {
        quantite.set(indice,quantite.get(indice)-1);
        if (quantite.get(indice)==0) {
            gateaux.remove(indice);
            quantite.remove(indice);
        }
    }

    public void afficheRecette() {
        if (recettes.size()>0) {
            for (int i=0;i<recettes.size();i++) {
                System.out.println(Integer.toString(i)+".\t"+recettes.get(i).getNom());
            }
        }
        else {
            System.out.println("Il n'y a aucune recette dans la boulangerie");
        }
    }

    public void ajouterRecette(RecetteSpecifique recette) {
        if (recettes.size()==0) {
            recettes.add(recette);
            System.out.println("La recette: "+recette.getNom()+" a bien été ajoutée dans la boulangerie");
        }
        else {
            for (RecetteSpecifique R : recettes) {
                if (R.getNom().equals(recette.getNom())) {
                    System.out.println("Cette recette existe déjà");
                    return;
                }
            }
            recettes.add(recette);
            System.out.println("La recette: "+recette.getNom()+" a bien été ajoutée dans la boulangerie");
        }
    }

    public void enleverRecette(int num) {
        recettes.remove(num);
    }

    public int getNombreRecettes() {
        return recettes.size();
    }

    public RecetteSpecifique getRecette(int num) {
        return recettes.get(num);
    }

    public Patissier getPatissier() {
        return patissier;
    }

    public String[] getChoux() {
        return choux;
    }

    public String[] getTarte() {
        return tarte;
    }
    
    public void afficheGateaux() {
        if (gateaux.size()>0) {
            for (int i=0;i<gateaux.size();i++) {
                System.out.println(Integer.toString(i)+".\t"+gateaux.get(i).getDescription()+"\tQuantité: "+Integer.toString(quantite.get(i)));
            }
        }
        else {
            System.out.println("Il n'y a pas de gâteaux disponibles dans la boulangerie");
        }    
    }

    public int getNombreDifferentsGateaux() {
        return gateaux.size();
    }

    public Gateau getGateau(int indice) {
        return (Gateau)gateaux.get(indice);
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse(){
        return adresse;
    }

} 