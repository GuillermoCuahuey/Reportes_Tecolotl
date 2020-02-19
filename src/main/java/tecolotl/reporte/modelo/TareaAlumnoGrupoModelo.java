package tecolotl.reporte.modelo;

import tecolotl.reporte.entidad.TareaAlumnoGrupoEntidad;

import java.util.StringJoiner;
import java.util.UUID;

public class TareaAlumnoGrupoModelo {

    private UUID id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int totalRespuestaMapaMental;
    private int totalAsignadaMapaMental;
    private int calificadoMapaMental;
    private int totalAsignadoRelacionar;
    private int totalRespuestaRelacionar;
    private int totalRespuestaGramatica;
    private int totalAsignadaGramatica;
    private int totalCalificadasGramatica;
    private int totalRespuestaOraciones;
    private int totalAsignadaOraciones;
    private int totalRespuestaRelacionarOracion;
    private int totalAsignadaRelacionarOracion;
    private int totalRespuestaCompletar;
    private int totalAsignadaCompletar;

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

    public int getTotalRespuestaMapaMental() {
        return totalRespuestaMapaMental;
    }

    public void setTotalRespuestaMapaMental(int totalRespuestaMapaMental) {
        this.totalRespuestaMapaMental = totalRespuestaMapaMental;
    }

    public int getTotalAsignadaMapaMental() {
        return totalAsignadaMapaMental;
    }

    public void setTotalAsignadaMapaMental(int totalAsignadaMapaMental) {
        this.totalAsignadaMapaMental = totalAsignadaMapaMental;
    }

    public int getTotalRespuestaGramatica() {
        return totalRespuestaGramatica;
    }

    public void setTotalRespuestaGramatica(int totalRespuestaGramatica) {
        this.totalRespuestaGramatica = totalRespuestaGramatica;
    }

    public int getTotalAsignadaGramatica() {
        return totalAsignadaGramatica;
    }

    public void setTotalAsignadaGramatica(int totalAsignadaGramatica) {
        this.totalAsignadaGramatica = totalAsignadaGramatica;
    }

    public int getTotalRespuestaOraciones() {
        return totalRespuestaOraciones;
    }

    public void setTotalRespuestaOraciones(int totalRespuestaOraciones) {
        this.totalRespuestaOraciones = totalRespuestaOraciones;
    }

    public int getTotalAsignadaOraciones() {
        return totalAsignadaOraciones;
    }

    public void setTotalAsignadaOraciones(int totalAsignadaOraciones) {
        this.totalAsignadaOraciones = totalAsignadaOraciones;
    }

    public int getTotalRespuestaRelacionarOracion() {
        return totalRespuestaRelacionarOracion;
    }

    public void setTotalRespuestaRelacionarOracion(int totalRespuestaRelacionarOracion) {
        this.totalRespuestaRelacionarOracion = totalRespuestaRelacionarOracion;
    }

    public int getTotalAsignadaRelacionarOracion() {
        return totalAsignadaRelacionarOracion;
    }

    public void setTotalAsignadaRelacionarOracion(int totalAsignadaRelacionarOracion) {
        this.totalAsignadaRelacionarOracion = totalAsignadaRelacionarOracion;
    }

    public int getTotalRespuestaCompletar() {
        return totalRespuestaCompletar;
    }

    public void setTotalRespuestaCompletar(int totalRespuestaCompletar) {
        this.totalRespuestaCompletar = totalRespuestaCompletar;
    }

    public int getTotalAsignadaCompletar() {
        return totalAsignadaCompletar;
    }

    public void setTotalAsignadaCompletar(int totalAsignadaCompletar) {
        this.totalAsignadaCompletar = totalAsignadaCompletar;
    }

    public int getCalificadoMapaMental() {
        return calificadoMapaMental;
    }

    public void setCalificadoMapaMental(int calificadoMapaMental) {
        this.calificadoMapaMental = calificadoMapaMental;
    }

    public int getTotalCalificadasGramatica() {
        return totalCalificadasGramatica;
    }

    public void setTotalCalificadasGramatica(int totalCalificadasGramatica) {
        this.totalCalificadasGramatica = totalCalificadasGramatica;
    }

    public int getTotalAsignadoRelacionar() {
        return totalAsignadoRelacionar;
    }

    public void setTotalAsignadoRelacionar(int totalAsignadoRelacionar) {
        this.totalAsignadoRelacionar = totalAsignadoRelacionar;
    }

    public int getTotalRespuestaRelacionar() {
        return totalRespuestaRelacionar;
    }

    public void setTotalRespuestaRelacionar(int totalRespuestaRelacionar) {
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
