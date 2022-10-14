package juegoTdPA;

import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 * @author davidarevalo
 * Clase en la cual se define el fondo del videjuego 
 * así como diferentes tecturas
 */
public class Fondo{
//	int anchura = 1500;
//	int altura = 800;
//	int x00 = 0;
//	int y00 = 0;
//	int x10 = 0;
//	int y20 = 0;
	Game juego;
	//Variables del fondo
	int anchura1 = 1500;
	int altura1 = 800;
	int x11 = 1500;
	int y11 = 0;
	int x21 = 0;
	int y21 = -100;
	//Variables del suelo "arriba"
	int anchura2 = 1500;
	int altura2 = 70;
	int x12 = 1500;
	int y12 = 0;
	int x22 = 0;
	int y22 = 670;
	//Variables del suelo "abajo"
	int anchura3 = 1500;
	int altura3 = 50;
	int x13 = 1500;
	int y13 = 0;
	int x23 = 0;
	int y23 = 730;
	
//	public void mover() {
//		x12 -= 2;
//		x22 -= 2;
//		if(x12 == 0 && x22 == -1500) {
//			x12 = 1500;
//			x22 = 0;
//		}
//	} 
	//Constructor
	public Fondo(Game juego) {
		this.juego = juego;
	}
	/**
	 * Metodo en el que dibujamos el objeto Fondo
	 * @param g
	 */
	public void dibujar(Graphics2D g) {
//		ImageIcon fondito = new ImageIcon(getClass().getResource("/imagenes/campo.png"));
//		g.drawImage(fondito.getImage(), x00, y00, anchura, altura, null);
//		g.drawImage(fondito.getImage(), x10, y20, anchura, altura, null);
//		
		ImageIcon mordor = new ImageIcon(getClass().getResource("/imagenes/mordor.png"));
		g.drawImage(mordor.getImage(), x11, y11, anchura1, altura1, null);
		g.drawImage(mordor.getImage(), x21, y21, anchura1, altura1, null);
		ImageIcon suelo = new ImageIcon(getClass().getResource("/imagenes/suelo_sup.jpeg"));
		g.drawImage(suelo.getImage(), x12, y12, anchura2, altura2, null);
		g.drawImage(suelo.getImage(), x22, y22, anchura2, altura2, null);
		ImageIcon subSuelo = new ImageIcon(getClass().getResource("/imagenes/suelo.jpeg"));
		g.drawImage(subSuelo.getImage(), x13, y13, anchura3, altura3, null);
		g.drawImage(subSuelo.getImage(), x23, y23, anchura3, altura3, null);
		
	}
}