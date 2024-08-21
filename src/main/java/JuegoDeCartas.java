import java.util.Random;

public class JuegoDeCartas {
    public static void main(String[] args) {

    }






    //El metodo devuelve una matriz con las cartas de un jugador
    public static String[][] obtenerCartas(String[][] matrizBarajaCartas) {
        String[][] matrizJugador = new String[3][2];
        while (true) {
            int numeroRandom = obtenerNumeroRandom(12);
            if (matrizBarajaCartas[numeroRandom][0] != null) {
                matrizJugador[0][0]= matrizBarajaCartas[numeroRandom][0];
                matrizJugador[1][0]= matrizBarajaCartas[numeroRandom][1];
                eliminarCarta(numeroRandom, matrizBarajaCartas);
            }

            if (matrizBarajaCartas[3][0] != null){
                return matrizJugador;
            }
        }
    }
    //Este metodo elimina una carta de la baraja
    public static String[][] eliminarCarta(int numeroCarta, String[][] matrizBarajaCartas) {
        matrizBarajaCartas[numeroCarta][0]=null;
        matrizBarajaCartas[numeroCarta][1]=null;
        return matrizBarajaCartas;
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

    public static int obtenerNumeroRandom(int numeroMaximo){
        Random rand = new Random();
        return rand.nextInt(numeroMaximo);
    }
}
