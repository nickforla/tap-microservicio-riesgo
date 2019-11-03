package nforla.tap.microservicioriesgo.servicios;

import nforla.tap.microservicioriesgo.modelo.Deuda;
import nforla.tap.microservicioriesgo.modelo.EstadoRequest;
import nforla.tap.microservicioriesgo.modelo.EstadoResponse;
import org.springframework.stereotype.Service;

@Service
public class ServicioEstado implements IServicioEstado{

    @Override
    public EstadoResponse determinarEstadoPeronsa(EstadoRequest estadoRequest) {

        int sumaValorSituaciones = 0;
        int estado;

        for (Deuda deuda: estadoRequest.getDeudas()) {
            sumaValorSituaciones += deuda.getSituacionDeDeuda();
        }

        estado = sumaValorSituaciones / estadoRequest.getDeudas().size();

        return new EstadoResponse(estadoRequest.getCuil(), estado);

    }
}
