package ar.unlam.edu.ar.tp.model.cazador;

public interface Cazador {
	int getExperiencia();
	char getTipoDeCazador();
	int getCantProfugosCapturados();

	void sumarExperiencia(int habilidadIntimidados, int cantidadCapturada);
	void sumarCapturas(int cantidadCapturada);
}