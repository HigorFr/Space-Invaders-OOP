package jogo.entidades;
import jogo.util.Contexto;

public abstract class Movel {
    public double cord_x;
    public double cord_y;
    public double velocity_X;
    public double velocity_Y;

    public double getCord_x() {
        return cord_x;
    }
    public void setCord_x(double cord_x) {
        this.cord_x = cord_x;
    }
    public double getCord_y() {
        return cord_y;
    }
    public void setCord_y(double cord_y) {
        this.cord_y = cord_y;
    }
    public double getVelocity_X() {
        return velocity_X;
    }
    public void setVelocity_X(double velocity_X) {
        this.velocity_X = avelocity_X;
    }
    public double getVelocity_Y() {
        return velocity_Y;
    }
    public void setVelocity_Y(double velocity_Y) {
        this.velocity_Y = avelocity_Y;
    }



}


public abstract class Entidade extends Movel {
    public static final int ACTIVE = 1;
    public static final int INACTIVE = 0;
    public static final int EXPLODING = 2;

    public int state;


    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    
    public abstract double getRadius();
    public abstract void update(Contexto ctx);

    
}