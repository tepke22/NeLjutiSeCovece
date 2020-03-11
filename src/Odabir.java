import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JCheckBox;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;

public class Odabir extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfZeleni;
	private JTextField tfCrveni;
	private JTextField tfZuti;
	private JTextField tfPlavi;
	private JButton btnStart;
	private JCheckBox chbZuti;
	private JCheckBox chbZeleni;
	private JCheckBox chbCrveni;
	private JCheckBox chbPlavi;
	
	private int odabrano = 0;
	

	private int broj_odabranih_igraca = 0;
	
	public Odabir() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(odabrano == 0) 
				{
					System.exit(0);
				}
			}
		});
		setResizable(false);
		setTitle("Odabir igra\u010Da");
		
		
		setBounds((int) ((screenSize.getWidth()/2)-380), 100, 763, 412);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 298, 736, 65);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				btnStart = new JButton("START");
				btnStart.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						zatvori();
					}
				});
				btnStart.setEnabled(false);
				btnStart.setFont(new Font("Consolas", Font.BOLD, 18));
				btnStart.setBounds(281, 11, 188, 43);
				btnStart.setActionCommand("OK");
				buttonPane.add(btnStart);
				getRootPane().setDefaultButton(btnStart);
			}
		}
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 351, 119);
		getContentPane().add(panel);
		
		chbZeleni = new JCheckBox("Zeleni igrac");
		chbZeleni.setFont(new Font("Consolas", Font.BOLD, 18));
		chbZeleni.setBounds(6, 20, 155, 23);
		panel.add(chbZeleni);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Odabir.class.getResource("/slike/pijuni/zeleni.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(7, 46, 66, 65);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Ime zelenog igraca : ");
		label_1.setFont(new Font("Consolas", Font.BOLD, 12));
		label_1.setBounds(74, 72, 155, 14);
		panel.add(label_1);
		
		tfZeleni = new JTextField();
		tfZeleni.setText("Igrac1");
		tfZeleni.setFont(new Font("Consolas", Font.PLAIN, 11));
		tfZeleni.setEnabled(false);
		tfZeleni.setColumns(10);
		tfZeleni.setBounds(227, 67, 114, 20);
		panel.add(tfZeleni);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(395, 11, 351, 119);
		getContentPane().add(panel_1);
		
		chbCrveni = new JCheckBox("Crveni igrac");
		chbCrveni.setFont(new Font("Consolas", Font.BOLD, 18));
		chbCrveni.setBounds(6, 20, 155, 23);
		panel_1.add(chbCrveni);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Odabir.class.getResource("/slike/pijuni/crveni.png")));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(7, 46, 66, 65);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Ime crvenog igraca : ");
		label_3.setFont(new Font("Consolas", Font.BOLD, 12));
		label_3.setBounds(74, 72, 155, 14);
		panel_1.add(label_3);
		
		tfCrveni = new JTextField();
		tfCrveni.setText("Igrac2");
		tfCrveni.setFont(new Font("Consolas", Font.PLAIN, 11));
		tfCrveni.setEnabled(false);
		tfCrveni.setColumns(10);
		tfCrveni.setBounds(227, 67, 114, 20);
		panel_1.add(tfCrveni);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(395, 156, 341, 119);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		chbPlavi = new JCheckBox("Plavi igrac");
		chbPlavi.setBounds(6, 7, 155, 23);
		panel_2.add(chbPlavi);
		chbPlavi.setFont(new Font("Consolas", Font.BOLD, 18));
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Odabir.class.getResource("/slike/pijuni/plavi.png")));
		label_6.setBounds(7, 33, 66, 65);
		panel_2.add(label_6);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_7 = new JLabel("Ime plavog igraca : ");
		label_7.setBounds(74, 59, 155, 14);
		panel_2.add(label_7);
		label_7.setFont(new Font("Consolas", Font.BOLD, 12));
		
		tfPlavi = new JTextField();
		tfPlavi.setBounds(227, 54, 114, 20);
		panel_2.add(tfPlavi);
		tfPlavi.setText("Igrac3");
		tfPlavi.setFont(new Font("Consolas", Font.PLAIN, 11));
		tfPlavi.setEnabled(false);
		tfPlavi.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(10, 156, 351, 119);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Odabir.class.getResource("/slike/pijuni/zuti.png")));
		label_4.setBounds(7, 33, 66, 65);
		panel_3.add(label_4);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_5 = new JLabel("Ime zutog igraca : ");
		label_5.setBackground(new Color(255, 255, 255));
		label_5.setBounds(74, 59, 155, 14);
		panel_3.add(label_5);
		label_5.setFont(new Font("Consolas", Font.BOLD, 12));
		
		tfZuti = new JTextField();
		tfZuti.setBounds(227, 54, 114, 20);
		panel_3.add(tfZuti);
		tfZuti.setText("Igrac4");
		tfZuti.setFont(new Font("Consolas", Font.PLAIN, 11));
		tfZuti.setEnabled(false);
		tfZuti.setColumns(10);
		
		chbZuti = new JCheckBox("Zuti igrac");
		chbZuti.setBounds(6, 7, 155, 23);
		panel_3.add(chbZuti);
		chbZuti.setFont(new Font("Consolas", Font.BOLD, 18));
		
		
		
		
		chbZeleni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				odabir(chbZeleni, tfZeleni);
			}
		});
		
		chbCrveni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				odabir(chbCrveni, tfCrveni);
			}
		});
		
		chbZuti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				odabir(chbZuti, tfZuti);
			}
		});
		
		chbPlavi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				odabir(chbPlavi, tfPlavi);
			}
		});
		
		
		
	}
	
	private void odabir(JCheckBox x, JTextField y) 
	{
		if(x.isSelected()) 
		{
			y.setEnabled(true);
			broj_odabranih_igraca++;
		}
		else 
		{
			y.setEnabled(false);
			broj_odabranih_igraca--;
		}
		if(broj_odabranih_igraca > 0) 
		{
			btnStart.setEnabled(true);
		}
		else 
		{
			btnStart.setEnabled(false);
		}
	}
	
	private void zatvori() 
	{
		this.dispose();
	}
	
	public String[] izabraniIgraci()
	{
		String[] igraci = {"","","",""};
		if(chbZeleni.isSelected()) 
		{
			igraci[0] = tfZeleni.getText();
		}
		if(chbCrveni.isSelected()) 
		{
			igraci[1] = tfCrveni.getText();
		}
		if(chbPlavi.isSelected()) 
		{
			igraci[2] = tfPlavi.getText();
		}
		if(chbZuti.isSelected()) 
		{
			igraci[3] = tfZuti.getText();
		}
		odabrano = 1;
		return igraci;
	}	
}
