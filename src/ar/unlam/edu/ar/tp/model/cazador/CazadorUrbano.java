package ar.unlam.edu.ar.tp.model.cazador;

import java.util.List;

import ar.unlam.edu.ar.tp.model.Zona;
import ar.unlam.edu.ar.tp.model.profugo.Profugo;

public class CazadorUrbano extends CazadorBase {
	
	public CazadorUrbano(String nombre, int experiencia) {
		super(nombre, experiencia);
	}
	
	@Override
	public boolean puedeCapturar(Profugo p) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void capturar(Zona zona) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void intimidar(Profugo p) {
		// TODO Auto-generated method stub
		
	}
}
