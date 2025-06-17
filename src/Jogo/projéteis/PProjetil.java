package projéteis;
import gamelib.GameLib;
import util.Contexto;
import java.awt.Color;


public class PProjetil extends Projetil{
    private static final double radius = 0.0;
    private static final int maxProjetil = 200;
    public PProjetil(){
        this.state = INACTIVE;
    }

    @Override
    public double getRadius() {
        return radius;
    }




    static public int getMaxProjetil() {return maxProjetil;}


    public void update(Contexto ctx){

        if(state == ACTIVE){
            
            GameLib.setColor(Color.GREEN);
            GameLib.drawLine(cord_x, cord_y - 5, cord_x, cord_y + 5);
            GameLib.drawLine(cord_x - 1, cord_y - 3, cord_x - 1, cord_y + 3);
            GameLib.drawLine(cord_x + 1, cord_y - 3, cord_x + 1, cord_y + 3);
        }
    }
}