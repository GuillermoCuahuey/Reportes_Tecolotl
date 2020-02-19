package tecolotl.reporte.modelo;

import tecolotl.reporte.entidad.DatosProfesorEntidad;

import java.util.StringJoiner;
import java.util.UUID;

public class DatosProfesorModelo {
    private UUID id;
    private String nombreCompleto;
    private String apodo;
    private String correo;

    public DatosProfesorModelo() {
    }

    public DatosProfesorModelo(DatosProfesorEntidad datosProfesorEntidad){
        this.id = datosProfesorEntidad.getId();
        this.nombreCompleto = datosProfesorEntidad.getNombreCompleto();
        this.apodo = datosProfesorEntidad.getApodo();
        this.correo = datosProfesorEntidad.getCorreo();
    }

    public UUID Id() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DatosProfesorModelo.class.getSimpleName() + "[", "]")
                .add("idProfesor=" + id)
                .add("nombreCompleto='" + nombreCompleto + "'")
                .add("apodo='" + apodo + "'")
                .add("correo='" + correo + "'")
                .toString();
    }
}
