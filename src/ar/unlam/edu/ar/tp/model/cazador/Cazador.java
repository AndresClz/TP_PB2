package ar.unlam.edu.ar.tp.model.cazador;

import java.util.List;

import ar.unlam.edu.ar.tp.model.Agencia;
import ar.unlam.edu.ar.tp.model.Zona;
import ar.unlam.edu.ar.tp.model.profugo.Profugo;

public interface Cazador {
	String getNombre();
	int getExperiencia();
	List<Profugo> getCapturados();
	int getCantidadCapturada();

	void sumarExperiencia(int habilidadIntimidados, int cantidadCapturada);
	boolean puedeCapturar(Profugo p);
	void capturar(Zona zona, Agencia agencia);
	void intimidar(Profugo p);
}