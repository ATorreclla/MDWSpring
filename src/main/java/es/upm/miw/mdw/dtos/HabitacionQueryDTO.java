package es.upm.miw.mdw.dtos;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


public class HabitacionQueryDTO {

    @NotNull
    private LocalDateTime fechaHoraReservaInicio;

    @NotNull
    private LocalDateTime fechaHoraReservaFin;

    @NotNull
    private String ubicacion;


    public HabitacionQueryDTO(LocalDateTime fechaHoraReservaInicio, LocalDateTime fechaHoraReservaFin, String ubicacion) {
        this.fechaHoraReservaFin = fechaHoraReservaFin;
        this.fechaHoraReservaInicio = fechaHoraReservaInicio;
        this.ubicacion = ubicacion;
    }


    public LocalDateTime getFechaHoraReservaInicio() {
        return fechaHoraReservaInicio;
    }

    public void setFechaHoraReservaInicio(LocalDateTime fechaHoraReservaInicio) {
        this.fechaHoraReservaInicio = fechaHoraReservaInicio;
    }

    public LocalDateTime getFechaHoraReservaFin() {
        return fechaHoraReservaFin;
    }

    public void setFechaHoraReservaFin(LocalDateTime fechaHoraReservaFin) {
        this.fechaHoraReservaFin = fechaHoraReservaFin;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "HabitacionQueryDTO{" +
                "fechaHoraReservaInicio=" + fechaHoraReservaInicio +
                ", fechaHoraReservaFin=" + fechaHoraReservaFin +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}

