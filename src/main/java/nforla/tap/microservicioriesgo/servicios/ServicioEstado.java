package nforla.tap.microservicioriesgo.servicios;

import nforla.tap.microservicioriesgo.modelo.Deuda;
import nforla.tap.microservicioriesgo.modelo.EstadoRequest;
import nforla.tap.microservicioriesgo.modelo.EstadoResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioEstado implements IServicioEstado{

    /**
     * Determina el estado del solicitante en base a los datos reibidos.
     * */
    @Override
    public EstadoResponse determinarEstadoPersona(EstadoRequest estadoRequest) {

        int sumaValorSituaciones = 0;
        int estado = 1;

        List<Deuda> deudas = estadoRequest.getDeudas();

        if(deudas != null && deudas.size() > 0){
            for (Deuda deuda: estadoRequest.getDeudas()) {
                sumaValorSituaciones += deuda.getSituacionDeDeuda();
            }

            estado = sumaValorSituaciones / estadoRequest.getDeudas().size();
        }

        return new EstadoResponse(estadoRequest.getCuil(), estado);

    }

    /**
     * Determina el estado de una lista de solicitudantes en base a los datos recibidos.
     * */
    @Override
    public List<EstadoResponse> determinarEstadoPersonas(List<EstadoRequest> estadoRequests) {

        List<EstadoResponse> estadoResponses = new ArrayList<>();

        estadoRequests.forEach(estadoRequest -> estadoResponses.add(determinarEstadoPersona(estadoRequest)));

        return estadoResponses;

    }
}
