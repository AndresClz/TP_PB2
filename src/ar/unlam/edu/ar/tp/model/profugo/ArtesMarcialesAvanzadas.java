package ar.unlam.edu.ar.tp.model.profugo;

public class ArtesMarcialesAvanzadas extends ProfugoDecorador {
    public ArtesMarcialesAvanzadas(Profugo base) {
        super(base);
    }

    @Override
    public int getHabilidad() {
        return Math.min(100, base.getHabilidad() * 2);
    }
}
