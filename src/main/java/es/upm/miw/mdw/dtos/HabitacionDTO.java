package es.upm.miw.mdw.dtos;

import es.upm.miw.mdw.documents.Habitacion;
import es.upm.miw.mdw.documents.TipoHabitacion;

public class HabitacionDTO {
    private String nombreHotel;

    private String codigoHabitacion;

    private String ubicacion;

    private TipoHabitacion tipoHabitacion;

    private float precioHora;

    public HabitacionDTO() {}

    public HabitacionDTO(Habitacion habitacion) {
        this.nombreHotel = habitacion.getNombreHotel();
        this.codigoHabitacion = habitacion.getCodigoHabitacion();
        this.ubicacion = habitacion.getUbicacion();
        this.tipoHabitacion = habitacion.getTipoHabitacion();
        this.precioHora = habitacion.getPrecioHora();
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

    @Override
    public String toString() {
        return "HabitacionDTO{" +
                "nombreHotel='" + nombreHotel + '\'' +
                ", codigoHabitacion='" + codigoHabitacion + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", tipoHabitacion=" + tipoHabitacion +
                ", precioHora=" + precioHora +
                '}';
    }
}
