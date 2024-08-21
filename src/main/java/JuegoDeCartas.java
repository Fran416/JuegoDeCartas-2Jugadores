import java.util.Scanner;

public class JuegoDeCartas {
    public static void main(String[] args) {
        String[][] matriz= inicializarCartasJuego();
        for (int fila=0; fila<matriz.length; fila++){
            System.out.println(matriz[fila][0]);
        }
    }


    //Esta funcion inicializa la baraja de cartas, generando la baraja para poder jugar
    public static String[][] inicializarCartasJuego() {
        String[][] matrizBarajaCartas = crearMatrizCartas();
        agregarCartas("As","11",matrizBarajaCartas);
        agregarCartas("Dos","2",matrizBarajaCartas);
        agregarCartas("Tres","3",matrizBarajaCartas);
        agregarCartas("Cuatro","4",matrizBarajaCartas);
        agregarCartas("Cinco", "5", matrizBarajaCartas);
        agregarCartas("Seis", "6", matrizBarajaCartas);
        agregarCartas("Siete", "7", matrizBarajaCartas);
        agregarCartas("Ocho", "8", matrizBarajaCartas);
        agregarCartas("Nueve", "9", matrizBarajaCartas);
        agregarCartas("Jota", "10", matrizBarajaCartas);
        agregarCartas("Queen", "11", matrizBarajaCartas);
        agregarCartas("King", "12", matrizBarajaCartas);
        return matrizBarajaCartas;

    }
    //Este metodo crea la matriz base para la baraja
    public static String[][] crearMatrizCartas(){
        String[][] matrizCartas = new String[12][2];
        return matrizCartas;
    }
    //Este metodo rellena la baraja de cartas con unas predefinidas

    public static String[][] agregarCartas(String nombreCarta, String puntaje, String[][] matrizCartas){
        for(int fila=0; fila<12; fila++ ) {
            if (matrizCartas[fila][0] == null) {
                matrizCartas[fila][0] = nombreCarta;
                matrizCartas[fila][1] = puntaje;
                return matrizCartas;
            }
        }

        return matrizCartas;
    }
}
