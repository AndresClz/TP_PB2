package ar.unlam.edu.ar.tp;
import static org.junit.Assert.*;

import ar.unlam.edu.ar.tp.model.Profugo;
import ar.unlam.edu.ar.tp.model.ProfugoBase;
import org.junit.Test;
import java.util.List;

public class ZonaTest {

    @Test
    public void queSeAgreguenProfugosCorrectamente() {
        Zona zona = new Zona("Ciudad Gótica");
        Profugo p1 = new ProfugoBase(20, 40, true);
        Profugo p2 = new ProfugoBase(30, 60, false);

        zona.agregarProfugo(p1);
        zona.agregarProfugo(p2);

        List<Profugo> lista = zona.getProfugos();
        assertEquals(2, lista.size());
        assertTrue(lista.contains(p1));
        assertTrue(lista.contains(p2));
    }

    @Test
    public void queSePuedaRemoverProfugo() {
        Zona zona = new Zona("Metropolis");
        Profugo p1 = new ProfugoBase(20, 40, true);
        zona.agregarProfugo(p1);

        zona.removerProfugo(p1);
        assertEquals(0, zona.getProfugos().size());
    }
}
