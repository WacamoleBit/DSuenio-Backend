package mx.uv.model;

public class Usuario {
    private int idUsuario = 0;
    private String usuario = null;
    private String contrasenia = null;
    private String recontrasenia = null;
    private String email = null;

    public Usuario() {}

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

    public void setRecontrasenia(String recontrasenia) {
        this.recontrasenia = recontrasenia;
    }

    public String getRecontrasenia() {
        return recontrasenia;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        String str = getIdUsuario() + " " + getUsuario() + " " + getContrasenia();
        return str;
    }
}
