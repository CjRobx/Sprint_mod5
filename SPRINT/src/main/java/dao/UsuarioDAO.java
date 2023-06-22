package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;

import modelo.Usuario;

public class UsuarioDAO {
    private static UsuarioDAO instancia;
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
 	private String columnas = "rut, nombres, fechaNacimiento, tipoUsuario";
 	
    private UsuarioDAO() {
        // Establecer la conexión a la base de datos en el constructor privado
        // Usar Singleton para asegurar que solo haya una instancia de UsuarioDAO
        // y una única conexión a la base de datos en todo el proyecto
        conexion = obtenerConexion();
    }
    
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

    public static UsuarioDAO getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioDAO();
        }
        return instancia;
    }
//_________________Métodos CRUD___________________

    public List<Usuario> read() {
    	
        List<Usuario> usuarios = new ArrayList<>();
        String query =
        				"SELECT " + columnas + " FROM " + tabla;

        try (PreparedStatement statement = conexion.prepareStatement(query);	
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setRut(resultSet.getString("rut"));
                usuario.setNombres(resultSet.getString("nombres"));
                usuario.setFechaNacimiento(LocalDate.parse(resultSet.getString("fechaNacimiento")));
                usuario.setTipoUsuario(resultSet.getString("tipoUsuario"));

                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public void create(Usuario usuario) {
        String query = "INSERT INTO usuario (rut, nombres, fechaNacimiento) VALUES (?, ?, ?)";

        try (PreparedStatement statement = conexion.prepareStatement(query)){

        	statement.setString(1, usuario.getRut());
        	statement.setString(2, usuario.getNombres());
            statement.setString(3, usuario.getFechaNacimiento().toString());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Usuario usuario) {
        String query = "UPDATE usuario SET rut = ?, nombres = ?, fechaNacimiento = ? WHERE id = ?";

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
        	statement.setString(1, usuario.getRut());
        	statement.setString(2, usuario.getNombres());
            statement.setString(3, usuario.getFechaNacimiento().toString());
            statement.setString(4, usuario.getTipoUsuario());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String rut) {
        String query = "DELETE FROM " + tabla + " WHERE rut = ?";

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, rut);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//_______________________________________________________________________
    public Usuario readPorRut(String rut) {
        Usuario usuario = null;
        String query = "SELECT id, rut, nombres, fechaNacimiento FROM usuario WHERE id = ?";

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, rut);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    usuario = new Usuario();
                    usuario.setRut(resultSet.getString("rut"));
                    usuario.setNombres(resultSet.getString("nombre"));
                    usuario.setFechaNacimiento(LocalDate.parse(resultSet.getString("fechaNacimiento")));
                    usuario.setTipoUsuario(resultSet.getString("tipoUsuario"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

}