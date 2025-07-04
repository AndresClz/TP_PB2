package ar.unlam.edu.ar.tp.model;

import java.util.*;
import ar.unlam.edu.ar.tp.model.profugo.Profugo;
import ar.unlam.edu.ar.tp.model.cazador.Cazador;

public class Agencia {
	private final Set<Cazador> listaCazadores;
	private final List<Map.Entry<Cazador, Profugo>> listaCapturas;
	
	public Agencia() {
		this.listaCazadores = new HashSet<>();
		this.listaCapturas = new ArrayList<>();
	}

	public void registrarCazador(Cazador cazador) {
		this.listaCazadores.add(cazador);
	}

	public Set<Cazador> getCazadores() {
		return Collections.unmodifiableSet(this.listaCazadores);
	}

	public void registrarCaptura(Cazador cazador, Profugo profugo) {
		Map.Entry<Cazador, Profugo> parCaptura = new AbstractMap.SimpleEntry<>(cazador, profugo);
		
		this.listaCapturas.add(parCaptura);
	}

	public List<Profugo> getCapturados() {
		List<Profugo> profugos = new ArrayList<>();
		
		for(Map.Entry<Cazador, Profugo> captura : listaCapturas) {
			profugos.add(captura.getValue());
		}
		
		return Collections.unmodifiableList(profugos);
	}

	public Profugo getMasHabilCapturado() {
		Profugo masHabil = null;
		int habilidadMax = 0;
		
		for(Profugo capturado : this.getCapturados()) {
			
			if(capturado.getHabilidad() >= habilidadMax) {
				habilidadMax = capturado.getHabilidad();
				masHabil = capturado;
			}
		}
		
		return masHabil;
	}

	public Cazador getCazadorConMasCapturas() {
		Cazador conMasCapturas = null;
		int mayorCantidad = -1; // Empezar en -1 para manejar el caso de 0 capturas

		for(Cazador c : this.listaCazadores) {
			if(c.getCantidadCapturada() > mayorCantidad) {
				mayorCantidad = c.getCantidadCapturada();
				conMasCapturas = c;
			}
		}
		
		return conMasCapturas;
	}
	
}