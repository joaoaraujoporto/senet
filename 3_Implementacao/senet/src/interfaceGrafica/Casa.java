package interfaceGrafica;

import java.awt.Color;
import javax.swing.JLabel;

// TODO - especializar casa para CasaTabuleiro
public class Casa extends JLabel {
	private static final long serialVersionUID = 1L;

	protected int numeroDaCasa;
	protected Color corDeFundo; // TODO - eliminar tudo relacionado a corDeFundo se n�o
	protected Color corDeFundoRealce; // se mostrar util depois TODO
	
	public Casa() {
		corDeFundo = Color.WHITE; // TODO - ver se padronizamos white como cor de fundo
	}
	
	public int obterNumeroDaCasa() {
		return numeroDaCasa;
	}
	
	public Color obterCorDeFundo() {
		return corDeFundo;
	}
	
	public Color obterCorDeFundoRealce() {
		if (!corDeFundo.equals(Color.WHITE))
			return (new Color(215,157,170));
		
		return corDeFundo;
	}
	
	public void alterarNumeroDaCasa(int numeroDaCasa) {
		this.numeroDaCasa = numeroDaCasa;
	}
	
	public void alterarCorDeFundo(Color corDeFundo) {
		this.corDeFundo = corDeFundo;
		setBackground(corDeFundo);
	}
	
	public void alterarPeaoOcupante(String corPeao) {
		if (corPeao == Constante.PEAO_CLARO)
			setIcon(new ImagemSenet(Constante.ENDERECO_IMG_PEAO_CLARO, 80, 100).getImagem());
		else if (corPeao == Constante.PEAO_ESCURO)
			setIcon(new ImagemSenet(Constante.ENDERECO_IMG_PEAO_ESCURO, 80, 100).getImagem());
		else
			setIcon(null);
	}
	
	@Override
	public String toString() {
		return "numero da casa = " + numeroDaCasa;
	}
}
