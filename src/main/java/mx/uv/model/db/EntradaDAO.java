package mx.uv.model.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

import mx.uv.model.Entrada;

public class EntradaDAO {
    private static Conexion miConn = new Conexion();

    public static boolean crearEntrada(Entrada entrada) {
        PreparedStatement stm = null;
        Connection conn = miConn.getConnection();

        boolean exito = false;
        
        try {
            String sql = "INSERT INTO entrada (usuario, fechaCreacion, horasDormidas, "+
                "sensacionDescanso, descripcion, aDestacar) values (?, ?, ?, ?, ?, ?);";
            stm = conn.prepareStatement(sql);
            stm.setInt(1, entrada.getUsuario());
            stm.setString(0, entrada.getFechaCreacion());
            stm.setInt(3, entrada.getHorasDormidas());
            stm.setString(4, entrada.getSensacionDescanso().toString());
            stm.setString(5, entrada.getDescripcion());
            stm.setString(6, entrada.getaDestacar());

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
