package es.upm.miw.mdw.dtos;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class HabitacionQueryDTO {

    private LocalDateTime fechaHoraReservaInicio;

    private Integer numeroHoras;

    private String ubicacion;

    public HabitacionQueryDTO() {}

    public LocalDateTime getFechaHoraReservaInicio() {
        return fechaHoraReservaInicio;
    }

    public Integer getNumeroHoras() {
        return numeroHoras;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    @Override
    public String toString() {
        return "HabitacionQueryDTO{" +
                "fechaHoraReservaInicio=" + fechaHoraReservaInicio +
                ", numeroHoras=" + numeroHoras +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}

