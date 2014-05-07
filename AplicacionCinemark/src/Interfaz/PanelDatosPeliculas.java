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
import static java.awt.AWTEventMulticaster.add;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Esteban
 */
public class PanelDatosPeliculas extends JPanel implements ActionListener{
    
    //referencia a la clase principal de la aplicacion cinmark
    private InterfazCinemark principal;
    
    //referencia a la clase teatros
    private Teatro teatro;
    
    //referencia a la clase peliculas
    private Pelicula pelicula;
    
    private static final String CAMBIAR_PELICULA = "CambiarPelicula";
    private static final String AGREGAR_PELICULA = "AgregarPelicula";
    private static final String VENDER_PELICULA = "VenderPelicula";
    
    private JComboBox comboPeliculas;
    private JComboBox comboClasificacion;
    private JComboBox comboCalidad;
    
    
    private JLabel etiquetaTitulo;
    private JLabel etiquetaSipnosis;
    private JLabel etiquetaGenero;
    private JLabel etiquetaIdioma;
    private JLabel etiquetaClasificacion;
    private JLabel etiquetaDuracion;
    private JLabel etiquetaPais;
    private JLabel etiquetaDirector;
    private JLabel etiquetaCalidad;
    private JLabel etiquetaImagen;
    private JLabel etiquetaPrecio;
    
    private JTextField txtTitulo;
    private JTextField txtSipnosis;
    private JTextField txtGenero;
    private JTextField txtIdioma;
    private JTextField txtClasicacion;
    private JTextField txtDuracion;
    private JTextField txtCalidad;
    private JTextField txtPais;
    private JTextField txtDirector;
    private JTextField txtPrecio;
    private JTextField txtImagen;

    private JButton botonAgregarPelicula;
    private JButton botonVenderPelicula;
    
