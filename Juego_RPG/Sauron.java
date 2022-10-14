package juegoTdPA;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import javax.swing.ImageIcon;

/**
 * @author davidarevalo
 * Clase donde se definen los atributos del personaje
 * asi como los diferentes metodos para que cumpla su funcion
 */
public class Sauron{
	Game juego;
	//Area del personaje
	Area cuerpoCabeza, pies; 
	Area cuerpoSauron;
	//Variables del personaje
	int anchura = 100;
	int altura = 150;
	static int posX = 1500; //Posicion inicial
	static int posY = 520;
	static int auxX = -4; //Movimiento horizontal
	//Constructor
	public Sauron(Game juego) {
		this.juego = juego;
	}
	/**
	 * Metodo que se divide en dos partes: si la posicion
	 * es 100 quiere decir que los dos objetos no han colisionado
	 * y por tanto hay un incremento de puntos y de nivel.
	 * En cambio si chocan, se llama al metodo choque() definiado
	 * mas adelante. Ahi, si el numero de vidas es 0, se llama al metodo
	 * guiemOuver, de lo contrario se llama a pierdeVida()
	 */
	public void mover() {
		if(posX <= -100) {
			juego.puntos++; //Linea 26 de la clase Game
			posX = 1300; //Vuelve a la posicion inicial
			if(juego.puntos == 3 | juego.puntos == 6 | juego.puntos == 9 | juego.puntos == 12) {
				auxX += -2;
				juego.nivel++; //Linea 27 de la clase Game
			}
		}
		else {
			/*
			 * Al producirse una colision, si tiene 0 vidas, se llama al metodo 
			 * que finaliza la partida, si no, le resta una vida
			 */
			if(choque()) { //Linea 62
				if(juego.vidas == 0) { //Linea 25 de la clase Game
					juego.gueimOuver(); //Linea 106 de la clase Game
				}
				else {
					juego.pierdeVida(); //Linea 109 de la clase Game
				}
			}
			else {
				posX += auxX;
			}
		}
	}
	/**
	 * Metodo en el que dibujamos el objeto Sauron
	 * @param g
	 */
	public void dibujar(Graphics2D g) {
		ImageIcon sauronElFeo = new ImageIcon(getClass().getResource("/imagenes/sauron.png"));
		g.drawImage(sauronElFeo.getImage(), posX, posY, anchura, altura, null);
	}
	/**
	 * Creamos el area del personaje para despues calcular 
	 * el area de colision en el metodo choque()
	 * @return cuerpoSauron
	 */
	public Area areaSauron() {
		Rectangle areaSauron = new Rectangle(posX, posY, 50, 95);
		cuerpoCabeza = new Area(areaSauron);
		cuerpoSauron = cuerpoCabeza;
		cuerpoSauron.add(cuerpoCabeza);
		
		return cuerpoSauron;
	}
	/**
	 * Metodo donde se calcula el area de colision entre
	 * las areas de los objetos Bilbo y Sauron
	 * @return
	 */
	public boolean choque() {
		Area areaColision = new Area(juego.bilbo.areaBilbo());
		areaColision.intersect(areaSauron());
		return !areaColision.isEmpty();
	}
}