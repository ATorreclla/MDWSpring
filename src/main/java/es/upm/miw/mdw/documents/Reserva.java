package es.upm.miw.mdw.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class Reserva {

    @Id
    private String codigoReserva;

    private String codigoHabitacion;

    private LocalDateTime fechaHoraReservaInicio;

    private LocalDateTime fechaHoraReservaFin;

    private float precioReserva;

    private String nombreCliente;

    private String correCliente;

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public String getCodigoHabitacion() {
        return codigoHabitacion;
    }

    public void setCodigoHabitacion(String codigoHabitacion) {
        this.codigoHabitacion = codigoHabitacion;
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

    public float getPrecioReserva() {
        return precioReserva;
    }

    public void setPrecioReserva(float precioReserva) {
        this.precioReserva = precioReserva;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCorreCliente() {
        return correCliente;
    }

    public void setCorreCliente(String correCliente) {
        this.correCliente = correCliente;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codigoReserva='" + codigoReserva + '\'' +
                ", codigoHabitacion='" + codigoHabitacion + '\'' +
                ", fechaHoraReservaInicio=" + fechaHoraReservaInicio +
                ", fechaHoraReservaFin=" + fechaHoraReservaFin +
                ", precioReserva=" + precioReserva +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", correCliente='" + correCliente + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reserva)) return false;
        Reserva reserva = (Reserva) o;
        return Float.compare(reserva.getPrecioReserva(), getPrecioReserva()) == 0 &&
                Objects.equals(getCodigoReserva(), reserva.getCodigoReserva()) &&
                Objects.equals(getCodigoHabitacion(), reserva.getCodigoHabitacion()) &&
                Objects.equals(getFechaHoraReservaInicio(), reserva.getFechaHoraReservaInicio()) &&
                Objects.equals(getFechaHoraReservaFin(), reserva.getFechaHoraReservaFin()) &&
                Objects.equals(getNombreCliente(), reserva.getNombreCliente()) &&
                Objects.equals(getCorreCliente(), reserva.getCorreCliente());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigoReserva(), getCodigoHabitacion(), getFechaHoraReservaInicio(), getFechaHoraReservaFin(), getPrecioReserva(), getNombreCliente(), getCorreCliente());
    }

}
