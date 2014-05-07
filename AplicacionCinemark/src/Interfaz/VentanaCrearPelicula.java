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

package Interfaz;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Esteban
 */
public class VentanaCrearPelicula extends JDialog{
    
    private InterfazCinemark principal;
    
    private PanelCrearPelicula panelDatos;
    private PanelBotonesPelicula panelBotones;
    
    public VentanaCrearPelicula( InterfazCinemark inicio )
    {
        super( inicio, true );
        principal = inicio;

        panelDatos = new PanelCrearPelicula( );
        panelBotones = new PanelBotonesPelicula( this );

        getContentPane( ).add( panelDatos, BorderLayout.CENTER );
        getContentPane( ).add( panelBotones, BorderLayout.SOUTH );

        setTitle( "Crear Pelicula�n" );
        pack( );
    }
    
    public void crearCancion( )
    {
        boolean parametersOk = true;
        double precio = 0;
        double duracion = 0;
        String nombre = panelDatos.getNombre( );
        String sipnosis = panelDatos.getSipnosis();
        String genero = panelDatos.getGenero();
        String idioma = panelDatos.getIdioma();
        String clasificacion = panelDatos.getClasificacion();
        String pais = panelDatos.getPais();
        String director = panelDatos.getDirector();
        String calidad = panelDatos.getCalidad();
        String imagen = panelDatos.getImagen();
        
        //Verificando campos...
        
        if( nombre.equals( "" ) )
        {
            parametersOk = false;
            JOptionPane.showMessageDialog( this, "Debe ingresar el nombre de la pelicula... " );
        }
        
        if( sipnosis.equals( "" ) )
        {
            parametersOk = false;
            JOptionPane.showMessageDialog( this, "Debe ingresar la sinopsis de la pelicula... " );
        }
        
        if( genero.equals( "" ) )
        {
            parametersOk = false;
            JOptionPane.showMessageDialog( this, "Debe ingresar el genero de la pelicula... " );
        }
        
        if( idioma.equals( "" ) )
        {
            parametersOk = false;
            JOptionPane.showMessageDialog( this, "Debe ingresar el idioma de la pelicula... " );
        }
        
        if( pais.equals( "" ) )
        {
            parametersOk = false;
            JOptionPane.showMessageDialog( this, "Debe ingresar el pais de la pelicula... " );
        }
        
        if( director.equals( "" ) )
        {
            parametersOk = false;
            JOptionPane.showMessageDialog( this, "Debe ingresar el nombre del director de la pelicula... " );
        }
        
        if( imagen.equals( "" ) )
        {
            parametersOk = false;
            JOptionPane.showMessageDialog( this, "Debe ingresar la direccion del archivo de la imagen... " );
        }
        
        try
        {
            precio = Double.parseDouble( panelDatos.getPrecio( ) );
            if( precio < 0 )
            {
                parametersOk = false;
                JOptionPane.showMessageDialog( this, "Debe ingresar el precio de la pelicula..." );
            }
        }
        catch( Exception e )
        {
            parametersOk = false;
            JOptionPane.showMessageDialog( this, "Debe ingresar el precio de la pelicula..." );
        }
        
         try
        {
            duracion = Double.parseDouble( panelDatos.getDuracion( ) );
            if( duracion < 0 )
            {
                parametersOk = false;
                JOptionPane.showMessageDialog( this, "Debe ingresar el precio de la pelicula..." );
            }
        }
        catch( Exception e )
        {
            parametersOk = false;
            JOptionPane.showMessageDialog( this, "Debe ingresar el precio de la pelicula..." );
        }
                
        if( parametersOk )
        {
            boolean ok = principal.crearPelicula( nombre, sipnosis, genero, idioma, clasificacion, duracion, pais,director, calidad, precio, imagen );
            if( ok )
                dispose( );
        }
    }
    
}
