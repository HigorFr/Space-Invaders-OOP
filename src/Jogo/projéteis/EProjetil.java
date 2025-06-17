package projéteis;


public class EProjetil extends Projetil{
    private static final double radius = 2.0;
    
    public EProjetil(){
        this.state = INACTIVE;
    } 

    @Override
    public double getRadius() {
        return radius;
    }
}