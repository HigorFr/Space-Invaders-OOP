package projéteis;


public class PProjetil extends Projetil{
    private static final double radius = 0.0;
    
    public PProjetil(){
        this.state = INACTIVE;
    }

    @Override
    public double getRadius() {
        return radius;
    }
}