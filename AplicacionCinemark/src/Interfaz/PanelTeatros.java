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

import Idea.Teatro;
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
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Esteban
 */
public class PanelTeatros extends JPanel implements ActionListener{
    
    private static final String CAMBIAR_TEATRO = "CambiarTeatro";
    private static final String AGREGAR_TEATRO = "AgregarTeatro";
    
    private InterfazCinemark principal;
    private Teatro teatro;
    
    
    private JComboBox comboTeatros;
    
    private JLabel etiquetaInformacion;
    private JLabel etiquetaDireccion;
    private JLabel etiquetaTelefono;
    
    private JTextField txtInformacion;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    
    private JButton botonAgregarTeatro;
    
    private JLabel etiquetaImagen;
    
    
    public PanelTeatros( InterfazCinemark ventanaPrincipal, ArrayList teatros )
    {
        principal = ventanaPrincipal;

        setLayout( new BorderLayout( ) );

        comboTeatros = new JComboBox( teatros.toArray( ) );
        comboTeatros.setEditable( false );
        comboTeatros.addActionListener( this );
        comboTeatros.setActionCommand( CAMBIAR_TEATRO );
        add( comboTeatros, BorderLayout.NORTH );

        JPanel panelDatosDisco = new JPanel( );
        add( panelDatosDisco, BorderLayout.CENTER );

        panelDatosDisco.setLayout( new GridLayout( 6, 1, 0, 5 ) );

        etiquetaInformacion = new JLabel( "Informacion: " );
        txtInformacion = new JTextField( 10 );
        txtInformacion.setEditable( false );
        txtInformacion.setFont( txtInformacion.getFont( ).deriveFont( Font.PLAIN ) );
        panelDatosDisco.add( etiquetaInformacion );
        panelDatosDisco.add( txtInformacion );

        etiquetaDireccion = new JLabel( "Direccion: " );
        txtDireccion = new JTextField( 10 );
        txtDireccion.setEditable( false );
        txtDireccion.setFont( txtDireccion.getFont( ).deriveFont( Font.PLAIN ) );
        panelDatosDisco.add( etiquetaDireccion );
        panelDatosDisco.add( txtDireccion );

        etiquetaTelefono = new JLabel( "Telefono: " );
        txtTelefono = new JTextField( 10 );
        txtTelefono.setEditable( false );
        txtTelefono.setFont( txtTelefono.getFont( ).deriveFont( Font.PLAIN ) );
        panelDatosDisco.add( etiquetaTelefono );
        panelDatosDisco.add( txtTelefono );
        
        etiquetaImagen = new JLabel( );
        etiquetaImagen.setPreferredSize( new Dimension( 200, 200 ) );
        etiquetaImagen.setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "" ) ) );
        add( etiquetaImagen, BorderLayout.BEFORE_LINE_BEGINS );

        botonAgregarTeatro = new JButton( "Agregar Teatro" );
        botonAgregarTeatro.setActionCommand( AGREGAR_TEATRO );
        botonAgregarTeatro.addActionListener( this );
        add( botonAgregarTeatro, BorderLayout.SOUTH );

        setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "Teatros" ) ) );

    }
    
    /**
     * Este metodo sirve para cambiar los teatros que se muestran en el menu
     * @param t es el nuevo disco a mostrar en el menu
     */
    public void cambiarTeatro( Teatro t )
    {
        teatro = t;
        if( teatro != null )
        {
            etiquetaImagen.setIcon( new ImageIcon( teatro.getImagen( ) ) );
            txtInformacion.setText( teatro.getTitulo());
            txtDireccion.setText( teatro.getDireccion());
            txtTelefono.setText( teatro.getTelefono());
        }
        else
        {
            setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "Detalles del Disco" ) ) );
        }
    }
    
    /**
    * Este metodo actualiza la informacion de los teatros
    * @param teatros es la lista de teatros que se dspliegga
     */
    public void refrescarTeatros( ArrayList teatros )
    {
        comboTeatros.removeAllItems( );

        for( int i = 0; i < teatros.size( ); i++ )
        {
            comboTeatros.addItem( teatros.get( i ) );
        }
    }
    
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( AGREGAR_TEATRO.equals( comando ) )
        {
            principal.mostrarVentanaAgregarTeatro( );
        }
        else if( CAMBIAR_TEATRO.equals( comando ) )
        {
            String nombreTeatro = ( String )comboTeatros.getSelectedItem( );
            principal.cambiarTeatroSeleccionado( nombreTeatro );
        }
    }
}
