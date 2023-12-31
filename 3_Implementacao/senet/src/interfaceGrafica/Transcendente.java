package interfaceGrafica;

import java.awt.Color;
import java.awt.Dimension;

public class Transcendente extends Peaozeiro {
	private static final long serialVersionUID = 1L;
	
	Transcendente() {
		super(7, 1, 7);
		configurarTranscendente();
		configurarCasasTranscendente();
	}

	public void configurarTranscendente() {
		setPreferredSize(new Dimension(700, 100));
	}
	
	private void configurarCasasTranscendente() {
		for (Casa casa : casasDePeao)
			casa.setBackground(Color.WHITE);
	}

	public void alterarConfiguracao(int qtdPeoes, String corPeoes) {
		for (int i = 0; i < qtdPeoes; i++) {
			casasDePeao[6-i].alterarPeaoOcupante(corPeoes);
		}
			
	}
}
