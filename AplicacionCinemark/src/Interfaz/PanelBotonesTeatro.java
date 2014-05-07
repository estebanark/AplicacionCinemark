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
import static sun.misc.ClassFileTransformer.add;

/**
 *
 * @author Esteban
 */
public class PanelBotonesTeatro extends JPanel implements ActionListener{
    
    private static final String CREAR_TEATRO = "CrearTeatro";
    private static final String CANCELAR = "Cancelar";
    
    private VentanaCrearTeatro ventana;
    
    private JButton botonAgregarTeatro;
    private JButton botonCancelar;
    
    public PanelBotonesTeatro( VentanaCrearTeatro vct )
    {

        ventana = vct;

        botonAgregarTeatro = new JButton( "Crear" );
        botonAgregarTeatro.setActionCommand( CREAR_TEATRO );
        botonAgregarTeatro.addActionListener( this );
        add( botonAgregarTeatro );

        botonCancelar = new JButton( "Cancelar" );
        botonCancelar.setActionCommand( CANCELAR );
        botonCancelar.addActionListener( this );
        add( botonCancelar );

    }
    
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( CREAR_TEATRO.equals( comando ) )
        {
            ventana.crearDisco( );
        }
        else if( CANCELAR.equals( comando ) )
        {
            ventana.dispose( );
        }

    }
    
}
