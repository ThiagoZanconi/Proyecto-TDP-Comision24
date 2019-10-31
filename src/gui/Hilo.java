package gui;

import juego.Juego;

public class Hilo extends Thread{
	private Juego juego;
	
	public Hilo(Juego juego) {
		this.juego=juego;
		
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			juego.mover();
		}
	}
}
