package jogo.projéteis;
import jogo.entidades.Entidade;


public abstract class Projetil extends Entidade{   

    public void update(long delta, int Maxheight){
        if(state == ACTIVE){
            if(cord_y < 0 || cord_y > Maxheight) {
                
                state = INACTIVE;
            }
            else {
            
                cord_x += velocity_X * delta;
                cord_y += velocity_Y * delta;
            }
        }  
    }

}






public class PProjetil extends Projetil{
    private static final double radius = 0.0;
    
    public void PProjetil(){
        this.state = INACTIVE;
    }
    
    
    @Override
    public double getRadius() {
        return radius;
    }
}

public class EProjetil extends Entidade{
    private static final double radius = 2.0;
    
    public void EProjetil(){
        this.state = INACTIVE;
    } 

    @Override
    public double getRadius() {
        return radius;
    }

}




