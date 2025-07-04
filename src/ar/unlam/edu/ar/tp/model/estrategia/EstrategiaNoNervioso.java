package ar.unlam.edu.ar.tp.model.estrategia;

import ar.unlam.edu.ar.tp.model.profugo.Profugo;

public class EstrategiaNoNervioso implements EstrategiaDeCaptura {
    @Override
    public boolean puedeCapturar(Profugo profugo) {
        return !profugo.isNervioso();
    }
}