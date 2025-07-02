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

    @Test
    public void queProfugoEvolucioneConVariasCapasDeEntrenamiento() {
        // Prófigo base: 30 de inocencia, 45 de habilidad, nervioso
        Profugo p = new ProfugoBase(30, 45, true);

        // Aplica artes marciales avanzadas: habilidad = 90
        p = new ArtesMarcialesAvanzadas(p);

        // Aplica entrenamiento elite: nervioso = false
        p = new EntrenamientoElite(p);

        // Aplica protección legal: inocencia mínima 40
        p = new ProteccionLegal(p);

        // Verificaciones
        assertEquals(40, p.getInocencia()); // original era 30, ahora mínimo 40
        assertEquals(90, p.getHabilidad()); // 45 * 2 = 90
        assertFalse(p.isNervioso());        // gracias a entrenamiento elite
    }
}
