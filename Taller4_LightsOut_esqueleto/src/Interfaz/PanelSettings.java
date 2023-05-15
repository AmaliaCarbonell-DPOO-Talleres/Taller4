package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelSettings extends JPanel implements ActionListener{
	JRadioButton Facil ;
	JRadioButton Medio;
	JRadioButton Dificil ;
	JComboBox opciones;
	static int tamanoTablero=5;
	
	public PanelSettings(Interfaz interfaz) {
		
		String[] Tamanos = {"5x5", "7x7","9x9"};
		opciones = new  JComboBox(Tamanos);
		opciones.addActionListener(this);
		opciones.setVisible(true);
		this.add(opciones);
		Facil = new JRadioButton("Facil");
		Medio = new JRadioButton("Medio");
		Dificil = new JRadioButton("Dificil");
		ButtonGroup group = new ButtonGroup();
		Facil.addActionListener(this);
		Medio.addActionListener(this);
		Dificil.addActionListener(this);
		group.add(Facil);
		group.add(Medio);
		group.add(Dificil);
		this.add(Facil);
		this.add(Medio);
		this.add(Dificil);
		
		this.setVisible(true);
		
	}
	public static int darTamano() {
		
		return tamanoTablero;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==Facil) {
			System.out.println("Facil");
		}
		if (e.getSource()==Medio) {
			System.out.println("Medio");
		}
		if (e.getSource()==Dificil) {
			System.out.println("Dificil");
		}
		if (e.getSource()==opciones) {
			//System.out.println(opciones.getSelectedItem());
			tamanoTablero= Integer.parseInt(opciones.getSelectedItem().toString().substring(0,1));
			
			System.out.println(tamanoTablero);
		}
		
	}
	
}
