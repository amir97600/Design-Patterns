abstract class GateauDecorator implements InterfaceGateau {
    protected InterfaceGateau tempGateau;

    public GateauDecorator(InterfaceGateau newGateau) {
        tempGateau=newGateau;       
    }

    public String getDescription() {
        return tempGateau.getDescription();
    }

    public float getPrix() {
        return tempGateau.getPrix();
    }
}