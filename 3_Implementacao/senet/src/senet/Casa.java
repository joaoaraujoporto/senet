package senet;

public class Casa {

	protected int numero;
	protected boolean ocupada;
	protected Peao peao;
	protected boolean segura;

	public Casa(int numero) {
		this.numero = numero;
		ocupada = false;
		peao = null;
		segura = false;
	}
	
	public boolean ehSeuNumero(int numero) {
		return this.numero == numero;
	}

	public String obterCorPeaoOcupante() {
		return peao.obterCor();
	}

	public int obterNumero() {
		return numero;
	}

	public boolean obterOcupada() {
		return ocupada;
	}

	public Peao obterPeao() {
		return peao;
	}

	public boolean obterSegura() {
		return segura;
	}

	public void alterarNumero(int numero) {
		this.numero = numero;
	}

	public void alterarOcupada() {
		ocupada = !ocupada;
	}

	public void alterarPeao(Peao peao) {
		this.peao = peao;
	}

	public void alterarSegura() {
		segura = !segura;
	}

}