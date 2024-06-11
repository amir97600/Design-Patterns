import java.util.ArrayList;

public class Boulangerie
{
    private String nom;
    private String adresse;
    private ArrayList<Patissier> patissiers;
    private ArrayList<InterfaceGateau> gateaux;
    private ArrayList<Integer> quantite;
    private String[] choux={"Choux","à la crème vanille","à la crème chocolat","avec chantilly","avec noisettes grillées","avec amandes grillées"};
    private String[] tarte={"Tarte","aux pommes","aux abricots","avec meringue","avec noisettes grillées","avec amandes grillées"};

    public Boulangerie(String name, String address){
        nom=name;
        adresse=address;
        patissiers=new ArrayList<Patissier>();
        gateaux=new ArrayList<InterfaceGateau>();
        quantite=new ArrayList<Integer>();
    }

    public void ajouterGateau(InterfaceGateau gateau){
        for (int i=0;i<gateaux.size();i++) {
            if (gateaux.get(i).getDescription().equals(gateau.getDescription())) {
                quantite.set(i,quantite.get(i)+1);
                return;
            }
        }
        gateaux.add(gateau);
        quantite.add(1);
    }

    public void enleverGateau(int num){
        quantite.set(num,quantite.get(num)-1);
        if (quantite.get(num)==0) {
            gateaux.remove(num);
            quantite.remove(num);
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

    public String getNom() {
        return nom;
    }

    public String getAdresse(){
        return adresse;
    }

} 