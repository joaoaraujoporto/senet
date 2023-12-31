package interfaceGrafica;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;

public class Botaozeiro extends JPanel {
	private static final long serialVersionUID = 1L;
	
	protected JButton lancarGravetos;
	protected JLabel liberarPeao;
	protected JButton tresVerdades;
	protected JButton reAtoum;
	protected TratadoraDeEvento tratadoraDeEvento;
	
	Botaozeiro(TratadoraDeEvento tratadoraDeEvento) {
		configurarBotaozeiro(tratadoraDeEvento);
		carregarComponentes();
	}
	
	public void configurarBotaozeiro(TratadoraDeEvento tratadoraDeEvento) {
		this.tratadoraDeEvento = tratadoraDeEvento;
		GridLayout layout = new GridLayout(1,4);
		setBackground(Color.WHITE);
		layout.setHgap(40);	
		setLayout(layout);	
	}
	
	public void carregarComponentes() {
		Color corFundo = new Color(255,255,255);
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		MatteBorder borda = new MatteBorder(1, 1, 1, 1, new Color(47,82,143));
		
		lancarGravetos = new JButton("LAN�AR GRAVETOS");
		lancarGravetos.setBackground(corFundo);
		lancarGravetos.setCursor(cursor);
		lancarGravetos.setBorder(borda);
		lancarGravetos.addActionListener(tratadoraDeEvento);
		lancarGravetos.addMouseListener(tratadoraDeEvento);
		lancarGravetos.setActionCommand(Constante.LANCAR_GRAVETOS);
		add(lancarGravetos);
		
		liberarPeao = new JLabel("Liberar pe�o da casa");
		liberarPeao.setHorizontalAlignment(SwingConstants.RIGHT);
		add(liberarPeao);
		
		tresVerdades = new JButton("TR�S VERDADES");
		tresVerdades.setBackground(corFundo);
		tresVerdades.setCursor(cursor);
		tresVerdades.setBorder(borda);
		tresVerdades.addActionListener(tratadoraDeEvento);
		tresVerdades.addMouseListener(tratadoraDeEvento);
		tresVerdades.setActionCommand(Constante.LIBERAR_TRES_VERDADES);
		add(tresVerdades);
		
		reAtoum = new JButton("RE-ATOUM");
		reAtoum.setBackground(corFundo);
		reAtoum.setCursor(cursor);
		reAtoum.setBorder(borda);
		reAtoum.addActionListener(tratadoraDeEvento);
		reAtoum.addMouseListener(tratadoraDeEvento);
		reAtoum.setActionCommand(Constante.LIBERAR_REATOUM);
		add(reAtoum);
	}

	public void alterarConfiguracao(int numeroCasaPeaoLiberacao) {
		switch (numeroCasaPeaoLiberacao) {
			case 28: tresVerdades.setBackground(Color.WHITE); break;
			case 29: reAtoum.setBackground(Color.WHITE); break;
		}
	}
}
