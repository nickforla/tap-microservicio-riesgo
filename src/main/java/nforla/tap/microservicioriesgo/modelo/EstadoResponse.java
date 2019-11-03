package nforla.tap.microservicioriesgo.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EstadoResponse {

    private String cuil;
    private int estado;

    public EstadoResponse(String cuil, int estado) {
        this.cuil = cuil;
        this.estado = estado;
    }
}
