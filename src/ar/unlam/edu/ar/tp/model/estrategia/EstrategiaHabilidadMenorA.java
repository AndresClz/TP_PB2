package ar.unlam.edu.ar.tp.model.estrategia;

import ar.unlam.edu.ar.tp.model.profugo.Profugo;

public class EstrategiaHabilidadMenorA implements EstrategiaDeCaptura {

    private final int umbral;

    public EstrategiaHabilidadMenorA(int umbral) {
        this.umbral = umbral;
    }

    @Override
    public boolean puedeCapturar(Profugo profugo) {
        return profugo.getHabilidad() < umbral;
    }
}