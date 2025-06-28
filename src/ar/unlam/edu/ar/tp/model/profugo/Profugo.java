package ar.unlam.edu.ar.tp.model.profugo;

public interface Profugo {
    int getInocencia();
    int getHabilidad();
    boolean isNervioso();

    void reducirInocencia(int cantidad);
    void reducirHabilidad(int cantidad);
    void setNervioso(boolean nervioso);
}

