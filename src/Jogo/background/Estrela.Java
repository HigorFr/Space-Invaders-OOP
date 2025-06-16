public class EstrelaFrente extends Movel{
    static double veolocity = 0.045;
    static double count = 0;

    public EstrelaFrente(){
        cord_x = Math.random() * GameLib.WIDTH;
        cord_y = Math.random() * GameLib.HEIGHT
    }

}



public class EstrelaTras extends Movel{
    static double veolocity = 0.07;
    static double count = 0;

    public EstrelaTras(){
        cord_x = Math.random() * GameLib.WIDTH;
        cord_y = Math.random() * GameLib.HEIGHT
    }
}
