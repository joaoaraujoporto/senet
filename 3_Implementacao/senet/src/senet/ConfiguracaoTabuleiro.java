package senet;

import interfaceGrafica.Constante;

public class ConfiguracaoTabuleiro {
	protected String[] conteudoCasas;
	protected boolean[] gravetosRiscados;
	protected String corPeaoJogador;
	protected String corPeaoAdversario;
	protected int qtdPeoesJogadorLiberados;
	protected int qtdPeoesAdversarioLiberados;
	protected int numeroCasaPeaoLiberacao;
	protected int pontuacao;
	protected String nomeJogadorDaVez;
	
	public ConfiguracaoTabuleiro() {
		conteudoCasas = new String[30];
		gravetosRiscados = new boolean[4];
		zerarConfiguracao();
	}
	
	public void zerarConfiguracao() {
		alterarConteudoCasas(null);
		alterarGravetosRiscados(null);
		alterarCorPeaoJogador(null);
		alterarCorPeaoAdversario(null);
		alterarQtdPeoesJogadorLiberados(0);
		alterarQtdPeoesAdversarioLiberados(0);
		alterarNumeroCasaPeaoLiberacao(0);
		alterarPontuacao(0);
		alterarNomeJogadorDaVez("");
	}
	
	public void alterarConteudoCasas(Casa[] casas) {
		for (int i = 0; i < 30 ; i++)
			conteudoCasas[i] = Constante.CASA_VAZIA;
		
		if (casas == null)
			return;
		
		for (int i = 0; i < 30 ; i++)
			if (casas[i].obterOcupada())
				conteudoCasas[i] = casas[i].obterCorPeaoOcupante();
	}

	public void alterarCorPeaoJogador(String corPeaoJogador) {
		this.corPeaoJogador = corPeaoJogador;
	}
	
	public void alterarCorPeaoAdversario(String corPeaoAdversario) {
		this.corPeaoAdversario = corPeaoAdversario;
	}
	
	public void alterarQtdPeoesJogadorLiberados(int qtdPeoesJogadorLiberados) {
		this.qtdPeoesJogadorLiberados = qtdPeoesJogadorLiberados;
	}
	
	public void alterarQtdPeoesAdversarioLiberados(int qtdPeoesAdversarioLiberados) {
		this.qtdPeoesAdversarioLiberados = qtdPeoesAdversarioLiberados;
	}

	public void alterarNumeroCasaPeaoLiberacao(int numeroCasaPeaoLiberacao) {
		this.numeroCasaPeaoLiberacao = numeroCasaPeaoLiberacao;
	}

	public void alterarPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public void alterarNomeJogadorDaVez(String nomeJogadorDaVez) {
		this.nomeJogadorDaVez = nomeJogadorDaVez;
	}

	public String[] obterConteudoCasas() {
		return conteudoCasas;
	}

	public String obterCorPeaoJogador() {
		return corPeaoJogador;
	}
	
	public String obterCorPeaoAdversario() {
		return corPeaoAdversario;
	}

	public int obterQtdPeoesJogadorLiberados() {
		return qtdPeoesJogadorLiberados;
	}

	public int obterQtdPeoesAdversarioLiberados() {
		return qtdPeoesAdversarioLiberados;
	}

	public int obterNumeroCasaPeaoLiberacao() {
		return numeroCasaPeaoLiberacao;
	}

	public int obterPontuacao() {
		return pontuacao;
	}

	public String obterNomeJogadorDaVez() {
		return nomeJogadorDaVez;
	}
	
	public boolean[] obterGravetosRiscados() {
		return gravetosRiscados;	
	}

	public void alterarGravetosRiscados(Graveto[] gravetos) {
		for (int i = 0; i < 4; i++)
			gravetosRiscados[i] = false;
		
		if (gravetos == null)
			return;
		
		for (int i = 0; i < 4; i++)
			gravetosRiscados[i] = gravetos[i].obterRiscado();
	}
}