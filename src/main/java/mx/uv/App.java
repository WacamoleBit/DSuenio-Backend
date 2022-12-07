package mx.uv;

import static spark.Spark.*;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import mx.uv.model.db.EntradaDAO;
import mx.uv.model.db.UsuarioDAO;
import mx.uv.model.Entrada;
import mx.uv.model.Usuario;
/**
 * Hello world!
 *
 */
public class App 
{
    private static Integer sesionIniciada = null;
    public static void main(String[] args) {
        Gson gson = new Gson();

        port(80);

        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");

            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");

            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
        
        post("/crearCuenta", (req, res) -> {
            JsonElement arbol = JsonParser.parseString(req.body());
            JsonObject peticion = arbol.getAsJsonObject();
            Usuario usuario = new Usuario();

            usuario.setUsuario(peticion.get("usuario").getAsString());
            usuario.setContrasenia(peticion.get("contrasenia").getAsString());
            usuario.setRecontrasenia(peticion.get("recontrasenia").getAsString());
            usuario.setEmail(peticion.get("email").getAsString());

            return UsuarioDAO.crearUsuario(usuario);
        });

        get("/iniciarSesion", (req, res) -> {
            JsonElement arbol = JsonParser.parseString(req.body());
            JsonObject peticion = arbol.getAsJsonObject();
            String usuario = peticion.get("usuario").getAsString();
            String contrasenia = peticion.get("contrasenia").getAsString();

            Integer sesion = UsuarioDAO.iniciarSesion(usuario, contrasenia);

            return empezarSesion(sesion);
        });

        post("/crearEntrada", (req, res) -> {
            JsonElement arbol = JsonParser.parseString(req.body());
            JsonObject peticion = arbol.getAsJsonObject();
            Entrada entrada = new Entrada();

            entrada.setUsuario(peticion.get("usuario").getAsInt());
            entrada.setFechaCreacion(peticion.get("fechaCreacion").getAsString());
            entrada.setHorasDormidas(peticion.get("horasDormidas").getAsInt());
            entrada.setSensacionDescanso(peticion.get("sensacionDescanso").toString());
            entrada.setDescripcion(peticion.get("descripcion").getAsString());
            entrada.setaDestacar(peticion.get("aDestacar").getAsString());

            return EntradaDAO.crearEntrada(entrada);
        });

        get("/cargarEntradas", (req, res) -> {
            return gson.toJson(EntradaDAO.getEntradas(sesionIniciada));
        });

        get("/cargarDescripcion", (req, res) -> {
            JsonElement arbol = JsonParser.parseString(req.body());
            JsonObject peticion = arbol.getAsJsonObject();
            Integer entrada = peticion.get("idEntrada").getAsInt();
            
            return gson.toJson(EntradaDAO.getDescripcipon(entrada));
        });

        get("/cerrarSesion", (req, res) -> {
            return cerrarSesion();
        });
    }

    static boolean empezarSesion(Integer sesion) {
        sesionIniciada = sesion;

        return sesionIniciada != null;
    }

    static boolean cerrarSesion() {
        sesionIniciada = null;

        return sesionIniciada == null;
    }
}
