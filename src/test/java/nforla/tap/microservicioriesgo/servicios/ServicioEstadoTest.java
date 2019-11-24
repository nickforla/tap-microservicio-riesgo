package nforla.tap.microservicioriesgo.servicios;

import nforla.tap.microservicioriesgo.modelo.Deuda;
import nforla.tap.microservicioriesgo.modelo.EstadoRequest;
import nforla.tap.microservicioriesgo.modelo.EstadoResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServicioEstadoTest {

    private IServicioEstado servicioEstado;

    @BeforeEach
    void setUp() {
        servicioEstado = new ServicioEstado();
    }

    @Test
    void determinarEstadoPersona() {

        EstadoRequest estadoRequest = new EstadoRequest();
        estadoRequest.setCuil("20397606393");
        List<Deuda> deudas = new ArrayList<>();
        deudas.add(new Deuda(20000, 2));
        deudas.add(new Deuda(20000, 4));
        estadoRequest.setDeudas(deudas);

        EstadoResponse estadoResponse = servicioEstado.determinarEstadoPersona(estadoRequest);

        assertEquals(estadoRequest.getCuil(), estadoResponse.getCuil());
        assertEquals(3, estadoResponse.getEstado());

    }

    @Test
    void determinarEstadoPersonas() {

        EstadoRequest estadoRequest = new EstadoRequest();
        estadoRequest.setCuil("20397606393");
        List<Deuda> deudas = new ArrayList<>();
        deudas.add(new Deuda(20000, 2));
        deudas.add(new Deuda(20000, 4));
        estadoRequest.setDeudas(deudas);
        EstadoRequest estadoRequest2 = new EstadoRequest();
        estadoRequest2.setCuil("20397606392");
        List<Deuda> deudas2 = new ArrayList<>();
        deudas2.add(new Deuda(20000, 3));
        deudas2.add(new Deuda(20000, 5));
        estadoRequest2.setDeudas(deudas2);

        List<EstadoRequest> requests = Arrays.asList(estadoRequest, estadoRequest2);
        List<EstadoResponse> responses = servicioEstado.determinarEstadoPersonas(requests);

        assertEquals(2, responses.size());
        assertEquals(estadoRequest.getCuil(), responses.get(0).getCuil());
        assertEquals(3, responses.get(0).getEstado());
        assertEquals(estadoRequest2.getCuil(), responses.get(1).getCuil());
        assertEquals(4, responses.get(1).getEstado());

    }
}