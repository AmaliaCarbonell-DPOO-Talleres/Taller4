package Interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelBotones extends JPanel implements ActionListener{
	JButton nuevo;
	public PanelBotones (Interfaz interfaz) {
		JPanel base= new JPanel();
		base.setBackground(new Color(244,238,226));
		base.setPreferredSize(new Dimension(200,200));
		base.setLayout(new GridLayout(4,1));
		base.setVisible(true);
		
		
		nuevo = new JButton("Nuevo");
		nuevo.addActionListener(this);
		nuevo.setBounds(50, 50, 100, 100);
		JButton Reiniciar = new JButton("Reiniciar");
		JButton Top10 = new JButton("Top10");
		JButton nuevoJugador = new JButton("nuevoJugador");
		nuevo.setVisible(true);
		Reiniciar.setVisible(true);
		Top10.setVisible(true);
		nuevoJugador.setVisible(true);
		base.add(nuevo);
		base.add(Reiniciar);
		base.add(Top10);
		base.add(nuevoJugador);
		this.add(base);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==nuevo) {
			System.out.println("SI");
			PanelTablero.nuevo();
		}
		
	}

}
