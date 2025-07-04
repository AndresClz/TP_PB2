package ar.unlam.edu.ar.tp.model.cazador;

import ar.unlam.edu.ar.tp.model.estrategia.EstrategiaNoNervioso;
import ar.unlam.edu.ar.tp.model.profugo.Profugo;

public class CazadorUrbano extends CazadorBase {

	public CazadorUrbano(String nombre, int experiencia) {
		super(nombre, experiencia, new EstrategiaNoNervioso());
	}
	
	@Override
	public void intimidar(Profugo p) {
		p.reducirInocencia(2);
		p.setNervioso(false);
	}
}