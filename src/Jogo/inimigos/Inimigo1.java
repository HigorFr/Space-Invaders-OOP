package jogo.inimigos;

import jogo.projéteis.EProjetil;
import jogo.util.Contexto;

public class Inimigo1 extends Inimigo {

    static double radius = 9.0;
    static long nextEnemy;

    public double getRadius() {
        return radius;
    }
    
	public static long getNextEnemy() {
		return nextEnemy;
	}
	public static void setNextEnemy(long nextEnemy) {
		Inimigo1.nextEnemy = nextEnemy;
	}

    public void update(Contexto ctx){ //TODO: Adicionar lista de Projeteis
        
        
        if(recebeuBala(ctx)) explodir(ctx.getCurrentTime());
        long tempoAtual = ctx.getCurrentTime();
        long delta = ctx.getDelta();

        if(confereEstado(tempoAtual)){
            cord_x += velocity_Y * Math.cos(angle) * delta;
            cord_y += velocity_Y * Math.sin(angle) * delta * (-1.0);
            angle += RV * delta;
            
            if(tempoAtual > nextShoot && cord_y < ctx.getJogador().getCord_y()){
                                                                                
                
                if(ctx.projeteis.size() < ctx.maxProjeteis){
                    
                    EProjetil novo = new EProjetil();
                    novo.setCord_x(cord_x);
                    novo.setCord_y(cord_y);
                    novo.setVelocity_X(Math.cos(angle) * 0.45);
                    novo.setVelocity_Y(Math.sin(angle) * 0.45 * (-1.0)); 
                    novo.setState(ACTIVE);
                    
                    nextShoot = (long) (tempoAtual + 200 + Math.random() * 500);
                }
            }
        }   
    }
}