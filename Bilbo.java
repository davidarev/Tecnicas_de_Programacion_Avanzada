package juegoTdPA;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import javax.swing.ImageIcon;

/**
 * @author davidarevalo
 * Clase donde se definen los atributos del personaje
 * asi como los diferentes metodos para que cumpla su funcion
 */
public class Bilbo{
	Game juego;
	//Accion del personaje
	static boolean saltar = false;
	boolean sube = false;
	boolean baja = false;
	//Area del personahe
	Area cuerpo; 
	Area cuerpoBilbo;
	//Variables del personaje
	int anchura = 100;
	int altura = 100;
	static int posX = 50; //Posicion incial
	static int posY = 570;
	int auxX = 0;
	int auxY = 0; //Movimiento vertical
	//Constructor
	public Bilbo(Game juego) {
		this.juego = juego;
	}
	/**
	 * Metodo en el que cambiamios el valor
	 * de la variable saltar, accionando asi el salto
	 * @param e
	 */
	public void saltar(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			saltar = true;
		}
	}
	/**
	 * Metodo con el que movemos al personaje
	 * y definimos el salto y el retorno a su posicion inicial
	 */
	public void mover() {
		if(saltar){
			if(posY == 570) { //Si Bilbo está en el suelo -posicion inicial-
				sube = true;
				auxY = -5; //Velocidad de subida
				auxX = +2;
				baja = false;
			}
			if(posY == 320) { //Si Bilbo llegó al limite del salto
				baja = true;
				auxY = 5; //Velocidad de bajada
				sube = false;
			}
			if(sube) {
				posY += auxY;
				posX += auxX;
			}
			if(baja) {
				posY += auxY;
				if(posY == 570) { //Si Bilbo llegó al suelo -posicion inicial-
					saltar = false;
				}
				posX += auxX;
			}
			if(((Sauron.posX > 1000 && Sauron.posX <= 1500) || Sauron.posX <= 1) && posY == 570) {
				posX = 100;
			}
		}
	}
	/**
	 * Metodo en el que dibujamos el objeto Bilbo
	 * @param g
	 */
	public void dibujar(Graphics2D g) {
		ImageIcon habiaUnaVezUnHobbit = new ImageIcon(getClass().getResource("/imagenes/bilbo.png"));
		g.drawImage(habiaUnaVezUnHobbit.getImage(), posX, posY, anchura, altura, null);
	}
	/**
	 * Creamos el area del personaje para despues 
	 * calcular el area de colision -en la clase Sauron
	 * en el metodo choque()-
	 * @return cuerpoBilbo
	 */
	public Area areaBilbo() {
		Rectangle areaBilbo = new Rectangle(posX, posY, 95, 90);
		cuerpo = new Area(areaBilbo);
		cuerpoBilbo = cuerpo;
		cuerpoBilbo.add(cuerpo);
		
		return cuerpoBilbo;
	}	
}