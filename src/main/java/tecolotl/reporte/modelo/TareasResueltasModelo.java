package tecolotl.reporte.modelo;

import tecolotl.reporte.entidad.TareasResueltasEntidad;

import java.util.StringJoiner;
import java.util.UUID;

public class TareasResueltasModelo {

    private UUID idGrupo;
    private UUID idAlumno;
    private Short nivelLenguajeAlumno;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private UUID idTarea;
    private Integer totalTareas;
    private String  nivelLenguaje;

    public TareasResueltasModelo() {
    }

    public TareasResueltasModelo(TareasResueltasEntidad tareasResueltasEntidad) {
        this.idGrupo = tareasResueltasEntidad.getIdGrupo();
        this.idAlumno = tareasResueltasEntidad.getIdAlumno();
        this.nivelLenguajeAlumno = tareasResueltasEntidad.getNivelLenguajeAlumno();
        this.nombre = tareasResueltasEntidad.getNombre();
        this.apellidoPaterno = tareasResueltasEntidad.getApellidoP();
        this.apellidoMaterno = tareasResueltasEntidad.getApellidoM();
        this.idTarea = tareasResueltasEntidad.getIdTarea();
        this.totalTareas = tareasResueltasEntidad.getTotalTareas();
        this.nivelLenguaje = tareasResueltasEntidad.getNivelLenguaje();
    }

    public UUID getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(UUID idGrupo) {
        this.idGrupo = idGrupo;
    }

    public UUID getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(UUID idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Short getNivelLenguajeAlumno() {
        return nivelLenguajeAlumno;
    }

    public void setNivelLenguajeAlumno(Short nivelLenguajeAlumno) {
        this.nivelLenguajeAlumno = nivelLenguajeAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public UUID getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(UUID idTarea) {
        this.idTarea = idTarea;
    }

    public Integer getTotalTareas() {
        return totalTareas;
    }

    public void setTotalTareas(Integer totalTareas) {
        this.totalTareas = totalTareas;
    }

    public String getNivelLenguaje() {
        return nivelLenguaje;
    }

    public void setNivelLenguaje(String nivelLenguaje) {
        this.nivelLenguaje = nivelLenguaje;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TareasResueltasModelo.class.getSimpleName() + "[", "]")
                .add("idGrupo=" + idGrupo)
                .add("idAlumno=" + idAlumno)
                .add("nivelLenguajeAlumno=" + nivelLenguajeAlumno)
                .add("nombre='" + nombre + "'")
                .add("apellidoPaterno='" + apellidoPaterno + "'")
                .add("apellidoMaterno='" + apellidoMaterno + "'")
                .add("idTarea=" + idTarea)
                .add("totalTareas=" + totalTareas)
                .add("nivelLenguaje='" + nivelLenguaje + "'")
                .toString();
    }
}
