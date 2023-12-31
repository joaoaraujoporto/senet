package interfaceGrafica;

import java.awt.*;
import javax.swing.*;

public class Status extends JPanel {
	private static final long serialVersionUID = 1L;
	
	protected JLabel pontuacao;
	protected JLabel deQuemEhVez;
	
	Status() {
		configurarStatus();
		carregarComponentes();
	}
	
	public void configurarStatus() {
		GridLayout layout = new GridLayout(2,1);
		setBackground(Color.WHITE);
		setLayout(layout);		
	}
	
	public void carregarComponentes() {
		pontuacao = new JLabel("Resultado lan�amento:");
		add(pontuacao);
		
		deQuemEhVez = new JLabel("De quem � a vez:");
		add(deQuemEhVez);
	}

	public void alterarConfiguracao(int pontuacao, String nomeJogadorDaVez) {		
		this.pontuacao.setText("Resultado lan�amento: " + pontuacao);
		this.deQuemEhVez.setText("De quem � a vez: " + nomeJogadorDaVez);
		
		if (pontuacao == 0)
			this.pontuacao.setText("Resultado lan�amento: ");
	}
}