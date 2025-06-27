package ar.unlam.edu.ar.tp;
import static org.junit.Assert.*;

import ar.unlam.edu.ar.tp.model.Profugo;
import org.junit.Test;

public class ProfugoTest {
    @Test
    public void queSeCreeProfugoCorrectamente() {
        Profugo p = new Profugo(40, 60, true);
        assertEquals(40, p.getInocencia());
        assertEquals(60, p.getHabilidad());
        assertTrue(p.isNervioso());
    }

    @Test
    public void queSeReduzcaLaInocenciaSinSerNegativa() {
        Profugo p = new Profugo(5, 50, false);
        p.reducirInocencia(10);
        assertEquals(0, p.getInocencia());
    }

    @Test
    public void queSeReduzcaLaHabilidadSinSerNegativa() {
        Profugo p = new Profugo(20, 3, true);
        p.reducirHabilidad(5);
        assertEquals(0, p.getHabilidad());
    }

    @Test
    public void queSePuedaCambiarEstadoDeNerviosismo() {
        Profugo p = new Profugo(30, 40, true);
        p.setNervioso(false);
        assertFalse(p.isNervioso());
    }
}
