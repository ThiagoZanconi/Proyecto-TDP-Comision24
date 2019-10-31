package aliados;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import visitor.VisitorAliado;

public class Barricada extends Aliado {

	public Barricada(int x,int y) {
		super(0,0,500,5000);
		imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\Barricada\\Barricada.png"));
		graficoActual = new JLabel();
		graficoActual.setIcon(imagenes[0].getIcon());
		graficoActual.setBounds(x, y-40, 1000,1000);
		alcanceDeAtaque=new Rectangle(x,y,0,0);
		rectangulo=new Rectangle(x,y-70,80,140);
		miVisitor=new VisitorAliado(this);
	}
	
	public void atacar() {
		
	}

}
