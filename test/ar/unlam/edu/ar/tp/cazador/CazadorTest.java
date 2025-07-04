package ar.unlam.edu.ar.tp.cazador;

import static org.junit.Assert.*;

import ar.unlam.edu.ar.tp.model.Agencia;
import ar.unlam.edu.ar.tp.model.ServicioDeCaptura;
import ar.unlam.edu.ar.tp.model.Zona;
import ar.unlam.edu.ar.tp.model.cazador.Cazador;
import ar.unlam.edu.ar.tp.model.cazador.CazadorUrbano;
import ar.unlam.edu.ar.tp.model.cazador.CazadorRural;
import ar.unlam.edu.ar.tp.model.cazador.CazadorSigiloso;
import ar.unlam.edu.ar.tp.model.exception.ProfugoNoEncontradoException;
import ar.unlam.edu.ar.tp.model.profugo.Profugo;
import ar.unlam.edu.ar.tp.model.profugo.ProfugoBase;

import org.junit.Before;
import org.junit.Test;

public class CazadorTest {

	private Agencia agencia;
	private Zona zona;
	private ServicioDeCaptura servicio;

	@Before
	public void setUp() {
		agencia = new Agencia();
		zona = new Zona("Distrito 9");
		servicio = new ServicioDeCaptura();
	}

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
    public void queCazadorCaptureYRemuevaDeZona() throws ProfugoNoEncontradoException {
        Cazador cazador = new CazadorUrbano("Carlos", 70);
        Profugo p = new ProfugoBase(60, 30, false);

        zona.agregarProfugo(p);
        servicio.procesarCapturas(cazador, zona, agencia);

        assertEquals(0, zona.getProfugos().size());
        assertEquals(1, cazador.getCantidadCapturada());
        assertTrue(cazador.getCapturados().contains(p));
    }
    
    @Test
    public void queCazadorCaptureYObtengaExperienciaCorrectamente() throws ProfugoNoEncontradoException {
        Cazador cazador = new CazadorUrbano("Mateo", 70);
        Profugo p1 = new ProfugoBase(60, 30, false); //Capturado
        Profugo p2 = new ProfugoBase(60, 30, true); //Intimidado

        zona.agregarProfugo(p1);
        zona.agregarProfugo(p2);
        servicio.procesarCapturas(cazador, zona, agencia);

        assertEquals(102, cazador.getExperiencia()); //70 + 30 + 2
    }

    @Test
    public void queSeIntimideProfugoCuandoNoPuedeSerCapturado() throws ProfugoNoEncontradoException {
        Cazador cazador = new CazadorUrbano("Lucía", 70);
        Profugo p = new ProfugoBase(90, 40, true); // no cumple regla urbana (es nervioso)

        zona.agregarProfugo(p);
        servicio.procesarCapturas(cazador, zona, agencia);

        // Verificamos que no fue capturado
        assertEquals(0, cazador.getCantidadCapturada());
        assertEquals(1, zona.getProfugos().size());

        // Verificamos que fue intimidado
        assertEquals(88, p.getInocencia()); // se reduce en 2
        assertFalse(p.isNervioso());        // urbano lo calma
    }

    @Test
    public void queLaCapturaFalleSiExperienciaEsIgualAInocencia() throws ProfugoNoEncontradoException {
        Cazador cazador = new CazadorUrbano("Lucía", 50);
        Profugo profugo = new ProfugoBase(50, 40, false); // exp (50) == inocencia (50)

        zona.agregarProfugo(profugo);
        servicio.procesarCapturas(cazador, zona, agencia);

        assertEquals(0, cazador.getCantidadCapturada());
        assertEquals(1, zona.getProfugos().size()); // No se remueve
    }

    @Test
    public void queNoPaseNadaSiLaZonaEstaVacia() throws ProfugoNoEncontradoException {
        Cazador cazador = new CazadorUrbano("Lucía", 70);
        int experienciaInicial = cazador.getExperiencia();

        servicio.procesarCapturas(cazador, zona, agencia);

        assertEquals(0, cazador.getCantidadCapturada());
        assertEquals(experienciaInicial, cazador.getExperiencia());
    }

    @Test
    public void queSePuedanCapturarVariosProfugosEnUnaOperacion() throws ProfugoNoEncontradoException {
        Cazador cazador = new CazadorUrbano("Rico", 80);
        Profugo p1 = new ProfugoBase(30, 40, false);
        Profugo p2 = new ProfugoBase(50, 60, false);

        zona.agregarProfugo(p1);
        zona.agregarProfugo(p2);
        servicio.procesarCapturas(cazador, zona, agencia);

        assertEquals(2, cazador.getCantidadCapturada());
        assertEquals(0, zona.getProfugos().size());
    }

    @Test
    public void queSeCalculeExperienciaCorrectamenteConMultiplesIntimidados() throws ProfugoNoEncontradoException {
        Cazador cazador = new CazadorSigiloso("Fantasma", 50); // No puede capturar a ninguno
        Profugo p1 = new ProfugoBase(60, 30, false); // Habilidad 60
        Profugo p2 = new ProfugoBase(25, 80, false); // Habilidad 25 (la menor)

        zona.agregarProfugo(p1);
        zona.agregarProfugo(p2);
        servicio.procesarCapturas(cazador, zona, agencia);

        // Experiencia inicial (50) + menor habilidad de intimidados (25) + 2 * capturados (0)
        assertEquals(75, cazador.getExperiencia());
        assertEquals(0, cazador.getCantidadCapturada());
    }

    @Test
    public void queLaCapturaFalleSiLaExperienciaEsInsuficiente() throws ProfugoNoEncontradoException {
        Cazador cazador = new CazadorUrbano("Novato", 30);
        Profugo profugo = new ProfugoBase(50, 40, false); // exp (30) < inocencia (40)

        zona.agregarProfugo(profugo);
        servicio.procesarCapturas(cazador, zona, agencia);

        assertEquals(0, cazador.getCantidadCapturada());
    }
}