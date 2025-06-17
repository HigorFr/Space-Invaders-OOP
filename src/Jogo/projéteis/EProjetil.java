package projéteis;
import gamelib.GameLib;
import util.Contexto;
import java.awt.Color;

public class EProjetil extends Projetil{
    private static final double radius = 2.0;
    private static final int maxProjetil = 200;



    static public int getMaxProjetil() {return maxProjetil;}


    public EProjetil(){
        this.state = INACTIVE;
    } 

    @Override
    public double getRadius() {
        return radius;
    }



    public void update(Contexto ctx){

        if(state == ACTIVE){
            
            GameLib.setColor(Color.RED);
            GameLib.drawCircle(cord_x, cord_y, radius);
        }
    }
}