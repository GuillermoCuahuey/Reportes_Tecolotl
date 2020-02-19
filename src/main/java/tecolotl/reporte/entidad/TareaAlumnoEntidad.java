package tecolotl.reporte.entidad;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;

@Entity
public class TareaAlumnoEntidad {
    private UUID id;
    private Date fechaAsignacion;
    private String idActividad;
    private Short calificacionTrascirpcion;
    private Short calificacionMapamental;
    private Short calificacionRelacionarImagen;
    private Short calificacionGramatica;
    private Short calificacionOraciones;
    private Short calificacionRelacionarOraciones;
    private Short calificacionCompletar;

    public TareaAlumnoEntidad() {
    }

    public TareaAlumnoEntidad(UUID id, Date fechaAsignacion, String idActividad, Short calificacionTrascirpcion, Short calificacionMapamental, Short calificacionRelacionarImagen, Short calificacionGramatica, Short calificacionOraciones, Short calificacionRelacionarOraciones, Short calificacionCompletar) {
        this.id = id;
        this.fechaAsignacion = fechaAsignacion;
        this.idActividad = idActividad;
        this.calificacionTrascirpcion = calificacionTrascirpcion;
        this.calificacionMapamental = calificacionMapamental;
        this.calificacionRelacionarImagen = calificacionRelacionarImagen;
        this.calificacionGramatica = calificacionGramatica;
        this.calificacionOraciones = calificacionOraciones;
        this.calificacionRelacionarOraciones = calificacionRelacionarOraciones;
        this.calificacionCompletar = calificacionCompletar;
    }

    @Id
    @Type(type = "pg-uuid")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Column(name = "fecha_asignacion")
    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    @Column(name = "id_actividad")
    public String getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(String idActividad) {
        this.idActividad = idActividad;
    }

    @Column(name = "calificacion_transcripcion")
    public Short getCalificacionTrascirpcion() {
        return calificacionTrascirpcion;
    }

    public void setCalificacionTrascirpcion(Short calificacionTrascirpcion) {
        this.calificacionTrascirpcion = calificacionTrascirpcion;
    }

    @Column(name = "calificacion_mapamental")
    public Short getCalificacionMapamental() {
        return calificacionMapamental;
    }

    public void setCalificacionMapamental(Short calificacionMapamental) {
        this.calificacionMapamental = calificacionMapamental;
    }

    @Column(name = "calificacion_relacionar_imagen")
    public Short getCalificacionRelacionarImagen() {
        return calificacionRelacionarImagen;
    }

    public void setCalificacionRelacionarImagen(Short calificacionRelacionarImagen) {
        this.calificacionRelacionarImagen = calificacionRelacionarImagen;
    }

    @Column(name = "calificacion_gramatica")
    public Short getCalificacionGramatica() {
        return calificacionGramatica;
    }

    public void setCalificacionGramatica(Short calificacionGramatica) {
        this.calificacionGramatica = calificacionGramatica;
    }

    @Column(name = "calificacion_oraciones")
    public Short getCalificacionOraciones() {
        return calificacionOraciones;
    }

    public void setCalificacionOraciones(Short calificacionOraciones) {
        this.calificacionOraciones = calificacionOraciones;
    }

    @Column(name = "calificacion_relacionar_oracion")
    public Short getCalificacionRelacionarOraciones() {
        return calificacionRelacionarOraciones;
    }

    public void setCalificacionRelacionarOraciones(Short calificacionRelacionarOraciones) {
        this.calificacionRelacionarOraciones = calificacionRelacionarOraciones;
    }

    @Column(name = "calificacion_completar")
    public Short getCalificacionCompletar() {
        return calificacionCompletar;
    }

    public void setCalificacionCompletar(Short calificacionCompletar) {
        this.calificacionCompletar = calificacionCompletar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TareaAlumnoEntidad that = (TareaAlumnoEntidad) o;
        return id.equals(that.id) &&
                fechaAsignacion.equals(that.fechaAsignacion) &&
                idActividad.equals(that.idActividad) &&
                calificacionTrascirpcion.equals(that.calificacionTrascirpcion) &&
                calificacionMapamental.equals(that.calificacionMapamental) &&
                calificacionRelacionarImagen.equals(that.calificacionRelacionarImagen) &&
                calificacionGramatica.equals(that.calificacionGramatica) &&
                calificacionOraciones.equals(that.calificacionOraciones) &&
                calificacionRelacionarOraciones.equals(that.calificacionRelacionarOraciones) &&
                calificacionCompletar.equals(that.calificacionCompletar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechaAsignacion, idActividad, calificacionTrascirpcion, calificacionMapamental, calificacionRelacionarImagen, calificacionGramatica, calificacionOraciones, calificacionRelacionarOraciones, calificacionCompletar);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TareaAlumnoEntidad.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("fechaAsignacion=" + fechaAsignacion)
                .add("idActividad='" + idActividad + "'")
                .add("calificacionTrascirpcion=" + calificacionTrascirpcion)
                .add("calificacionMapamental=" + calificacionMapamental)
                .add("calificacionRelacionarImagen=" + calificacionRelacionarImagen)
                .add("calificacionGramatica=" + calificacionGramatica)
                .add("calificacionOraciones=" + calificacionOraciones)
                .add("calificacionRelacionarOraciones=" + calificacionRelacionarOraciones)
                .add("calificacionCompletar=" + calificacionCompletar)
                .toString();
    }
}
