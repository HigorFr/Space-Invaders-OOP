package jogo.entidades;

import jogo.GameLib;
//import jogo.projéteis.PProjetil;


public class Player extends Entidade {
    double explosion_start = 0;					// instante do início da explosão
    double explosion_end = 0;					// instante do final da explosão
    long nextShot;	
    double radius = 12.0;

    //PProjetil[] projeteis = new PProjetil[10];
    public Player() {
        state = 1;
        cord_x = GameLib.WIDTH / 2;
        cord_y =  GameLib.HEIGHT * 0.90;
        Velocity_X = 0.25;
        Velocity_Y =  0.25;
        
        this.nextShot = System.currentTimeMillis();
    //    for (int i = 0; i < 10; i++) {
    //      projeteis[i] = new PProjetil();
    //     }
    }


    public void Explodir(long currentTime) {				
        state = 2;
        explosion_start = currentTime;
        explosion_end = currentTime + 2000;
    }
}
