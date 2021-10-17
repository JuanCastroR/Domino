/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino.IU;

import domino.core.Ficha;
import domino.core.Jugador;
import domino.core.Monton;
import domino.core.Tablero;

/**
 *
 * @author Rosalia
 */
public class Domino {
    private static Jugador[] jugadores;
    
    private static void crearJugadores(){
      int numJugadores;
		
        System.out.println("\n----------------------- DOMINO -----------------");
		
	do{
            numJugadores = ES.pideNumero("\nDime cuantos jugadores participan (2 a 4): ");
			
	}while (numJugadores < 2 || numJugadores > 4);
		
	jugadores = new Jugador[numJugadores];
		
	for (int i = 0; i < numJugadores; i++)
	{
            System.out.print("\nJugador " +i);
            jugadores[i] = new Jugador(ES.pideCadena(" Dime tu nombre : "));
	}  
    }

    public static void inicioJuego(Monton monton){
        
        
        System.out.println("\n Comienza el juego ..........\n");
	// Reparto de fichas
		
	for (int i = 0; i < jugadores.length; i++)
	{
		jugadores[i].vacioMano();
                System.out.println("\nJugador " +jugadores[i].getNombre() + " coge fichas del montón");
		for (int j = 0; j < 7; j++)
		{
			jugadores[i].cogerFichaMonton(monton);
		}
					
	}
    }
    
    private static void comprobarGanador(boolean hayTablas, Jugador jugadorActivo){
     if (! hayTablas) //Algun jugador ha colocado todas las fichas
		
	System.out.println("\nEl ganador ha sido "+jugadorActivo.getNombre());
		
        else {
			// Gana el que tenga menor número de puntos.
			int menorNumeroPuntos = Integer.MAX_VALUE;
			String ganador = "";
			for (int i = 0; i<jugadores.length; i++)
			{
				int numPunt = jugadores[i].getNumPuntosPartida();
				if (menorNumeroPuntos > numPunt) {
					menorNumeroPuntos = numPunt;
					ganador = jugadores[i].getNombre();
				}
			}
			
			System.out.println("\nEl ganador en esta partida por tener menor número de puntos es "+ganador);
			
			
		}   
    }
    
    private static void comprobarGanadorFinal(){
     // Gana el que tenga menor número de puntos.
	int menorNumeroPuntos = Integer.MAX_VALUE;
	String ganador = "";
	for (int i = 0; i<jugadores.length; i++)
	{
            int numPunt = jugadores[i].getNumPuntos();
            if (menorNumeroPuntos > numPunt) {
		menorNumeroPuntos = numPunt;
		ganador = jugadores[i].getNombre();
            }
	}
			
	System.out.println("\nEl ganador del juego es "+ganador + " con "+menorNumeroPuntos+" puntos");
			
			
		   
    }
    
    public static void inicioPartida() {
		
         crearJugadores();
         char seguir='n';
         do{
		Tablero mesaJ = new Tablero();
		Monton monton = new Monton();
                
		
		inicioJuego(monton);
			
		int jugadorActivo=-1;
		boolean hayTablas = false;
		int contadorTablas = 0;
		boolean colocarF = false;
		
		do {
			colocarF = false;
			jugadorActivo = (jugadorActivo+1)%jugadores.length;
			
			System.out.println(jugadores[jugadorActivo]);
			
			System.out.println(mesaJ);
			do{							 	
                            if (!jugadores[jugadorActivo].colocarFicha(mesaJ)){
                                if (monton.getNumFich()>0)  {  
                                    System.out.println("Robando ficha.....");
                                    jugadores[jugadorActivo].cogerFichaMonton(monton);
                                }
                            }else colocarF=true;
                            
                        }while (!colocarF && monton.getNumFich()>0);				
			// Comprobar que algun jugador continua jugando y no hay tablas
			if (colocarF) contadorTablas = 0;
			else if (monton.getNumFich() == 0) 
				 {
				    	contadorTablas ++;
				    	if (contadorTablas == jugadores.length) hayTablas = true;
				}
		
		}while (!jugadores[jugadorActivo].soyGanador() && ! hayTablas);
                seguir=ES.pideCadena("¿Quieres jugar otra partida? (S/N) ").toLowerCase().charAt(0);
                comprobarGanador(hayTablas,jugadores[jugadorActivo]);
         }while (seguir=='s');
		
                comprobarGanadorFinal();
		
	}
    
}
