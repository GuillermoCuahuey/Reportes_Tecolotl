package tecolotl.reporte.modelo;

import tecolotl.reporte.entidad.DatosAlumnoTareaEntidad;

import java.util.StringJoiner;
import java.util.UUID;

public class DatosAlumnoTareaModelo {
    private UUID id;
    private String nombreCompleto;
    private String apodo;
    private String correo;


    public DatosAlumnoTareaModelo() {
    }

    public DatosAlumnoTareaModelo(DatosAlumnoTareaEntidad datosAlumnoTareaEntidad){
        this.id = datosAlumnoTareaEntidad.getId();
        this.nombreCompleto = datosAlumnoTareaEntidad.getNombrecompleto();
        this.apodo = datosAlumnoTareaEntidad.getApodo();
        this.correo = datosAlumnoTareaEntidad.getCorreo();
    }

    public UUID getId() {
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
        return new StringJoiner(", ", DatosAlumnoTareaModelo.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nombreCompleto='" + nombreCompleto + "'")
                .add("apodo='" + apodo + "'")
                .add("correo='" + correo + "'")
                .toString();
    }
}
