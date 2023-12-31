package interfaceGrafica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;


public class TratadoraDeEvento extends MouseAdapter implements ActionListener, WindowListener {
	private final InterfaceGrafica interfaceGrafica;

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		switch (comando) {
			case Constante.CONECTAR_SERVIDOR: interfaceGrafica.conectarServidor(); break;
			case Constante.ALTERAR_SERVIDOR: interfaceGrafica.alterarServidor(); break;
			case Constante.DESCONECTAR: interfaceGrafica.desconectarServidor(); break;
			case Constante.INICIAR_NOVA_PARTIDA: interfaceGrafica.iniciarNovaPartida(); break;
			case Constante.DESISTIR_DA_PARTIDA: interfaceGrafica.desistirPartida(); break;
			case Constante.SAIR: interfaceGrafica.sair(); break;
			case Constante.LANCAR_GRAVETOS: interfaceGrafica.lancarGravetos(); break;
			case Constante.LIBERAR_TRES_VERDADES: interfaceGrafica.declararLiberacaoPeao(28); break;
			case Constante.LIBERAR_REATOUM: interfaceGrafica.declararLiberacaoPeao(29); break;
			case Constante.AJUDA: interfaceGrafica.ajuda(); break;
		}
	}
	
	public TratadoraDeEvento(InterfaceGrafica interfaceGrafica) {
		this.interfaceGrafica = interfaceGrafica;
	}
	
	public InterfaceGrafica obterInterfaceGrafica() {
		return interfaceGrafica;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof Casa) {
			Casa casa = (Casa) e.getSource();
			interfaceGrafica.moverPeao(casa.obterNumeroDaCasa());			
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getComponent() instanceof Casa) {
			Casa casa = (Casa) e.getComponent();
			casa.setBackground(new Color(215,157,170));	
		} else if (e.getComponent() instanceof JButton) {
			JButton botao = (JButton) e.getComponent();
			
			if (!botao.getBackground().equals(new Color(91, 155, 213)))
				botao.setBackground(new Color(91, 155, 213));
			else
				botao.setBackground(Color.WHITE);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getComponent() instanceof Casa) {
			Casa casa = (Casa) e.getComponent();
			casa.setBackground(casa.obterCorDeFundo());	
		} else if (e.getComponent() instanceof JButton) {
			JButton botao = (JButton) e.getComponent();
			
			if (!botao.getBackground().equals(new Color(91, 155, 213)))
				botao.setBackground(new Color(91, 155, 213));
			else
				botao.setBackground(Color.WHITE);
		}
	}

	@Override
	public void windowActivated(WindowEvent arg0) {}

	@Override
	public void windowClosed(WindowEvent arg0) {}

	@Override
	public void windowClosing(WindowEvent e) {
		interfaceGrafica.sair();		
	}

	@Override
	public void windowDeactivated(WindowEvent arg) {}

	@Override
	public void windowDeiconified(WindowEvent arg) {}

	@Override
	public void windowIconified(WindowEvent arg) {}

	@Override
	public void windowOpened(WindowEvent arg) {}
}
