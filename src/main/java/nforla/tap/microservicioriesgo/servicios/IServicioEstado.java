package nforla.tap.microservicioriesgo.servicios;

import nforla.tap.microservicioriesgo.modelo.EstadoRequest;
import nforla.tap.microservicioriesgo.modelo.EstadoResponse;

import java.util.List;

public interface IServicioEstado {

    EstadoResponse determinarEstadoPeronsa(EstadoRequest estadoRequest);

    List<EstadoResponse> determinarEstadoPersonas(List<EstadoRequest> estadoRequests);

}
