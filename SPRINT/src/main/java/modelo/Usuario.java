package modelo;

import java.time.LocalDate;

public class Usuario {
	
	String nombres, rut, tipoUsuario;

	LocalDate fechaNacimiento;

	public Usuario() {}

	public Usuario(String rut, String nombres, LocalDate fechaNacimiento, String tipoUsuario) {
		this.rut = rut;
		this.nombres = nombres;
		this.fechaNacimiento = fechaNacimiento;
		this.tipoUsuario = tipoUsuario;
	}
//______________Getter y Setter________________
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	//_______________________________________________________

	

}
