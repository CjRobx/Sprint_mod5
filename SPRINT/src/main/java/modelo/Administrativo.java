package modelo;

import java.time.LocalDate;

public class Administrativo extends Usuario {

	private String area, experienciaPrevia;

	public Administrativo(String run, String nombres, LocalDate fechaNacimiento, String tipoUsuario,
										String area, String experienciaPrevia) {
		super(run, nombres, fechaNacimiento, tipoUsuario);
		this.area = area;
		this.experienciaPrevia = experienciaPrevia;
	}

	public Administrativo() {
	};

//____________Getter y Setter___________________________
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getExperienciaPrevia() {
		return experienciaPrevia;
	}
	public void setExperienciaPrevia(String experienciaPrevia) {
		this.experienciaPrevia = experienciaPrevia;
	}
//______________________________________________________

	@Override
	public String toString() {
		return "Administrativo:\n" +
				super.toString() + "\nArea: " + area + "\nExperiencia Previa: " + experienciaPrevia;
	}
//____________________Metodos__________________________

}
