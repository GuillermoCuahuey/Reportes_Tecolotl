package tecolotl.reporte.entidad;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;

@Entity
public class DatosAlumnoTareaEntidad {

    private UUID id;
    private String nombrecompleto;
    private String apodo;
    private String correo;

    public DatosAlumnoTareaEntidad() {
    }

    public DatosAlumnoTareaEntidad(UUID id, String nombrecompleto, String apodo, String correo) {
        this.id = id;
        this.nombrecompleto = nombrecompleto;
        this.apodo = apodo;
        this.correo = correo;
    }

    @Id
    @Column(name = "id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Column(name = "nombre_completo")
    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    @Column(name = "apodo")
    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    @Column(name = "correo")
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DatosAlumnoTareaEntidad that = (DatosAlumnoTareaEntidad) o;
        return id.equals(that.id) &&
                nombrecompleto.equals(that.nombrecompleto) &&
                apodo.equals(that.apodo) &&
                correo.equals(that.correo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombrecompleto, apodo, correo);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DatosAlumnoTareaEntidad.class.getSimpleName() + "[", "]")
                .add("idAlumno=" + id)
                .add("nombrecompleto='" + nombrecompleto + "'")
                .add("apodo='" + apodo + "'")
                .add("correo='" + correo + "'")
                .toString();
    }
}
