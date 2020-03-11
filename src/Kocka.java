import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Kocka {
	
	private ImageIcon[] slicice = new ImageIcon[7];
	
	private ImageIcon bacenaKockica = new ImageIcon(Main.class.getResource("slike/kocka/bacenaKockica.gif"));
	
	private JLabel kocka = new JLabel("");
	
	public Kocka(Polje mestoKocka) 
	{
		slikeKocka();
		kocka.setBounds(mestoKocka.getX(),mestoKocka.getY(),75,75);
		kocka.setIcon(slicice[0]);		
		kocka.setVerticalAlignment(SwingConstants.CENTER);
		kocka.setHorizontalAlignment(SwingConstants.CENTER);
		Tabla.tabla.add(kocka);
	}

		
	public JLabel getKocka() {
		return kocka;
	}
	
	public void setKocka(JLabel kocka) {
		this.kocka = kocka;
	}
	
	private void slikeKocka() 
	{
		try 
		{
			slicice[0] = new ImageIcon(ImageIO.read(Main.class.getResource("slike/kocka/kocka0.png")));
			slicice[1] = new ImageIcon(ImageIO.read(Main.class.getResource("slike/kocka/kocka1.png")));
			slicice[2] = new ImageIcon(ImageIO.read(Main.class.getResource("slike/kocka/kocka2.png")));
			slicice[3] = new ImageIcon(ImageIO.read(Main.class.getResource("slike/kocka/kocka3.png")));
			slicice[4] = new ImageIcon(ImageIO.read(Main.class.getResource("slike/kocka/kocka4.png")));
			slicice[5] = new ImageIcon(ImageIO.read(Main.class.getResource("slike/kocka/kocka5.png")));
			slicice[6] = new ImageIcon(ImageIO.read(Main.class.getResource("slike/kocka/kocka6.png")));
		} 
		catch (IOException e) 
		{
			JOptionPane.showMessageDialog(null, "GESKA PRI UVOZU SLIKA ZA KOCKICU");
		}

	}
		
	public ImageIcon[] getSlicice() {
		return slicice;
	}

	public ImageIcon getBacenaKockica() {
		return bacenaKockica;
	}
	
	public int baciKockicu(Random r) 
	{
		int vrednost = r.nextInt(6) + 1;
		kocka.setIcon(slicice[vrednost]);
		
		return vrednost;
	}
	
}


