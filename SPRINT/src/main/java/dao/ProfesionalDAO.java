package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.Administrativo;
import modelo.Profesional;

public class ProfesionalDAO {
    private static ProfesionalDAO instancia;
    private Connection conexion;
 // URL segmentada
 	private String API = "jdbc";
 	private String database = "mysql";
 	private String serverName = "localhost";
 	private String IP = "";
 	private String puerto = "3306"; 
 	private String schema = "mod5";
 // datos para acceder a la BD
 	private String usuario = "explorador";
 	private String contrasena = "arenaGato";
 // datos tabla
 	private String tabla = "usuario";
 	private String columnas = "rut, nombres, fechaNacimiento, titulo, fechaIngreso";
	private String insertar = "rut, nombres, fechaNacimiento, tipoUsuario, titulo, fechaIngreso";
 	private String update = "nombres = ?, fechaNacimiento = ?, titulo = ?, fechaIngreso = ?";

//Constructor
 	private ProfesionalDAO() {
 		conexion = obtenerConexion();
 	}

 	public static ProfesionalDAO getInstancia() {
 		if (instancia == null) {
 			instancia = new ProfesionalDAO();
 		}
 		return instancia;
 	}

 	public Connection obtenerConexion() {
 		Connection conexion = null;

        try {
// Cargar driver MySQL
        	Class.forName("com.mysql.jdbc.Driver");

            String url = API + ":" + database + "://" + serverName + IP + ":" + puerto + "/" + schema  ;
// Establecer la conexión
            conexion = DriverManager.getConnection(url, usuario, contrasena);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexion;
 	}
//_________________Métodos CRUD___________________

 	public void create(Profesional prof) {
 		String query =
				"INSERT INTO " + tabla + " (" + insertar + ") VALUES (?, ?, ?, 'Profesional', ?, ?)";
		try(PreparedStatement statement = conexion.prepareStatement(query)){
			statement.setString(1, prof.getRut());
        	statement.setString(2, prof.getNombres());
            statement.setString(3, prof.getFechaNacimiento().toString());
			statement.setString(4,prof.getTitulo());
			statement.setString(5,prof.getFechaIngreso().toString());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
 	}

 	public List<Profesional> read(){
 		List<Profesional> profesionales = new ArrayList<>();
 		String query =
 				"SELECT id, " + columnas + " FROM " + tabla;
 		try(PreparedStatement statement = conexion.prepareStatement(query);
 				ResultSet resultados = statement.executeQuery()){
 				
			while(resultados.next()) {
				Profesional prof = new Profesional();
				
				prof.setRut(resultados.getString("rut"));
				prof.setNombres(resultados.getString("nombres"));
				prof.setFechaNacimiento(LocalDate.parse(resultados.getString("fechaNacimiento")));
				prof.setTitulo(resultados.getString("Titulo"));
				prof.setFechaIngreso(LocalDate.parse(resultados.getString("fechaIngreso")));
				
				profesionales.add(null);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return profesionales;
 	}
 	
 	public void update(Profesional prof) {
 		String query = "UPDATE " + tabla + " SET " + update + " WHERE rut = ?";
 		try (PreparedStatement statement = conexion.prepareStatement(query)) {
        	statement.setString(1, prof.getNombres());
            statement.setString(2, prof.getFechaNacimiento().toString());
            statement.setString(3, prof.getTitulo());
            statement.setString(4, prof.getFechaIngreso().toString());
// Especificar RUT
 			statement.setString(5, prof.getRut());
// 			System.out.println(statement);
// Ejecutar
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
 		
 	}

    public void delete(String rut) {
        String query = "DELETE FROM " + tabla + " WHERE rut = ?";

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, rut);
// Ejecutar
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//_______________________________________________________________________
   public Profesional readPorRUT(String rut) {
		Profesional prof = null;
		String query = "SELECT " + columnas + " FROM " + tabla + " WHERE rut = ?";
		
		try (PreparedStatement statement = conexion.prepareStatement(query)) {
		    statement.setString(1, rut);
		
		    try (ResultSet resultados = statement.executeQuery()) {
		        if (resultados.next()) {
		        	prof = new Profesional();
		        	prof.setRut(resultados.getString("rut"));
					prof.setNombres(resultados.getString("nombres"));
					prof.setFechaNacimiento(LocalDate.parse(resultados.getString("fechaNacimiento")));
					prof.setTitulo(resultados.getString("Titulo"));
					prof.setFechaIngreso(LocalDate.parse(resultados.getString("fechaIngreso")));
		        }
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return prof;
    }

}