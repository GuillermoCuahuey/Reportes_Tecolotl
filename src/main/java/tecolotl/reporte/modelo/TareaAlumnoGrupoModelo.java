package tecolotl.reporte.modelo;

import tecolotl.reporte.entidad.TareaAlumnoGrupoEntidad;

import java.util.StringJoiner;
import java.util.UUID;

public class TareaAlumnoGrupoModelo {

    private UUID id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Integer totalRespuestaMapaMental;
    private Integer totalAsignadaMapaMental;
    private Integer calificadoMapaMental;
    private Integer totalAsignadoRelacionar;
    private Integer totalRespuestaRelacionar;
    private Integer totalRespuestaGramatica;
    private Integer totalAsignadaGramatica;
    private Integer totalCalificadasGramatica;
    private Integer totalRespuestaOraciones;
    private Integer totalAsignadaOraciones;
    private Integer totalRespuestaRelacionarOracion;
    private Integer totalAsignadaRelacionarOracion;
    private Integer totalRespuestaCompletar;
    private Integer totalAsignadaCompletar;

    public TareaAlumnoGrupoModelo() {
    }

    public TareaAlumnoGrupoModelo(TareaAlumnoGrupoEntidad tareaAlumnoGrupoEntidad) {
        this.id = tareaAlumnoGrupoEntidad.getId();
        this.nombre = tareaAlumnoGrupoEntidad.getNombre();
        this.apellidoPaterno = tareaAlumnoGrupoEntidad.getApellidoPaterno();
        this.apellidoMaterno = tareaAlumnoGrupoEntidad.getApellidoMaterno();
        this.totalRespuestaMapaMental = tareaAlumnoGrupoEntidad.getTotalRespuestaMapaMental();
        this.totalAsignadaMapaMental = tareaAlumnoGrupoEntidad.getTotalAsignadaMapaMental();
        this.calificadoMapaMental = tareaAlumnoGrupoEntidad.getCalificadoMapaMental();
        this.totalAsignadoRelacionar = tareaAlumnoGrupoEntidad.getTotalAsignadoRelacionar();
        this.totalRespuestaRelacionar = tareaAlumnoGrupoEntidad.getTotalRespuestaRelacionar();
        this.totalRespuestaGramatica = tareaAlumnoGrupoEntidad.getTotalRespuestaGramatica();
        this.totalAsignadaGramatica = tareaAlumnoGrupoEntidad.getTotalAsignadaGramatica();
        this.totalCalificadasGramatica = tareaAlumnoGrupoEntidad.getTotalCalificadasGramatica();
        this.totalRespuestaOraciones = tareaAlumnoGrupoEntidad.getTotalRespuestaOraciones();
        this.totalAsignadaOraciones = tareaAlumnoGrupoEntidad.getTotalAsignadaOraciones();
        this.totalRespuestaRelacionarOracion = tareaAlumnoGrupoEntidad.getTotalRespuestaRelacionarOracion();
        this.totalAsignadaRelacionarOracion = tareaAlumnoGrupoEntidad.getTotalAsignadaRelacionarOracion();
        this.totalRespuestaCompletar = tareaAlumnoGrupoEntidad.getTotalRespuestaCompletar();
        this.totalAsignadaCompletar = tareaAlumnoGrupoEntidad.getTotalAsignadaCompletar();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Integer getTotalRespuestaMapaMental() {
        return totalRespuestaMapaMental;
    }

    public void setTotalRespuestaMapaMental(Integer totalRespuestaMapaMental) {
        this.totalRespuestaMapaMental = totalRespuestaMapaMental;
    }

    public Integer getTotalAsignadaMapaMental() {
        return totalAsignadaMapaMental;
    }

    public void setTotalAsignadaMapaMental(Integer totalAsignadaMapaMental) {
        this.totalAsignadaMapaMental = totalAsignadaMapaMental;
    }

    public Integer getTotalRespuestaGramatica() {
        return totalRespuestaGramatica;
    }

    public void setTotalRespuestaGramatica(Integer totalRespuestaGramatica) {
        this.totalRespuestaGramatica = totalRespuestaGramatica;
    }

    public Integer getTotalAsignadaGramatica() {
        return totalAsignadaGramatica;
    }

    public void setTotalAsignadaGramatica(Integer totalAsignadaGramatica) {
        this.totalAsignadaGramatica = totalAsignadaGramatica;
    }

    public Integer getTotalRespuestaOraciones() {
        return totalRespuestaOraciones;
    }

    public void setTotalRespuestaOraciones(Integer totalRespuestaOraciones) {
        this.totalRespuestaOraciones = totalRespuestaOraciones;
    }

    public Integer getTotalAsignadaOraciones() {
        return totalAsignadaOraciones;
    }

    public void setTotalAsignadaOraciones(Integer totalAsignadaOraciones) {
        this.totalAsignadaOraciones = totalAsignadaOraciones;
    }

    public Integer getTotalRespuestaRelacionarOracion() {
        return totalRespuestaRelacionarOracion;
    }

    public void setTotalRespuestaRelacionarOracion(Integer totalRespuestaRelacionarOracion) {
        this.totalRespuestaRelacionarOracion = totalRespuestaRelacionarOracion;
    }

    public Integer getTotalAsignadaRelacionarOracion() {
        return totalAsignadaRelacionarOracion;
    }

    public void setTotalAsignadaRelacionarOracion(Integer totalAsignadaRelacionarOracion) {
        this.totalAsignadaRelacionarOracion = totalAsignadaRelacionarOracion;
    }

    public Integer getTotalRespuestaCompletar() {
        return totalRespuestaCompletar;
    }

    public void setTotalRespuestaCompletar(Integer totalRespuestaCompletar) {
        this.totalRespuestaCompletar = totalRespuestaCompletar;
    }

    public Integer getTotalAsignadaCompletar() {
        return totalAsignadaCompletar;
    }

    public void setTotalAsignadaCompletar(Integer totalAsignadaCompletar) {
        this.totalAsignadaCompletar = totalAsignadaCompletar;
    }

    public Integer getCalificadoMapaMental() {
        return calificadoMapaMental;
    }

    public void setCalificadoMapaMental(Integer calificadoMapaMental) {
        this.calificadoMapaMental = calificadoMapaMental;
    }

    public Integer getTotalCalificadasGramatica() {
        return totalCalificadasGramatica;
    }

    public void setTotalCalificadasGramatica(Integer totalCalificadasGramatica) {
        this.totalCalificadasGramatica = totalCalificadasGramatica;
    }

    public Integer getTotalAsignadoRelacionar() {
        return totalAsignadoRelacionar;
    }

    public void setTotalAsignadoRelacionar(Integer totalAsignadoRelacionar) {
        this.totalAsignadoRelacionar = totalAsignadoRelacionar;
    }

    public Integer getTotalRespuestaRelacionar() {
        return totalRespuestaRelacionar;
    }

    public void setTotalRespuestaRelacionar(Integer totalRespuestaRelacionar) {
        this.totalRespuestaRelacionar = totalRespuestaRelacionar;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TareaAlumnoGrupoModelo.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nombre='" + nombre + "'")
                .add("apellidoPaterno='" + apellidoPaterno + "'")
                .add("apellidoMaterno='" + apellidoMaterno + "'")
                .add("totalRespuestaMapaMental=" + totalRespuestaMapaMental)
                .add("totalAsignadaMapaMental=" + totalAsignadaMapaMental)
                .add("calificadoMapaMental=" + calificadoMapaMental)
                .add("totalRespuestaGramatica=" + totalRespuestaGramatica)
                .add("totalAsignadaGramatica=" + totalAsignadaGramatica)
                .add("totalCalificadasGramatica=" + totalCalificadasGramatica)
                .add("totalRespuestaOraciones=" + totalRespuestaOraciones)
                .add("totalAsignadaOraciones=" + totalAsignadaOraciones)
                .add("totalRespuestaRelacionarOracion=" + totalRespuestaRelacionarOracion)
                .add("totalAsignadaRelacionarOracion=" + totalAsignadaRelacionarOracion)
                .add("totalRespuestaCompletar=" + totalRespuestaCompletar)
                .add("totalAsignadaCompletar=" + totalAsignadaCompletar)
                .toString();
    }
}
