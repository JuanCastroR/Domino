/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino.core;

import domino.IU.ES;

/**
 *
 * @author Rosalia
 */
public class Jugador {
    private String nombre;
    private Ficha[] montoncito;
    private int numFichas;
    private int numPuntos;
    private int numPuntosPartida;
	
	
	public Jugador(String nom)
	{
		nombre = nom;
		numFichas = 0; //fichas que tiene el jugador en cada momento
		montoncito = new Ficha[28];
                numPuntos=0;
                numPuntosPartida=0;
		
	}
        public String getNombre()
	{
		return nombre;
	}
	
	private void añadirFicha(Ficha f)
	{
		montoncito[numFichas++] = f;
                numPuntos+=(f.getDerecha()+f.getIzquierda());
	}
	
	private void quitarFicha(Ficha f)
	{
		int i= 0;
				
		while (i < numFichas && !montoncito[i].equals(f))
		{					
			i++;
			
		}
                numPuntos-=(f.getDerecha()+f.getIzquierda());
                montoncito[i]=montoncito[numFichas-1];
                montoncito[numFichas-1]=null;
                numFichas--;
	}
	
	public int getNumFichas()
	{
		return numFichas;
	}
	
	public boolean soyGanador()
	{
		if (numFichas == 0) return true;
		else return false;
	}
	
	public void cogerFichaMonton(Monton mon)
	{
		int numFicha;
		Ficha f = null;
		numFicha = (int) (Math.random() * mon.getNumFich());
                f = mon.sacarFichaMonton(numFicha);
		añadirFicha(f);
	}
	
	public String toString()
	{
		String toRet = "\nFichas de "+getNombre()+" ";
		for (int i = 0; i<numFichas; i++)
		{
			toRet += montoncito[i].toString() + "   ";
		}
		toRet += "\n";
		return toRet;
	}
	
	private Ficha[] fichasPosibles(Tablero mesa){
            Ficha [] fichPosibles = new Ficha[numFichas];
            int j=0;
            
            for (int i=0; i<numFichas; i++){
                if (mesa.getFichasMesa()){
                    if (montoncito[i].getDerecha()==mesa.getFichaDerecha().getDerecha() ||
                            montoncito[i].getDerecha()==mesa.getFichaIzquierda().getIzquierda() ||
                            montoncito[i].getIzquierda()==mesa.getFichaDerecha().getDerecha() ||
                            montoncito[i].getIzquierda()==mesa.getFichaIzquierda().getIzquierda()){
                        fichPosibles[j++]=montoncito[i];
                    }
                } else if (montoncito[i].getDerecha()==montoncito[i].getIzquierda())
                        fichPosibles[j++]=montoncito[i];
            }
            return fichPosibles;     
           
        }
        public boolean colocarFicha(Tablero mesa)
	{
            Ficha [] posibles=fichasPosibles(mesa);
            int i=0;
            int numFichPosibles=0;
            //Visualizar las fichas posibles
            System.out.print("Fichas posibles para colocar: ");
            while (i<posibles.length && posibles[i]!=null){
                System.out.print(posibles[i++]+ "("+i+")");
                numFichPosibles++;
            }
            if (numFichPosibles > 0){
                int seleccionFicha;
            
                do{
                    seleccionFicha = ES.pideNumero(getNombre()+" indicame la Ficha seleccionada (1-"+numFichPosibles+")");	
                }while (seleccionFicha <= 0 || seleccionFicha > numFichPosibles);
		
		Ficha f = posibles[seleccionFicha-1];
                quitarFicha(f);
                mesa.añadirFicha(f);
                return true;
            } 
            else return false;
			
	}
        public int getNumPuntos(){
            return numPuntos;
        }
        
        public int getNumPuntosPartida(){
            return numPuntosPartida;
        }
        public void vacioMano(){
            numFichas = 0; //fichas que tiene el jugador en cada momento
	    montoncito = new Ficha[28];
            numPuntosPartida=0;
        }

}

