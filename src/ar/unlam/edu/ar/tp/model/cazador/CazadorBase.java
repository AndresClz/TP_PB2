package ar.unlam.edu.ar.tp.model.cazador;

import java.util.*;

import ar.unlam.edu.ar.tp.model.Zona;
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
		return experiencia;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	
	public void sumarExperiencia(int habilidadIntimidados, int cantidadCapturada) {
		this.experiencia += habilidadIntimidados + (2 * cantidadCapturada);
	}

	public List<Profugo> getCapturados() {
		return this.capturados;
	}

	public boolean puedeCapturar(Profugo p) {
		// TODO Auto-generated method stub
		return false;
	}

	public void capturar(Zona zona) {
		// TODO Auto-generated method stub
		
	}

	public void intimidar(Profugo p) {
		// TODO Auto-generated method stub
		
	}
}