package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Capacitacion {
	private String rutCliente, lugar;
	
	private LocalDate fecha;

	private LocalTime horaInicio, horaTermino; // HH:MM

	private int cantAsistentes, id;

	public Capacitacion() {}

	public Capacitacion(String rutCliente, String lugar, LocalDate fecha,
							LocalTime horaInicio, LocalTime horaTermino,
										int cantAsistentes) {
		this.rutCliente = rutCliente;
		this.lugar = lugar;
		this.fecha = fecha;
		this.cantAsistentes = cantAsistentes;
		this.horaInicio = horaInicio;
		this.horaTermino = horaTermino;
	}
//___________Getter & Setter_______________
	
	public String getRutCliente() {
		return rutCliente;
	}
	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}
	public LocalTime getHoraTermino() {
		return horaTermino;
	}
	public void setHoraTermino(LocalTime horaTermino) {
		this.horaTermino = horaTermino;
	}
	public int getCantAsistentes() {
		return cantAsistentes;
	}
	public void setCantAsistentes(int cantAsistentes) {
		this.cantAsistentes = cantAsistentes;
	}
//_________________________________________________________
	@Override
	public String toString() {
		return "Capacitacion [rutCliente=" + rutCliente + ", lugar=" + lugar + ", fecha=" + fecha + ", horaInicio=" + horaInicio
				+ ", horaTermio=" + horaTermino + ", cantAsistentes=" + cantAsistentes + "]";
	}



}
