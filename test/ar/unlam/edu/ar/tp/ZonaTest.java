package ar.unlam.edu.ar.tp;
import static org.junit.Assert.*;

import ar.unlam.edu.ar.tp.model.Zona;
import ar.unlam.edu.ar.tp.model.exception.ProfugoNoEncontradoException;
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
    public void queSePuedaRemoverProfugo() throws ProfugoNoEncontradoException {
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

    @Test(expected = ProfugoNoEncontradoException.class)
    public void queLanzeExcepcionAlRemoverProfugoInexistente() throws ProfugoNoEncontradoException {
        Zona zona = new Zona("Ciudad Central");
        Profugo p1 = new ProfugoBase(30, 50, true);
        Profugo p2 = new ProfugoBase(40, 60, false); // Este prófugo nunca se añade a la zona

        zona.agregarProfugo(p1);
        zona.removerProfugo(p2); // Debería lanzar la excepción aquí
    }

    @Test
    public void queSePuedaManejarExcepcionAlRemoverProfugoInexistenteYVerificarMensaje() {
        Zona zona = new Zona("Ciudad Star");
        Profugo profugoInexistente = new ProfugoBase(10, 10, false);
        String mensajeEsperado = "El profugo no pudo ser removido porque no se encontró en la zona '" + zona.getNombre() + "'.";

        try {
            zona.removerProfugo(profugoInexistente);
            fail("Se esperaba una ProfugoNoEncontradoException pero no fue lanzada.");
        } catch (ProfugoNoEncontradoException e) {
            assertEquals(mensajeEsperado, e.getMessage());
        }
    }
}
