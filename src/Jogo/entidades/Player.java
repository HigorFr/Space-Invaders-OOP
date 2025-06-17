package entidades;



import gamelib.GameLib;
//import jogo.projéteis.PProjetil;
import projéteis.Projetil;
import java.util.List;
import inimigos.Inimigo;
import util.Contexto;
import java.awt.Color;

public class Player extends Entidade {
    double explosion_start = 0;					// instante do início da explosão
    double explosion_end = 0;					// instante do final da explosão
    long nextShot;	
    double radius = 12.0;

    //PProjetil[] projeteis = new PProjetil[10];
    public Player(long currentTime) {
        state = ACTIVE;
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

        //Colisão Inimigo


        for(Entidade e : ctx.getInimigo()){
            
            double dx = e.getCord_x() - this.cord_x;
            double dy = e.getCord_y() - this.cord_y;
            double dist = Math.sqrt(dx * dx + dy * dy);
            
            if(dist < (radius + e.getRadius()) * 0.8) explodir(ctx.getCurrentTime());
        }


        //Colisão com Bala

        for(Entidade e : ctx.getEProjeteis()){

            double dx = e.getCord_x() - this.cord_x;
            double dy = e.getCord_y() - this.cord_y;
            double dist = Math.sqrt(dx * dx + dy * dy);

            if(dist < (radius + e.getRadius()) * 0.8) explodir(ctx.getCurrentTime());
        }





        //Movimento
        long delta = ctx.getDelta();
        if(ctx.isUp()) cord_x -= delta * velocity_X;
        if(ctx.isDown()) cord_y += delta * velocity_Y;
        if(ctx.isLeft()) cord_x -= delta * velocity_X;
        if(ctx.isRight()) cord_y += delta * velocity_Y;        


        if(cord_x < 0.0) cord_x = 0.0;
        if(cord_x >= ctx.getWIDTH()) cord_x = ctx.getWIDTH()- 1;
        if(cord_y < 25.0) cord_y = 25.0;
        if(cord_y >= ctx.getHEIGHT()) cord_y = ctx.getHEIGHT() - 1;


        //Respawn
        if(state == EXPLODING){
            
            if(ctx.getCurrentTime() > explosion_end){
                
                state = ACTIVE;
            }
        }



        //Desenho
        if(state == EXPLODING){
            
            double alpha = (ctx.getCurrentTime() - explosion_start) / (explosion_end - explosion_start);
            GameLib.drawExplosion(cord_x, cord_y, alpha);
        }
        else{
            
            GameLib.setColor(Color.BLUE);
            GameLib.drawPlayer(cord_x, cord_y, radius);
        }



    }
}
