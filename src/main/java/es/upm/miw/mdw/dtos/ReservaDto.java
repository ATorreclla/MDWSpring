package es.upm.miw.mdw.dtos;

import es.upm.miw.mdw.documents.Reserva;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReservaDto {

    private static final String DATE_FORMATTER= "yyyy-MM-dd HH:mm:ss";

    private String id;

    private String codigoHabitacion;

    private String fechaInicio;

    private String fechaFin;

    private float precio;

    private String nombreCliente;

    private String correCliente;

    public ReservaDto(){

    }

    public String getId() {
        return id;
    }

    public String getCodigoHabitacion() {
        return codigoHabitacion;
    }

    public void setCodigoHabitacion(String codigoHabitacion) {
        this.codigoHabitacion = codigoHabitacion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
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

    public Reserva toDocument(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        Reserva reserva = new Reserva();
        BeanUtils.copyProperties(this, reserva);
        reserva.setFechaHoraReservaInicio(LocalDateTime.parse(this.getFechaInicio(),formatter));
        reserva.setFechaHoraReservaFin(LocalDateTime.parse(this.getFechaFin(),formatter));
        return reserva;
    }
}
