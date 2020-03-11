import javax.swing.JDialog;

public class Main {

	public static void main(String[] args) {
		Odabir odabrani = new Odabir();
		odabrani.setModal(true);	
		odabrani.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		odabrani.setVisible(true);
		
		Tabla tabla = new Tabla(odabrani.izabraniIgraci());
		tabla.setVisible(true);
	}

}
