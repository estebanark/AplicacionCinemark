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

import Idea.*;
import Idea.ExceptionElemento;
import Idea.ExceptionPerseverancia;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Es la clase principal de la interfaz de la aplicacion Cinemark
 */

public class InterfazCinemark extends JFrame{
    
    private JLabel imagen;

    private static final String RUTA_FACTURAS = "./data/facturas";

    private Cinemark cinemark;

    private Teatro teatroSeleccionado;
   
    //private PanelImagen panelImagen;
    
    private PanelTeatros panelTeatros;
    
    private PanelDatosPeliculas panelDatosPeliculas;
    
    private PanelAutor panelAutor;
    
    public InterfazCinemark( Cinemark d )
    {
        cinemark = d;

        // Panel con el logo de cinemark
//        panelImagen = new PanelImagen( );
//        add( panelImagen, BorderLayout.NORTH );

        //panel central que contiene toda la informacion sobre las peliculas, teatros, etc
        JPanel panelCentral = new JPanel( new BorderLayout( ) );
        add( panelCentral, BorderLayout.CENTER );

        //agrega el panelTeatro a el panelCentral
        panelTeatros = new PanelTeatros( this, cinemark.getTeatros( ) );
        panelCentral.add( panelTeatros, BorderLayout.CENTER );

        panelDatosPeliculas = new PanelDatosPeliculas( this );
        panelCentral.add( panelDatosPeliculas, BorderLayout.EAST );

        ArrayList teatros = cinemark.getTeatros();
        if( teatros.size( ) > 0 )
        {
            cambiarTeatroSeleccionado( ( ( String )teatros.get( 0 ) ) );
        }

//        panelPedido = new PanelPedido( this );
//        panelCentral.add( panelPedido, BorderLayout.SOUTH );

        // Panel inferior con los botones para las extensiones del ejercicio
        panelAutor = new PanelAutor( this );
        add( panelAutor, BorderLayout.SOUTH );

        setTitle( "Bienvenidos - CINEMARK" );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        pack( );
    }
    
//    --------------------------------------
//    METODOS
//    --------------------------------------
    
    /**
     * Este metodo cambia el teatro seleccionado en el panel de los detalles del teatro
     * @param nombreTeatro  es el nombre del teatro a la cual se quieren mostrar los detalles
     */
    public void cambiarTeatroSeleccionado( String nombreTeatro )
    {
        teatroSeleccionado = cinemark.getTeatro( nombreTeatro );
        panelTeatros.cambiarTeatro( teatroSeleccionado );
        panelDatosPeliculas.cambiarTeatro(teatroSeleccionado);
    }
    
    /**
     * Este metodo abre la ventana para agregar un nuevo teatro a la aplicacion
     */
    public void mostrarVentanaAgregarTeatro( )
    {
        VentanaCrearTeatro ventanaT = new VentanaCrearTeatro( this );
        ventanaT.setLocationRelativeTo( this );
        ventanaT.setVisible( true );
    }
    
    /**
     * Metodo que abre la ventana para agregar una nueva pelicula
     */
    public void mostrarVentanaAgregarPelicula( )
    {
        VentanaCrearPelicula ventanaP = new VentanaCrearPelicula( this );
        ventanaP.setLocationRelativeTo( this );
        ventanaP.setVisible( true );
    }
    
    /**
     * Este metodo crea un nuevo teatro en la aplicacion y actualiza el panel con la lista de teatros
     * @param nombreTeatro es el titulo del teatro a crear
     * @param direccion es la direccion del nuevo teatro
     * @param telefono es el telefono del nuevo teatro
     * @param imagen es la imagen del nuevo teatro
     * @return verdadero si la pelicula se pudo agregar, de lo contrario salte una exception
     */
    public boolean crearTeatro( String nombreTeatro, String direccion, String telefono, String imagen )
    {
        boolean ok = false;
        try
        {
            cinemark.agregarTeatro( nombreTeatro, direccion, telefono, imagen );
            panelTeatros.refrescarTeatros( cinemark.getTeatros());
            
            ok = true;
        }
        catch( ExceptionElemento e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ) );
        }

        return ok;
    }
    
    public boolean crearPelicula( String titulo, String sipnosis, String genero, String idioma, String clasificacion, double duracion, String pais, String director, String calidad, double precio, String imagen )
    {
        boolean ok = false;

        if( teatroSeleccionado != null )
        {
            try
            {
                cinemark.agregarPeliculaATeatro( teatroSeleccionado.getTitulo(), titulo, sipnosis, genero, idioma, clasificacion, duracion, pais, director, calidad, precio, imagen);
                teatroSeleccionado = cinemark.getTeatro( teatroSeleccionado.getTitulo() );
                panelTeatros.cambiarTeatro( teatroSeleccionado );
                ok = true;
            }
            catch( ExceptionElemento e )
            {
                JOptionPane.showMessageDialog( this, e.getMessage( ) );
            }
        }

        return ok;
    }
    
    /**
     * Este metodo guarda la informacion de la aplicacion, antes de cerrar la aplicacion
     */
    public void dispose( )
    {
        try
        {
            cinemark.salvarDiscotienda( );
            super.dispose( );
        }
        catch( Exception e )
        {
            setVisible( true );
            int respuesta = JOptionPane.showConfirmDialog( this, "Error grave, no se genero el archivo binario:\n" + e.getMessage( ) + "\n�Quiere cerrar la aplicacion cinemark sin guardar", "Error", JOptionPane.YES_NO_OPTION );
            if( respuesta == JOptionPane.YES_OPTION )
            {
                super.dispose( );
            }
        }
    }
    
    /**
     * Ejecuta el punto de extensi�n 1
     */
    public void reqFuncOpcion1( )
    {
        String resultado = cinemark.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "", JOptionPane.INFORMATION_MESSAGE );
        
    }
    
    
    
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Programa principal de la aplicacion Cinemark
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    /**
     * Este es el método que ejecuta la aplicacion
     */
    public static void main( String[] args )
    {
        Cinemark discotienda = null;
        try
        {
            discotienda = new Cinemark( "./data/cinemark.txt" );
        }
        catch( ExceptionPerseverancia e )
        {
            e.printStackTrace( );
            System.exit( 1 );
        }
        InterfazCinemark iniciarAplicacion = new InterfazCinemark( discotienda );
        iniciarAplicacion.setVisible( true );
        iniciarAplicacion.setResizable(false);
    }
    
}
