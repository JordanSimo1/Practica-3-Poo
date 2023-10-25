import java.util.Scanner; 
/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MainParaJugar
{
    static public void main(String []args ){
        System.out.println("Ingrese el numero de jugadores:");
        Scanner lecturaInt = new Scanner(System.in);
        int jugadores = lecturaInt.nextInt();
        System.out.println("ingrese la puntuacion para ganar:");
        int puntos = lecturaInt.nextInt();
        
        boolean ganador =false;
        Juego juego = new Juego(jugadores);
        do{
        Boneyard boneyard  = new Boneyard(juego.getMula());
        juego.inicar(boneyard);
        Tablero tablero =new Tablero();
        boolean fin=false, vacio =false;
        do {
            int numFich;
            boolean si =false, mula =false;
            do{
            si =false;
            tablero.mostrarMesa();
            System.out.println("");
            juego.getJugador();
            System.out.println("\n"+"selecciones la ficha a poner");
            numFich = lecturaInt.nextInt();
                if(juego.comprobar(tablero, numFich)) {
                    juego.ponerFicha(tablero, numFich);
                    if (tablero.getValorUltimaFIcha().getValor1()==tablero.getValorUltimaFIcha().getValor2()) mula=true;
                    else si =true;
                } else {
                    if (boneyard.getFichas() != 0){
                        System.out.println("comer [1]si / [0]no");
                        if(lecturaInt.nextInt()==1){
                        juego.comerFicha(boneyard.tomarFicha());
                            
                        } 
                        else{
                            if(mula) si = true;
                            else si = false;
                        }
                    } else{
                        vacio = true;
                        si = true;
                     }  
                }
            }while(!si);  //fin del turno 
            if(juego.sinFIchas() ) fin = true;
            else if (!juego.seguirJugando(tablero) && vacio) fin = true;
            else juego.siguienteTurno();
            mula =false;
    } while (!fin);     // fin de la ronda 
    juego.calcularPuntos();
    ganador = juego.ganador(puntos);
    juego.verPuntos();
    juego.siguienteRonda(tablero);
    } while (!ganador);    // fin del juego    
    System.out.println("a");
    }
}
