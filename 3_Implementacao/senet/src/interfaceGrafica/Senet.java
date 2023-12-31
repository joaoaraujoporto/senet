package interfaceGrafica;

import servidor.*;

public class Senet {
	public static void main(String args[]) {
		AtorJogador atorJogador = new AtorJogador();
		InterfaceGrafica interfaceGrafica = new InterfaceGrafica("Senet", atorJogador);
		AtorServidor servidor = new AtorServidor(atorJogador);
		senet.Tabuleiro tabuleiro = new senet.Tabuleiro(atorJogador);
		atorJogador.alterarInterfaceGrafica(interfaceGrafica);
		atorJogador.alterarServidor(servidor);
		atorJogador.alterarTabuleiro(tabuleiro);
	}
}
