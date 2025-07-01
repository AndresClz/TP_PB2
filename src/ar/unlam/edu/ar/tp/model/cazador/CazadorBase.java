package ar.unlam.edu.ar.tp.model.cazador;

public class CazadorBase implements Cazador {
	private int experiencia;
	private int tipoDeCazador;
	
	public CazadorBase(int experiencia, char tipoDeCazador) {
		this.experiencia = experiencia;
		this.tipoDeCazador = tipoDeCazador;
	}
	
	public int getExperiencia() {
		return experiencia;
	}
	
	public int getTipoDeCazador() {
		return this.tipoDeCazador;
	}
	
	public void sumarExperiencia(int habilidadIntimidados, int cantidadCapturada) {
		this.experiencia = this.experiencia + habilidadIntimidados + (2 * cantidadCapturada);
	}
}