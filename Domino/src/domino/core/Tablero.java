/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino.core;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 *
 * @author Rosalia
 */
public class Tablero {
	private Deque<Ficha> tablero;
	
	
	
	public Tablero()
	{
		tablero = new ArrayDeque<Ficha>(28);
		
	}
	
	public void añadirFicha(Ficha f)
	{
		// la primera vez que se introduce una ficha
		if (tablero.isEmpty()) {
			tablero.addLast(f);
			
		}
		
                else if (tablero.getLast().getDerecha() == f.getIzquierda()) 
			{
			tablero.addLast(f);
			
			}
                else if (tablero.getLast().getDerecha() == f.getDerecha()) 
		{
			//Le damos la vuelta a la ficha
                        f.girar();
			System.out.println("Girando Ficha...");
                        tablero.addLast(f);
			
		}
                else if (tablero.getFirst().getIzquierda() == f.getDerecha()) 
			{
			   tablero.addFirst(f);
			   
			}
                else if (tablero.getFirst().getIzquierda() == f.getIzquierda()) 
		{
		   //Le damos la vuelta a la ficha
                    f.girar();
                    System.out.println("Girando Ficha...");
                    tablero.addFirst(f);
		    
		}
		
			
	}
	
	public String toString()
	{
		Iterator<Ficha> it = tablero.iterator();
		String toRet = "\nFichas en la Mesa ";
		while (it.hasNext())
		   toRet += it.next()+" ";
		toRet += "\n";
		return toRet;
	}
	
	public Ficha getFichaDerecha()
	{
		return tablero.getLast();
	}
	
	public Ficha getFichaIzquierda()
	{
		return tablero.getFirst();
	}
	
	
	public boolean getFichasMesa()
	{
		return !tablero.isEmpty();
	}
  
}

