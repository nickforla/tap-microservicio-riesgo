package nforla.tap.microservicioriesgo.controller;

import nforla.tap.microservicioriesgo.servicios.IServicioEstado;
import nforla.tap.microservicioriesgo.modelo.EstadoRequest;
import nforla.tap.microservicioriesgo.modelo.EstadoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/analizarEstado")
public class EstadoController {

    private final Logger logger = LoggerFactory.getLogger(EstadoController.class);
    private IServicioEstado servicioEstado;

    public EstadoController(IServicioEstado servicioEstado) {
        this.servicioEstado = servicioEstado;
    }

    @GetMapping(path = "/persona", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstadoResponse> analizarEstadoPersona(@RequestBody @Valid EstadoRequest estadoRequest) {

        logger.info("Solicitud de estado: " + estadoRequest);
        return ResponseEntity.ok().body(servicioEstado.determinarEstadoPeronsa(estadoRequest));

    }

    @GetMapping(path = "/personas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EstadoResponse>> analizarEstadoPeronas(@RequestBody @Valid List<EstadoRequest> estadoRequests){

        logger.info(estadoRequests.toString());

        return ResponseEntity.ok().body(servicioEstado.determinarEstadoPersonas(estadoRequests));

    }

}
