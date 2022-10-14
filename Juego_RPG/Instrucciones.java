package juegoTdPA;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author davidarevalo
 * Clase donde se crea un ventana en la esquina derecha 
 * con las instrucciones del juego. Una vez se inicie
 * el juego, estas desaparecerán.
 */
public class Instrucciones{
	static JFrame ventanaIN;
	//Constructor
	public Instrucciones() {
		crearVentanaInstrucciones();
	}
	/**
	 * Metodo en que añadimos el panel a 
	 * la ventana, ademas de crear un area de texto
	 * que añadimos al panel -indirectamente mediante
	 * un scroll-
	 */
	private void crearVentanaInstrucciones(){
		//Ventana
		ventanaIN = new JFrame("MANUAL");
		ventanaIN.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Panel
		JPanel panel = new JPanel();
		Color colorPanel = new Color(60, 76, 97);
		panel.setSize(new Dimension(450, 600));
		panel.setBackground(colorPanel);
		panel.setPreferredSize(new Dimension(450, 600));
		ventanaIN.add(panel);
		//Texto del Panel
		String textito = "\n           MANUAL DE INSTRUCCIONES \n\n"
				+ ""
				+ "   El juego consiste en lo siguiente. Manejas a \n   Bilbo Bolsón"
				+ " y tienes que evitar a toda costa a \n   Sauron, el cual se mueve a una velocidad"
				+ " que \n   irá aumentando al pasar de nivel."
				+ " \n   Pulsa la tecla del espacio para saltar y pasar de \n   ronda."
				+ " \n   Solo tienes 3 vidas, si te quedas sin vidas \n   pierdes y se reinicia la puntuación"
				+ "\n\n"
				+ "           ¡¡¡QUE COMIENCE EL JUEGO!!! \n";
		JTextArea texto = new JTextArea("", 15, 26);
		texto.setText(textito);
		texto.setFont(new Font("times", Font.LAYOUT_NO_LIMIT_CONTEXT, 19));
		texto.setLineWrap(true);
		texto.setWrapStyleWord(true);
		texto.setForeground(Color.WHITE);
		texto.setBackground(colorPanel);
		texto.setEditable(false);
		//Scroll
		JScrollPane scroll = new JScrollPane(texto);
		panel.add(scroll);
		//Final
		ventanaIN.setSize(425, 400);
		ventanaIN.setResizable(false);
		ventanaIN.setLocation(1500, 0);
		ventanaIN.setVisible(true);
	}
}