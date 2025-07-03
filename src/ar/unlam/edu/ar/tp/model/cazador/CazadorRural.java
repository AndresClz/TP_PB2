package ar.unlam.edu.ar.tp.model.cazador;

import ar.unlam.edu.ar.tp.model.profugo.Profugo;

public class CazadorRural extends CazadorBase {

	public CazadorRural(String nombre, int experiencia) {
		super(nombre, experiencia);
	}
	
	@Override
	public boolean puedeCapturar(Profugo p) {
		return this.getExperiencia() > p.getInocencia() && p.isNervioso();
	}
	
	@Override
	public void intimidar(Profugo p) {
		p.reducirInocencia(2);
		p.setNervioso(true);
	}
	
}