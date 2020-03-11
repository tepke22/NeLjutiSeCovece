import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Igrac {

	private String ime;
	private String boja;
	private Pijun[] pijuni=new Pijun[4];
	private Polje[] startnaPolja = new Polje[4];
	private Polje[] kucicaPolja = new Polje[4];
	private int brojPijunaNaTabli;
	private Polje prvoPolje;
	private int brojZauzetihKucica;
	
	public int getBrojPijunaNaTabli() {
		return brojPijunaNaTabli;
	}

	public void setBrojPijunaNaTabli(int brojPijunaNaTabli) {
		this.brojPijunaNaTabli = brojPijunaNaTabli;
	}

	public void brojPijunaNaTabliSmanji() 
	{
		brojPijunaNaTabli--;
	}
	
	public void brojPijunaNaTabliPovecaj() 
	{
		brojPijunaNaTabli++;
	}
	
	public Pijun[] getPijuni() {
		return pijuni;
	}

	
	public Igrac(String boja, String ime, ImageIcon slikaPijuna, Polje prvoPolje,Polje[] startnaPolja, Polje[] kucica, Polje mestoIme, int indeksIgraca, int indeksAktivnogIgraca) 
	{
		this.setBoja(boja);
		this.ime = ime;
		for(int i=0;i<4;i++) 
		{
			pijuni[i]=new Pijun(startnaPolja[i], slikaPijuna, indeksIgraca, boja, i, indeksAktivnogIgraca);
		}
		this.brojPijunaNaTabli = 0;
		this.brojZauzetihKucica = 0;
		this.prvoPolje=prvoPolje;
		this.startnaPolja = startnaPolja;
		this.kucicaPolja=kucica;
		JLabel i = new JLabel(ime);
		i.setOpaque(true);
		i.setBackground(Color.WHITE);
		i.setHorizontalAlignment(SwingConstants.CENTER);
		i.setFont(new Font("Consolas", Font.BOLD, 17));
		i.setBounds(mestoIme.getX(),mestoIme.getY(),(Tabla.getVelicinaPijuna() == 50 ? 120 : 100), (Tabla.getVelicinaPijuna() == 50 ? 30 : 20));
		Tabla.tabla.add(i);
	}
	
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getBoja() {
		return boja;
	}

	public void setBoja(String boja) {
		this.boja = boja;
	}

	public Polje[] getStartnaPolja() {
		return startnaPolja;
	}

	public void setStartnaPolja(Polje[] startnaPolja) {
		this.startnaPolja = startnaPolja;
	}

	public Polje[] getKucica() {
		return kucicaPolja;
	}

	public Polje getPrvoPolje() {
		return prvoPolje;
	}

	public int getBrojZauzetihKucica() {
		return brojZauzetihKucica;
	}

	public void povecajBrojZauzetihKucica() {
		this.brojZauzetihKucica++;
	}

}

