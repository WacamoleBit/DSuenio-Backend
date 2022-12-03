package mx.uv;

import static spark.Spark.*;

import java.io.Console;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import mx.uv.controller.db.EntradaDAO;
import mx.uv.controller.db.UsuarioDAO;
import mx.uv.model.Entrada;
import mx.uv.model.SensacionDescanso;
import mx.uv.model.Usuario;
/**
 * Hello world!
 *
 */
public class App 
{
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
        // before((req, res) -> res.type("application/json"));
        
        
        post("/crearCuenta", (req, res) -> {
            // Usuario usuario = gson.fromJson(datos, Usuario.class);
            JsonElement arbol = JsonParser.parseString(req.body());
            JsonObject peticion = arbol.getAsJsonObject();
            Usuario usuario = new Usuario();

            usuario.setUsuario(peticion.get("usuario").getAsString());
            usuario.setContrasenia(peticion.get("contrasenia").getAsString());
            usuario.setRecontrasenia(peticion.get("recontrasenia").getAsString());
            usuario.setEmail(peticion.get("email").getAsString());
            

            return UsuarioDAO.crearUsuario(usuario);
        });

        get("/iniciarSesion", (req, res) -> gson.toJson(UsuarioDAO.iniciarSesion("manueeel", "manuel_PW")));

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
    }
}
