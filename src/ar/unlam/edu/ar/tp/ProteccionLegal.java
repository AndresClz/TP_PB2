package ar.unlam.edu.ar.tp;

import ar.unlam.edu.ar.tp.model.Profugo;
import ar.unlam.edu.ar.tp.model.ProfugoDecorador;

public class ProteccionLegal extends ProfugoDecorador {
    public ProteccionLegal(Profugo base) {
        super(base);
    }

    @Override
    public int getInocencia() {
        return Math.max(40, base.getInocencia());
    }
}

