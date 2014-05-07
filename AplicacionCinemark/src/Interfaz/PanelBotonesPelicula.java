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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Esteban
 */
public class PanelBotonesPelicula extends JPanel implements ActionListener{
    
    private static final String CREAR_PELICULA = "CrearPelicula";
    private static final String CANCELAR = "Cancelar";
    
    private VentanaCrearPelicula ventana;
    
    private JButton botonAgregarCancion;
    private JButton botonCancelar;
    
    public PanelBotonesPelicula( VentanaCrearPelicula vcp )
    {

        ventana = vcp;

        botonAgregarCancion = new JButton( "Crear" );
        botonAgregarCancion.setActionCommand( CREAR_PELICULA );
        botonAgregarCancion.addActionListener( this );
        add( botonAgregarCancion );

        botonCancelar = new JButton( "Cancelar" );
        botonCancelar.setActionCommand( CANCELAR );
        botonCancelar.addActionListener( this );
        add( botonCancelar );

    }
    
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( CREAR_PELICULA.equals( comando ) )
        {
            ventana.crearCancion( );
        }
        else if( CANCELAR.equals( comando ) )
        {
            ventana.dispose();
        }

    }
}
