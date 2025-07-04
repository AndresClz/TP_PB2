package ar.unlam.edu.ar.tp.model.estrategia;

import ar.unlam.edu.ar.tp.model.profugo.Profugo;

/**
 * Estrategia para capturar prófugos nerviosos.
 */
public class EstrategiaNervioso implements EstrategiaDeCaptura {
    @Override
    public boolean puedeCapturar(Profugo profugo) {
        return profugo.isNervioso();
    }
}