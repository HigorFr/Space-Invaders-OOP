package util;

import background.EstrelaFrente;
import background.EstrelaTras;
import gamelib.GameLib;
import projéteis.*;
import entidades.*;
import inimigos.*;
import java.util.ArrayList;
import java.util.List;


public class Contexto {
    public long delta;
    public long currentTime;



    public Player jogador;

    public List<Entidade> colisores = new ArrayList<>();

    public List<Projetil> Eprojeteis = new ArrayList<>();
    public List<Projetil> Pprojeteis = new ArrayList<>();

    public List<Inimigo> inimigos = new ArrayList<>();
    public List<Inimigo> inimigo1 = new ArrayList<>();
    public List<Inimigo> inimigo2 = new ArrayList<>();
    public List<Movel> estrelas = new ArrayList<>();



    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;
    public boolean escape;
    public boolean ctrl;



    public long WIDTH = GameLib.WIDTH;
    public long HEIGHT = GameLib.HEIGHT;


    public Contexto(){

        currentTime = System.currentTimeMillis();

        for (int i = 0; i < PProjetil.getMaxProjetil(); i++) {
            Projetil novo = (Projetil) new PProjetil();
            Pprojeteis.add(novo);
        }

        for (int i = 0; i < EProjetil.getMaxProjetil(); i++) {
            Projetil novo = (Projetil) new EProjetil();
            Eprojeteis.add(novo);
            colisores.add(novo);
        }



        for (int i = 0; i < Inimigo1.getMaxInimigos(); i++) {
            Inimigo1 novo = (Inimigo1) new Inimigo1(currentTime);
            inimigo1.add(novo);
            inimigos.add(novo);
            colisores.add(novo);
        }

        for (int i = 0; i < Inimigo2.getMaxInimigos(); i++) {
            Inimigo2 novo = (Inimigo2) new Inimigo2(currentTime);
            inimigo2.add(novo);
            inimigos.add(novo);
            colisores.add(novo);
        }



        for (int i = 0; i < EstrelaFrente.getMaxEstrelas(); i++) {
            Movel novo = (Movel) new EstrelaFrente();
            estrelas.add(novo);
        }

        for (int i = 0; i < EstrelaTras.getMaxEstrelas(); i++) {
            Movel novo = (Movel) new EstrelaTras();
            estrelas.add(novo);

        }
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public long getWIDTH() {
        return WIDTH;
    }

    public long getHEIGHT() {
        return HEIGHT;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isEscape() {return escape;}

    public boolean isCtrl() {return ctrl;}


    public long getDelta() {
        return delta;
    }

    public void setDelta(long delta) {
        this.delta = delta;
    }

    public long getCurrentTime() {
        return currentTime;
    }


    public List<Movel> getEstrelas() {return estrelas;}



    public void setJogador(Player jogador) {
        this.jogador = jogador;
    }

    public List<Projetil> getEProjeteis() {
        return Eprojeteis;
    }

    public List<Projetil> getPProjeteis() {
        return Pprojeteis;
    }

    public List<Entidade> getColisores() {return colisores;}

    public List<Inimigo> getInimigo() {return inimigos;}

    public List<Inimigo> getInimigo1() {
        return inimigo1;
    }

    public List<Inimigo> getInimigo2() {
        return inimigo2;
    }

    public Player getJogador() {
        return jogador;
    }


    public void update() {
        currentTime = System.currentTimeMillis();

        if (GameLib.iskeyPressed(GameLib.KEY_UP)) {
            up = true;
        } else {
            up = false;
        }

        if (GameLib.iskeyPressed(GameLib.KEY_DOWN)) {
            down = true;
        } else {
            down = false;
        }

        if (GameLib.iskeyPressed(GameLib.KEY_LEFT)) {
            left = true;
        } else {
            left = false;
        }

        if (GameLib.iskeyPressed(GameLib.KEY_RIGHT)) {
            right = true;
        } else {
            right = false;
        }

        if (GameLib.iskeyPressed(GameLib.KEY_CONTROL)) {
            ctrl = true;
        } else {
            ctrl = false;
        }

        if (GameLib.iskeyPressed(GameLib.KEY_ESCAPE)) {
            escape = true;
        } else {
            escape = false;
        }


    }
}
