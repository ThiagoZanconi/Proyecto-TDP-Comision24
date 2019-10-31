package juego;
import java.util.Random;
import enemigos.Curador;
import enemigos.Invocador;
import enemigos.Normal;
import enemigos.Rango;
import enemigos.Rapido;
import enemigos.Tanque;
import gui.*;

public final class Juego {
	
	protected static Tienda tienda;
	protected static GUI gui;
	protected static Elementos elementos;
	protected static final Juego juego=new Juego();
	protected static HiloAparicionEnemigos hiloAparicionEnemigos;
	protected static Hilo hiloGeneral;
	protected static NivelUno nivel;
	
	private Juego() {
		elementos=Elementos.getElementos();
	}
	
	public static Juego getJuego() {
		return juego;
	}
	
	public void iniciarJuego() {
		gui=GUI.getGUI();
		nivel=new NivelUno();
		tienda=new Tienda(nivel);
		hiloAparicionEnemigos=new HiloAparicionEnemigos(this);
		hiloGeneral=new Hilo(this);
		hiloGeneral.start();
		hiloAparicionEnemigos.start();
	}
	
	public boolean crearAliado() {
		return tienda.crearAliado();
	}
	
	public String aliadoComprado() {
		return tienda.aliadoComprado();
	}

	//Enemigos
	
	private void generarCurador(int x,int y) {
		Elemento curador=new Curador(x,y);
		elementos.a�adirElemento(curador);
		gui.getVentanaJuego().add(curador.getGrafico(),0);
	}
	
	private void generarInvocador(int x, int y) {
		Invocador invocador=new Invocador(x,y);
		elementos.a�adirElemento(invocador);
		gui.getVentanaJuego().add(invocador.getGrafico(),0);
	}
	
	private void generarNormal(int x, int y) {
		Normal normal=new Normal(x,y);
		elementos.a�adirElemento(normal);
		gui.getVentanaJuego().add(normal.getGrafico(),0);
	}
	
	private void generarRango(int x,int y) {
		Rango rango=new Rango(x,y);
		elementos.a�adirElemento(rango);
		gui.getVentanaJuego().add(rango.getGrafico(),0);
	}
	
	private void generarRapido(int x, int y) {
		Rapido rapido=new Rapido(x,y);
		elementos.a�adirElemento(rapido);
		gui.getVentanaJuego().add(rapido.getGrafico(),0);
	}
	
	private void generarTanque(int x, int y) {
		Tanque tanque=new Tanque(x,y);
		elementos.a�adirElemento(tanque);
		gui.getVentanaJuego().add(tanque.getGrafico(),0);
	}
	
	public void generarEnemigoAleatorio() {
		Random r=new Random();
		int fila=traducirFila(r.nextInt(700));
		int n=r.nextInt(100);
		if(n<30)
			generarNormal(-65,fila);
		else
			if(n<50)
				generarRapido(-65,fila);
			else
				if(n<70)
					generarTanque(-65,fila);
				else
					if(n<84)
						generarRango(-65,fila);
					else
						if(n<92)
							generarCurador(-65,fila);
						else
							generarInvocador(-65,fila);
	}
	
	private int traducirFila(int y) {
		int toReturn;
		if(y<200)
			toReturn=150;
		else
			if(y<300)
				toReturn=250;
			else
				if(y<400)
					toReturn=350;
				else
					if(y<500)
						toReturn=450;
					else
						if(y<600)
							toReturn=550;
						else
							toReturn=650;
		return toReturn-550;
	}
	
	/**
	 * 
	 */
	public void mover() {
		for(int i=0;i<elementos.size();i++) {
			elementos.getElemento(i).actividadSinColision();
			for(int j=i+1;j<elementos.size();j++) {
				elementos.chequearColision(elementos.getElemento(i),elementos.getElemento(j));
			}	
		}
		elementos.eliminar();
	}

}
