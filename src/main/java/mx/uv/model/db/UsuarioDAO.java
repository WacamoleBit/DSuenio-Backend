package mx.uv.model.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mx.uv.model.Usuario;

public class UsuarioDAO {
    private static Conexion miConn = new Conexion();

    public static boolean crearUsuario(Usuario usuario) {
        PreparedStatement stm = null;
        Connection conn = miConn.getConnection();
        
        boolean exito = false;

        try{
            String sql = "INSERT INTO usuario (usuario, contrasenia, email) values (?, ?, ?);";
            stm = conn.prepareStatement(sql);
            stm.setString(1, usuario.getUsuario());
            stm.setString(2, usuario.getContrasenia());
            stm.setString(3, usuario.getEmail());

            if(stm.executeUpdate() > 0) {
                exito = true;
            }
        } catch (Exception e) {
            System.out.println(e);

        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                stm = null;
            }
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        return exito;
    }

    public static Integer iniciarSesion(String nombreUsuario, String contrasenia) {
        Integer usuario = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Connection conn = miConn.getConnection();

        try {
            String sql = "SELECT idUsuario FROM usuario WHERE usuario = ? and contrasenia = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, nombreUsuario);
            stm.setString(2, contrasenia);
            rs = stm.executeQuery();

            if(rs.next()) {
                usuario = Integer.valueOf(rs.getInt("idUsuario"));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            rs = null;
            if (stm != null) {
                try {
                    stm.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                stm = null;
            }
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return usuario;
    }
    
    public static boolean cambiarContrasenia(Integer usuario, String contrasenia) {
        PreparedStatement stm = null;
        Connection conn = miConn.getConnection();
        
        boolean exito = false;

        try{
            String sql = "UPDATE usuario SET contrasenia = ? WHERE idUsuario = ?;";
            stm = conn.prepareStatement(sql);
            stm.setString(1, contrasenia);
            stm.setInt(2, usuario);

            if(stm.executeUpdate() > 0) {
                exito = true;
            }
        } catch (Exception e) {
            System.out.println(e);

        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                stm = null;
            }
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        return exito;
    }
}
