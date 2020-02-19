package tecolotl.reporte.modelo;

import tecolotl.reporte.entidad.TareaAlumnoEntidad;

import java.util.Date;
import java.util.StringJoiner;
import java.util.UUID;

public class TareaAlumnoModelo {
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

    public TareaAlumnoModelo() {
    }

    public TareaAlumnoModelo(TareaAlumnoEntidad tareaAlumnoEntidad){
        this.id = tareaAlumnoEntidad.getId();
        this.fechaAsignacion = tareaAlumnoEntidad.getFechaAsignacion();
        this.idActividad = tareaAlumnoEntidad.getIdActividad();
        this.calificacionTrascirpcion = tareaAlumnoEntidad.getCalificacionTrascirpcion();
        this.calificacionMapamental = tareaAlumnoEntidad.getCalificacionMapamental();
        this.calificacionRelacionarImagen = tareaAlumnoEntidad.getCalificacionRelacionarImagen();
        this.calificacionGramatica = tareaAlumnoEntidad.getCalificacionGramatica();
        this.calificacionOraciones = tareaAlumnoEntidad.getCalificacionOraciones();
        this.calificacionRelacionarOraciones = tareaAlumnoEntidad.getCalificacionRelacionarOraciones();
        this.calificacionCompletar = tareaAlumnoEntidad.getCalificacionCompletar();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public String getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(String idActividad) {
        this.idActividad = idActividad;
    }

    public Short getCalificacionTrascirpcion() {
        return calificacionTrascirpcion;
    }

    public void setCalificacionTrascirpcion(Short calificacionTrascirpcion) {
        this.calificacionTrascirpcion = calificacionTrascirpcion;
    }

    public Short getCalificacionMapamental() {
        return calificacionMapamental;
    }

    public void setCalificacionMapamental(Short calificacionMapamental) {
        this.calificacionMapamental = calificacionMapamental;
    }

    public Short getCalificacionRelacionarImagen() {
        return calificacionRelacionarImagen;
    }

    public void setCalificacionRelacionarImagen(Short calificacionRelacionarImagen) {
        this.calificacionRelacionarImagen = calificacionRelacionarImagen;
    }

    public Short getCalificacionGramatica() {
        return calificacionGramatica;
    }

    public void setCalificacionGramatica(Short calificacionGramatica) {
        this.calificacionGramatica = calificacionGramatica;
    }

    public Short getCalificacionOraciones() {
        return calificacionOraciones;
    }

    public void setCalificacionOraciones(Short calificacionOraciones) {
        this.calificacionOraciones = calificacionOraciones;
    }

    public Short getCalificacionRelacionarOraciones() {
        return calificacionRelacionarOraciones;
    }

    public void setCalificacionRelacionarOraciones(Short calificacionRelacionarOraciones) {
        this.calificacionRelacionarOraciones = calificacionRelacionarOraciones;
    }

    public Short getCalificacionCompletar() {
        return calificacionCompletar;
    }

    public void setCalificacionCompletar(Short calificacionCompletar) {
        this.calificacionCompletar = calificacionCompletar;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TareaAlumnoModelo.class.getSimpleName() + "[", "]")
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
