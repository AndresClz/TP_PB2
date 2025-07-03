package ar.unlam.edu.ar.tp.model.cazador;

import java.util.*;

import ar.unlam.edu.ar.tp.model.Zona;
import ar.unlam.edu.ar.tp.model.Agencia;
import ar.unlam.edu.ar.tp.model.profugo.Profugo;

public class CazadorBase implements Cazador {
	private String nombre;
	private int experiencia;
	private List<Profugo> capturados;
	
	public CazadorBase(String nombre, int experiencia) {
		this.nombre = nombre;
		this.experiencia = experiencia;
		this.capturados = new ArrayList<>();
	}
	
	public int getExperiencia() {
		return this.experiencia;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public List<Profugo> getCapturados() {
		return this.capturados;
	}
	
	public int getCantidadCapturada() {
		return this.capturados.size();
	}
	
	public void agregarCapturado(Profugo capturado) {
		this.capturados.add(capturado);
	}
	
	public void sumarExperiencia(int habilidadIntimidados, int cantidadCapturada) {
		this.experiencia += habilidadIntimidados + (2 * cantidadCapturada);
	}

	public boolean puedeCapturar(Profugo p) {
		return false;
	}

	public void capturar(Zona zona, Agencia agencia) {
		List<Profugo> profugos = zona.getProfugos();
		int cantidadCapturada = 0;
		int habilidadMinima = 101; //Se pone en 101 para que siempre guarde el primero.
		
		for( Profugo profugo : profugos) {
			
			if( this.puedeCapturar(profugo) == true ) {
				zona.removerProfugo(profugo);
				this.agregarCapturado(profugo);
				agencia.registrarCaptura(this, profugo);
				
				cantidadCapturada += 1;
			}
			else {
				this.intimidar(profugo);
				
				if(profugo.getHabilidad() < habilidadMinima ) 
				{ habilidadMinima = profugo.getHabilidad(); }
			}
			
		}
		
		if( habilidadMinima < 101) {
			this.sumarExperiencia(habilidadMinima, cantidadCapturada);
		}
		else {
			habilidadMinima = 0;
			this.sumarExperiencia(habilidadMinima, cantidadCapturada);
		}
	}

	public void intimidar(Profugo p) {
	}
}