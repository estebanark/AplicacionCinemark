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

import java.io.Serializable;

/**
 *Esta es la clase que representa una pelicula en la aplicacion
 */
public class Pelicula implements Serializable{
    
    
    private static final long serialVersionUID = 200L;
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

     // Es el titulo de la pelicula
    private String nombre;
    
    //Es la sinopsis de la pelicula
    private String sipnosis;
    
    //es el genero de la pelicula
    private String genero;
    
    //es el idioma de la pelicula
    private String idioma;
    
    //es la clasificacion de la pelicula
    private String clasificacion;
    
    //es la duracion de la pelicula
    private double duracion;
    
    //es la pais donde se hizo la pelicula
    private String pais;
    
    // es el nombre del director de la pelicua
    private String director;
    
    //es el tipo de calidad de la pelicula (3D, xtreme definition)
    private String calidad;
    
    //Nombre del archivo que contiene la imagen asociada con la cancion
    private String imagen;
    
    //es el precio de la pelicula
    private double precio;
    
    /**
     * Este contructor construye una nueva pelicula segun los datos que se le suministren
      * @param nombreP Es el titulo de la pelicula - tituloP != null o tituloP !=""
      * @param sipnosisP Es la sipnosis de la pelicula - sipnosisP != null o sipnosisP !=""
      * @param generoP Es el genero de la pelicula - generoP != null o generoP !=""
      * @param idiomaP Es el idioma de la pelicula - idiomaP != null o idiomaP !=""
      * @param clasificacionP Es la clasificacion de la pelicula - clasificacionP != null o clasificacionP !=""
      * @param duracionP Es la duracion de la pelicula - duracionP > 0
      * @param paisP Es el pais de la pelicula - paisP != null o paisP !=""
      * @param directorP Es el director de la pelicula (3d o xtreme definition)- directorP != null o directorP !=""
      * @param calidadP Es la calidad de la pelicula - calidadP != null o calidadP !=""
      * @param imagenP Es la imagen o caratula de la pelicula - imagenP != null o imagenP !=""
      * @param precio Es el precio de la pelicula - precio > 0
     */
    public Pelicula( String nombreP, String sipnosisP, String generoP, String idiomaP, String clasificacionP, double duracionP, String paisP, String directorP, String calidadP, double precioP, String imagenP )
    {
        nombre = nombreP;
        sipnosis = sipnosisP;
        genero = generoP;
        idioma = idiomaP;
        clasificacion = clasificacionP;
        duracion = duracionP;
        pais = paisP;
        director = directorP;
        calidad = calidadP;
        precio = precioP;
        imagen = imagenP;

        verificar( );
    }
    
    //---------------------
    // metodos
    //--------------------- 
    
    /**
     * Este metodo retorna el titulo de la pelicula
     * @return Titulo de la pelicua
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Este metodo retorna el precio de una pelicula
     * @return 
     */
    public double getPrecio() {
        return precio;
    }
    
    /**
     * Este metodo retorna la sipnosis de la pelicula
     * @return Titulo de la pelicua
     */
    public String getSipnosis() {
        return sipnosis;
    }
    
    /**
     * Este metodo retorna el genero de la pelicula
     * @return Genero de la pelicua
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Este meodo retorna el idioma de la pelicula
     * @return idioma de la pelicula
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * Este metodo retorna la clasificacion de la pelicula
     * @return Clasificacion de la pelicula.
     */
    public String getClasificacion() {
        return clasificacion;
    }

    /**
     * Este metodo retorna la duracion en minutos de la pelicla
     * @return Duracion de la pelicula - double
     */
    public double getDuracion() {
        return duracion;
    }

    /**
     * Este metodo retorna el pais donde se hizo la pelicula
     * @return Pais de la pelicula
     */
    public String getPais() {
        return pais;
    }

    /**
     * Este metodo retorna el nombre del director de la pelicula
     * @return Director de la pelicula
     */
    public String getDirector() {
        return director;
    }

    /**
     * Retorna la calidad de la pelicula
     * @return Calidad de la pelicula
     */
    public String getCalidad() {
        return calidad;
    }

    /**
     * Este metodo retorna la imagen o caratula de la pelicula
     * @return Imagen o caratula de la pelicula
     */
    public String getImagen() {
        return imagen;
    }
    
    /**
     * Metodo que inica si la pelicula tiene el nombre que llega como parametro
     * @param nombrePelicula nombre de la pelicula - nombrePelicula !=null
     * @return Verdadero si la pelicula tiene el mismo nombre que llega como parametro
     */
    public boolean equals( String nombrePelicula )
    {
        return nombre.equalsIgnoreCase( nombrePelicula );
    }
    
    /**
     * Verifica que no se admita las variaciones que afectan a otras partes del misma clase.
     *titulo != null && !titulo.equals( "" ), 
     *sipnosis != null && !sipnosis.equals(""), 
     *genero != null && !genero.equals( "" ) , 
     *idioma != null && !idioma.equals( "" ) , 
     *clasificacion != null && !clasificacion.equals( "" ), 
     *duracion > 0 , 
     *pais != null && !pais.equals( "" ), 
     *director != null && !director.equals( "" ) , 
     *calidad != null && !calidad.equals( "" ) , 
     *imagen != null && !imagen.equals( "" ) , 
     * 
     */
    private void verificar(){
        assert nombre != null && !nombre.equals( "" ) : "El titulo es invalido, esta vacio";
        assert sipnosis != null && !sipnosis.equals(""): "El titulo es invalido, esta vacio";
        assert genero != null && !genero.equals( "" ) : "El genero es invalido, esta vacio";
        assert idioma != null && !idioma.equals( "" ) : "El titulo es invalido, esta vacio";
        assert clasificacion != null && !clasificacion.equals( "" ) : "El titulo es invalido, esta vacio";
        assert duracion > 0 : "La duracion debe ser positiva";
        assert pais != null && !pais.equals( "" ) : "El titulo es invalido, esta vacio";
        assert director != null && !director.equals( "" ) : "El titulo es invalido, esta vacio";
        assert calidad != null && !calidad.equals( "" ) : "El titulo es invalido, esta vacio";
        assert imagen != null && !imagen.equals( "" ) : "El titulo es invalido, esta vacio";
        assert precio > 0 : "El precio debe ser mayor a cero";
    }
    
    
    
    
}
