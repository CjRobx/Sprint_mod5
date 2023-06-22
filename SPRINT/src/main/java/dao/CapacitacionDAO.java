package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import modelo.Capacitacion; 

public class CapacitacionDAO {
	private static CapacitacionDAO instancia;
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
	private String tabla = "capacitacion";
	private String columnas = "rutCliente, lugar, fecha, cantAsistentes, horaInicio, horaTermino";

// Obtener Instancia
	public static CapacitacionDAO getInstancia() {
		if (instancia == null) {
			instancia = new CapacitacionDAO();
		}
		return instancia;
	}
// Constructor
	private CapacitacionDAO() {
		conexion = obtenerConexion();
	}
// Obtener conexion a la BD
	private Connection obtenerConexion() {
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
//_________________Metodos CRUD_______________
	public void create(Capacitacion capacitacion) {
		String query =
				"INSERT INTO " + tabla + " (" + columnas + ") VALUES (?, ?, ?, ?, ?, ?)";
		try(PreparedStatement statement = conexion.prepareStatement(query)){
			statement.setString(1,capacitacion.getRutCliente());
			statement.setString(2,capacitacion.getLugar());
			statement.setString(3,capacitacion.getFecha().toString());
			statement.setString(4,Integer.toString(capacitacion.getCantAsistentes()));
			statement.setString(5,capacitacion.getHoraInicio().toString());
			statement.setString(6,capacitacion.getHoraTermino().toString());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Capacitacion> read(){
		List<Capacitacion> capacitaciones = new ArrayList<>();
		String query = 
				"SELECT id, " + columnas + " FROM " + tabla;
		try(PreparedStatement statement = conexion.prepareStatement(query);
			ResultSet resultados = statement.executeQuery()){
			
			while(resultados.next()) {
				Capacitacion capacitacion = new Capacitacion();
				capacitacion.setId(resultados.getInt("id"));
				capacitacion.setRutCliente(resultados.getString("rutCliente"));
				capacitacion.setLugar(resultados.getString("lugar"));
				capacitacion.setFecha(LocalDate.parse(resultados.getString("fecha")));
				capacitacion.setCantAsistentes(Integer.parseInt(resultados.getString("cantAsistentes")));
				capacitacion.setHoraInicio(LocalTime.parse(resultados.getString("horaInicio")));
				capacitacion.setHoraTermino(LocalTime.parse(resultados.getString("horaTermino")));

				capacitaciones.add(capacitacion);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return capacitaciones;
	}
	
	public void update(Capacitacion capacitacion) {
        String query = "UPDATE " + tabla
        		+ " SET rutCliente = ?, lugar = ?, cantAsistentes = ?, "
        		+ "horaInicio = ?, horaTermino = ? "
        		+ "WHERE id = ?";

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, capacitacion.getRutCliente());
            statement.setString(2, capacitacion.getLugar());
            statement.setInt(3, capacitacion.getCantAsistentes());
            statement.setString(4, capacitacion.getHoraInicio().toString());
            statement.setString(5, capacitacion.getHoraTermino().toString());
// Especificar ID
            statement.setInt(6, capacitacion.getId());
            System.out.println(statement);
// Ejecutar
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
    public void delete(int id) {
        String query = "DELETE FROM " + tabla + " WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
// Ejecutar
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//_______________________________________________________________________
    public Capacitacion readPorID(int id) {
    	Capacitacion capacitacion = null;
    	String query = "SELECT id, " + columnas + " FROM " + tabla + " WHERE id= ?";
    	try (PreparedStatement statement = conexion.prepareStatement(query)) {
    		statement.setInt(1, id);
    		
    		try (ResultSet resultados = statement.executeQuery()) {
	    		if(resultados.next()) {
	    			capacitacion = new Capacitacion();
					capacitacion.setId(resultados.getInt("id"));
					capacitacion.setRutCliente(resultados.getString("rutCliente"));
					capacitacion.setLugar(resultados.getString("lugar"));
					capacitacion.setFecha(LocalDate.parse(resultados.getString("fecha")));
					capacitacion.setCantAsistentes(Integer.parseInt(resultados.getString("cantAsistentes")));
					capacitacion.setHoraInicio(LocalTime.parse(resultados.getString("horaInicio")));
					capacitacion.setHoraTermino(LocalTime.parse(resultados.getString("horaTermino")));
	    		}
    		}
		} catch (SQLException e) {
            e.printStackTrace();
        }
        return capacitacion;
	}
}
