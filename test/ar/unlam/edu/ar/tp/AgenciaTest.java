package ar.unlam.edu.ar.tp;

import static org.junit.Assert.*;


import ar.unlam.edu.ar.tp.model.Agencia;
import ar.unlam.edu.ar.tp.model.cazador.Cazador;
import ar.unlam.edu.ar.tp.model.cazador.CazadorBase;
import ar.unlam.edu.ar.tp.model.cazador.CazadorRural;
import ar.unlam.edu.ar.tp.model.cazador.CazadorUrbano;
import ar.unlam.edu.ar.tp.model.profugo.Profugo;
import ar.unlam.edu.ar.tp.model.profugo.ProfugoBase;

import org.junit.Test;

public class AgenciaTest {
	@Test
	public void queSePuedaRegistrarUnCazador() {
		Agencia agencia = new Agencia();
		Cazador cazador = new CazadorUrbano("Juan", 50);
		
		agencia.registrarCazador(cazador);
		
		assertTrue(agencia.getCazadores().contains(cazador));
	}
	
	@Test
	public void queSePuedaRegistrarCaptura() {
		Agencia agencia = new Agencia();
		Cazador cazador = new CazadorUrbano("Ana", 70);
		Profugo profugo = new ProfugoBase(30, 50, false);

		agencia.registrarCazador(cazador);
		agencia.registrarCaptura(cazador, profugo);
		
		assertTrue(agencia.getCapturados().contains(profugo));
        assertTrue(cazador.getCapturados().contains(profugo));
	}
	
	@Test
    public void queDevuelvaElProfugoMasHabilCapturado() {
        Agencia agencia = new Agencia();
        Cazador cazador = new CazadorUrbano("Pedro", 60);
        Profugo p1 = new ProfugoBase(20, 40, false);
        Profugo p2 = new ProfugoBase(30, 80, false);

        agencia.registrarCazador(cazador);
        agencia.registrarCaptura(cazador, p1);
        agencia.registrarCaptura(cazador, p2);

        assertEquals(p2, agencia.getMasHabilCapturado());
    }

    @Test
    public void queDevuelvaCazadorConMasCapturas() {
        Agencia agencia = new Agencia();

        Cazador cazador1 = new CazadorUrbano("Laura", 50);
        Cazador cazador2 = new CazadorRural("Carlos", 70);
        Profugo p1 = new ProfugoBase(20, 30, false);
        Profugo p2 = new ProfugoBase(25, 45, true);
        Profugo p3 = new ProfugoBase(30, 55, true);

        agencia.registrarCazador(cazador1);
        agencia.registrarCazador(cazador2);

        agencia.registrarCaptura(cazador1, p1);
        agencia.registrarCaptura(cazador2, p2);
        agencia.registrarCaptura(cazador2, p3);

        assertEquals(cazador2, agencia.getCazadorConMasCapturas());
    }
}