package nforla.tap.microservicioriesgo.modelo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
public class EstadoRequest {

    @NotNull
    private String cuil;
    private List<@Valid Deuda> deudas;

}
