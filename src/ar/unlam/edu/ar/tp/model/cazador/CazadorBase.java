package ar.unlam.edu.ar.tp.model.cazador;

public class CazadorBase implements Cazador {
	private int experiencia;
	private char tipoDeCazador;
	private int cantProfugosCapturados;
	
	public CazadorBase(int experiencia, char tipoDeCazador) {
		this.experiencia = experiencia;
		this.tipoDeCazador = tipoDeCazador;
		this.cantProfugosCapturados = 0;
	}
	
	public int getExperiencia() {
		return experiencia;
	}
	
	public char getTipoDeCazador() {
		return this.tipoDeCazador;
	}
	
	public int getCantProfugosCapturados() {
		return this.cantProfugosCapturados;
	}
	
	public void sumarExperiencia(int habilidadIntimidados, int cantidadCapturada) {
		this.experiencia += habilidadIntimidados + (2 * cantidadCapturada);
	}
	
	public void sumarCapturas(int cantCapturada) {
		this.cantProfugosCapturados += cantCapturada;
	}
}