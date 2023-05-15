package Interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import uniandes.dpoo.taller4.modelo.Tablero;

public class PanelAbajo  extends JPanel implements ActionListener{
	JButton boton;
	JTextField nombre;
	int jugadas =0;
	static JPanel base;
	PanelTablero Tablero;
	private Interfaz principal;
	
	
	public PanelAbajo (Interfaz interfaz) {
		//Tablero=new PanelTablero(interfaz);
		base= new JPanel();
		base.setLayout(new FlowLayout());
		base.setBackground(Color.WHITE);
		base.setVisible(true);
		
		JLabel jug = new JLabel("Jugadas");
		base.add(jug);
		
		
		JLabel numJugadas = new JLabel();
		numJugadas.setText(Integer.toString(PanelTablero.jugadas()));
		numJugadas.setVisible(true);
		base.add(numJugadas);
		
		
		
		
		
		boton = new JButton("Nombre: ");
		boton.addActionListener(this);
		boton.setVisible(true);
		base.add(boton);
		nombre= new JTextField();
		nombre.setPreferredSize(new Dimension (250,40));
		base.add(nombre);
		this.add(base);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== boton) {
			System.out.println("Hola "+ nombre.getText());
			nombre.setEditable(false);
			boton.setEnabled(false);
		}
		
	}

}
