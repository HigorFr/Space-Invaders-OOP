package util;

import jogo.inimigos.Inimigo;
import jogo.projéteis.Projetil;
import jogo.entidades.*;
import java.util.List;


public class Contexto {
    public int maxProjeteis = 10;
    public int maxInimigos = 10;
    public long delta;
    public long currentTime;
    public Player jogador;
    public List<Entidade> colisores;
    public List<Projetil> projeteis;
    public List<Inimigo> inimigo;


    public List<Entidade> getColisores() {
        return colisores;
    }

    public long getDelta() {
        return delta;
    }
    public void setDelta(long delta) {
        this.delta = delta;
    }
    public long getCurrentTime() {
        return currentTime;
    }
    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }
    public Player getJogador() {
        return jogador;
    }
    public void setJogador(Player jogador) {
        this.jogador = jogador;
    }
    public List<Projetil> getProjeteis() {
        return projeteis;
    }
    public void setProjeteis(List<Projetil> projeteis) {
        this.projeteis = projeteis;
    }
    public List<Inimigo> getInimigo() {
        return inimigo;
    }
    public void setInimigo(List<Inimigo> inimigo) {
        this.inimigo = inimigo;
    }
    
}
