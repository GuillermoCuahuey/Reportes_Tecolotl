package tecolotl.reporte.entidad;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class TareaAlumnoGrupoEntidad {

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

    @Id
    @Type(type = "pg-uuid")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "apellido_paterno")
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    @Column(name = "apellido_materno")
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    @Column(name = "total_respuesta_mapamental")
    public Integer getTotalRespuestaMapaMental() {
        return totalRespuestaMapaMental;
    }

    public void setTotalRespuestaMapaMental(Integer totalRespuestaMapaMental) {
        this.totalRespuestaMapaMental = totalRespuestaMapaMental;
    }

    @Column(name = "total_asignadas_mapamental")
    public Integer getTotalAsignadaMapaMental() {
        return totalAsignadaMapaMental;
    }

    public void setTotalAsignadaMapaMental(Integer totalAsignadaMapaMental) {
        this.totalAsignadaMapaMental = totalAsignadaMapaMental;
    }

    @Column(name = "total_calificado_mapamental")
    public Integer getCalificadoMapaMental() {
        return calificadoMapaMental;
    }

    public void setCalificadoMapaMental(Integer calificadoMapaMental) {
        this.calificadoMapaMental = calificadoMapaMental;
    }

    @Column(name = "total_asignado_relacionar")
    public Integer getTotalAsignadoRelacionar() {
        return totalAsignadoRelacionar;
    }

    public void setTotalAsignadoRelacionar(Integer totalAsignadoRelacionar) {
        this.totalAsignadoRelacionar = totalAsignadoRelacionar;
    }

    @Column(name = "total_respuesta_relacionar")
    public Integer getTotalRespuestaRelacionar() {
        return totalRespuestaRelacionar;
    }

    public void setTotalRespuestaRelacionar(Integer totalRespuestaRelacionar) {
        this.totalRespuestaRelacionar = totalRespuestaRelacionar;
    }

    @Column(name = "total_respuesta_gramatica")
    public Integer getTotalRespuestaGramatica() {
        return totalRespuestaGramatica;
    }

    public void setTotalRespuestaGramatica(Integer totalRespuestaGramatica) {
        this.totalRespuestaGramatica = totalRespuestaGramatica;
    }

    @Column(name = "total_asignado_gramatica")
    public Integer getTotalAsignadaGramatica() {
        return totalAsignadaGramatica;
    }

    public void setTotalAsignadaGramatica(Integer totalAsignadaGramatica) {
        this.totalAsignadaGramatica = totalAsignadaGramatica;
    }

    @Column(name = "total_calificadas_gramatica")
    public Integer getTotalCalificadasGramatica() {
        return totalCalificadasGramatica;
    }

    public void setTotalCalificadasGramatica(Integer totalCalificadasGramatica) {
        this.totalCalificadasGramatica = totalCalificadasGramatica;
    }

    @Column(name = "total_respuesta_oraciones")
    public Integer getTotalRespuestaOraciones() {
        return totalRespuestaOraciones;
    }

    public void setTotalRespuestaOraciones(Integer totalRespuestaOraciones) {
        this.totalRespuestaOraciones = totalRespuestaOraciones;
    }

    @Column(name = "total_asignado_oraciones")
    public Integer getTotalAsignadaOraciones() {
        return totalAsignadaOraciones;
    }

    public void setTotalAsignadaOraciones(Integer totalAsignadaOraciones) {
        this.totalAsignadaOraciones = totalAsignadaOraciones;
    }

    @Column(name = "total_respuesta_relacionar_oracion")
    public Integer getTotalRespuestaRelacionarOracion() {
        return totalRespuestaRelacionarOracion;
    }

    public void setTotalRespuestaRelacionarOracion(Integer totalRespuestaRelacionarOracion) {
        this.totalRespuestaRelacionarOracion = totalRespuestaRelacionarOracion;
    }

    @Column(name = "total_asignado_relacionar_oracion")
    public Integer getTotalAsignadaRelacionarOracion() {
        return totalAsignadaRelacionarOracion;
    }

    public void setTotalAsignadaRelacionarOracion(Integer totalAsignadaRelacionarOracion) {
        this.totalAsignadaRelacionarOracion = totalAsignadaRelacionarOracion;
    }

    @Column(name = "total_respuesta_completar")
    public Integer getTotalRespuestaCompletar() {
        return totalRespuestaCompletar;
    }

    public void setTotalRespuestaCompletar(Integer totalRespuestaCompletar) {
        this.totalRespuestaCompletar = totalRespuestaCompletar;
    }

    @Column(name = "total_asignado_completar")
    public Integer getTotalAsignadaCompletar() {
        return totalAsignadaCompletar;
    }

    public void setTotalAsignadaCompletar(Integer totalAsignadaCompletar) {
        this.totalAsignadaCompletar = totalAsignadaCompletar;
    }

}
