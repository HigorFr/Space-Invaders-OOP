package inimigos;

import gamelib.GameLib;

import java.awt.Color;

import entidades.Player;
import projéteis.*;
import util.Contexto;


public class Inimigo2 extends Inimigo {
    
    static int maxInimigos = 10;

    static double radius = 12.0;
    static long nextEnemy;
    static double spawnX = GameLib.WIDTH*0.2;
    static int count = 0;
    


    public Inimigo2(long currentTime){nextEnemy = currentTime + 7000}

    public static int getMaxInimigos() {
        return maxInimigos;
    }

    public double getRadius() {
        return radius;
    }

	public static long getNextEnemy() {
		return nextEnemy;
	}
    
	public static void setNextEnemy(long nextEnemy) {
		Inimigo2.nextEnemy = nextEnemy;
	}


    public void update(Contexto ctx){ 

        spawnX = ctx.getWIDTH()*0.20;

        if(recebeuBala(ctx)) explodir(ctx.getCurrentTime());
        
        if(confereEstado(ctx.getCurrentTime())){
            
            double delta = ctx.getDelta();

            boolean shootNow = false;
            double previousY = cord_y;                      
            cord_x += cord_x * Math.cos(angle) * delta;
            cord_y += cord_y * Math.sin(angle) * delta * (-1.0);
            angle += RV * delta;
            
            double threshold = GameLib.HEIGHT * 0.30;
            
            if(previousY < threshold && cord_y >= threshold) {
                
                if(cord_x < GameLib.WIDTH / 2) RV = 0.003;
                else RV = -0.003;
            }
            
            if(RV > 0 && Math.abs(angle - 3 * Math.PI) < 0.05){
                
                RV = 0.0;
                angle = 3 * Math.PI;
                shootNow = true;
            }
            
            if(RV < 0 && Math.abs(angle) < 0.05){
                
                RV = 0.0;
                angle = 0.0;
                shootNow = true;
            }
                          
            
            if(shootNow){

                double [] angles = { Math.PI/2 + Math.PI/8, Math.PI/2, Math.PI/2 - Math.PI/8 };
                
                for (int k = 0; k < angles.length; k++){


                    Projetil p = encontrarEntidadeLivre(ctx.getEProjeteis());
                    if(ctx.getEProjeteis().size() < EProjetil.getMaxProjetil()){

                        double a = angles[k] + Math.random() * Math.PI/6 - Math.PI/12;
                        double vx = Math.cos(a);
                        double vy = Math.sin(a);


                        p.setCord_x(cord_x);
                        p.setCord_y(cord_y);
                        p.setVelocity_X(vx * 0.30);
                        p.setVelocity_Y(vy * 0.30);
                        p.setState(ACTIVE);


                    }
                }
            }
        }


        if(state == EXPLODING){
            
            double alpha = (ctx.getCurrentTime() - explosion_start) / (explosion_end - explosion_start);
            GameLib.drawExplosion(cord_x, cord_y, alpha);
        }
        
        if(state == ACTIVE){
    
            GameLib.setColor(Color.MAGENTA);
            GameLib.drawDiamond(cord_x, cord_y, radius);
        }



    }
}






