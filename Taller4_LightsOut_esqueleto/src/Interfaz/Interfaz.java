package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import uniandes.dpoo.taller4.modelo.Tablero;

public class Interfaz extends JFrame{
	private PanelSettings Settings;
	private PanelTablero Tablero; 
	private PanelBotones Botones;
	private PanelAbajo Abajo;
	private Interfaz interfaz;
	
	public static Tablero tablero;
	static int tamano = PanelSettings.darTamano();
    
	
	

	public static void main (String[ ] args) {
		Interfaz interfaz = new Interfaz();
		interfaz.setLocationRelativeTo( null );
	    interfaz.getContentPane().setBackground(new Color (244,238,226));
	    interfaz.setVisible( true );
	    tablero=new Tablero(tamano);
	}
	public Interfaz() {
		setSize(1400, 500);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setTitle( "Lights Out" );
        setLayout( new BorderLayout( ) );
		
        
        Settings = new PanelSettings(interfaz);
        add(Settings, BorderLayout.NORTH);
        
        Tablero = new PanelTablero(interfaz);
        add(Tablero,BorderLayout.CENTER);
        
        Botones = new PanelBotones(interfaz);
        add(Botones,BorderLayout.EAST);
        
        Abajo = new PanelAbajo(interfaz);
        add(Abajo, BorderLayout.SOUTH);
        
	}
}
