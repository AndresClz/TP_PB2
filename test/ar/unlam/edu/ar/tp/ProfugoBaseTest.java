package ar.unlam.edu.ar.tp;
import static org.junit.Assert.*;

import ar.unlam.edu.ar.tp.model.ProfugoBase;
import org.junit.Test;

public class ProfugoBaseTest {
    @Test
    public void queSeCreeProfugoCorrectamente() {
        ProfugoBase p = new ProfugoBase(40, 60, true);
        assertEquals(40, p.getInocencia());
        assertEquals(60, p.getHabilidad());
        assertTrue(p.isNervioso());
    }

    @Test
    public void queSeReduzcaLaInocenciaSinSerNegativa() {
        ProfugoBase p = new ProfugoBase(5, 50, false);
        p.reducirInocencia(10);
        assertEquals(0, p.getInocencia());
    }

    @Test
    public void queSeReduzcaLaHabilidadSinSerNegativa() {
        ProfugoBase p = new ProfugoBase(20, 3, true);
        p.reducirHabilidad(5);
        assertEquals(0, p.getHabilidad());
    }

    @Test
    public void queSePuedaCambiarEstadoDeNerviosismo() {
        ProfugoBase p = new ProfugoBase(30, 40, true);
        p.setNervioso(false);
        assertFalse(p.isNervioso());
    }
}
