package nforla.tap.microservicioriesgo.modelo;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Deuda {

    @Positive
    private int montoDeDeuda;
    @NotNull
    @Positive
    private int situacionDeDeuda;

}
