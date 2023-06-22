package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class Profesional extends Usuario {

	private String titulo;

	private LocalDate fechaIngreso;

	public Profesional() {}
	
	public Profesional(String run, String nombres, LocalDate fechaNacimiento, String tipoUsuario,
								String titulo, LocalDate fechaIngreso) {
		super(run, nombres, fechaNacimiento, tipoUsuario);
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
	}
//_____________Getter y Setter______________________
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
//__________________________________________________
	@Override
	public String toString() {
		return "Profesional [titulo=" + titulo + ","
				+ "fechaIngreso=" + fechaIngreso + "]";
	}
//_________________Metodos__________________________

}