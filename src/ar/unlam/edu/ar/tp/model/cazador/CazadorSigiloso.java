package ar.unlam.edu.ar.tp.model.cazador;

import ar.unlam.edu.ar.tp.model.profugo.Profugo;

public class CazadorSigiloso extends CazadorBase {

	public CazadorSigiloso(String nombre, int experiencia) {
		super(nombre, experiencia);
	}
	
	@Override
	public boolean puedeCapturar(Profugo p) {
		return this.getExperiencia() > p.getInocencia() && p.getHabilidad() < 50;
	}
	
	@Override
	public void intimidar(Profugo p) {
		p.reducirInocencia(2);
		p.reducirHabilidad(5);
	}
	
}