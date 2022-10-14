package juegoTdPA;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 * @author davidarevalo
 * Clase en la que se definen las variables para
 * que el juego funcione, se crean los objetos y los
 * diferentes metodos para que estos se vean/muevan
 */
public class Game extends JPanel{
	//Creo los objetos de las clases
	Bilbo bilbo = new Bilbo(this);
	Sauron sauron = new Sauron(this);
	Fondo fondo = new Fondo(this);
	//Variables del juego
	public static boolean gameOver = false;
	public static boolean pierdeVida = false;
	public static int vidas = 3;
	public static int puntos = 0;
	public static int nivel = 1;
	//Constructor
	public Game() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {		
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					bilbo.saltar(e); //Se aciona el salto
				}	
			}
			@Override
			public void keyReleased(KeyEvent e) {				
			}
		});
		setFocusable(true);
	}
	/**
	 * Metodo en el que llamamos al metodo mover() 
	 * de las clases Bilbo y Sauron
	 */
	public void moverObjetos() {
		sauron.mover(); //Linea 36 de la clase Sauron
		bilbo.mover(); //Linea 48 de la clase Bilbo
		//fondo.mover();
	}
	/**
	 * Metodo en el que llamamos a los metodos que 
	 * pintan los objetos y la puntuacion
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		pintar(g2); //Linea 71
		pintarPuntuacion(g2); //Linea 83
	}
	/**
	 * Metodo en el que llamamos al metodo dibujar()
	 * de las clases Bilbo, Sauron y Fondo y al
	 * metodo anterior moverObjetos()
	 * @param g
	 */
	public void pintar(Graphics2D g) {
		fondo.dibujar(g); //Linea 57 de la clase Fondo
		bilbo.dibujar(g); //Linea 81 de la clase Bilbo
		sauron.dibujar(g); //Linea 67 de la clase Sauron
		moverObjetos();
	}
	/**
	 * Metodo en el que pintamos la puntuacion, el
	 * numero de vidas, y el nivel del juego, asi
	 * como el mensaje que lee el usuario al perder
	 * @param g
	 */
	public void pintarPuntuacion(Graphics2D g) {
		Graphics2D g1 = g;
		Graphics2D g2 = g;
		Font score = new Font("Times", Font.BOLD, 30);
		g.setFont(score);
		g.setColor(Color.RED);
		g1.drawString("Puntuacion: " + puntos, 1100, 30);
		g1.drawString("Vidas: " + vidas, 20, 30);
		g1.drawString("Nivel: " + nivel, 570, 30);
		//Si tienes 0 vidas manda este mensaje 
		if(gameOver) {
			g2.setColor(Color.RED);
			g2.drawString("¡¡PERDISTE, LOSER!!", ((float)getBounds().getCenterX() / 2) + 170, 70);
		}
	}
	/**
	 * Metodos en los que se modifican los 
	 * valores de las variables booleanas
	 * gameOver y pierdeVida, tales metodos
	 * se llamaran mas adelante en la clase
	 * Sauron dentro de un condicional en el
	 * metodo mover() -lineas 52 y 55-
	 */
	public void gueimOuver() {
		gameOver = true;
	}
	public void pierdeVida() {
		pierdeVida = true;
	}
}