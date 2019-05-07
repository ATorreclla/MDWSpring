package es.upm.miw.mdw.dtos;

import es.upm.miw.mdw.documents.Reserva;
import org.springframework.beans.BeanUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ReservaDto {

    private static final String DATE_FORMATTER= "yyyy-MM-dd HH:mm:ss";

    private String codigoHabitacion;

    private String fechaInicio;

    private String fechaFin;

    private float precio;

    private String nombreCliente;

    private String correoCliente;

    public ReservaDto(){

    }

    public ReservaDto(Reserva reserva){
        this.codigoHabitacion = reserva.getCodigoHabitacion();
        this.fechaInicio = ReservaDto.convertLocalDateTimeToString(reserva.getFechaHoraReservaInicio());
        this.fechaFin = ReservaDto.convertLocalDateTimeToString(reserva.getFechaHoraReservaFin());
        this.precio = reserva.getPrecioReserva();
        this.nombreCliente = reserva.getNombreCliente();
        this.correoCliente = reserva.getCorreoCliente();
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

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = ReservaDto.convertLocalDateTimeToString(fechaInicio);
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = ReservaDto.convertLocalDateTimeToString(fechaFin);
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

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public Reserva toDocument(){
        Reserva reserva = new Reserva();
        reserva.setCodigoHabitacion(this.getCodigoHabitacion());
        reserva.setNombreCliente(this.getNombreCliente());
        reserva.setCorreoCliente(this.getCorreoCliente());
        reserva.setPrecioReserva(this.getPrecio());
        reserva.setFechaHoraReservaInicio(ReservaDto.convertStringToLocalDateTime(this.getFechaInicio()));
        reserva.setFechaHoraReservaFin(ReservaDto.convertStringToLocalDateTime(this.getFechaFin()));
        return reserva;
    }

    public static Date convertToDate(String date){
        SimpleDateFormat sd = new SimpleDateFormat(ReservaDto.DATE_FORMATTER);
        try {
            return sd.parse(date);
        }catch(Exception ex){
            return null;
        }
    }

    public static String convertLocalDateTimeToString(LocalDateTime dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ReservaDto.DATE_FORMATTER);
        return dateTime.format(formatter);
    }

    public static LocalDateTime convertStringToLocalDateTime(String dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ReservaDto.DATE_FORMATTER);
        return LocalDateTime.parse(dateTime,formatter);
    }
}
