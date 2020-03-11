import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Pijun extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Polje poz;
	private int pozicijaNaPutanji;
	private String boja;
	private int indeksIgraca;
	private int indeksPijuna;
	private JLabel slika = new JLabel();
	private int brPredjenihPolja;
	private int indeksAktivnogIgraca;
	private Polje startPolje;
	
	public JLabel getSlika() {
		return slika;
	}
	
	public int getIndeksIgraca() {
		return indeksIgraca;
	}

	public void setPoz(Polje poz) {
		slika.setBounds(poz.getX(), poz.getY(), Tabla.getVelicinaPijuna(), Tabla.getVelicinaPijuna());
		this.poz = poz;
	}
	
	public void setBrPredjenihPolja(int brPredjenihPolja) {
		this.brPredjenihPolja = brPredjenihPolja;
	}

	public Pijun(Polje pozicija, ImageIcon slicica, int indeksIgraca, String boja, int indeksPijuna, int indeksAktivnogIgraca)
	{
		this.indeksPijuna = indeksPijuna;
		this.indeksAktivnogIgraca = indeksAktivnogIgraca;
		this.pozicijaNaPutanji = -1;
		this.brPredjenihPolja = 0;
		this.startPolje = pozicija;
		this.poz = new Polje(pozicija.getX(),pozicija.getY());
		this.boja = boja;
		this.indeksIgraca = indeksIgraca;
		slika.setBounds(this.poz.getX(), this.poz.getY(), Tabla.getVelicinaPijuna(), Tabla.getVelicinaPijuna());
		slika.setIcon(slicica);
		slika.setVerticalAlignment(SwingConstants.CENTER);
		slika.setHorizontalAlignment(SwingConstants.CENTER);
		Tabla.tabla.add(slika);
		
		slika.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				//parametri[0] - kockica bacena
				//paramteri[1] - vrednost kockice
				//paramteri[2] - igrac igrao
				//paramteri[3] - trenutni igrac
				Object[] par = Tabla.vratiParametre();
				
				if((int)par[0] != 1 && (int)par[0] != 2)
				{
					if((int)par[3] == indeksAktivnogIgraca) 
					{
						if((int)par[1] == 6) 
						{
							/*if(Tabla.getAktivniIgraci()[indeksAktivnogIgraca].getBrojPijunaNaTabli() == 0) 
							{
								//JOptionPane.showMessageDialog(null, "Uspesno mozete da izadjete!");
								ubaciPijuna(Tabla.getAktivniIgraci()[indeksAktivnogIgraca].getPrvoPolje());
								Tabla.getAktivniIgraci()[indeksAktivnogIgraca].brojPijunaNaTabliPovecaj();
								Tabla.setKockicaBacena(1);
							}*/
							if(brPredjenihPolja >= 1) 
							{
								pomeriPijuna((int)par[1]);
								Tabla.setKockicaBacena(1);
								Tabla.sledeciIgrac();
								Tabla.getLbTekst().setText(Tabla.getAktivniIgraci()[Tabla.getTrenutniIgracNaPotezu()].getBoja() + " baca kockicu");
							}
							else 
							{
								ubaciPijuna(Tabla.getAktivniIgraci()[indeksAktivnogIgraca].getPrvoPolje());
								Tabla.setKockicaBacena(1);
							}
						}				
						else if((int)par[1] != 6)
						{
							if(Tabla.getAktivniIgraci()[indeksAktivnogIgraca].getBrojPijunaNaTabli() == 0) 
							{
								Tabla.sledeciIgrac();
								JOptionPane.showMessageDialog(null, "Potrebna vam je sestica da krenete,  " + Tabla.getAktivniIgraci()[indeksAktivnogIgraca] + " baca kockicu");
							}
							else if(pozicijaNaPutanji != -1)
							{
								pomeriPijuna((int)par[1]);
								Tabla.setKockicaBacena(1);
								Tabla.sledeciIgrac();
								Tabla.getLbTekst().setText(Tabla.getAktivniIgraci()[Tabla.getTrenutniIgracNaPotezu()].getBoja() + " baca kockicu");
								
							}
						}
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Pogresan igrac");
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Kockica nije bacena");
				}
				
				
			}
		});

	}

	public int getBrPredjenihPolja() {
		return brPredjenihPolja;
	}
	
	private int indeksPolja() 
	{
		for(int i = 0; i < Tabla.getPutanja().size(); i++) 
		{
			if(Tabla.getPutanja().get(i).getX() == poz.getX() && Tabla.getPutanja().get(i).getY() == poz.getY()) 
			{
				//System.out.println("indeks polja pijuna " + i);
				//System.out.println("broj predjenih polja " + this.brPredjenihPolja);
				return i;
			}
		}
		
		return -1;
	}
	
	private void ubaciPijuna(Polje a) 
	{
		
		Tabla.getAktivniIgraci()[indeksAktivnogIgraca].brojPijunaNaTabliPovecaj();	
		System.out.println("\n " + Tabla.getAktivniIgraci()[indeksAktivnogIgraca].getBoja() + " ----- " + Tabla.getAktivniIgraci()[indeksAktivnogIgraca].getBrojPijunaNaTabli());
		this.poz.setX(a.getX());
		this.poz.setY(a.getY());
		this.slika.setBounds(a.getX(), a.getY(), Tabla.getVelicinaPijuna(), Tabla.getVelicinaPijuna());
		this.pozicijaNaPutanji = indeksPolja();
		this.brPredjenihPolja = 1;		
		if(Tabla.getPutanja().get(pozicijaNaPutanji).getZauzeto() == 1) 
		{
			if(Tabla.getPutanja().get(pozicijaNaPutanji).getZauzeo().getIndeksIgraca() != this.indeksIgraca) 
			{
				Tabla.getPutanja().get(pozicijaNaPutanji).getZauzeo().pojedenPijun();
			}
		}
		Tabla.getPutanja().get(pozicijaNaPutanji).setZauzeto(1);
		Tabla.getPutanja().get(pozicijaNaPutanji).setZauzeo(this);
		
	}
	
	public void pomeriPijuna(int brojKoraka) 
	{
		if(this.brPredjenihPolja < 52 && this.brPredjenihPolja + brojKoraka < 56) 
		{
			this.pozicijaNaPutanji = indeksPolja();
			Tabla.getPutanja().get(pozicijaNaPutanji).setZauzeto(0);
			Tabla.getPutanja().get(pozicijaNaPutanji).setZauzeo(null);
		}
		else if(this.brPredjenihPolja > 51 && this.brPredjenihPolja + brojKoraka < 56)
		{
			Tabla.getAktivniIgraci()[indeksAktivnogIgraca].getKucica()[this.brPredjenihPolja - 51].setZauzeto(0);
		}
		
		if(this.brPredjenihPolja + brojKoraka <= 51) 
		{
			if(this.pozicijaNaPutanji + brojKoraka > 51) 
			{
				this.slika.setBounds(Tabla.getPutanja().get(pozicijaNaPutanji + brojKoraka - 52).getX(),Tabla.getPutanja().get(pozicijaNaPutanji + brojKoraka - 52).getY(),Tabla.getVelicinaPijuna(),Tabla.getVelicinaPijuna());
				this.pozicijaNaPutanji = pozicijaNaPutanji + brojKoraka - 52;
				this.brPredjenihPolja += brojKoraka ;
			}
			else
			{
				this.slika.setBounds(Tabla.getPutanja().get(pozicijaNaPutanji+brojKoraka).getX(),Tabla.getPutanja().get(pozicijaNaPutanji + brojKoraka).getY(),Tabla.getVelicinaPijuna(),Tabla.getVelicinaPijuna());
				this.pozicijaNaPutanji += brojKoraka;
				this.brPredjenihPolja +=  brojKoraka;
			}
			
			if(Tabla.getPutanja().get(pozicijaNaPutanji).getZauzeto() == 1) 
			{
				if(Tabla.getPutanja().get(pozicijaNaPutanji).getZauzeo().getIndeksIgraca() != this.indeksIgraca) 
				{
					Tabla.getPutanja().get(pozicijaNaPutanji).getZauzeo().pojedenPijun();
				}
			}
			Tabla.getPutanja().get(pozicijaNaPutanji).setZauzeto(1);
			Tabla.getPutanja().get(pozicijaNaPutanji).setZauzeo(this);
		}
		else if(this.brPredjenihPolja + brojKoraka > 51 && this.brPredjenihPolja + brojKoraka - Tabla.getAktivniIgraci()[indeksAktivnogIgraca].getBrojZauzetihKucica()  < 56)
		{
			this.slika.setBounds(Tabla.getAktivniIgraci()[indeksAktivnogIgraca].getKucica()[this.brPredjenihPolja - 51 + brojKoraka - 1].getX(), Tabla.getAktivniIgraci()[indeksAktivnogIgraca].getKucica()[this.brPredjenihPolja - 51 + brojKoraka - 1].getY(), Tabla.getVelicinaPijuna(), Tabla.getVelicinaPijuna());
			Tabla.getAktivniIgraci()[indeksAktivnogIgraca].getKucica()[this.brPredjenihPolja - 51 + brojKoraka - 1].setZauzeto(1);
			this.brPredjenihPolja +=  brojKoraka;
			
		}
		else if(this.brPredjenihPolja + brojKoraka > 55 )
		{
			if(Tabla.getAktivniIgraci()[indeksAktivnogIgraca].getBrojPijunaNaTabli() == 1) 
			{
				Tabla.sledeciIgrac();
				Tabla.setKockicaBacena(1);
				Tabla.getLbTekst().setText(Tabla.getAktivniIgraci()[Tabla.getTrenutniIgracNaPotezu()].getBoja() + " baca kockicu");
			}
			/*else if()
			{
				JOptionPane.showMessageDialog(null, "Nemoguce pomeriti tog pijuna");
			}
			*/
		}
		this.poz.setX(slika.getX());
		this.poz.setY(slika.getY());		
		this.pozicijaNaPutanji = indeksPolja();		
		//proveraKraj();
		System.out.println(this.boja + "Poz na putanji  " + indeksPolja() + " ,,,,, broj predj polja " + this.brPredjenihPolja);
	}
	
	
	@SuppressWarnings("unused")
	private void proveraKraj() 
	{
		if(Tabla.getAktivniIgraci()[indeksAktivnogIgraca].getKucica()[3].getZauzeto() == 1 && Tabla.getAktivniIgraci()[indeksAktivnogIgraca].getBrojZauzetihKucica() == 0) 
		{
			Tabla.getAktivniIgraci()[indeksAktivnogIgraca].povecajBrojZauzetihKucica();
		}
		if(Tabla.getAktivniIgraci()[indeksAktivnogIgraca].getKucica()[2].getZauzeto() == 1 && Tabla.getAktivniIgraci()[indeksAktivnogIgraca].getBrojZauzetihKucica() == 1) 
		{
			Tabla.getAktivniIgraci()[indeksAktivnogIgraca].povecajBrojZauzetihKucica();
		}
		if(Tabla.getAktivniIgraci()[indeksAktivnogIgraca].getKucica()[1].getZauzeto() == 1 && Tabla.getAktivniIgraci()[indeksAktivnogIgraca].getBrojZauzetihKucica() == 2) 
		{
			Tabla.getAktivniIgraci()[indeksAktivnogIgraca].povecajBrojZauzetihKucica();
		}
		if(Tabla.getAktivniIgraci()[indeksAktivnogIgraca].getKucica()[0].getZauzeto() == 1 && Tabla.getAktivniIgraci()[indeksAktivnogIgraca].getBrojZauzetihKucica() == 3) 
		{
			JOptionPane.showMessageDialog(null, "KRAJ IGRE POBEDNIK JE " + Tabla.getAktivniIgraci()[indeksAktivnogIgraca].getIme());
			System.exit(0);
		}
	}
	
	public void pojedenPijun() 
	{
		Tabla.getAktivniIgraci()[indeksAktivnogIgraca].brojPijunaNaTabliSmanji();	
		System.out.println("\n " + Tabla.getAktivniIgraci()[indeksAktivnogIgraca].getBoja() + " ----- " + Tabla.getAktivniIgraci()[indeksAktivnogIgraca].getBrojPijunaNaTabli());
		pozicijaNaPutanji = -1;
		brPredjenihPolja = 0;
		setPoz(startPolje);
		System.out.println(startPolje);
		
	}

	public int getIndeksPijuna() {
		return indeksPijuna;
	}

	
}
