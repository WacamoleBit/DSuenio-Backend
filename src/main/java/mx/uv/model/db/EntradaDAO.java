package mx.uv.model.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            stm.setString(2, entrada.getFechaCreacion());
            stm.setInt(3, entrada.getHorasDormidas());
            stm.setInt(4, entrada.getSensacionDescanso());
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

    public static List<Entrada> getEntradas(Integer usuario) {
        List<Entrada> lista = new ArrayList<>();
        PreparedStatement stm = null;
        ResultSet rs = null;
        Connection conn = miConn.getConnection();

        try {
            String sql ="SELECT idEntrada, fechaCreacion, horasDormidas, sensacionDescanso, descripcion, aDestacar FROM entrada " +
            "WHERE usuario = ?";
            stm = conn.prepareStatement(sql);
            stm.setInt(1, usuario);
            rs = stm.executeQuery();

            while (rs.next()) {
                Entrada entrada = new Entrada();
                entrada.setIdEntrada(rs.getInt("idEntrada"));
                entrada.setFechaCreacion(rs.getString("fechaCreacion"));
                entrada.setHorasDormidas(rs.getInt("horasDormidas"));
                entrada.setDescripcion(rs.getString("descripcion"));
                entrada.setaDestacar(rs.getString("aDestacar"));

                lista.add(entrada);
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

        return lista;
    }

    public static String getDescripcipon(Integer idEntrada) {
        String descripcion = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Connection conn = miConn.getConnection();

        try {
            String sql ="SELECT descripcion FROM entrada WHERE idEntrada = ?";
            stm = conn.prepareStatement(sql);
            stm.setInt(1, idEntrada);
            rs = stm.executeQuery();

            if(stm.executeUpdate() > 0) {
                descripcion = rs.getString("descripcion");
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

        return descripcion;
    }
}
