package ar.unlam.edu.ar.tp.model.profugo;

public class ProteccionLegal extends ProfugoDecorador {
    public ProteccionLegal(Profugo base) {
        super(base);
    }

    @Override
    public int getInocencia() {
        return Math.max(40, base.getInocencia());
    }
}

