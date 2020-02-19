package tecolotl.reporte.entidad;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;

@Entity
public class DatosProfesorEntidad {
    private UUID id;
    private String nombreCompleto;
    private String apodo;
    private String correo;

    public DatosProfesorEntidad() {
    }

    public DatosProfesorEntidad(UUID  id, String nombreCompleto, String apodo, String correo) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.apodo = apodo;
        this.correo = correo;
    }

    @Id
    @Type(type = "pg-uuid")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Column(name = "nombre_completo")
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
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
        DatosProfesorEntidad that = (DatosProfesorEntidad) o;
        return id.equals(that.id) &&
                nombreCompleto.equals(that.nombreCompleto) &&
                apodo.equals(that.apodo) &&
                correo.equals(that.correo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombreCompleto, apodo, correo);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DatosProfesorEntidad.class.getSimpleName() + "[", "]")
                .add("idProfesor=" + id)
                .add("nombreCompleto='" + nombreCompleto + "'")
                .add("apodo='" + apodo + "'")
                .add("correo='" + correo + "'")
                .toString();
    }
}
