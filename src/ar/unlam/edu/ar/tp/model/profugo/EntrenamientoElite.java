package ar.unlam.edu.ar.tp.model.profugo;

public class EntrenamientoElite extends ProfugoDecorador {
    public EntrenamientoElite(Profugo base) {
        super(base);
    }

    @Override
    public boolean isNervioso() {
        return false;
    }
}
