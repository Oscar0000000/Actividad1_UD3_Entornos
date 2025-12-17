/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor..
 */
package Actividad_01_UD3_ED;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author ana
 */
public class Actividad_01_UD3_ED 
{  
    private static byte[] intermedio = new byte[1000]; /**En esta parte he cambiado buffer, filename, inputStream, e inputfile*/
    private static String nombreArchivo = "fichero.dat";
    private static FileInputStream flujoEntrada = null;
    private static BufferedInputStream entradaIntermedia = null;

    public static void inicializarFicheros() throws FileNotFoundException
    {
        flujoEntrada = new FileInputStream(nombreArchivo); /**Aqui tambien he refactorizado los dos que podemos ver como podemos observar*/
        entradaIntermedia = new BufferedInputStream(flujoEntrada); /**Este documento nos permite iniciar el programa*/
    }
    
    public static int mostrarTextoFichero() throws IOException /**Y de nuevo aqui cambio tambien varias partes*/
    {
        int total = 0;
        int nLeido = 0;
        while((nLeido = flujoEntrada.read(intermedio)) != -1) 
        {
            System.out.println(new String(intermedio));
            total += nLeido;
        }
        
        return total;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        try 
        {
            inicializarFicheros                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ();
            
            int total = mostrarTextoFichero();           

            System.out.println("\nLeídos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( entradaIntermedia != null && flujoEntrada != null )
                {
                    flujoEntrada.close();
                    entradaIntermedia.close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }
    
}
