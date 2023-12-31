package interfaceGrafica;

import servidor.*;
import senet.*;

public class AtorJogador {
	protected InterfaceGrafica interfaceGrafica;
	protected AtorServidor servidor;
	protected senet.Tabuleiro tabuleiro;

	public AtorJogador() {}
	
	public void conectarServidor() {
		if (servidor.obterServidorConectado()) {
			if (interfaceGrafica.confirmarAcao("alterar servidor"))
				alterarServidor();
		} else if (procederConectarServidor())
			interfaceGrafica.exibirMensagem("Conectado", Constante.SUCESSO_CONECTAR);
	}
	
	public void desconectarServidor() {
		if (tabuleiro.obterPartidaEmAndamento())
			if (!procederDesistirPartida())
				return;
		
		if (servidor.desconectar()) {
			interfaceGrafica.exibirMensagem("", Constante.SUCESSO_DESCONECTAR);
			return;
		}
			
		interfaceGrafica.exibirMensagem("", Constante.FRACASSO_DESCONECTAR);
	}

	public boolean procederConectarServidor() {
		String[] dados;
		String[] nomesDados = {"nome jogador", "nome servidor"};
		
		dados = interfaceGrafica.obterDados("Dados para conex�o", nomesDados);
		
		while (dados != null && (dados[0].length() < 1 || dados[1].length() < 1)) {
			interfaceGrafica.exibirMensagem("", Constante.DADOS_INCORRETOS);
			dados = interfaceGrafica.obterDados("Dados para conex�o", nomesDados);
		}
		
		if (dados == null)
			return false;
		
		if (servidor.conectar(dados[0], dados[1]))
			return true;
			
		interfaceGrafica.exibirMensagem("", Constante.FRACASSO_CONECTAR);
		return false;	
	}

	public void alterarServidor() {
		if (tabuleiro.obterPartidaEmAndamento())
			if (!procederDesistirPartida())
				return;
		
		if (!servidor.desconectar())
			interfaceGrafica.exibirMensagem("Erro", "Alterar servidor" + Constante.ERRO_NAO_CONECTADO);
		else if (procederConectarServidor())
			interfaceGrafica.exibirMensagem("Alterado", Constante.SUCESSO_ALTERAR);
		else if (!servidor.restabelecerConexao())
			interfaceGrafica.exibirMensagem("N�o conectado", Constante.FRACASSO_ALTERAR);
	}

	public void iniciarNovaPartida() {
		if (tabuleiro.obterPartidaEmAndamento())
			if (!procederDesistirPartida())
				return;
		
		if (!servidor.iniciarPartida())
			interfaceGrafica.exibirMensagem("Erro", "Iniciar partida" + Constante.ERRO_NAO_CONECTADO);
	}

	public void desistirPartida() {
		if (!tabuleiro.obterPartidaEmAndamento()) {
			interfaceGrafica.exibirMensagem("Erro", Constante.SEM_PARTIDA);
			return;
		}
		
		procederDesistirPartida();
	}

	public boolean procederDesistirPartida() {
		if (interfaceGrafica.confirmarAcao("desistir da partida")) {
			servidor.enviarJogada(tabuleiro.desistirPartida());
			alterarConfiguracaoTabuleiro();
			interfaceGrafica.exibirMensagem("Fim partida", Constante.JOGADOR_PERDEU);
			
			return true;
		}
		
		return false;
	}

	public void receberJogada(JogadaSenet jogada) {
		tabuleiro.receberJogada(jogada);
		alterarConfiguracaoTabuleiro();
	}

	public void receberSolicitacaoInicio(int posicao, String nomeJogador, String nomeAdversario) {
		interfaceGrafica.exibirMensagem("Partida iniciada", "O nome do seu advers�rio � " + nomeAdversario);
		tabuleiro.iniciarNovaPartida(posicao, nomeJogador, nomeAdversario);
		alterarConfiguracaoTabuleiro();
		
		if (posicao == 1)
			interfaceGrafica.exibirMensagem("Voc� come�a", Constante.JOGADOR_COMECA_LANC);
		else
			interfaceGrafica.exibirMensagem("Seu advers�rio come�a", Constante.ADVERSARIO_COMECA_LANC);
	}

	public boolean sair() {
		if (tabuleiro.obterPartidaEmAndamento())
			if (!procederDesistirPartida())
				return false;
		
		if (servidor.obterServidorConectado())
			servidor.desconectar();
		
		return true;
	}

	public void declararLiberacaoPeao(int numeroCasaPeao) {
		if (!tabuleiro.declararLiberacaoPeao(numeroCasaPeao))
			return;
		
		alterarConfiguracaoTabuleiro();
	}

	public void lancarGravetos() {
		JogadaSenet jogada;
		
		if ((jogada = tabuleiro.lancarGravetos()) == null)
			return;

		servidor.enviarJogada(jogada);
		alterarConfiguracaoTabuleiro();
	}

	public void moverPeao(int numeroCasaPeao) {
		JogadaSenet jogada;
		
		if ((jogada = tabuleiro.moverPeao(numeroCasaPeao)) == null)
			return;

		servidor.enviarJogada(jogada);
		alterarConfiguracaoTabuleiro();
	}

	public void alterarConfiguracaoTabuleiro() {
		interfaceGrafica.alterarConfiguracaoTabuleiro(tabuleiro.obterConfiguracaoTabuleiro());
	}

	public void receberMensagem(String mensagem) {
		interfaceGrafica.exibirMensagem("", mensagem);
	}
	
	public String obterCorPeaoEscolhida() {
		Object[] opcoes = {"claro", "escuro"};
		
		if (interfaceGrafica.obterOpcao(opcoes,"Escolha a cor de seus pe�es", "Escolher cor") == 0)
			return Constante.PEAO_CLARO;
		
		return Constante.PEAO_ESCURO;
	}
	
	public void alterarInterfaceGrafica(InterfaceGrafica interfaceGrafica) {
		this.interfaceGrafica = interfaceGrafica;
	}
	
	public void alterarServidor(AtorServidor servidor) {
		this.servidor = servidor;
	}
	
	public void alterarTabuleiro(senet.Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
}