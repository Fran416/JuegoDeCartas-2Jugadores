import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class JuegoDeCartas {
    public static void main(String[] args) {
        menuPrincipal();

    }
    //Metodos del menu
    public static void menuPrincipal(){

        System.out.println("------------ MenuPrincipal ------------");
        System.out.println("1. Jugar");
        System.out.println("2. Salir");
        boolean variableAuxiliar = true;
        while (variableAuxiliar){
            variableAuxiliar = accionesMenu();

        }
    }

    public static boolean accionesMenu() {
        int seleccionUsuario = seleccionUsuario();
        switch (seleccionUsuario) {
            case 1:
                String [][] barajaCartas = inicializarCartasJuego();
                String [][] cartasPrimerJugador = obtenerCartas(barajaCartas);
                String [][] cartasSegundoJugador = obtenerCartas(barajaCartas);
                mostrarResultadoFinal(cartasPrimerJugador, cartasSegundoJugador);
                return true;
            case 2:
                return false;

        }
    }
    //Este metodo comprueba la seleccion del usuario y que cumpla los requisitos necesarios
    public static int seleccionUsuario(){
        int numeroOpciones = 2; //Valor modificable segun las opciones establecidas
        while (true) {
            int seleccionUsuario=0;
            try {
                seleccionUsuario = obtenerEntero();
                if (seleccionUsuario>0 && seleccionUsuario<=numeroOpciones){
                    return seleccionUsuario;
                }else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Opcion Invalida!");
            }
        }
    }


    public static int obtenerEntero(){
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }
    //Fin metodos del menu


    public static void mostrarResultadoFinal(String[][] matrizPrimerJugador, String[][] matrizSegundoJugador) {
        int puntajePrimerJugador = obtenerPuntaje(matrizPrimerJugador);
        int puntajeSegundoJugador = obtenerPuntaje(matrizSegundoJugador);
        if (puntajePrimerJugador>20 && puntajeSegundoJugador>20){
            System.out.println("Ambos jugadores pierden");
            System.out.println("Puntaje jugador 1:"+puntajePrimerJugador);
            System.out.println("Puntaje jugador 2:"+puntajeSegundoJugador);
        } else if (puntajePrimerJugador > 20) {
            System.out.println("El jugador 2 Gano");
            System.out.println("Puntaje jugador 1:"+puntajePrimerJugador);
            System.out.println("Puntaje jugador 2:"+puntajeSegundoJugador);
        } else if (puntajeSegundoJugador > 20) {
            System.out.println("El jugador 1 Gano");
            System.out.println("Puntaje jugador 1:"+puntajePrimerJugador);
            System.out.println("Puntaje jugador 2:"+puntajeSegundoJugador);
        } else if (puntajePrimerJugador>puntajeSegundoJugador) {
            System.out.println("El jugador 1 Gano");
            System.out.println("Puntaje jugador 1:"+puntajePrimerJugador);
            System.out.println("Puntaje jugador 2:"+puntajeSegundoJugador);
        } else {
            System.out.println("El jugador 2 Gano");
            System.out.println("Puntaje jugador 1:"+puntajePrimerJugador);
            System.out.println("Puntaje jugador 2:"+puntajeSegundoJugador);
        }
    }
    public static int obtenerPuntaje(String[][] matrizJugador){
        int primerPuntaje = Integer.parseInt(matrizJugador[0][1]);
        int segundoPuntaje = Integer.parseInt(matrizJugador[1][1]);
        int tercerPuntaje = Integer.parseInt(matrizJugador[2][1]);
        int puntajeFinal = sumarPuntaje(primerPuntaje,segundoPuntaje,tercerPuntaje);
        return puntajeFinal;
    }


    public static int sumarPuntaje(int primeraCarta, int segundaCarta, int terceraCarta){
        return primeraCarta + segundaCarta + terceraCarta;
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
