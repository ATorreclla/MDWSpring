package es.upm.miw.mdw.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document
public class Habitacion {

    private String nombreHotel;

    @Id
    private String codigoHabitacion;

    private String ubicacion;

    private TipoHabitacion tipoHabitacion;

    private float precioHora;

    @DBRef(lazy = true)
    private List<Reserva> reservas;

    public Habitacion() {
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public String getCodigoHabitacion() {
        return codigoHabitacion;
    }

    public void setCodigoHabitacion(String codigoHabitacion) {
        this.codigoHabitacion = codigoHabitacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public float getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(float precioHora) {
        this.precioHora = precioHora;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "nombreHotel='" + nombreHotel + '\'' +
                ", codigoHabitacion='" + codigoHabitacion + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", tipoHabitacion=" + tipoHabitacion +
                ", precioHora=" + precioHora +
                ", reservas=" + reservas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Habitacion)) return false;
        Habitacion that = (Habitacion) o;
        return Float.compare(that.getPrecioHora(), getPrecioHora()) == 0 &&
                Objects.equals(getNombreHotel(), that.getNombreHotel()) &&
                Objects.equals(getCodigoHabitacion(), that.getCodigoHabitacion()) &&
                Objects.equals(getUbicacion(), that.getUbicacion()) &&
                getTipoHabitacion() == that.getTipoHabitacion() &&
                Objects.equals(getReservas(), that.getReservas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombreHotel(), getCodigoHabitacion(), getUbicacion(), getTipoHabitacion(), getPrecioHora(), getReservas());
    }

}
