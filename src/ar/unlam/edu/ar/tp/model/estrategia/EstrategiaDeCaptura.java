package ar.unlam.edu.ar.tp.model.estrategia;

import ar.unlam.edu.ar.tp.model.profugo.Profugo;

/**
 * Define la regla específica de captura para un tipo de cazador.
 * No incluye la regla general (experiencia > inocencia) que se aplica en CazadorBase.
 */
public interface EstrategiaDeCaptura {
    boolean puedeCapturar(Profugo profugo);
}