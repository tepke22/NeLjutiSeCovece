import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;



public class Tabla extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JPanel tabla;

	private String[] igraci;
	private static Igrac[] aktivniIgraci = new Igrac[4];
	private static int brojAktivnihIgraca;
	private static int trenutniIgracNaPotezu = 0;
	private static int velicinaPijuna;

	public static int getVelicinaPijuna() {
		return velicinaPijuna;
	}

	public static void sledeciIgrac() {
		trenutniIgracNaPotezu++;
		if(trenutniIgracNaPotezu == brojAktivnihIgraca) 
		{
			trenutniIgracNaPotezu = 0;
		}
	}
	
	public static int getTrenutniIgracNaPotezu() {
		return trenutniIgracNaPotezu;
		
	}

	public static Igrac[] getAktivniIgraci() {
		return aktivniIgraci;
	}

	private Random nasumicno = new Random();
	
	private Polje mestoKocka;
	private Polje mestoKockaMala = new Polje(268, 268);
	private Polje mestoKockaVelika = new Polje(368, 368);
	private static Kocka kockica;
	private static int vrednostKockice;
	private static int kockicaBacena = 1;
	
	public static void setKockicaBacena(int kockicaBacena) {
		Tabla.kockicaBacena = kockicaBacena;
	}

	private static boolean igracIgrao = false;
	private static Polje[][] startPolja;
	
	public static Polje[][] getStartPolja() {
		return startPolja;
	}

	private Polje[][] startPoljaMala= {
			{new Polje(66,106), new Polje(106,65), new Polje(145,106), new Polje(106,145)},
			{new Polje(425,106), new Polje(465,65), new Polje(506,106), new Polje(465,145)}, 
			{new Polje(425,465), new Polje(465,425), new Polje(506,465), new Polje(465,505)},
			{new Polje(66,465), new Polje(106,425), new Polje(145,465), new Polje(106,504)}};
	
	private Polje[][] startPoljaVelika= {
			{new Polje(88,141), new Polje(141,88), new Polje(194,141), new Polje(141,194)},
			{new Polje(566,141), new Polje(619,88), new Polje(672,141), new Polje(619,194)}, 
			{new Polje(566,619), new Polje(619,566), new Polje(672,619), new Polje(619,672)},
			{new Polje(88,619), new Polje(141,566), new Polje(194,619), new Polje(141,672)}};
	
	//private Polje[][] startPoljaZeleni= {{new Polje(85,133), new Polje(136,82), new Polje(187,133), new Polje(136,185)},
	//private Polje[] startPoljaCrveni= {new Polje(546,133), new Polje(597,82), new Polje(650,133), new Polje(598,185)};
	//private Polje[] startPoljaPlavi= {new Polje(546,595), new Polje(597,544), new Polje(650,595), new Polje(598,647)};
	//private Polje[] startPoljaZuti= {new Polje(85,595), new Polje(136,544), new Polje(187,595), new Polje(136,647)};
	private static Polje[][] kucaPolja;
	
	public static Polje[][] getKucaPolja() {
		return kucaPolja;
	}

	private Polje[][] kucaPoljaMala= {
			{new Polje(47,285), new Polje(87,285), new Polje(162,285), new Polje(213,285)},
			{new Polje(286,46), new Polje(286,86), new Polje(286,126), new Polje(286,165)},			
			{new Polje(526,286), new Polje(486,286), new Polje(446,286), new Polje(406,286)},
			{new Polje(285,524), new Polje(285,484), new Polje(285,444), new Polje(285,405)}};
	
	private Polje[][] kucaPoljaVelika= {
			{new Polje(61,380), new Polje(114,380), new Polje(167,380), new Polje(220,380)},
			{new Polje(380,61), new Polje(380,114), new Polje(380,167), new Polje(380,220)},			
			{new Polje(699,380), new Polje(646,380), new Polje(592,380), new Polje(540,380)},
			{new Polje(380,699), new Polje(380,646), new Polje(380,592), new Polje(380,540)}};
	
	
	//private Polje[] kucaPoljaZeleni= {new Polje(60,365), new Polje(110,365), new Polje(162,365), new Polje(213,365)};
	//private Polje[] kucaPoljaCrveni= {new Polje(367,57), new Polje(367,107), new Polje(367,159), new Polje(367,210)};
	//private Polje[] kucaPoljaPlavi= {new Polje(675,365), new Polje(624,365), new Polje(573,365), new Polje(521,365)};
	//private Polje[] kucaPoljaZuti= {new Polje(367,672), new Polje(367,620), new Polje(367,569), new Polje(367,518)};
	
	private Polje[] poljaImena;
	
	private Polje[] poljaImenaMala = {new Polje(145,225), new Polje(365,225),  new Polje(365,366), new Polje(145,366)};
	private Polje[] poljaImenaVelika = {new Polje(199,292), new Polje(487,292),  new Polje(487,488), new Polje(199,488)};
	
	
	private static ArrayList<Polje> putanja;	
	public static ArrayList<Polje> getPutanja() {
		return putanja;
	}		
	private static ArrayList<Polje> putanjaMala = new ArrayList<Polje>( Arrays.asList(
			new Polje(7,245), new Polje(46,245), new Polje(86,245), new Polje(126,245), new Polje(166,245), new Polje(206,245),
			new Polje(246,206), new Polje(246,166), new Polje(246,126), new Polje(246,86), new Polje(246,46), new Polje(246,7),
			new Polje(286,7),
			new Polje(326,7), new Polje(326,46), new Polje(326,86), new Polje(326,126), new Polje(326,166), new Polje(326,206),
			new Polje(365,245), new Polje(405,245), new Polje(445,245), new Polje(485,245), new Polje(525,245), new Polje(565,245),
			new Polje(565,285),
			new Polje(565,325), new Polje(525,325), new Polje(485,325), new Polje(445,325), new Polje(405,325), new Polje(365,325),
			new Polje(326,365), new Polje(326,405), new Polje(326,445), new Polje(326,485), new Polje(326,525), new Polje(326,565),
			new Polje(285,565),
			new Polje(245,565), new Polje(245,525), new Polje(245,485), new Polje(245,445), new Polje(245,405), new Polje(245,365),
			new Polje(206,325), new Polje(166,325), new Polje(126,325), new Polje(86,325), new Polje(46,325), new Polje(7,325),
			new Polje(7,285)));
	
	private static ArrayList<Polje> putanjaVelika = new ArrayList<Polje>( Arrays.asList(
			new Polje(9,327), new Polje(61,327), new Polje(115,327), new Polje(168,327), new Polje(221,327), new Polje(274,327),
			new Polje(327,274), new Polje(327,221), new Polje(327,168), new Polje(327,115), new Polje(327,61), new Polje(327,9),
			new Polje(380,9),
			new Polje(434,9), new Polje(434,61), new Polje(434,115), new Polje(434,168), new Polje(434,221), new Polje(434,274),
			new Polje(488,327), new Polje(540,327), new Polje(593,327), new Polje(646,327), new Polje(699,327), new Polje(755,327),
			new Polje(752,380),
			new Polje(752,433), new Polje(699,433), new Polje(646,433), new Polje(593,433), new Polje(540,433), new Polje(488,433),
			new Polje(434,488), new Polje(434,540), new Polje(434,593), new Polje(434,646), new Polje(434,699), new Polje(434,752),
			new Polje(380,752),
			new Polje(327,752), new Polje(327,699), new Polje(327,646), new Polje(327,593), new Polje(327,540), new Polje(327,488),
			new Polje(274,433), new Polje(221,433), new Polje(168,433), new Polje(115,433), new Polje(61,433), new Polje(9,433),
			new Polje(9,380)));	
	
	

	private static Polje[] prvaPolja = new Polje[4];
	
	public static Polje[] getPrvaPolja() {
		return prvaPolja;
	}	
	
	private static JLabel lbTekst;
	public static JLabel getLbTekst() {
		return lbTekst;
	}
	
	
	public Tabla(String[] igraci) 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tabla.class.getResource("/slike/kocka/kocka6.png")));
		setTitle("Ne ljuti se \u010Dove\u010De");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.igraci=igraci;
		addMouseListener(new Mouse());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tabla = new JPanel();
		tabla.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(tabla);
		tabla.setLayout(null);
		
		JLabel lbTabla = new JLabel("");
		
		lbTekst = new JLabel("");
		lbTekst.setFont(new Font("Papyrus", Font.BOLD, 18));
		lbTekst.setHorizontalAlignment(SwingConstants.CENTER);
		lbTekst.setBounds(5, 810, 805, 40);
		
		try 
		{
			
			Image tablaSlika = ImageIO.read(Main.class.getResource("slike/tabla13.png"));
			if(screenSize.getHeight() < 900) 
			{
				setBounds((int) ((screenSize.getWidth()/2)-300) , 20, 625, 690);
				Image novaTabla = tablaSlika.getScaledInstance(600, 600, Image.SCALE_DEFAULT);
				lbTabla.setIcon(new ImageIcon(novaTabla));
				lbTabla.setBounds(5, 5, 600, 600);
				velicinaPijuna = 40;
				putanja = putanjaMala;
				startPolja = startPoljaMala;
				kucaPolja = kucaPoljaMala;
				poljaImena = poljaImenaMala;
				lbTekst.setBounds(5, 610, 605, 40);
				mestoKocka = mestoKockaMala;
			}
			else 
			{
				setBounds((int) ((screenSize.getWidth()/2)-400) , 60, 825, 890);
				Image novaTabla = tablaSlika.getScaledInstance(800, 800, Image.SCALE_DEFAULT);
				lbTabla.setIcon(new ImageIcon(novaTabla));
				lbTabla.setBounds(5, 5, 800, 800);
				velicinaPijuna = 50;
				putanja = putanjaVelika;
				startPolja = startPoljaVelika;
				kucaPolja = kucaPoljaVelika;
				poljaImena = poljaImenaVelika;
				lbTekst.setBounds(5, 810, 805, 40);
				mestoKocka = mestoKockaVelika;
			}
			prvaPolja[0] = putanja.get(1);
			prvaPolja[1] = putanja.get(14);
			prvaPolja[2] = putanja.get(27);
			prvaPolja[3] = putanja.get(40);
			brojAktivnihIgraca = postaviIgrace();
			
			lbTekst.setText(aktivniIgraci[0].getBoja() + " igrac baca kockicu");
			tabla.add(lbTekst);
			
			kockica = new Kocka(mestoKocka);
			
			JLabel lbKocka = new JLabel("");
			lbKocka.setBounds(331, 330, 120, 120);
			tabla.add(lbKocka);
			
			lbTabla.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lbTabla.setHorizontalAlignment(SwingConstants.LEFT);
			lbTabla.setVerticalAlignment(SwingConstants.TOP);
			tabla.add(lbTabla);
			
			
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	private int postaviIgrace() throws IOException 
	{
		int br = 0;
		if(!igraci[0].equals("")) 
		{
			Image image = ImageIO.read(Main.class.getResource("slike/pijuni/zeleni.png"));
			ImageIcon i = new ImageIcon(image.getScaledInstance(velicinaPijuna - 10, velicinaPijuna - 10, Image.SCALE_DEFAULT));
			aktivniIgraci[br] = new Igrac("Zeleni", igraci[0], i, prvaPolja[0], startPolja[0], kucaPolja[0], poljaImena[0] , 0, br);
			br++;
		}
		if(!igraci[1].equals("")) 
		{
			Image image = ImageIO.read(Main.class.getResource("slike/pijuni/crveni.png"));
			ImageIcon i = new ImageIcon(image.getScaledInstance(velicinaPijuna - 10, velicinaPijuna - 10, Image.SCALE_DEFAULT));
			aktivniIgraci[br] = new Igrac("Crveni", igraci[1], i, prvaPolja[1], startPolja[1], kucaPolja[1], poljaImena[1], 1,  br);
			br++;
		}	
		if(!igraci[2].equals("")) 
		{
			Image image = ImageIO.read(Main.class.getResource("slike/pijuni/plavi.png"));
			ImageIcon i = new ImageIcon(image.getScaledInstance(velicinaPijuna - 10, velicinaPijuna - 10, Image.SCALE_DEFAULT));
			aktivniIgraci[br] = new Igrac("Plavi", igraci[2], i, prvaPolja[2], startPolja[2], kucaPolja[2], poljaImena[2], 2,  br);
			br++;
		}
		if(!igraci[3].equals("")) 
		{
			Image image = ImageIO.read(Main.class.getResource("slike/pijuni/zuti.png"));
			ImageIcon i = new ImageIcon(image.getScaledInstance(velicinaPijuna - 10, velicinaPijuna - 10, Image.SCALE_DEFAULT));
			aktivniIgraci[br] = new Igrac("Zuti", igraci[3], i, prvaPolja[3], startPolja[3], kucaPolja[3], poljaImena[3], 3, br);
			br++;
		}
		return br;
	}

	public static Object[] vratiParametre() 
	{
		Object[] parametri = new Object[10];
		
		//parametri[0] - kockica bacena
		parametri[0] = kockicaBacena;
		//paramteri[1] - vrednost kockice
		parametri[1] = vrednostKockice;
		//paramteri[2] - igrac igrao
		parametri[2] = igracIgrao;
		//paramteri[3] - trenutni igrac
		parametri[3] = trenutniIgracNaPotezu;
		
		return parametri;
		
	}
	public class Mouse extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseClicked(e);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
						
			
			if(x  > (mestoKocka.getX() + 10 ) && x < (mestoKocka.getX() + kockica.getKocka().getWidth() + 10)) 
			{
				if(y > (mestoKocka.getY() + 35) && y < (mestoKocka.getY() + kockica.getKocka().getHeight() + 35)) 
				{

					//System.out.println("vrednost kocke = " + vrednostKockice + "  trenutni igrac " + trenutniIgracNaPotezu);
					if(kockicaBacena == 1 && !igracIgrao) 
					{
						kockica.getKocka().setIcon(kockica.getBacenaKockica());
						kockicaBacena = 2;
					}
					else if(kockicaBacena == 2)
					{
						vrednostKockice = kockica.baciKockicu(nasumicno);

						if(vrednostKockice < 6) 
						{
							if(aktivniIgraci[trenutniIgracNaPotezu].getBrojPijunaNaTabli() == 0) 
							{
								trenutniIgracNaPotezu++;
								if(trenutniIgracNaPotezu == brojAktivnihIgraca) 
								{
									trenutniIgracNaPotezu = 0;
									lbTekst.setText(aktivniIgraci[brojAktivnihIgraca - 1].getBoja() + " je bacio " + vrednostKockice + ",  " + aktivniIgraci[trenutniIgracNaPotezu].getBoja() + " baca kockicu");
								}
								else 
								{
									lbTekst.setText(aktivniIgraci[trenutniIgracNaPotezu - 1].getBoja() + " je bacio " + vrednostKockice + ",  " + aktivniIgraci[trenutniIgracNaPotezu].getBoja() + " baca kockicu");
								}
								kockicaBacena = 1;
							}
							else 
							{
								lbTekst.setText(aktivniIgraci[trenutniIgracNaPotezu].getBoja() + " je bacio " + vrednostKockice + ", odaberite pijuna");
								kockicaBacena = 3;
							}

						}
						else if(vrednostKockice == 6 && aktivniIgraci[trenutniIgracNaPotezu].getBrojPijunaNaTabli() == 0)
						{
							lbTekst.setText(aktivniIgraci[trenutniIgracNaPotezu].getBoja() + " je bacio " + vrednostKockice + ", odaberite pijuna");
							kockicaBacena = 3;
						}
						else if(vrednostKockice == 6 && aktivniIgraci[trenutniIgracNaPotezu].getBrojPijunaNaTabli() != 0)
						{
							lbTekst.setText(aktivniIgraci[trenutniIgracNaPotezu].getBoja() + " je bacio " + vrednostKockice + ", odaberite pijuna");
							kockicaBacena = 3;
						}
						
					}
				}
			}
			
			super.mousePressed(e);
		}
		
	}
}
