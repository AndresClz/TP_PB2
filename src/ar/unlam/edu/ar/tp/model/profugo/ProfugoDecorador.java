package ar.unlam.edu.ar.tp.model.profugo;

public abstract class ProfugoDecorador implements Profugo {
    protected Profugo base;

    public ProfugoDecorador(Profugo base) {
        this.base = base;
    }

    @Override
    public int getInocencia() {
        return base.getInocencia();
    }

    @Override
    public int getHabilidad() {
        return base.getHabilidad();
    }

    @Override
    public boolean isNervioso() {
        return base.isNervioso();
    }

    @Override
    public void reducirInocencia(int cantidad) {
        base.reducirInocencia(cantidad);
    }

    @Override
    public void reducirHabilidad(int cantidad) {
        base.reducirHabilidad(cantidad);
    }

    @Override
    public void setNervioso(boolean nervioso) {
        base.setNervioso(nervioso);
    }
}
