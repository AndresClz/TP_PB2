package ar.unlam.edu.ar.tp.cazador;

import static org.junit.Assert.*;

import ar.unlam.edu.ar.tp.model.cazador.CazadorBase;

import org.junit.Test;

public class CazadorBaseTest {
	@Test
    public void queSeCreeCazadorCorrectamente() {
        CazadorBase c = new CazadorBase(40, 'U');
        assertEquals(40, c.getExperiencia());
        assertEquals('U', c.getTipoDeCazador());
        assertEquals(0, c.getCantProfugosCapturados());
    }
	
	@Test
    public void queSeSumeExperienciaCorrectamente() {
        CazadorBase c = new CazadorBase(40, 'U');
        c.sumarExperiencia(10, 5);
        assertEquals(60, c.getExperiencia());
    }
	
	@Test
    public void queSeSumenCapturasCorrectamente() {
        CazadorBase c = new CazadorBase(40, 'U');
        c.sumarCapturas(5);
        assertEquals(5, c.getCantProfugosCapturados());
    }
}