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
* Esta exception se genera cuando hay un error al leer o escribir el archivo binario con la informacion con el estado de la aplicacion
* Esto retorna un mensaje escribiendo el problema que se presento
*/
public class ExceptionPerseverancia extends Exception{
    
    public ExceptionPerseverancia( String causaDelError )
    {
        super( causaDelError );
    }
}
