package ar.unlam.edu.ar.tp.model;


import java.util.*;

import ar.unlam.edu.ar.tp.model.profugo.Profugo;
import ar.unlam.edu.ar.tp.model.cazador.Cazador;



public class Agencia {
	private List<Map.Entry<Cazador, Profugo>> listaCazadores;
	
	public Agencia() {
		listaCazadores = new ArrayList<>();
	}

	public void registrarCazador(Cazador cazador) {
		// TODO Auto-generated method stub
		
	}

	public List<Cazador> getCazadores() {
		// TODO Auto-generated method stub
		return null;
	}

	public void registrarCaptura(Cazador cazador, Profugo profugo) {
		// TODO Auto-generated method stub
		
	}

	public List<Profugo> getCapturados() {
		// TODO Auto-generated method stub
		return null;
	}

	public Profugo getMasHabilCapturado() {
		// TODO Auto-generated method stub
		return null;
	}

	public Cazador getCazadorConMasCapturas() {
		// TODO Auto-generated method stub
		return null;
	}
	
}