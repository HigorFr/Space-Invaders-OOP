package entidades;
import util.Contexto;
import java.util.List;



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


    public static <T extends Entidade> T encontrarEntidadeLivre(List<T> lista) {
        for (T e : lista) {
            if (e.getState() == INACTIVE) {
                return e;
            }
        }
        return null;
    }


    public static <T extends Entidade> int contarAtivos(List<T> lista) {
        int i = 0;
        for (T e : lista) {
            if (e.getState() == ACTIVE) {
                i++;
            }
        }
        return i;
    }


}