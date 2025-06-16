package jogo.inimigos;

import jogo.GameLib;
import jogo.entidades.Player;
import jogo.projéteis.EProjetil;
import jogo.util.Contexto;

public class Inimigo2 extends Inimigo {
    
    static double radius = 12.0;
    static long nextEnemy;
    static double enemy2_spawnX = GameLib.WIDTH * 0.20;
    static int count = 0;
    
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
                    

                    if(ctx.projeteis.size() < ctx.maxProjeteis){
                        
                        double a = angles[k] + Math.random() * Math.PI/6 - Math.PI/12;
                        double vx = Math.cos(a);
                        double vy = Math.sin(a);
                            
  
                        EProjetil novo = new EProjetil();
                        novo.setCord_x(cord_x);
                        novo.setCord_y(cord_y);
                        novo.setVelocity_X(vx * 0.30);
                        novo.setVelocity_Y(vy * 0.30); 
                        novo.setState(ACTIVE);

                        ctx.projeteis.add(novo);
                        ctx.colisores.add(novo);

                    }
                }
            }
        }
    }
}






