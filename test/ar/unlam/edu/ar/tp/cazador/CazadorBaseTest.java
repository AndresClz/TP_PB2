package ar.unlam.edu.ar.tp.cazador;

import static org.junit.Assert.*;

import ar.unlam.edu.ar.tp.model.Zona;
import ar.unlam.edu.ar.tp.model.cazador.Cazador;
import ar.unlam.edu.ar.tp.model.cazador.CazadorBase;
import ar.unlam.edu.ar.tp.model.cazador.CazadorUrbano;
import ar.unlam.edu.ar.tp.model.cazador.CazadorRural;
import ar.unlam.edu.ar.tp.model.cazador.CazadorSigiloso;
import ar.unlam.edu.ar.tp.model.profugo.Profugo;
import ar.unlam.edu.ar.tp.model.profugo.ProfugoBase;

import org.junit.Test;

public class CazadorBaseTest {
	@Test
    public void queSeCreeCazadorCorrectamente() {
        Cazador cazador = new CazadorUrbano("Juan", 50);
        assertEquals("Juan", cazador.getNombre());
        assertEquals(50, cazador.getExperiencia());
        assertEquals(0, cazador.getCapturados().size());
    }

    @Test
    public void queCazadorUrbanoPuedaCapturarSegunRegla() {
        Cazador cazador = new CazadorUrbano("Ana", 60);
        Profugo p = new ProfugoBase(50, 40, false);

        assertTrue(cazador.puedeCapturar(p));
    }
    
    @Test
    public void queCazadorRuralPuedaCapturarSegunRegla() {
        Cazador cazador = new CazadorRural("Pedro", 60);
        Profugo p = new ProfugoBase(50, 40, true);

        assertTrue(cazador.puedeCapturar(p));
    }
    
    @Test
    public void queCazadorSigilosoPuedaCapturarSegunRegla() {
        Cazador cazador = new CazadorSigiloso("Maria", 60);
        Profugo p = new ProfugoBase(50, 40, false);

        assertTrue(cazador.puedeCapturar(p));
    }

    @Test
    public void queCazadorCaptureYRemuevaDeZona() {
        Cazador cazador = new CazadorUrbano("Carlos", 70);
        Zona zona = new Zona("Ciudad Gótica");
        Profugo p = new ProfugoBase(60, 30, false);

        zona.agregarProfugo(p);
        cazador.capturar(zona);

        assertEquals(0, zona.getProfugos().size());
        assertEquals(1, cazador.getCapturados().size());
        assertTrue(cazador.getCapturados().contains(p));
    }
    
    @Test
    public void queCazadorCaptureYObtengaExperienciaCorrectamente() {
        Cazador cazador = new CazadorUrbano("Mateo", 70);
        Zona zona = new Zona("Ciudad Urban");
        Profugo p1 = new ProfugoBase(60, 30, false); //Capturado
        Profugo p2 = new ProfugoBase(60, 30, true); //Intimidado

        zona.agregarProfugo(p1);
        zona.agregarProfugo(p2);
        cazador.capturar(zona);

        assertEquals(102, cazador.getExperiencia()); //70 + 30 + 2
    }

    @Test
    public void queSeIntimideProfugoCuandoNoPuedeSerCapturado() {
        Cazador cazador = new CazadorUrbano("Lucía", 70);
        Profugo p = new ProfugoBase(90, 40, true); // no cumple regla urbana

        cazador.intimidar(p);

        assertEquals(38, p.getInocencia()); // se reduce en 2
        assertFalse(p.isNervioso());        // urbano lo calma
    }
}