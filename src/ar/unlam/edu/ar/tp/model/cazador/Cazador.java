package ar.unlam.edu.ar.tp.model.cazador;

import java.util.List;

import ar.unlam.edu.ar.tp.model.Zona;
import ar.unlam.edu.ar.tp.model.profugo.Profugo;

public interface Cazador {
	String getNombre();
	int getExperiencia();
	List<Profugo> getCapturados();

	void sumarExperiencia(int habilidadIntimidados, int cantidadCapturada);
	boolean puedeCapturar(Profugo p);
	void capturar(Zona zona);
	void intimidar(Profugo p);
}