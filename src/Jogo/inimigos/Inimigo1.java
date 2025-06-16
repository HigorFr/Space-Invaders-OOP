package jogo.inimigos;

import jogo.projéteis.EProjetil;
import jogo.entidades.Player ;

public class Inimigo1 extends Inimigo {

    static double radius = 9.0;
    static long nextEnemy;

    public static double getRadius() {
        return radius;
    }
    
	public static long getNextEnemy() {
		return nextEnemy;
	}
	public static void setNextEnemy(long nextEnemy) {
		Inimigo1.nextEnemy = nextEnemy;
	}

    public void update(long tempoAtual, long delta, Player jogador){ //TODO: Adicionar lista de Projeteis
        if(confereEstado(tempoAtual)){
            cord_x += velocity_Y * Math.cos(angle) * delta;
            cord_y += velocity_Y * Math.sin(angle) * delta * (-1.0);
            angle += RV * delta;
            
            if(tempoAtual > nextShoot && cord_y < jogador.getCord_y()){
                                                                                
                int free = findFreeIndex(e_projectile_states);
                
                if(free < e_projectile_states.length){
                    
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