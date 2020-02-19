package tecolotl.reporte.entidad;

import javax.persistence.*;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;

@SqlResultSetMapping(name = "AlumnoTareasNivelEntidadMapping",
        entities = {
                @EntityResult(
                        entityClass = TareasResueltasEntidad.class,
                        fields = {
                                @FieldResult(name = "id_grupo", column = "idGrupo"),
                                @FieldResult(name = "id_alumn", column = "idAlumno"),
                                @FieldResult(name = "nombre", column = "nombre"),
                                @FieldResult(name = "apellido_paterno", column = "apellidoPaterno"),
                                @FieldResult(name = "apellido_materno", column = "apellidoMaterno"),
                                @FieldResult(name = "id_tarea", column = "idTarea"),
                                @FieldResult(name = "total_tareas_resueltas", column = "totalTareasResueltas"),
                                @FieldResult(name = "nivel_lenguaje", column = "nivelLenguaje"),
                        }
                )
        }
)
@Entity
public class TareasResueltasEntidad {
    private UUID idGrupo;
    private UUID idAlumno;
    private Short nivelLenguajeAlumno;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private UUID idTarea;
    private Integer totalTareas;
    private String nivelLenguaje;

    public TareasResueltasEntidad() {
    }

    public TareasResueltasEntidad(UUID idGrupo, UUID idAlumno, Short nivelLenguajeAlumno, String nombre, String apellidoP, String apellidoM, UUID idTarea, Integer totalTareas, String nivelLenguaje) {
        this.idGrupo = idGrupo;
        this.idAlumno = idAlumno;
        this.nivelLenguajeAlumno = nivelLenguajeAlumno;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.idTarea = idTarea;
        this.totalTareas = totalTareas;
        this.nivelLenguaje = nivelLenguaje;
    }

    @Id
    @Basic
    @Column(name = "id_grupo")
    public UUID getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(UUID idGrupo) {
        this.idGrupo = idGrupo;
    }

    @Basic
    @Column(name = "id_alumno")
    public UUID getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(UUID idAlumno) {
        this.idAlumno = idAlumno;
    }

    @Basic
    @Column(name = "nivel_lenguaje_alumno")
    public Short getNivelLenguajeAlumno() {
        return nivelLenguajeAlumno;
    }

    public void setNivelLenguajeAlumno(Short nivelLenguajeAlumno) {
        this.nivelLenguajeAlumno = nivelLenguajeAlumno;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "apellido_paterno")
    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    @Basic
    @Column(name = "apellido_materno")
    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    @Basic
    @Column(name = "id_tarea")
    public UUID getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(UUID idTarea) {
        this.idTarea = idTarea;
    }

    @Basic
    @Column(name = "total_tareas_resueltas")
    public Integer getTotalTareas() {
        return totalTareas;
    }

    public void setTotalTareas(Integer totalTareas) {
        this.totalTareas = totalTareas;
    }

    @Basic
    @Column(name = "nivel_lenguaje")
    public String getNivelLenguaje() {
        return nivelLenguaje;
    }

    public void setNivelLenguaje(String nivelLenguaje) {
        this.nivelLenguaje = nivelLenguaje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TareasResueltasEntidad that = (TareasResueltasEntidad) o;
        return idGrupo.equals(that.idGrupo) &&
                idAlumno.equals(that.idAlumno) &&
                nivelLenguajeAlumno.equals(that.nivelLenguajeAlumno) &&
                nombre.equals(that.nombre) &&
                apellidoP.equals(that.apellidoP) &&
                apellidoM.equals(that.apellidoM) &&
                idTarea.equals(that.idTarea) &&
                totalTareas.equals(that.totalTareas) &&
                nivelLenguaje.equals(that.nivelLenguaje);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGrupo, idAlumno, nivelLenguajeAlumno, nombre, apellidoP, apellidoM, idTarea, totalTareas, nivelLenguaje);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TareasResueltasEntidad.class.getSimpleName() + "[", "]")
                .add("idGrupo=" + idGrupo)
                .add("idAlumno=" + idAlumno)
                .add("nivelLenguajeAlumno=" + nivelLenguajeAlumno)
                .add("nombre='" + nombre + "'")
                .add("apellidoP='" + apellidoP + "'")
                .add("apellidoM='" + apellidoM + "'")
                .add("idTarea=" + idTarea)
                .add("totalTareas=" + totalTareas)
                .add("nivelLenguaje='" + nivelLenguaje + "'")
                .toString();
    }
}
