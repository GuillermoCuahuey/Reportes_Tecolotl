package tecolotl.reporte.entidad;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;

@Entity
public class GrupoEntidad {
    private UUID id;
    private Short grado;
    private char grupo;

    public GrupoEntidad() {
    }

    public GrupoEntidad(UUID id, Short grado, char grupo) {
        this.id = id;
        this.grado = grado;
        this.grupo = grupo;
    }

    @Id
    @Type(type = "pg-uuid")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Column(name = "grado")
    public Short getGrado() {
        return grado;
    }

    public void setGrado(Short grado) {
        this.grado = grado;
    }

    @Column(name = "grupo")
    public char getGrupo() {
        return grupo;
    }

    public void setGrupo(char grupo) {
        this.grupo = grupo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        GrupoEntidad that = (GrupoEntidad) o;
        return grupo == that.grupo &&
                id.equals(that.id) &&
                grado.equals(that.grado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, grado, grupo);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GrupoEntidad.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("grado=" + grado)
                .add("grupo=" + grupo)
                .toString();
    }
}
