/*
 * **************************************************************
 * Proyecto Cinemark - Programacion 4
 * Aplicacion que administra los teatros y sus peliculas asociadas.
 * @author Elvis Esteban Aragon Castaño
 * Código: 1115077569
 * @version 1.0
 * Universidad Tecnologica de Pereira - 2014
 * **************************************************************
 */

package Idea;

/**
 * Esta exception se genera  y sirve para indicar si se genera un error al procesar el archivo al momento de hacer el tiquet
 */
public class ExceptionArchivo extends Exception {
    
    /**
     * Este constructor construye la exception como un error.
     * @param causa El mensaje que describe el problema que se presento
     */
    public ExceptionArchivo( String causaError)
    {
        super( causaError );
        
    }
    
}
