package inimigos;

import projéteis.EProjetil;
import projéteis.Projetil;
import util.Contexto;
import gamelib.GameLib;
import java.awt.Color;


public class Inimigo1 extends Inimigo {

    static int maxInimigos = 10;

    static int count = 0;
    static double radius = 9.0;
    static long nextEnemy;


    public Inimigo1(long currentTime){nextEnemy = currentTime + 2000;}

    public static int getMaxInimigos() {
        return maxInimigos;
    }

    public double getRadius() {return radius;    }
    
	public static long getNextEnemy() {return nextEnemy;}

	public static void setNextEnemy(long nextEnemy) {
		Inimigo1.nextEnemy = nextEnemy;
	}


    public static void Spawner(Contexto ctx){

        Inimigo i = encontrarEntidadeLivre(ctx.getInimigo1());
        if(i != null && count < maxInimigos) {
            i.cord_x =  Math.random() * (GameLib.WIDTH - 20.0) + 10.0;
            i.cord_y = -10.0;
            i.velocity_X = 0.2 + Math.random() * 0.15;
            i.angle = (3*Math.PI) / 2;
            i.RV = 0.0;
            i.state = ACTIVE;
            i.nextShoot = ctx.getCurrentTime() + 500;
            nextEnemy = ctx.getCurrentTime() + 500;
            count++;

            //System.out.println("Spawnei: X=" + a + " | Instância: " + i.hashCode());
        }

    }


    public void update(Contexto ctx){

        int state_ant = state;

        long tempoAtual = ctx.getCurrentTime();
        long delta = ctx.getDelta();

        if(recebeuBala(ctx)) explodir(tempoAtual);




        if(confereEstado(tempoAtual)){
            cord_x += velocity_X * Math.cos(angle) * delta;
            cord_y += velocity_X * Math.sin(angle) * delta * (-1.0);
            angle += RV * delta;
            
            if(tempoAtual > nextShoot && cord_y < ctx.getJogador().getCord_y()){

                Projetil p = encontrarEntidadeLivre(ctx.getEProjeteis());
                if(p != null && count < EProjetil.getMaxProjetil()){

                    p.setCord_x(cord_x);
                    p.setCord_y(cord_y);
                    p.setVelocity_X(Math.cos(angle) * 0.45);
                    p.setVelocity_Y(Math.sin(angle) * 0.45 * (-1.0));
                    p.setState(ACTIVE);
                    
                    nextShoot = (long) (tempoAtual + 200 + Math.random() * 500);
                }
            }
        }


        //if(tempoAtual > nextEnemy) Spawner(ctx);

        if(state == EXPLODING){
            
            double alpha = (ctx.getCurrentTime() - explosion_start) / (explosion_end - explosion_start);
            GameLib.drawExplosion(cord_x, cord_y, alpha);
        }


        
        if(state == ACTIVE){
    
            GameLib.setColor(Color.CYAN);
            GameLib.drawCircle(cord_x, cord_y, radius);
        }

        if(state != ACTIVE && state_ant == ACTIVE) count--;


    }
}