import java.util.*;

public class GateauComposite extends GateauComposant {  
    int quantite=0;
    private List<GateauComposant> ingredients = new ArrayList<GateauComposant>();
    
    public GateauComposite() {

    }

    public void add(GateauComposant composant) {
        ingredients.add(composant);
    }

    public String getNom() {
        if (ingredients.size()==0) {
            System.out.println("Ce composite est vide");
            return null;
        }
        else {
            String nomComplet=ingredients.get(0).getNom();
            if (ingredients.size()>=1) {
                for (int i=1;i<ingredients.size();i++) {
                nomComplet+=" "+ingredients.get(i).getNom();
                }
            }
            return nomComplet;
        }
    }

    public float getPrix() {
        float prixTotal=0;
        for (GateauComposant I : ingredients) {
            prixTotal+=I.getPrix();
        }
        return prixTotal;
    }

    public int getQuantite() {
        return quantite;
    }

    public void ajouterQuantite(int nb) {
        quantite+=nb;
    }

    public void enleverQuantite(int nb) {
        if (quantite>=nb) {
            quantite-=nb;
        }
        else if (quantite==0) {
            System.out.println("Il n'y a plus de gâteau \""+this.getNom()+"\". Veuillez en refaire");
        }
        else {
            System.out.println("Il ne reste que "+Integer.toString(quantite)+" \""+this.getNom()+"\"");
            quantite=0;
            System.out.println("Il n'en reste désormais plus");
        }
    }
}