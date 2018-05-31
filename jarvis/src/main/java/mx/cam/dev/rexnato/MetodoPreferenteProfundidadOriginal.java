package mx.cam.dev.rexnato;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Scanner;


class Estado
{
   
    public ArrayList<Estado> EstadosVecinos = new ArrayList<Estado>();
    public String nombre;
    public boolean visitado=false;
     
// public Estado ev1, ev2, ev3, ev4;
    // Método para imprimir los datos del objeto
    
    

    public void Imprimir() {
        Estado estadoVecino;
        System.out.println();
        //System.out.println("\n");
        System.out.println("______________________________");
        
        System.out.println("Nombre: " + nombre);
        System.out.println("Estados vecinos:");
        for (int x =0; x < EstadosVecinos.size(); x++)
        {
            estadoVecino =EstadosVecinos.get(x); 
            System.out.println(estadoVecino.nombre);
            //System.out.println(EstadosVecinos.get(x).nombre);
        }
    }
        
}

class EspacioEstados
{  // Paso 1. Crear objetos
    //Objeto 1
    Estado Obj_Oradea = new Estado();
    //Objeto 2
    Estado Obj_Zerind= new Estado();
    //Objeto 3
    Estado Obj_Arad = new Estado();
    //Objeto 4
    Estado Obj_Sibu = new Estado();
    //Objeto 5
    Estado Obj_Fagaras = new Estado();
   
    
    //Constructor de la clase
    public EspacioEstados() {
        // Paso 2. Asignar nombre a cada objeto estado
      Obj_Arad.nombre = "Arad";      
      Obj_Fagaras.nombre = "Fagaras";      
      Obj_Oradea.nombre = "Oradea";
      Obj_Sibu.nombre = "Sibu";
      Obj_Zerind.nombre = "Zerind";
      
      //Paso 3. Conexión entre estados
      Obj_Oradea.EstadosVecinos.add(Obj_Zerind);
      Obj_Oradea.EstadosVecinos.add(Obj_Sibu);
      
      
      Obj_Zerind.EstadosVecinos.add(Obj_Arad);
      Obj_Zerind.EstadosVecinos.add(Obj_Oradea);
      /*int totalEstadosVecinos;
      totalEstadosVecinos = Obj_Arad.EstadosVecinos.size();*/
      Obj_Sibu.EstadosVecinos.add(Obj_Oradea);
      Obj_Sibu.EstadosVecinos.add(Obj_Arad);
      Obj_Sibu.EstadosVecinos.add(Obj_Fagaras);
      
      Obj_Arad.EstadosVecinos.add(Obj_Sibu);
      Obj_Arad.EstadosVecinos.add(Obj_Zerind);
      
      Obj_Fagaras.EstadosVecinos.add(Obj_Sibu);             
      
    }   
   
}

class Nodo{
    public int Padre;
    public String nombre;
    //public ArrayList<Integer> hijos = new ArrayList<Nodo>();
}

