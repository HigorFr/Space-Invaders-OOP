package entidades;



import gamelib.GameLib;
//import jogo.projéteis.PProjetil;
import projéteis.Projetil;
import java.util.List;
import inimigos.Inimigo;
import util.Contexto;


public class Player extends Entidade {
    double explosion_start = 0;					// instante do início da explosão
    double explosion_end = 0;					// instante do final da explosão
    long nextShot;	
    double radius = 12.0;

    //PProjetil[] projeteis = new PProjetil[10];
    public Player(long currentTime) {
        state = 1;
        cord_x = GameLib.WIDTH / 2;
        cord_y =  GameLib.HEIGHT * 0.90;
        velocity_X = 0.25;
        velocity_Y =  0.25;
        
        this.nextShot = currentTime;
    //    for (int i = 0; i < 10; i++) {
    //      projeteis[i] = new PProjetil();
    //     }
    }


    public double getRadius(){
        return radius;
    }


    public void explodir(long currentTime) {				
        state = EXPLODING;
        explosion_start = currentTime;
        explosion_end = currentTime + 2000;
    }

    public void update(Contexto ctx){

        //Colisão Inimigo ou Bala
        for(Entidade e : ctx.getColisores()){
            
            double dx = e.getCord_x() - this.cord_x;
            double dy = e.getCord_y() - this.cord_y;
            double dist = Math.sqrt(dx * dx + dy * dy);
            
            if(dist < (radius + e.getRadius()) * 0.8) explodir(ctx.getCurrentTime());
        }

    }
}
