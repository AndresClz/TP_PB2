package ar.unlam.edu.ar.tp;
import static org.junit.Assert.*;

import ar.unlam.edu.ar.tp.model.Zona;
import ar.unlam.edu.ar.tp.model.profugo.Profugo;
import ar.unlam.edu.ar.tp.model.profugo.ProfugoBase;
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

    @Test
    public void queDevuelvaElNombreDeLaZona() {
        Zona zona = new Zona("Gotham");
        assertEquals("Gotham", zona.getNombre());
    }

    @Test
    public void queNoFalleAlRemoverProfugoInexistente() {
        Zona zona = new Zona("Ciudad Central");
        Profugo p1 = new ProfugoBase(30, 50, true);
        Profugo p2 = new ProfugoBase(40, 60, false);

        zona.agregarProfugo(p1);
        zona.removerProfugo(p2); // p2 no estaba

        assertEquals(1, zona.getProfugos().size());
        assertTrue(zona.getProfugos().contains(p1));
    }

}
