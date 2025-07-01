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
	public int getTipoDeCazador() {
		return base.getTipoDeCazador();
	}
	
	@Override
	public void sumarExperiencia(int habilidadIntimidados, int cantidadCapturada) {
		base.sumarExperiencia(habilidadIntimidados, cantidadCapturada);
	}
}