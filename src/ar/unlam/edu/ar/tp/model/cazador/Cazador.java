package ar.unlam.edu.ar.tp.model.cazador;

public interface Cazador {
	int getExperiencia();
	int getTipoDeCazador();

	void sumarExperiencia(int habilidadIntimidados, int cantidadCapturada);
}