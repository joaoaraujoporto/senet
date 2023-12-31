package interfaceGrafica;

public class Constante {
	public static final String CONECTAR_SERVIDOR = "conectarServidor";
	public static final String ALTERAR_SERVIDOR = "alterarServidor";
	public static final String DESCONECTAR = "desconectar";
	public static final String INICIAR_NOVA_PARTIDA = "iniciarNovaPartida";
	public static final String DESISTIR_DA_PARTIDA = "desistirDaPartida";
	public static final String SAIR = "sair";
	public static final String LANCAR_GRAVETOS = "lancarGravetos";
	public static final String LIBERAR_TRES_VERDADES = "liberarTresVerdades";
	public static final String LIBERAR_REATOUM = "liberarReAtoum";
	public static final String FRACASSO_CONECTAR = "N�o foi poss�vel conectar com o servidor. " +
													"Altere o servidor ou tente mais tarde.";
	public static final String SUCESSO_CONECTAR = "O servidor foi conectado com sucesso."; // TODO - just?
	public static final String SUCESSO_DESCONECTAR = "O servidor foi desconectado com sucesso.";
	public static final String FRACASSO_DESCONECTAR = "Voc� j� est� desconectado";
	public static final String DADOS_INCORRETOS = "Seus dados est�o incorretos. " +
												  "Confira-os e tente novamente.";
	public static final String SUCESSO_ALTERAR = "O servidor foi alterado com sucesso.";
	public static final String FRACASSO_ALTERAR = "Voc� est� desconectado.";
	public static final String ERRO_NAO_CONECTADO = " n�o � poss�vel, pois voc� est� desconectado.";
	public static final String PEAO_CLARO = "claro";
	public static final String PEAO_ESCURO = "escuro";
	public static final String CASA_VAZIA = "casaVazia";
	public static final String CASA_PEAO_JOGADOR = "casaPeaoJogador";
	public static final String CASA_PEAO_ADVERSARIO = "casaPeaoAdversario";
	public static final String JOGADOR_COMECA_LANC = "Lance os gravetos para definir primeiro jogador.";
	public static final String ADVERSARIO_COMECA_LANC = "Aguarde o lan�amento do seu advers�rio.";
	public static final String ENDERECO_IMG_PEAO_CLARO = "imagens/peaoClaro.png";
	public static final String ENDERECO_IMG_PEAO_ESCURO = "imagens/peaoEscuro.png";
	public static final String ENDERECO_IMG_RISCO = "imagens/risco.png";
	public static final String SEM_PARTIDA = "Sem partida em andamento.";
	public static final String SEM_VEZ_JOGADOR = "A vez � do advers�rio.";
	public static final String SEM_COR_PEAO_DEFINIDA = "Lance os gravetos para definir quem inicia.";
	public static final String SEM_PEAO_LIBERACAO = "N�o existe pe�o a ser liberado nessa casa.";
	public static final String SEM_MOVIMENTO_POSSIVEL = "N�o h� movimento poss�vel. Vez passada ao advers�rio";
	public static final String JOGADOR_VENCEU = "Parab�ns, voc� venceu!";
	public static final String SEM_PEAO_NA_CASA = "Essa casa n�o possui um de seus pe�es.";
	public static final String SEM_GRAVETOS_LANCADOS = "Lance os gravetos antes de mover os pe�es.";
	public static final String MOVIMENTO_INVALIDO = "Movimento n�o permitido.";
	public static final String JOGADOR_PERDEU = "Voc� perdeu.";
	public static final String ADVERSARIO_DESISTIU = "Seu advers�rio desistiu. Parab�ns, voc� ganhou.";
	public static final String LIBERACAO_DECLARADA = "Lance os gravetos para tentar liberar seu pe�o.";
	public static final String GRAVETOS_JA_LANCADOS = "Voc� j� lan�ou os gravetos.";
	public static final String AJUDA = "1. Conecte-se a um servidor.\n" +
									   "2. Inicie uma nova partida.\n" +
									   "3. Lance os gravetos ou espere seu advers�rio lan�ar para decidir" +
									   " quem inicia e escolhe a cor dos pe�es.\n" +
									   "4. Antes de mover um pe�o, sempre lance os gravetos para" +
									   " definir quantas casas seu pe�o poder� andar.\n" +
									   "5. Para liberar um pe�o clique no bot�o da casa correspondente" +
									   " antes de lan�ar os gravetos.\n" +
									   "\t5.1 A casa das tr�s verdades � a antepen�ltima e necessita de" +
									   " 3 pontos para liberar o pe�o.\n" +
									   "\t5.2 A casa Re-Atoum � a pen�ltima e necessita de 2 pontos para" +
									   " liberar o pe�o.\n" +
									   "6. Quem liberar todos os pe�es antes vence!\n";
}
