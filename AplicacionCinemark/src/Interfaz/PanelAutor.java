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
public class PanelAutor extends JPanel implements ActionListener{
    
    private static final String AUTOR = "Autor";
    public JButton botonAutor;
    private InterfazCinemark principal;
    
    public PanelAutor( InterfazCinemark ventanaPrincipal )
    {
        principal = ventanaPrincipal;

        botonAutor = new JButton( "Acerca" );
        botonAutor.setActionCommand( AUTOR  );
        botonAutor.addActionListener( this );
        add( botonAutor );

    }
    
    public void actionPerformed( ActionEvent event )
    {
        String comando = event.getActionCommand( );

        if( AUTOR.equals( comando ) )
        {
            principal.reqFuncOpcion1( );
        }
        
    }
}