    public PanelDatosPeliculas( InterfazCinemark ventanaPrincipal )
    {
        principal = ventanaPrincipal;

        setLayout( new BorderLayout( ) );

        setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "Peliculas" ) ) );

        comboPeliculas = new JComboBox( );
        comboPeliculas.setEditable( false );
        comboPeliculas.addActionListener( this );
        comboPeliculas.setActionCommand( CAMBIAR_PELICULA );
        add( comboPeliculas, BorderLayout.NORTH );

        JPanel panelDatos = new JPanel( new GridLayout( 5, 2 ) );

        etiquetaTitulo = new JLabel( "titulo: " );
        txtTitulo = new JTextField( 7 );
        txtTitulo.setEditable( false );
        txtTitulo.setFont( txtTitulo.getFont( ).deriveFont( Font.PLAIN ) );
        Border borde = txtTitulo.getBorder( );
        txtTitulo.setBorder( new CompoundBorder( new EmptyBorder( 2, 0, 2, 0 ), borde ) );
        panelDatos.add( etiquetaTitulo );
        panelDatos.add( txtTitulo );

        etiquetaSipnosis = new JLabel( "sipnosis: " );
        txtSipnosis = new JTextField( 7 );
        txtSipnosis.setEditable( false );
        txtSipnosis.setFont( txtSipnosis.getFont( ).deriveFont( Font.PLAIN ) );
        borde = txtSipnosis.getBorder( );
        txtSipnosis.setBorder( new CompoundBorder( new EmptyBorder( 2, 0, 2, 0 ), borde ) );
        panelDatos.add( etiquetaSipnosis );
        panelDatos.add( txtSipnosis );

        etiquetaGenero = new JLabel( "genero: " );
        txtGenero = new JTextField( 7 );
        txtGenero.setEditable( false );
        txtGenero.setFont( txtGenero.getFont( ).deriveFont( Font.PLAIN ) );
        borde = txtGenero.getBorder( );
        txtGenero.setBorder( new CompoundBorder( new EmptyBorder( 2, 0, 2, 0 ), borde ) );
        panelDatos.add( etiquetaGenero );
        panelDatos.add( txtGenero );
        
        etiquetaIdioma = new JLabel( "Idioma: " );
        txtIdioma = new JTextField( 7 );
        txtIdioma.setEditable( false );
        txtIdioma.setFont( txtIdioma.getFont( ).deriveFont( Font.PLAIN ) );
        borde = txtIdioma.getBorder( );
        txtIdioma.setBorder( new CompoundBorder( new EmptyBorder( 2, 0, 2, 0 ), borde ) );
        panelDatos.add( etiquetaIdioma );
        panelDatos.add( txtIdioma );
        
        etiquetaClasificacion = new JLabel( "Clasificacion: " );
        txtClasicacion = new JTextField( 7 );
        txtClasicacion.setEditable( false );
        txtClasicacion.setFont( txtClasicacion.getFont( ).deriveFont( Font.PLAIN ) );
        borde = txtClasicacion.getBorder( );
        txtClasicacion.setBorder( new CompoundBorder( new EmptyBorder( 2, 0, 2, 0 ), borde ) );
        panelDatos.add( etiquetaClasificacion );
        panelDatos.add( txtClasicacion );
        
        
        etiquetaDuracion = new JLabel( "Duracion: " );
        txtDuracion = new JTextField( 7 );
        txtDuracion.setEditable( false );
        txtDuracion.setFont( txtDuracion.getFont( ).deriveFont( Font.PLAIN ) );
        borde = txtDuracion.getBorder( );
        txtDuracion.setBorder( new CompoundBorder( new EmptyBorder( 2, 0, 2, 0 ), borde ) );
        panelDatos.add( etiquetaDuracion );
        panelDatos.add( txtDuracion );
        
        etiquetaPais = new JLabel( "Pais: " );
        txtPais = new JTextField( 7 );
        txtPais.setEditable( false );
        txtPais.setFont( txtPais.getFont( ).deriveFont( Font.PLAIN ) );
        borde = txtPais.getBorder( );
        txtPais.setBorder( new CompoundBorder( new EmptyBorder( 2, 0, 2, 0 ), borde ) );
        panelDatos.add( etiquetaPais );
        panelDatos.add( txtPais );
        
        etiquetaDirector = new JLabel( "Director: " );
        txtDirector = new JTextField( 7 );
        txtDirector.setEditable( false );
        txtDirector.setFont( txtDirector.getFont( ).deriveFont( Font.PLAIN ) );
        borde = txtDirector.getBorder( );
        txtDirector.setBorder( new CompoundBorder( new EmptyBorder( 2, 0, 2, 0 ), borde ) );
        panelDatos.add( etiquetaDirector );
        panelDatos.add( txtDirector );
        
        etiquetaCalidad = new JLabel( "Calidad: " );
        txtCalidad = new JTextField( 7 );
        txtCalidad.setEditable( false );
        txtCalidad.setFont( txtCalidad.getFont( ).deriveFont( Font.PLAIN ) );
        borde = txtCalidad.getBorder( );
        txtCalidad.setBorder( new CompoundBorder( new EmptyBorder( 2, 0, 2, 0 ), borde ) );
        panelDatos.add( etiquetaCalidad );
        panelDatos.add( txtCalidad );
        
        etiquetaPrecio = new JLabel( "Precio: " );
        txtPrecio = new JTextField( 7 );
        txtPrecio.setEditable( false );
        txtPrecio.setFont( txtPrecio.getFont( ).deriveFont( Font.PLAIN ) );
        borde = txtPrecio.getBorder( );
        txtPrecio.setBorder( new CompoundBorder( new EmptyBorder( 2, 0, 2, 0 ), borde ) );
        panelDatos.add( etiquetaPrecio );
        panelDatos.add( txtPrecio );
        
    
        
        etiquetaImagen = new JLabel( );
        etiquetaImagen.setPreferredSize( new Dimension( 200, 200 ) );
        etiquetaImagen.setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "" ) ) );
        add( etiquetaImagen, BorderLayout.BEFORE_LINE_BEGINS );

        add( panelDatos, BorderLayout.CENTER );

        JPanel panelBotones = new JPanel( new BorderLayout( ) );

        botonAgregarPelicula = new JButton( "Agregar pelicula" );
        botonAgregarPelicula.setActionCommand( AGREGAR_PELICULA );
        botonAgregarPelicula.addActionListener( this );
        botonAgregarPelicula.setEnabled( false );
        panelBotones.add( botonAgregarPelicula, BorderLayout.NORTH );

        botonVenderPelicula = new JButton( "Vender tiquete" );
        botonVenderPelicula.setActionCommand( VENDER_PELICULA );
        botonVenderPelicula.addActionListener( this );
        botonVenderPelicula.setEnabled( false );
        panelBotones.add( botonVenderPelicula, BorderLayout.SOUTH );

        add( panelBotones, BorderLayout.SOUTH );
    }
    
    /**
     * Este metodo cambia el teatro que se muestran las peliculas en el panel y se actualiza
     * @param t es el teatro en el que se quiere nmostrar las imagenes
     */
    public void cambiarTeatro( Teatro t )
    {
        if( t != null )
        {
            teatro = t;
            
            botonAgregarPelicula.setEnabled( true );

            comboPeliculas.removeAllItems( );
            ArrayList peliculas = teatro.getNombresPeliculas();
            for( int i = 0; i < peliculas.size( ); i++ )
            {
                comboPeliculas.addItem( peliculas.get( i ) );
                //etiquetaImagen.setIcon( new ImageIcon( cancion.darImagen( ) ) );

            }

            if( peliculas.size( ) > 0 )
            {
                botonVenderPelicula.setEnabled( true );
            }
            else
            {
                botonVenderPelicula.setEnabled( false );
            }
        }
    }
    
    /**
     * Este metodo void lo que hace es refrescar las canciones.
     */
    private void refrescarPeliculas( )
    {
        comboPeliculas.removeAllItems( );
        ArrayList peliculas = teatro.getNombresPeliculas();
        for( int i = 0; i < peliculas.size( ); i++ )
        {
            comboPeliculas.addItem( peliculas.get( i ) );
        }

        if( peliculas.size( ) > 0 )
        {
            botonVenderPelicula.setEnabled( true );
        }
        else
        {
            botonVenderPelicula.setEnabled( false );
        }
    }
    
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( CAMBIAR_PELICULA.equals( comando ) )
        {
            String nombrePelicula = ( String )comboPeliculas.getSelectedItem();
            

            if( nombrePelicula != null )
            {
                pelicula = teatro.getPelicula( nombrePelicula );
                
                txtTitulo.setText(pelicula.getNombre());
                txtSipnosis.setText(pelicula.getSipnosis());
                txtGenero.setText(pelicula.getGenero());
                txtIdioma.setText(pelicula.getIdioma());
                txtClasicacion.setText(pelicula.getClasificacion());
                txtDuracion.setText( Double.toString( pelicula.getDuracion()));
                txtCalidad.setText(pelicula.getCalidad());
                txtPais.setText(pelicula.getPais());
                txtDirector.setText(pelicula.getDirector());
                txtPrecio.setText( Double.toString( pelicula.getPrecio()));
                etiquetaImagen.setIcon( new ImageIcon( pelicula.getImagen() ) );

            }
            else
            {
                txtTitulo.setText( "" );
                txtSipnosis.setText( "" );
                txtGenero.setText( "" );
                txtIdioma.setText( "" );
                txtClasicacion.setText( "" );
                txtDuracion.setText( "" );
                txtCalidad.setText( "" );
                txtPais.setText( "" );
                txtDirector.setText( "" );
                txtPrecio.setText( "" );
                etiquetaImagen.setIcon(null);
                
                //txtImagen.setText( "" );
                
            }
        }
        else if( AGREGAR_PELICULA.equals( comando ) )
        {
            principal.mostrarVentanaAgregarPelicula( );
            refrescarPeliculas( );
        }
        else if( VENDER_PELICULA.equals( comando ) )
        {
            //??  principal.venderPelicula( teatro, pelicula );
            //txtUnidades.setText( Integer.toString( cancion.darUnidadesVendidas( ) ) );
        }
    }
    
    
}
