package jogo.inimigos;
import jogo.GameLib;
import jogo.entidades.Entidade;

public abstract class Inimigo extends Entidade{
	double angle;				// ângulos (indicam direção do movimento)
	double RV;					// velocidades de rotação
	double explosion_start;			// instantes dos inícios das explosões
	double explosion_end;			// instantes dos finais da explosões
	long nextShoot;				// instantes do próximo tiro





	public double getAngle() {
		return angle;
	}
	public void setAngle(double angle) {
		this.angle = angle;
	}
	public double getRV() {
		return RV;
	}
	public void setRV(double rv) {
		RV = rv;
	}
	public double getExplosion_start() {
		return explosion_start;
	}
	public void setExplosion_start(double explosion_start) {
		this.explosion_start = explosion_start;
	}
	public double getExplosion_end() {
		return explosion_end;
	}
	public void setExplosion_end(double explosion_end) {
		this.explosion_end = explosion_end;
	}
	public long getNextShoot() {
		return nextShoot;
	}
	public void setNextShoot(long nextShoot) {
		this.nextShoot = nextShoot;
	}



	public boolean confereEstado(long tempoAtual) {
		if(state == INACTIVE) return false;
		
		
		
		if(state == EXPLODING){
				
			if(tempoAtual > explosion_end){		
				state = INACTIVE;
				return false;
			}
		}

		if(state == ACTIVE){
			if(cord_y > GameLib.HEIGHT + 10) {
				state = INACTIVE;
				return false;
			}

			return true;
		}

		return false;
	}


}