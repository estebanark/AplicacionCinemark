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
import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Esteban
 */
public class VentanaCrearTeatro extends JDialog{
    
    //es una referencia a la ventana principal de la aplicacion
    private InterfazCinemark principal;
    
    
    //panel que contiene los datos de los teatros
    private PanelCrearTeatro panelDatos;
    
    //panel que contiene los botones
    private PanelBotonesTeatro panelBotones;
    
    public VentanaCrearTeatro( InterfazCinemark id )
    {
        super( id, true );
        principal = id;

        panelDatos = new PanelCrearTeatro( );
        panelBotones = new PanelBotonesTeatro( this );

        getContentPane( ).add( panelDatos, BorderLayout.CENTER );
        getContentPane( ).add( panelBotones, BorderLayout.SOUTH );

        setTitle( "Crear teatro" );
        pack( );

    }
    
    /**
     * Guarda el teatro
     */
    public void crearDisco( )
    {
        boolean parametersOk = true;
        
        String titulo = panelDatos.getTitulo();
        String direccion = panelDatos.getDireccion();
        String telefono = panelDatos.getDireccion();
        String imagen = panelDatos.getImagen();

        if( ( titulo.equals( "" ) || titulo.equals( "" ) ) || ( direccion.equals( "" ) || imagen.equals( "" ) ) )
        {
            parametersOk = false;
            JOptionPane.showMessageDialog( this, "Todos los campos deben ser llenados para crear el disco" );
        }
        if( parametersOk )
        {
            boolean ok = principal.crearTeatro( titulo, direccion, telefono, imagen );
            if( ok )
                dispose( );
        }
    }
    
}
