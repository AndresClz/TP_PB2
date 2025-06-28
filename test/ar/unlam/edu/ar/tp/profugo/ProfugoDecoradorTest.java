package ar.unlam.edu.ar.tp.profugo;
import static org.junit.Assert.*;

import ar.unlam.edu.ar.tp.model.profugo.*;
import org.junit.Test;

public class ProfugoDecoradorTest {

    @Test
    public void queLaHabilidadSeDupliqueConArtesMarcialesSinSuperarCien() {
        Profugo p = new ProfugoBase(30, 60, true);
        Profugo entrenado = new ArtesMarcialesAvanzadas(p);
        assertEquals(100, entrenado.getHabilidad());
    }

    @Test
    public void queElProfugoConEntrenamientoEliteNuncaSeaNervioso() {
        Profugo p = new ProfugoBase(30, 50, true);
        Profugo entrenado = new EntrenamientoElite(p);
        assertFalse(entrenado.isNervioso());
    }

    @Test
    public void queElProfugoConProteccionLegalMantengaInocenciaMinimaDeCuarenta() {
        Profugo p = new ProfugoBase(35, 50, true);
        Profugo entrenado = new ProteccionLegal(p);
        assertEquals(40, entrenado.getInocencia());
    }
}
