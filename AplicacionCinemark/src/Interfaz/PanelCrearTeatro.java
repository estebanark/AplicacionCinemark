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
public class PanelCrearTeatro extends JPanel implements ActionListener{
    
    //constante para el boton explorar y buscar el archivo
    private static final String EXPLORAR = "Explorar";
    
    //Etiquetas
    private JLabel etiquetaTitulo;
    private JLabel etiquetaDireccion;
    private JLabel etiquetaTelefono;
    private JLabel etiquetaImagen;
    private JLabel imagenCabecera;
    
    //campos de texto
    private JTextField txtTitulo;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtImagen;

    private JButton botonExplorar;
    
    public PanelCrearTeatro( )
    {
         setLayout(new GridLayout(5, 2, 5, 5));

        etiquetaTitulo = new JLabel("Titulo:");
        etiquetaTitulo.setFont(etiquetaTitulo.getFont().deriveFont(Font.PLAIN));
        add(etiquetaTitulo);
        
        txtTitulo = new JTextField(2);
        add(txtTitulo);
        
        etiquetaDireccion = new JLabel("Direccion:");
        etiquetaDireccion.setFont(etiquetaDireccion.getFont().deriveFont(Font.PLAIN));
        add(etiquetaDireccion);
        
        txtDireccion = new JTextField(2);
        add(txtDireccion);
        
        etiquetaTelefono = new JLabel("Telefono:");
        etiquetaTelefono.setFont(etiquetaTelefono.getFont().deriveFont(Font.PLAIN));
        add(etiquetaTelefono);
        
        txtTelefono = new JTextField(2);
        add(txtTelefono);
        
        etiquetaImagen = new JLabel("Imagen:");
        etiquetaImagen.setFont(etiquetaImagen.getFont().deriveFont(Font.PLAIN));
        add(etiquetaImagen);
        
        txtImagen = new JTextField(2);
        add(txtImagen);
        
        add( new JLabel( ) );
        botonExplorar = new JButton( "Explorar" );
        botonExplorar.setActionCommand( EXPLORAR );
        botonExplorar.addActionListener( this );
        add( botonExplorar );
        
        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
    }
    
    public String getTitulo() {
        return txtTitulo.getText( );
    }

    public String getDireccion() {
        return txtDireccion.getText( );
    }

    public String getTelefono() {
        return txtTelefono.getText( );
    }

    public String getImagen( )
    {
        return txtImagen.getText( );
    }
    
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( EXPLORAR.equals( comando ) )
        {
            JFileChooser fc = new JFileChooser( "./data/imagenes" );
            fc.setDialogTitle( "Imagen del teatro" );
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
