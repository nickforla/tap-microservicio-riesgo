package nforla.tap.microservicioriesgo.servicios;

import nforla.tap.microservicioriesgo.modelo.EstadoRequest;
import nforla.tap.microservicioriesgo.modelo.EstadoResponse;

public interface IServicioEstado {

    EstadoResponse determinarEstadoPeronsa(EstadoRequest estadoRequest);

}
