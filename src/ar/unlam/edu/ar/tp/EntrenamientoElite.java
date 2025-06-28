package ar.unlam.edu.ar.tp;

import ar.unlam.edu.ar.tp.model.Profugo;
import ar.unlam.edu.ar.tp.model.ProfugoDecorador;

public class EntrenamientoElite extends ProfugoDecorador {
    public EntrenamientoElite(Profugo base) {
        super(base);
    }

    @Override
    public boolean isNervioso() {
        return false;
    }
}
