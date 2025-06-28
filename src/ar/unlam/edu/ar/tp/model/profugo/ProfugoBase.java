package ar.unlam.edu.ar.tp.model.profugo;

public class ProfugoBase implements Profugo {

    private int inocencia;
    private int habilidad;
    private boolean nervioso;

    public ProfugoBase(int inocencia, int habilidad, boolean nervioso) {
        this.inocencia = Math.max(0, inocencia);
        this.habilidad = Math.max(0, habilidad);
        this.nervioso = nervioso;
    }

    public int getInocencia() {
        return inocencia;
    }

    public int getHabilidad() {
        return habilidad;
    }

    public boolean isNervioso() {
        return nervioso;
    }

    public void reducirInocencia(int cantidad) {
        this.inocencia = Math.max(0, this.inocencia - cantidad);
    }

    public void reducirHabilidad(int cantidad) {
        this.habilidad = Math.max(0, this.habilidad - cantidad);
    }

    public void setNervioso(boolean nervioso) {
        this.nervioso = nervioso;
    }
}
