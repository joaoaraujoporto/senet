package interfaceGrafica;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import java.awt.*;

public class Graveteiro extends JPanel {
	private static final long serialVersionUID = 1L;
	
	protected JLabel[] gravetos;
	
	Graveteiro() {
		configurarGraveteiro();
		carregarComponentes();
	}
	
	public void configurarGraveteiro() {
		GridLayout layout = new GridLayout(1,4);
		layout.setHgap(5);
		setLayout(layout);
		setBackground(Color.WHITE);
		gravetos = new JLabel[4];
	}
	
	public void carregarComponentes() {		
		for (int i = 0; i < 4; i++) {
			JLabel graveto = new JLabel();
			
			graveto.setPreferredSize(new Dimension(30,150));
			graveto.setBackground(new Color(215,157,120));
			graveto.setOpaque(true);
			graveto.setBorder(new MatteBorder(3, 3, 3, 3, Color.BLACK));
			graveto.setCursor(new Cursor(Cursor.HAND_CURSOR));
			gravetos[i] = graveto;
			add(graveto);
		}
	}
	
	public JLabel[] getCasasTabuleiro() {
		return gravetos;
	}

	public void alterarConfiguracao(boolean[] gravetosRiscados) {
		for (int i = 0; i < 4; i++) {
			if (!gravetosRiscados[i]) {
				gravetos[i].setIcon(null);
				continue;
			}
			
			gravetos[i].setIcon(new ImagemSenet(Constante.ENDERECO_IMG_RISCO, 30, 150).getImagem());
		}
	}
}
