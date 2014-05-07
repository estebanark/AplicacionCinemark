/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */

package Idea;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Esteban
 */
public class Teatro implements Serializable{
    
    private static final long serialVersionUID = 100L;
    
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    
    // Es el vector con las canciones del disco
    private ArrayList peliculas;

    private String titulo;
    
    //Es la direccion del teatro
    private String direccion;
    
    // Es el telefono del teatro
    private String telefono;
    
    //Nombre del archivo que contiene la imagen asociada con el disco
    private String imagen;
    
    /**
     * Contruye un nuevo teatro con los datos suministrados pero sin peliculas
     * @param tituloT es el titulo del teatro - tituloT != null, tituloT != ""
     * @param direccionTes la direccion del teatro- direccionTes != null, direccionTes != ""
     * @param telefonoT es el telefono del teatro- telefonoT != null, telefonoT != ""
     * @param imagenT  es la imagen del teatro - imagenT != null, imagenT != ""
     */
     public Teatro( String tituloT, String direccionT, String telefonoT, String imagenT )
    {
        peliculas = new ArrayList( );
        titulo = tituloT;
        direccion = direccionT;
        telefono = telefonoT;
        imagen = imagenT;
        //precioTotal = 0;

        verificar( );
    }
     
     /**
     * Metodo que retorna una pelicula dependiendo de su nombre
     * @param nombreP Es el nombre de la pelicula a buscar - tituloP !=null;
     * @return La pelicula cuyo nombre es igual al nombre dado en el parametro. Si no lo encuentra retorna NULL
     */
      public Pelicula getPelicula( String nombreP )
      {
        for( int i = 0; i < peliculas.size( ); i++ )
        {
            Pelicula p = ( Pelicula )peliculas.get( i );
            if( p.equals( nombreP ) )
                return p;
        }
        return null;
      }
      
     /**
     * Agrega una pelicula al teatro
     * @param c la nueva pelicula que se va a agregar al teatro
     */
      public void agregarPelicula( Pelicula p ) throws ExceptionElemento
      {
        if( getPelicula( p.getNombre()) != null )
            throw new ExceptionElemento( "La pelicula " + p.getNombre()+ " ya existe en el disco" );

        peliculas.add( p );
        //precioTotal += c.getTitulo();

        verificar( );
      }

    /**
     * Retorna el titulo del teatro
     * @return Titulo del teatro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Retorna la direccion del teatro
     * @return Direccion del teatro
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Retorna el telefono del teatro
     * @return Telefono del teatro
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Retorna nombre del archivo que tiene la imagen del teatro
     * @return Nombre del archivo que tiene la imagen del teatro
     */
    public String getImagen() {
        return imagen;
    }
    
    /**
    *  Retorna un vector con los nombres de las peliculas del teatro
    * @return vector con los nombres de las peliculas
    */
    
    public ArrayList getNombresPeliculas( )
    {
        ArrayList nombresPeliculas = new ArrayList( );
        for( int i = 0; i < peliculas.size( ); i++ )
        {
            Pelicula c = ( Pelicula )peliculas.get( i );
            nombresPeliculas.add( c.getNombre());
        }
        return nombresPeliculas;
    }
    
    /**
     * Metodo que indica si el teatro tiene el nombre que llega desde el parametro
     * @param nombre es el nombre de un teatro
     * @return  Verdadero si el tatro tiene un mismo nombre que llega como parametro
     */
    public boolean equals( String nombre )
    {
        return titulo.equalsIgnoreCase( nombre );
    }
    
    
    /**
     * Verifica que no se admita las variaciones que afectan a otras partes del misma clase.
     * peliculas != null 
     * titulo != null && titulo != "" 
     * direccion != null && direccion != "" 
     * telefono != null && telefono != "" 
     * imagen != null && imagen != "" 
     */
    private void verificar(){
        assert peliculas !=null: "La lista de peliculas esta vacia";
        assert titulo != null && !titulo.equals( "" ) : "El titulo es invalido, esta vacio";
        assert direccion != null && !direccion.equals( "" ) : "La direccion es invalida, esta vacio";
        assert telefono != null && !telefono.equals( "" ) : "El telefono es invalido, esta vacio";
        assert imagen != null && !imagen.equals( "" ) : "El nombre del archivo de imagen es erroneo";  
    }
 
    //    @Override
//    public String toString() {
//        return "Disco{" + "canciones=" + canciones + ", titulo=" + titulo + ", direccion=" + direccion + ", telefono=" + telefono + ", imagen=" + imagen + ", precioTotal=" + precioTotal + '}';
//    }
//    
//    
//       public static void main(String[] args) {
//        
//        
//        Disco t = new Disco("Cinemark parque Arboleda","Avenida circunvalar","23332322","imageb");
//        Cancion p = new Cancion("Capitan america 2","Tras los devastadores acontecimientos ocurridos",
//                                    "Acción","Doblada al español","7 años", 6, 
//                "USA", "Anthony Russo", "3D", 123, "hello");
//        
//        ArrayList a = new ArrayList();
//       
//       
//    
//        System.out.println(t.toString());
//    }
}
