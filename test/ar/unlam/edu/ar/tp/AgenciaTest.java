package ar.unlam.edu.ar.tp;

import static org.junit.Assert.*;


import ar.unlam.edu.ar.tp.model.Agencia;
import ar.unlam.edu.ar.tp.model.ServicioDeCaptura;
import ar.unlam.edu.ar.tp.model.Zona;
import ar.unlam.edu.ar.tp.model.cazador.Cazador;
import ar.unlam.edu.ar.tp.model.cazador.CazadorRural;
import ar.unlam.edu.ar.tp.model.cazador.CazadorUrbano;
import ar.unlam.edu.ar.tp.model.profugo.Profugo;
import ar.unlam.edu.ar.tp.model.profugo.ProfugoBase;

import org.junit.Before;
import org.junit.Test;

public class AgenciaTest {

	private Agencia agencia;
	private ServicioDeCaptura servicio;

	@Before
	public void setUp() {
		agencia = new Agencia();
		servicio = new ServicioDeCaptura();
	}

	@Test
	public void queSePuedaRegistrarUnCazador() {
		Cazador cazador = new CazadorUrbano("Juan", 50);
		
		agencia.registrarCazador(cazador);
		
		assertTrue(agencia.getCazadores().contains(cazador));
	}
	
	@Test
	public void queSePuedaRegistrarCaptura() {
		Zona zona = new Zona("Ciudad Urban");
		Cazador cazador = new CazadorUrbano("Ana", 70);
		Profugo profugo = new ProfugoBase(50, 30, false);

		zona.agregarProfugo(profugo);

		agencia.registrarCazador(cazador);
		servicio.procesarCapturas(cazador, zona, agencia);

		assertTrue(agencia.getCapturados().contains(profugo));
        assertTrue(cazador.getCapturados().contains(profugo));
	}
	
	@Test
    public void queDevuelvaElProfugoMasHabilCapturado() {
        Cazador cazador = new CazadorUrbano("Pedro", 60);
        Profugo p1 = new ProfugoBase(40, 20, false);
        Profugo p2 = new ProfugoBase(80, 30, false);

        agencia.registrarCazador(cazador);
        // El registro de capturas debe hacerse a través del servicio para ser realista
        // pero para este test puntual, registrarlo manualmente es aceptable si solo probamos la agencia.
        agencia.registrarCaptura(cazador, p1);
        agencia.registrarCaptura(cazador, p2);

        assertEquals(p2, agencia.getMasHabilCapturado());
    }

    @Test
    public void queDevuelvaCazadorConMasCapturasTrasOperacionSecuencialConIntimidacion() {
        Zona zona = new Zona("Multi-zona");
        Cazador cazador1 = new CazadorUrbano("Laura", 80);
        Cazador cazador2 = new CazadorRural("Carlos", 80);
        Profugo p1 = new ProfugoBase(30, 20, false); // Capturable por Laura
        Profugo p2 = new ProfugoBase(45, 25, true); // Capturable por Carlos, pero la intimidacion de laura luego no se lo permite
        Profugo p3 = new ProfugoBase(55, 30, true); // Capturable por Carlos, pero la intimidacion de laura luego no se lo permite

        agencia.registrarCazador(cazador1);
        agencia.registrarCazador(cazador2);
        zona.agregarProfugo(p1);
        zona.agregarProfugo(p2);
        zona.agregarProfugo(p3);

        // --- Ejecución ---
        // Se simula la captura de todos los prófugos en la zona por ambos cazadores
        servicio.procesarCapturas(cazador1, zona, agencia);
        servicio.procesarCapturas(cazador2, zona, agencia);

        // --- Verificación ---
        // cazador1 debe tener 1 captura, cazador2 debe tener 2
        assertEquals(cazador1, agencia.getCazadorConMasCapturas());
    }
}