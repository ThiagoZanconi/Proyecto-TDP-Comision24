package visitor;
import aliados.Aliado;
import disparos.Disparo;
import enemigos.Enemigo;

public class VisitorEnemigo extends Visitor {
	protected Enemigo miEnemigo;
	
	public VisitorEnemigo(Enemigo e) {
		miEnemigo=e;
	}
	
	public void visitarAliado(Aliado a) {
		miEnemigo.aceptar(a.getVisitor());
		
	}
	/**
	 * Colision enemigo con enemigo no hace nada
	 */
	public void visitarEnemigo(Enemigo e) {
		
	}

	public void visitarDisparo(Disparo d) {
		miEnemigo.aceptar(d.getVisitor());
		
	}

}
