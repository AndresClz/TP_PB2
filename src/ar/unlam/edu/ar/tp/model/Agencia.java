package ar.unlam.edu.ar.tp.model;

import ar.unlam.edu.ar.tp.model.profugo.Profugo;
import ar.unlam.edu.ar.tp.model.cazador.Cazador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Agencia {
	private final List<Cazador> cazadores;
	private final List<Profugo> profugosCapturados;
	
	public Agencia() {
		this.cazadores = new ArrayList<>();
		this.profugosCapturados = new ArrayList<>();
	}
	
	public void agregarProfugo(Profugo p) {
        this.profugosCapturados.add(p);
    }
	
	public void agregarCazador(Cazador c) {
        this.cazadores.add(c);
    }
	
	public List<Profugo> getProfugosCapturados() {
        return Collections.unmodifiableList(this.profugosCapturados);
    }
}