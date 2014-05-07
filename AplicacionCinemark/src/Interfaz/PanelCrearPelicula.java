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

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import static sun.misc.ClassFileTransformer.add;

/**
 *
 * @author Esteban
 */
public class PanelCrearPelicula extends JPanel implements ActionListener{
    
    private static final String EXPLORAR = "Explorar";
        
       private JLabel etiquetaTitulo;
       private JLabel etiquetaSipnosis;
       private JLabel etiquetaGenero;
       private JLabel etiquetaIdioma;
       private JLabel etiquetaClasificacion;
       private JLabel etiquetaDuracion;
       private JLabel etiquetaPais;
       private JLabel etiquetaDirector;
       private JLabel etiquetaCalidad;
       private JLabel etiquetaPrecio;
       private JLabel etiquetaImagen;


       private JTextField txtTitulo;
       private JTextField txtSipnosis;
       private JTextField txtGenero;
       private JTextField txtIdioma;
       private JTextField txtClasificacion;
       private JTextField txtDuracion;
       private JTextField txtPais;
       private JTextField txtDirector;
       private JTextField txtCalidad;
       private JTextField txtPrecio;
       private JTextField txtImagen;

        private JButton btnExplorar;
        
        public PanelCrearPelicula( )
    {
        setLayout( new GridLayout( 6, 2, 5, 5 ) );

        etiquetaTitulo = new JLabel( "Nombre: " );
        etiquetaTitulo.setFont( etiquetaTitulo.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaTitulo );
        txtTitulo = new JTextField( 2 );
        add( txtTitulo );
        
        etiquetaSipnosis = new JLabel( "Sipnosis: " );
        etiquetaSipnosis.setFont( etiquetaSipnosis.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaSipnosis );
        txtSipnosis = new JTextField( 2 );
        add( txtSipnosis );
        
        etiquetaGenero = new JLabel( "Genero: " );
        etiquetaGenero.setFont( etiquetaGenero.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaGenero );
        txtGenero = new JTextField( 2 );
        add( txtGenero );
        
        etiquetaIdioma = new JLabel( "Idioma: " );
        etiquetaIdioma.setFont( etiquetaIdioma.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaIdioma );
        txtIdioma = new JTextField( 2 );
        add( txtIdioma );
        
        etiquetaClasificacion = new JLabel( "Clasificacion: " );
        etiquetaClasificacion.setFont( etiquetaClasificacion.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaClasificacion );
        txtClasificacion = new JTextField( 2 );
        add( txtClasificacion );
        
        etiquetaDuracion = new JLabel( "Duracion: " );
        etiquetaDuracion.setFont( etiquetaDuracion.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaDuracion );
        txtDuracion = new JTextField( 2 );
        add( txtDuracion );
        
        etiquetaPais = new JLabel( "Pais: " );
        etiquetaPais.setFont( etiquetaPais.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaPais );
        txtPais = new JTextField( 2 );
        add( txtPais );
        
        etiquetaDirector = new JLabel( "Director: " );
        etiquetaDirector.setFont( etiquetaDirector.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaDirector );
        txtDirector = new JTextField( 2 );
        add( txtDirector );
        
        etiquetaCalidad = new JLabel( "Calidad: " );
        etiquetaCalidad.setFont( etiquetaCalidad.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaCalidad );
        txtCalidad = new JTextField( 2 );
        add( txtCalidad );
        
        etiquetaPrecio = new JLabel( "Precio: " );
        etiquetaPrecio.setFont( etiquetaPrecio.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaPrecio );
        txtPrecio = new JTextField( 2 );
        add( txtPrecio );
        
        
        
        etiquetaImagen = new JLabel( "Imagen: " );
        etiquetaImagen.setFont( etiquetaImagen.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaImagen );

        txtImagen = new JTextField( 2 );
        add( txtImagen );

        add( new JLabel( ) );

        btnExplorar = new JButton( "Explorar" );
        btnExplorar.setActionCommand( EXPLORAR );
        btnExplorar.addActionListener( this );
        add( btnExplorar );

        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
    }
        
    public String getNombre( )
    {
        return txtTitulo.getText( );
    }
    
    public String getSipnosis() {
        return txtSipnosis.getText();
    }

    public String getGenero() {
        return txtGenero.getText();
    }

    public String getIdioma() {
        return txtIdioma.getText();
    }

    public String getClasificacion() {
        return txtClasificacion.getText();
    }

    public String getDuracion() {
        return txtDuracion.getText();
    }

    public String getPais() {
        return txtPais.getText();
    }

    public String getDirector() {
        return txtDirector.getText();
    }
    
    public String getCalidad() {
        return txtCalidad.getText();
    }
    
    public String getPrecio() {
        return txtPrecio.getText();
    }
    
    public String getImagen() {
        return txtImagen.getText();
    }
    
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( EXPLORAR.equals( comando ) )
        {
            JFileChooser fc = new JFileChooser( "./data/imagenes" );
            fc.setDialogTitle( "Imagen del Disco" );
            int resultado = fc.showOpenDialog( this );
            if( resultado == JFileChooser.APPROVE_OPTION )
            {
                File archivo = fc.getSelectedFile( );
                String strArchivo = archivo.getAbsolutePath( );
                String strCarpetaImagenes = new File( "data/imagenes" ).getAbsolutePath( );

                if( strArchivo.startsWith( strCarpetaImagenes ) )
                {
                    txtImagen.setText( "data/imagenes/" + archivo.getName( ) );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "La imagen debe estar en la carpeta " + strCarpetaImagenes );
                }
            }
        }
    }
}
