package mx.uv.model;

public class Usuario {
    private int idUsuario = 0;
    private String usuario = null;
    private String contrasenia = null;
    private String email = null;

    public Usuario() {}

    public Usuario (int idUsuario, String usuario, String contrasenia, String email) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.email = email;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
