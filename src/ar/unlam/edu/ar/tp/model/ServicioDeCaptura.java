package ar.unlam.edu.ar.tp.model;

import ar.unlam.edu.ar.tp.model.cazador.Cazador;
import ar.unlam.edu.ar.tp.model.profugo.Profugo;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio que orquesta las operaciones con {@link Zona} y {@link Agencia} para
 * reducir el acoplamiento de los cazadores.
 */
public class ServicioDeCaptura {

    public void procesarCapturas(Cazador cazador, Zona zona, Agencia agencia) {
        int capturadosEnOperacion = 0;
        int minHabilidadIntimidados = Integer.MAX_VALUE;

        List<Profugo> aRemover = new ArrayList<>();

        for (Profugo profugo : buscarPotenciales(zona)) {
            if (cazador.puedeCapturar(profugo)) {
                cazador.agregarCapturado(profugo);
                aRemover.add(profugo);
                registrarCapturaEnAgencia(cazador, profugo, agencia);
                capturadosEnOperacion++;
            } else {
                cazador.intimidar(profugo);
                minHabilidadIntimidados = Math.min(minHabilidadIntimidados, profugo.getHabilidad());
            }
        }

        for(Profugo p : aRemover) {
            removerDeZona(zona, p);
        }

        if (minHabilidadIntimidados == Integer.MAX_VALUE) {
            minHabilidadIntimidados = 0;
        }
        cazador.sumarExperiencia(minHabilidadIntimidados, capturadosEnOperacion);
    }

    private List<Profugo> buscarPotenciales(Zona zona) {
        return new ArrayList<>(zona.getProfugos());
    }

    private void removerDeZona(Zona zona, Profugo p) {
        zona.removerProfugo(p);
    }

    private void registrarCapturaEnAgencia(Cazador cazador, Profugo p, Agencia agencia) {
        agencia.registrarCaptura(cazador, p);
    }
}