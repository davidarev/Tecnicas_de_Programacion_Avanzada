package juegoTdPA;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author davidarevalo
 * En la clase Main se crea la ventana del juego
 * así como las condiciones para que el juego 
 * continue, se reinicie, o finalice
 */
public class Main{
	//Variable de reinicio del juego
	public static int reinicio = -1;
	
	/**
	 * Metodo main de solo 5 lineas :):
	 * @param args
	 */
	public static void main(String[] args) {
		//Creacion de la ventana de instrucciones
		Instrucciones instrucciones = new Instrucciones();
		JOptionPane.showMessageDialog(null, "¿PREPARADO? \n Lee las instrucciones detenidamente");
		Instrucciones.ventanaIN.setVisible(false); //La ventana desaparece en cuanto pulsas 'OK' //Clase Instrucciones linea 18
		//Creacion de la ventana del juego
		JFrame ventana = new JFrame("GAME");
		Game juego = new Game();
		ventana.add(juego);
		ventana.setSize(1500, 800);
		ventana.setLocationRelativeTo(null);;
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//"Condiciones" del juego
		while(true){
			if(juego.gameOver) { //Linea 23 de la clase Game
				reinicio = JOptionPane.showConfirmDialog(null, "Perdiste por ser un loser, ¿quieres jugar de nuevo?", "HAS PERDIDO", JOptionPane.YES_NO_OPTION);
				if(reinicio == 0) {
					reiniciaValores(); //Linea 74
				}
				else if(reinicio == 1){
					System.exit(0);
				}
			}
			else {
				juego.repaint();
				try {
					Thread.sleep(10);
				}
				catch(InterruptedException ex) {
					Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
				}
				/*
				 * Se modifican o reinician los valores de las variables 
				 * -Game.vidas se modifica, pero Sauron.posX se reinicia-
				 */
				if(Game.pierdeVida == true) {
					JOptionPane.showConfirmDialog(null, "¡¡CUIDADO!!");
					Game.pierdeVida = false; //Linea 109 de la clase Game
					Game.vidas--; //Linea 25 de la clase Game
					Bilbo.posY = 570; //Linea 27 de la clase Bilbo //vuelve a su posicion inicial
					Bilbo.saltar = false; //Linea 17 de la clase Bilbo
					Bilbo.posX = 50;
					Sauron.posX = 1500; //Linea 21 de la clase Sauron //vuelve a su posicion inicial
				}
			}
		}
	}
	/**
	 * Metodo en el que se reinician los valores de las variables
	 * cuando el juego termina -te quedas sin vidas-
	 */
	public static void reiniciaValores() {
		Game.gameOver = false; 
		Sauron.auxX = -4; //Linea 23 de la clase Sauron
		Game.puntos = 0; //Linea 26 de la clase Game
		Game.nivel = 1; //Linea 27 de la clase Game
		Game.vidas = 3; 
		reinicio = -1;
		Sauron.posX = 1500; //vuelve a su posicion inicial
	}
}