public class MetodoPreferenteProfundidadOriginal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Crear el objeto del espacio de estados
        EspacioEstados espacioEstadosMapaRumania = new EspacioEstados();
        espacioEstadosMapaRumania.Obj_Arad.Imprimir();
        espacioEstadosMapaRumania.Obj_Fagaras.Imprimir();
        espacioEstadosMapaRumania.Obj_Oradea.Imprimir();
        espacioEstadosMapaRumania.Obj_Sibu.Imprimir();
        espacioEstadosMapaRumania.Obj_Zerind.Imprimir();
        
        int opcion;
        String c;
        Scanner s = new Scanner(System.in);
        Estado estadoInicial = new Estado();
        Estado estadoFinal = new Estado();
        
        System.out.println("Selecciona una ciudad de inicio");
        System.out.println("1. Arad");
        System.out.println("2. Fagaras");
        System.out.println("3. Oradea");
        System.out.println("4. Sibiu");
        System.out.println("5. Zerind");        
        do {       
            c=s.nextLine();
            opcion = Integer.parseInt(c);
            
            switch(opcion)
            {
                case 1:
                 System.out.println("Arad");
                 estadoInicial = espacioEstadosMapaRumania.Obj_Arad;
                break;
                case 2:
                 System.out.println("Fagaras");
                 estadoInicial = espacioEstadosMapaRumania.Obj_Fagaras;
                break;
                case 3:
                 System.out.println("Oradea");
                 estadoInicial = espacioEstadosMapaRumania.Obj_Oradea;
                break;
                case 4:
                 System.out.println("Sibiu");
                 estadoInicial = espacioEstadosMapaRumania.Obj_Sibu;
                break;
                case 5:
                 System.out.println("Zerind");
                 estadoInicial = espacioEstadosMapaRumania.Obj_Zerind;
                break;                
                default:
                    System.out.println("Incorrecto");
            }   
        } while (opcion<=0 || opcion>5);
        
        
        System.out.println("Selecciona una ciudad destino");
        System.out.println("1. Arad");
        System.out.println("2. Fagaras");
        System.out.println("3. Oradea");
        System.out.println("4. Sibiu");
        System.out.println("5. Zerind");        
        do {       
            c=s.nextLine();
            opcion = Integer.parseInt(c);
            
            switch(opcion)
            {
                case 1:
                 System.out.println("Arad");
                 estadoFinal = espacioEstadosMapaRumania.Obj_Arad;
                break;
                case 2:
                 System.out.println("Fagaras");
                 estadoFinal = espacioEstadosMapaRumania.Obj_Fagaras;
                break;
                case 3:
                 System.out.println("Oradea");
                 estadoFinal = espacioEstadosMapaRumania.Obj_Oradea;
                break;
                case 4:
                 System.out.println("Sibiu");
                 estadoFinal = espacioEstadosMapaRumania.Obj_Sibu;
                break;
                case 5:
                 System.out.println("Zerind");
                 estadoFinal = espacioEstadosMapaRumania.Obj_Zerind;
                break;             
                
                default:
                    System.out.println("Incorrecto");
            }   
        } while (opcion<=0 || opcion>5);
        
        ArrayList<Nodo> arbol = new ArrayList<Nodo>();
        ArrayList<Estado> fila = new ArrayList<Estado>();
        
        int posicion=0;
        boolean pruebaMeta = false;
        
        if (estadoInicial.nombre == estadoFinal.nombre)
        {
            System.out.println("No hay ruta, ya estas en el estado meta");
        }
        else
        {
            // _____________________ Inicia el algoritmo _______________________
            Estado estadoActual = new Estado();
            fila.add(estadoInicial);
            
            while ( fila.isEmpty()== false && pruebaMeta == false )
            {
                    estadoActual = fila.get(0);
                    fila.remove(0);
                    estadoActual.visitado= true;
                    Nodo nodoActual = new Nodo();
                                      
                     
                    if (arbol.isEmpty()) // el nodo que se creará es la raíz
                    { 
                        nodoActual.nombre = estadoActual.nombre; 
                        nodoActual.Padre = -1; 
                        arbol.add(nodoActual); 
                        posicion = arbol.size()-1;                    
                    } 
                    else // localizo el nodo en el árbol 
                    {
                       for ( int x= 0; x < arbol.size(); x++)
                       {
                           if (arbol.get(x).nombre == estadoActual.nombre)
                           {
                               posicion = x;
                              break;
                           }
                           
                       }
                    }       
                    
                    
                    //Insertar en la fila y en el árbol los hijos del estado actual 
                    
                    for (int x=0; x < estadoActual.EstadosVecinos.size(); x++)
                    {
                        if(estadoActual.EstadosVecinos.get(x).visitado == false)
                        {
                             fila.add(estadoActual.EstadosVecinos.get(x));
                            Nodo nodoHijo = new Nodo();
                            nodoHijo.nombre = estadoActual.EstadosVecinos.get(x).nombre;
                            nodoHijo.Padre = posicion;
                            arbol.add(nodoHijo);    
                            if (nodoHijo.nombre ==estadoFinal.nombre)
                            {    pruebaMeta = true;
                                 break;
                            }
                            
                        }                      
                       
                    }
                  
            }
            
            
        }
       
        
    // Imprimo el árbol

     for (int x=0; x < arbol.size(); x++)
     {
         System.out.println("posicion: " + x + " Nombre: " + arbol.get(x).nombre + " Padre: " + arbol.get(x).Padre);
     }
     
     
     /*
      Continua el código para encontrar la ruta........
     */
        
    }
    
}
