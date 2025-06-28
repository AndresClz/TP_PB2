package ar.unlam.edu.ar.tp.model;

import ar.unlam.edu.ar.tp.model.profugo.Profugo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Zona {
    private final String nombre;
    private final List<Profugo> profugos;

    public Zona(String nombre) {
        this.nombre = nombre;
        this.profugos = new ArrayList<>();
    }

    public void agregarProfugo(Profugo p) {
        this.profugos.add(p);
    }

    public void removerProfugo(Profugo p) {
        this.profugos.remove(p);
    }

    public List<Profugo> getProfugos() {
        return Collections.unmodifiableList(this.profugos);
    }

    public String getNombre() {
        return nombre;
    }
}
