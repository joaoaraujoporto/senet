package senet;

public class Graveto {

	protected boolean riscado;

	public Graveto() {
		riscado = false;
	}
	
	public void alterarRiscado(boolean riscado) {
		this.riscado = riscado;
	}

	public boolean obterRiscado() {
		return riscado;
	}

}