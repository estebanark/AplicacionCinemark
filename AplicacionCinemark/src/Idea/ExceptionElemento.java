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
 * Este exception se genera cuando se quiere aderir una pelicula duplicada a la aplicacion
 * Se retorna un mensaje del error al nombre del elemento que esta causando el error.
 */

public class ExceptionElemento extends Exception{
    
    public ExceptionElemento(String nombreElemento){
        
        super(nombreElemento);
    }
}
