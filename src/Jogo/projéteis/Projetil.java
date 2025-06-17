package projéteis;
import entidades.Entidade;


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






