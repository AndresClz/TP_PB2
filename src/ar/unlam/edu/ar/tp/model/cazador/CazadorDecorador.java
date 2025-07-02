package ar.unlam.edu.ar.tp.model.cazador;

public abstract class CazadorDecorador implements Cazador {
	protected Cazador base;
	
	public CazadorDecorador(Cazador base) {
		this.base = base;
	}
	
	@Override
	public int getExperiencia() {
		return base.getExperiencia();
	}
	
	@Override
	public char getTipoDeCazador() {
		return base.getTipoDeCazador();
	}
	
	@Override
	public int getCantProfugosCapturados() {
		return base.getCantProfugosCapturados();
	}
	
	@Override
	public void sumarExperiencia(int habilidadIntimidados, int cantidadCapturada) {
		base.sumarExperiencia(habilidadIntimidados, cantidadCapturada);
	}
	
	@Override
	public void sumarCapturas(int cantidadCapturada) {
		base.sumarCapturas(cantidadCapturada);
	}
}