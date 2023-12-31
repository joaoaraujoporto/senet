package servidor;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;
import interfaceGrafica.*;
import senet.*;

public class AtorServidor implements OuvidorProxy {
	private static final long serialVersionUID = 1L;
	
	protected AtorJogador atorJogador;
	protected Proxy proxy;
	protected String nomeJogador;
	protected String nomeServidor;
	protected boolean conectado;
	
	public AtorServidor(AtorJogador atorJogador) {
		this.atorJogador = atorJogador;
		proxy = Proxy.getInstance();
		proxy.addOuvinte(this);
		conectado = false;
	}

	public boolean conectar(String nome, String servidor) {
		try {
			proxy.conectar(servidor, nome);
			alterarNomeJogador(nome);
			alterarNomeServidor(servidor);
			conectado = true;
			return true;
		} catch (JahConectadoException | NaoPossivelConectarException | ArquivoMultiplayerException e) {
			return false;
		}
	}

	public boolean desconectar() {
		try {
			proxy.desconectar();
			conectado = false;
			return true;
		} catch (NaoConectadoException e) {
			return false;
		}
	}

	public boolean iniciarPartida() {
		try {
			proxy.iniciarPartida(2);
			return true;
		} catch (NaoConectadoException e) {
			return false;
		}		
	}

	public boolean restabelecerConexao() {
		try {
			proxy.conectar(obterNomeJogador(), obterNomeServidor());
			conectado = true;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 
	 * @param jogada
	 */
	public void enviarJogada(JogadaSenet jogada) {
		try {
			proxy.enviaJogada(jogada);
		} catch (NaoJogandoException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param posicao
	 */
	@Override
	public void iniciarNovaPartida(Integer posicao) {
		String nomeAdversario = proxy.obterNomeAdversario(-1 * posicao + 3);
		atorJogador.receberSolicitacaoInicio(posicao, nomeJogador, nomeAdversario);		
	}

	public boolean obterServidorConectado() {
		return conectado;
	}

	public String obterNomeJogador() {
		return nomeJogador;
	}

	public String obterNomeServidor() {
		return nomeServidor;
	}

	public void alterarNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}

	public void alterarNomeServidor(String nomeServidor) {
		this.nomeServidor = nomeServidor;
	}

	public void alterarAtorJogador(AtorJogador atorJogador) {
		this.atorJogador = atorJogador;
	}

	@Override
	public void receberJogada(Jogada jogada) {
		JogadaSenet jogadaSenet = (JogadaSenet) jogada;
		atorJogador.receberJogada(jogadaSenet);
	}
	
	@Override
	public void finalizarPartidaComErro(String message) {}

	@Override
	public void receberMensagem(String msg) {}

	@Override
	public void tratarConexaoPerdida() {}

	@Override
	public void tratarPartidaNaoIniciada(String message) {}
}