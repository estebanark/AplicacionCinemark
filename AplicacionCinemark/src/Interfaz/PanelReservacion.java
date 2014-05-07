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
import javax.swing.border.TitledBorder;

/**
 *
 * @author Esteban
 */
public class PanelReservacion extends JPanel implements ActionListener{
    
        private static final String RESERVACION = "Reservar";
        private InterfazCinemark principal;
        private JButton botonReserva;
        
        
         public PanelReservacion( InterfazCinemark reserva )
        {
        principal = reserva;
        setBorder( new TitledBorder( "Reservacion de tiquete" ) );

        botonReserva = new JButton( "Reservar Tiqute" );
        botonReserva.setActionCommand( RESERVACION );
        botonReserva.addActionListener( this );
        add( botonReserva );
        }
         
         public void actionPerformed( ActionEvent evento )
        {
        String comando = evento.getActionCommand( );

        if( RESERVACION.equals( comando ) )
        {
            //principal.reservarTiquete( );
        }
        }
}
