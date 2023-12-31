package interfaceGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import senet.*;

public class InterfaceGrafica extends JFrame {
	private static final long serialVersionUID = 1L;
	
	protected AtorJogador atorJogador;
	protected JMenuBar barraDeMenu;
	protected JMenu menu;
	protected JMenu conexao;
	protected JMenuItem conectarServidor;
	protected JMenuItem alterarServidor;
	protected JMenuItem desconectar;
	protected JMenu partida;
	protected JMenuItem iniciarNovaPartida;
	protected JMenuItem desistirDaPartida;
	protected JMenuItem sair;
	protected JMenuItem ajuda;
	protected ConteudoJanela conteudoJanela;
	protected Font fontePadrao;
	protected TratadoraDeEvento tratadoraDeEvento;
	
	public InterfaceGrafica(String nomeJanela, AtorJogador atorJogador) {
		super(nomeJanela);
		configurarInterface(atorJogador);
		configurarFontePadrao();
		carregarComponentes();
		pack();
		setVisible(true);
	}
	
	public void configurarInterface(AtorJogador atorJogador) {
		tratadoraDeEvento = new TratadoraDeEvento(this);
		this.atorJogador = atorJogador;
		setPreferredSize(new Dimension(1150, 790));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		addWindowListener(tratadoraDeEvento);
	}
	
	public void configurarFontePadrao() {
		fontePadrao = new Font("sans-serif", Font.PLAIN, 20);
		
		UIManager.put("Menu.font", fontePadrao);
		UIManager.put("Button.font", fontePadrao);
		UIManager.put("MenuItem.font", fontePadrao);
		UIManager.put("Label.font", fontePadrao);
	}
	
	public void carregarComponentes() {
		carregarMenu();
		setContentPane(conteudoJanela = new ConteudoJanela(tratadoraDeEvento));
	}
	
	public void carregarMenu() {
		Color corDeFundo = Color.WHITE;
		
		barraDeMenu = new JMenuBar();
		barraDeMenu.setPreferredSize(new Dimension(500, 30));
		barraDeMenu.setBackground(corDeFundo);
		barraDeMenu.setOpaque(true);
		setJMenuBar(barraDeMenu);
		
		menu = new JMenu("Menu");
		menu.setBackground(corDeFundo);
		menu.setMnemonic(KeyEvent.VK_M);
		barraDeMenu.add(menu);
		
		conexao = new JMenu("Conex�o");
		conexao.setOpaque(true);
		conexao.setBackground(corDeFundo);
		menu.add(conexao);
		
		conectarServidor = new JMenuItem("Conectar servidor");
		conectarServidor.setBackground(corDeFundo);
		conectarServidor.addActionListener(tratadoraDeEvento);
		conectarServidor.setActionCommand(Constante.CONECTAR_SERVIDOR);
		conexao.add(conectarServidor);
		
		alterarServidor = new JMenuItem("Alterar servidor");
		alterarServidor.setBackground(corDeFundo);
		alterarServidor.addActionListener(tratadoraDeEvento);
		alterarServidor.setActionCommand(Constante.ALTERAR_SERVIDOR);
		conexao.add(alterarServidor);
		
		desconectar = new JMenuItem("Desconectar");
		desconectar.setBackground(corDeFundo);
		desconectar.addActionListener(tratadoraDeEvento);
		desconectar.setActionCommand(Constante.DESCONECTAR);
		conexao.add(desconectar);
		
		partida = new JMenu("Partida");
		partida.setOpaque(true);
		partida.setBackground(corDeFundo);
		menu.add(partida);
		
		iniciarNovaPartida = new JMenuItem("Iniciar nova partida");
		iniciarNovaPartida.setBackground(corDeFundo);
		iniciarNovaPartida.addActionListener(tratadoraDeEvento);
		iniciarNovaPartida.setActionCommand(Constante.INICIAR_NOVA_PARTIDA);
		partida.add(iniciarNovaPartida);
		
		desistirDaPartida = new JMenuItem("Desistir da partida");
		desistirDaPartida.setBackground(corDeFundo);
		desistirDaPartida.addActionListener(tratadoraDeEvento);
		desistirDaPartida.setActionCommand(Constante.DESISTIR_DA_PARTIDA);
		partida.add(desistirDaPartida);
		
		sair = new JMenuItem("Sair");
		sair.setBackground(corDeFundo);
		sair.addActionListener(tratadoraDeEvento);
		sair.setActionCommand(Constante.SAIR);
		menu.add(sair);
		
		ajuda = new JMenuItem("Ajuda");
		ajuda.setBackground(corDeFundo);
		ajuda.setMnemonic(KeyEvent.VK_A);
		ajuda.addActionListener(tratadoraDeEvento);
		ajuda.setActionCommand(Constante.AJUDA);
		barraDeMenu.add(ajuda);
	}
	
	public void conectarServidor() {
		atorJogador.conectarServidor();
	}

	public boolean confirmarAcao(String acao) {
		Object[] opcoes = {"sim", "cancelar"};
		
		if (obterOpcao(opcoes, "Voc� deseja realmente " + acao + "?", "Confirmar") == 0)
			return true;
		
		return false;
	}

	public void exibirMensagem(String titulo, String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem, titulo, JOptionPane.PLAIN_MESSAGE);
	}

	public String[] obterDados(String tituloRequisicao, String[] mensagemPreenchimentoDado) {
		String[] dadosObtidos = new String[mensagemPreenchimentoDado.length];
		
		int i = 0;
		for (String dado : mensagemPreenchimentoDado)
			dadosObtidos[i++] = JOptionPane.showInputDialog(this, dado, tituloRequisicao,
								JOptionPane.QUESTION_MESSAGE);
		
		for (String dado : dadosObtidos)
			if (dado == null)
				return null;
		
		return dadosObtidos;
	}

	public int obterOpcao(Object[] opcoes, String mensagem, String titulo) {
		return	JOptionPane.showOptionDialog(this, mensagem,
				titulo, JOptionPane.PLAIN_MESSAGE,
				JOptionPane.QUESTION_MESSAGE, null, opcoes, null);
	}

	public void alterarServidor() {
		atorJogador.alterarServidor();
	}

	public void alterarConfiguracaoTabuleiro(ConfiguracaoTabuleiro configuracaoTabuleiro) {
		conteudoJanela.alterarConfiguracaoTabuleiro(configuracaoTabuleiro);
	}

	public void desconectarServidor() {
		atorJogador.desconectarServidor();
	}

	public void ajuda() {
		JOptionPane.showMessageDialog(null, Constante.AJUDA, "Ajuda", JOptionPane.INFORMATION_MESSAGE);
	}

	public void sair() {
		if (atorJogador.sair())
			System.exit(0);
	}

	public void declararLiberacaoPeao(int numeroCasaPeao) {
		atorJogador.declararLiberacaoPeao(numeroCasaPeao);
	}

	public void moverPeao(int numeroCasaPeao) {
		atorJogador.moverPeao(numeroCasaPeao);
	}

	public void lancarGravetos() {
		atorJogador.lancarGravetos();
	}

	public void iniciarNovaPartida() {
		atorJogador.iniciarNovaPartida();
	}

	public void desistirPartida() {
		atorJogador.desistirPartida();
	}
	
	public void alterarAtorJogador(AtorJogador atorJogador) {
		this.atorJogador = atorJogador;
	}
}
