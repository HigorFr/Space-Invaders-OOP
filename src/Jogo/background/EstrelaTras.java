package background;

import entidades.Movel;
import util.Contexto;
import gamelib.GameLib;

public class EstrelaTras extends Movel{

    static double count = 0.0;
    static double maxEstrelas = 50;





    public EstrelaTras(){
        cord_x = Math.random() * GameLib.WIDTH;
        cord_y = Math.random() * GameLib.HEIGHT;
        velocity_X = 0.045;
    }

    public static double getMaxEstrelas() {return maxEstrelas;}


    public void update(Contexto ctx){
        long delta = ctx.getDelta();
        count += velocity_X * delta;
        GameLib.fillRect(cord_x, (cord_y + count) % ctx.getHEIGHT(), 2, 2);

    }


}