package ar.unlam.edu.ar.tp.model.cazador;

import ar.unlam.edu.ar.tp.model.profugo.Profugo;

public class CazadorUrbano extends CazadorBase {
	
	public CazadorUrbano(String nombre, int experiencia) {
		super(nombre, experiencia);
	}
	
	@Override
	public boolean puedeCapturar(Profugo p) {
		boolean sePuedeCapturar = false; 
		
		if( this.getExperiencia() > p.getInocencia() && 
			p.isNervioso() == false ) {
			sePuedeCapturar = true;
		}
		
		return sePuedeCapturar;
	}
	
	@Override
	public void intimidar(Profugo p) {
		p.reducirInocencia(2);
		p.setNervioso(false);
	}
}
