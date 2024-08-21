import java.util.Scanner;
import java.util.Random;


public class JuegoDeCartas {


    //Esta funcion inicializa la baraja de cartas, generando la baraja para poder jugar
    public static String[][] inicializarCartasJuego() {
        matrizBarajaCartas = crearMatrizCartas();
        agregarCartas(matrizBarajaCartas)
        return matrizBarajaCartas

    }
    //Este metodo crea la matriz base para la baraja
    public static String[][] crearMatrizCartas(){
        String[][] matrizCartas = new String[12][2];
        return matrizCartas;
    }
    //Este metodo rellena la baraja de cartas con unas predefinidas

    public static String[][] agregarCartas(String nombreCarta, String puntaje, String[][] matrizCartas){
        for(int fila=0; fila<12; fila++ ){
            matrizCartas[fila][0] = nombreCarta;
            matrizCartas[fila][1] = puntaje;
        }
        return matrizCartas;
    }
}
