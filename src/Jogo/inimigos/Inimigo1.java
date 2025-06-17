package inimigos;

import projéteis.EProjetil;
import projéteis.Projetil;
import util.Contexto;
import gamelib.GameLib;
import java.awt.Color;


public class Inimigo1 extends Inimigo {

    static int maxInimigos = 10;


    static double radius = 9.0;
    static long nextEnemy;


    public Inimigo1(long currentTime){nextEnemy = currentTime + 2000}

    public static int getMaxInimigos() {
        return maxInimigos;
    }

    public double getRadius() {
        return radius;
    }
    
	public static long getNextEnemy() {return nextEnemy;}

	public static void setNextEnemy(long nextEnemy) {
		Inimigo1.nextEnemy = nextEnemy;
	}

    public void update(Contexto ctx){
        
        
        if(recebeuBala(ctx)) explodir(ctx.getCurrentTime());

        long tempoAtual = ctx.getCurrentTime();
        long delta = ctx.getDelta();

        if(confereEstado(tempoAtual)){
            cord_x += velocity_Y * Math.cos(angle) * delta;
            cord_y += velocity_Y * Math.sin(angle) * delta * (-1.0);
            angle += RV * delta;
            
            if(tempoAtual > nextShoot && cord_y < ctx.getJogador().getCord_y()){

                Projetil p = encontrarEntidadeLivre(ctx.getEProjeteis());
                if(ctx.getEProjeteis().size() < EProjetil.getMaxProjetil()){

                    p.setCord_x(cord_x);
                    p.setCord_y(cord_y);
                    p.setVelocity_X(Math.cos(angle) * 0.45);
                    p.setVelocity_Y(Math.sin(angle) * 0.45 * (-1.0));
                    p.setState(ACTIVE);
                    
                    nextShoot = (long) (tempoAtual + 200 + Math.random() * 500);
                }
            }
        }


        if(state == EXPLODING){
            
            double alpha = (ctx.getCurrentTime() - explosion_start) / (explosion_end - explosion_start);
            GameLib.drawExplosion(cord_x, cord_y, alpha);
        }
        
        if(state == ACTIVE){
    
            GameLib.setColor(Color.CYAN);
            GameLib.drawCircle(cord_x, cord_y, radius);
        }





    }
}