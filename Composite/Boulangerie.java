import java.util.ArrayList;

public class Boulangerie
{
    private String nom;
    private String adresse;
    private Patissier patissier;
    private ArrayList<GateauComposite> gateaux;
    private String[][] choux={{"Choux"},{"à la crème vanille","à la crème chocolat"},{"avec chantilly","avec noisettes grillées","avec amandes grillées"}};
    private float[][] prixChoux={{6.5f},{2.2f,2.1f},{0.9f,1.1f,1.5f}};
    private String[][] tarte={{"Tarte"},{"aux pommes","aux abricots"},{"avec meringue","avec noisettes grillées","avec amandes grillées"}};
    private float[][] prixTarte={{9.3f},{2.5f,2.8f},{1.5f,1.3f,1.8f}};

    public Boulangerie(String name, String address) {
        nom=name;
        adresse=address;
        patissier=new Patissier();
        gateaux=new ArrayList<GateauComposite>();
    }

    public void ajouterGateau(GateauComposite gateau, int num) {
        for (int i=0;i<gateaux.size();i++) {
            if (gateaux.get(i).getNom().equals(gateau.getNom())) {
                gateaux.get(i).ajouterQuantite(num);
                System.out.println("Le gâteau \""+gateau.getNom()+"\" a bien été créé et ajouté dans la boulangerie");
                return;
            }
        }
        gateaux.add(gateau);
        gateau.ajouterQuantite(num);
        System.out.println("Le gâteau \""+gateau.getNom()+"\" a bien été créé et ajouté dans la boulangerie");
    }

    public void enleverGateau(int indice, int num) {
        gateaux.get(indice).enleverQuantite(num);
    }

    public String[][] getChoux() {
        return choux;
    }

    public float[][] getPrixChoux() {
        return prixChoux;
    }

    public String[][] getTarte() {
        return tarte;
    }

    public float[][] getPrixTarte() {
        return prixTarte;
    } 
    
    public void afficheGateaux() {
        if (gateaux.size()>0) {
            for (int i=0;i<gateaux.size();i++) {
                System.out.println(Integer.toString(i)+".\t"+gateaux.get(i).getNom()+"\tQuantité: "+Integer.toString(gateaux.get(i).getQuantite())+"\tPrix: "+Float.toString(gateaux.get(i).getPrix()));
            }
        }
        else {
            System.out.println("Il n'y a pas de gâteaux disponibles dans la boulangerie");
        }    
    }

    public int getNombreDifferentsGateaux() {
        return gateaux.size();
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse(){
        return adresse;
    }

    public Patissier getPatissier() {
        return patissier;
    }

} 