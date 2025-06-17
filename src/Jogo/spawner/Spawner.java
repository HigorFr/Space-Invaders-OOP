package spawner;

import java.util.List;

import jogo.inimigos.Inimigo;
import jogo.util.Contexto;


public class Spawner {
    public static <T extends Inimigo> void spawn(InimigoFactory<T> fabrica, Contexto ctx) {
        long agora = ctx.getCurrentTime();
        T temp = fabrica.criar();

        if (temp.getNextEnemy() <= agora) {
            T novo = fabrica.criar();
            novo.configurarInicial(agora);
            destino.add(novo);
            ctx.adicionar(novo);
            temp.setNextEnemy(agora + intervalo);  
        }
    }
}   
