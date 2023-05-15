package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Tablero;

public class PanelTablero extends JPanel implements MouseListener {
	public static Tablero tablero;
	private Interfaz principal;
	private int ladoTablero;
	boolean[][] tableroJuego;
	
	public PanelTablero(Interfaz interfaz ) {
	
		
		principal=interfaz;
		addMouseListener(this);
		add(new JLabel("                                                                                         " ));
		vacias();
		
		
		
	}
	
	public String Intento () {
		String intento = Integer.toString(tablero.darJugadas());
		return intento;
	}
	
	public void vacias() {
		int tamano = Integer.parseInt(JOptionPane.showInputDialog("Escriba el numero del tamano de tablero que desea?   ej: 5 "));
		int  dificultad= Integer.parseInt(JOptionPane.showInputDialog("Escriba la dificultad en la que desea Jugar:\n 1. Facil 2. Medio 3. Dificil "));
        tablero=new Tablero(tamano);
		tableroJuego= tablero.darTablero();
		ladoTablero=tableroJuego.length;
		if (dificultad==1) {
			tablero.desordenar(3);
		}
		if (dificultad ==2) {
			tablero.desordenar(5);
		}
		if( dificultad ==3) {
			tablero.desordenar(7);
		}
        for (int i =0; i<ladoTablero;i++) {
        	for (int j=0;j<ladoTablero;j++) {
        		if (i==0) {
        			tableroJuego[i][j]=false;
        		}
        		
        	}
        }
	}
    
	 public void paint(Graphics g) {
		 Graphics2D  g2d = (Graphics2D) g;
	        
	        g.drawRect( 0, 0, 120, 320 );
	        g.setColor( Color.CYAN );
	        
	        g.fillRect( 10, 50, 50, 60 );
	       // int tamano = PanelSettings.darTamano();
	        //tablero=new Tablero(tamano);
	        //System.out.println("HOLA"+tamano);
	        
	        //boolean[][] tableroJuego= tablero.darTablero();
	        //tableroJuego[2][3]=false;
	        //tableroJuego[2][4]=false;
	        ladoTablero=tableroJuego.length;
	       
	        
	        int ancho=getWidth( )/ladoTablero;
	        int alto= getHeight( )/ladoTablero;
	        
	        for(int i=0;i<ladoTablero;i++)
	        {
	            for(int j=0; j<ladoTablero;j++)
	            {
	                if(tableroJuego[i][j]==true )
	                {
	                	
	                    g.setColor( new Color(1,169,219));
	                    g.fillRect( i*ancho, j*alto, ancho, alto );
	                    g.setColor( Color.BLACK );
	                    g.drawRect( i*ancho, j*alto, ancho, alto );
	                    
	                }
	                else
	                {
	                	
	                    g.setColor( Color.GRAY );
	                    g.fillRect( i*ancho, j*alto, ancho, alto );
	                    g.setColor( Color.BLUE );
	                    g.drawRect( i*ancho, j*alto, ancho, alto );
	                }
	                
	                
	            }
	         
	            System.out.println("jugadas"+tablero.darJugadas());
	        }
	        
	        
	    }
	 public static int darJugadas() {
		 int jugadas= tablero.darJugadas();
		 return jugadas;
	 }
	public static void nuevo() {
		System.out.println("nuevo tablero");
		tablero.desordenar(1);
		tablero.reiniciar();
		JOptionPane.showMessageDialog(null, "Nuevo Tablero Creado", "Tablero", JOptionPane.INFORMATION_MESSAGE);
	}
	public static int jugadas() {
		System.out.println();
		int respuesta =tablero.darJugadas();
		return respuesta;
	}
	@Override
	public void mousePressed(MouseEvent e) {

        int click_x = e.getX();
        int click_y = e.getY();
        int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
        
        tablero.jugar(casilla[1], casilla[0]);
        
        repaint();
	
	}
	private int[] convertirCoordenadasACasilla(int x, int y)
    {
//        int ladoTablero = tablero.length;
        int altoPanelTablero = getHeight();
        int anchoPanelTablero = getWidth();
        int altoCasilla = altoPanelTablero / ladoTablero;
        int anchoCasilla = anchoPanelTablero / ladoTablero;
        int fila = (int) (y / altoCasilla);
        int columna = (int) (x / anchoCasilla);
        return new int[] { fila, columna };
    }
	@Override
	public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
