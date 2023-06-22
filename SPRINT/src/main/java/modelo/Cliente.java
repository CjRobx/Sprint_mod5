package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class Cliente extends Usuario {
	String rut, nombres, apellidos, telefono,
				sistemaSalud, afp, direccion,comuna;

	public Cliente() {}

	public Cliente(String rut, String nombres, LocalDate fechaNacimiento, String tipoUsuario, String apellidos, String telefono, String sistemaSalud, String afp,
		String direccion, String comuna) {
		super(rut, nombres, fechaNacimiento, tipoUsuario);
	
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.sistemaSalud = sistemaSalud;
		this.afp = afp;
		this.direccion = direccion;
		this.comuna = comuna;
	}
//___________Getter & Setter_______________	
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getSistemaSalud() {
		return sistemaSalud;
	}
	public void setSistemaSalud(String sistemaSalud) {
		this.sistemaSalud = sistemaSalud;
	}
	public String getAfp() {
		return afp;
	}
	public void setAfp(String afp) {
		this.afp = afp;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getComuna() {
		return comuna;
	}
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}
	//_________________________________________________________

	@Override
	public String toString() {
		return "Cliente [rut=" + rut + ", nombres=" + nombres + ","
				+ "apellidos=" + apellidos + ", telefono=" + telefono
				+ ", sistemaSalud=" + sistemaSalud + ", afp=" + afp +
				", direccion=" + direccion + ", comuna=" + comuna + "]";
	}


}
