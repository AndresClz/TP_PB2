package ar.unlam.edu.ar.tp.model.cazador;

import java.util.*;

import ar.unlam.edu.ar.tp.model.estrategia.EstrategiaDeCaptura;
import ar.unlam.edu.ar.tp.model.profugo.Profugo;

public class CazadorBase implements Cazador {
	private String nombre;
	private int experiencia;
	private List<Profugo> capturados;

	private final EstrategiaDeCaptura estrategia;

	public CazadorBase(String nombre,
					   int experiencia,
					   EstrategiaDeCaptura estrategia) {
		this.nombre = nombre;
		this.experiencia = experiencia;
		this.estrategia = estrategia;
		this.capturados = new ArrayList<>();
	}

	public int getExperiencia() {
		return this.experiencia;
	}

	public String getNombre() {
		return this.nombre;
	}

	public List<Profugo> getCapturados() {
		return Collections.unmodifiableList(this.capturados);
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
		return this.experiencia > p.getInocencia() && estrategia.puedeCapturar(p);
	}


	public void intimidar(Profugo p) { }
}