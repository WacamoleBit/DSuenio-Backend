package mx.uv.model;

public class Entrada {
    private int idEntrada = 0;
    private int usuario = 0;
    private String fechaCreacion = null;
    private int horasDormidas = 0;
    private String sensacionDescanso = null;
    private String descripcion = null;
    private String aDestacar = null;

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getHorasDormidas() {
        return horasDormidas;
    }

    public void setHorasDormidas(int horasDormidas) {
        this.horasDormidas = horasDormidas;
    }

    public String getSensacionDescanso() {
        return sensacionDescanso;
    }

    public void setSensacionDescanso(String sensacionDescanso) {
        this.sensacionDescanso = sensacionDescanso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getaDestacar() {
        return aDestacar;
    }

    public void setaDestacar(String aDestacar) {
        this.aDestacar = aDestacar;
    }
}
