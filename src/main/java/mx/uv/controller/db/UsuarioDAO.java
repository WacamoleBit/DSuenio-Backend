package mx.uv.controller.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

import mx.uv.model.Usuario;

public class UsuarioDAO {
    private Conexion miConn = new Conexion();

    public String crearUsuario(Usuario u) {
        PreparedStatement stm = null;
        Connection conn = miConn.getConnection();
        String msj = "";

        try{
            String sql = "INSERT INTO usuario (id, usuario, contrasenia, email) vaues (?,?,?,?)";
            stm = conn.prepareStatement(sql);
            stm.setInt(1, u.getIdUsuario());
            stm.setString(2, u.getUsuario());
            stm.setString(3, u.getContrasenia());
            stm.setString(4, u.getContrasenia());

            if(stm.executeUpdate() > 0) {
                msj = "Usuario creado";
            } else {
                msj = "Imposible crear usuario";
            }
        } catch (Exception e) {

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
        return msj;
    }
}
