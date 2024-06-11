import java.util.ArrayList;

public class Boulangerie
{
    private String nom;
    private String adresse;
    private Patissier patissier;
    private ArrayList<InterfaceGateau> gateaux;
    private ArrayList<Integer> quantite;
    private String[] choux={"Choux","à la crème vanille","à la crème chocolat","avec chantilly","avec noisettes grillées","avec amandes grillées"};
    private String[] tarte={"Tarte","aux pommes","aux abricots","avec meringue","avec noisettes grillées","avec amandes grillées"};
    private ArrayList<Recette> recettes;

    public Boulangerie(String name, String address) {
        nom=name;
        adresse=address;
        gateaux=new ArrayList<InterfaceGateau>();
        quantite=new ArrayList<Integer>();
        recettes=new ArrayList<Recette>();
        patissier=new Patissier();
    }

    public void ajouterGateau(InterfaceGateau gateau, int num) {
        for (int i=0;i<gateaux.size();i++) {
            if (gateaux.get(i).getDescription().equals(gateau.getDescription())) {
                quantite.set(i,quantite.get(i)+num);
                System.out.println("Le gâteau \""+gateau.getDescription()+"\" a bien été ajouté");
                return;
            }
        }
        gateaux.add(gateau);
        quantite.add(num);
        System.out.println("Le gâteau \""+gateau.getDescription()+"\" a bien été ajouté");
    }

    public void enleverGateau(int indice) {
        quantite.set(indice,quantite.get(indice)-1);
        if (quantite.get(indice)==0) {
            gateaux.remove(indice);
            quantite.remove(indice);
        }
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

    public void addRecette(Recette recette) {
        for (Recette R : recettes) {
            if (R.getNom().equals(recette.getNom())) {
                System.out.println("Cette recette existe déjà");
                return;
            }
        }
        recettes.add(recette);
        System.out.println("La recette: \""+recette.getNom()+"\" a bien été ajoutée");
    }

    public void afficheRecettes() {
        for (int i=0;i<recettes.size();i++) {
            System.out.println(Integer.toString(i)+".\t"+recettes.get(i).getNom());
        }
        if (recettes.size()==0) {
            System.out.println("Il n'y a pas de recettes disponibles");
        }
    }

    public void removeRecette(int indice) {
        recettes.remove(indice);
    }

    public int getNombreRecettes() {
        return recettes.size();
    }

    public Recette getRecette(int indice) {
        return recettes.get(indice);
    }

    public Patissier getPatissier() {
        return patissier;
    }
} 