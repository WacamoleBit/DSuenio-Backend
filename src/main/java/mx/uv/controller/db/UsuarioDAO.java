package mx.uv.controller.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

import mx.uv.model.Usuario;

public class UsuarioDAO {
    private Conexion miConn = new Conexion();

    public boolean crearUsuario(Usuario usuario) {
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
}
