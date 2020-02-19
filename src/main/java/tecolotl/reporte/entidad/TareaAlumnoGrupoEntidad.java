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
    public int getTotalRespuestaMapaMental() {
        return totalRespuestaMapaMental;
    }

    public void setTotalRespuestaMapaMental(int totalRespuestaMapaMental) {
        this.totalRespuestaMapaMental = totalRespuestaMapaMental;
    }

    @Column(name = "total_asignadas_mapamental")
    public int getTotalAsignadaMapaMental() {
        return totalAsignadaMapaMental;
    }

    public void setTotalAsignadaMapaMental(int totalAsignadaMapaMental) {
        this.totalAsignadaMapaMental = totalAsignadaMapaMental;
    }

    @Column(name = "calificado_mapamental")
    public int getCalificadoMapaMental() {
        return calificadoMapaMental;
    }

    public void setCalificadoMapaMental(int calificadoMapaMental) {
        this.calificadoMapaMental = calificadoMapaMental;
    }

    @Column(name = "total_asignado_relacionar")
    public int getTotalAsignadoRelacionar() {
        return totalAsignadoRelacionar;
    }

    public void setTotalAsignadoRelacionar(int totalAsignadoRelacionar) {
        this.totalAsignadoRelacionar = totalAsignadoRelacionar;
    }

    @Column(name = "total_respuesta_relacionar")
    public int getTotalRespuestaRelacionar() {
        return totalRespuestaRelacionar;
    }

    public void setTotalRespuestaRelacionar(int totalRespuestaRelacionar) {
        this.totalRespuestaRelacionar = totalRespuestaRelacionar;
    }

    @Column(name = "total_respuesta_gramatica")
    public int getTotalRespuestaGramatica() {
        return totalRespuestaGramatica;
    }

    public void setTotalRespuestaGramatica(int totalRespuestaGramatica) {
        this.totalRespuestaGramatica = totalRespuestaGramatica;
    }

    @Column(name = "total_asignado_gramatica")
    public int getTotalAsignadaGramatica() {
        return totalAsignadaGramatica;
    }

    public void setTotalAsignadaGramatica(int totalAsignadaGramatica) {
        this.totalAsignadaGramatica = totalAsignadaGramatica;
    }

    @Column(name = "total_calificadas_gramatica")
    public int getTotalCalificadasGramatica() {
        return totalCalificadasGramatica;
    }

    public void setTotalCalificadasGramatica(int totalCalificadasGramatica) {
        this.totalCalificadasGramatica = totalCalificadasGramatica;
    }

    @Column(name = "total_respuesta_oraciones")
    public int getTotalRespuestaOraciones() {
        return totalRespuestaOraciones;
    }

    public void setTotalRespuestaOraciones(int totalRespuestaOraciones) {
        this.totalRespuestaOraciones = totalRespuestaOraciones;
    }

    @Column(name = "total_asignado_oraciones")
    public int getTotalAsignadaOraciones() {
        return totalAsignadaOraciones;
    }

    public void setTotalAsignadaOraciones(int totalAsignadaOraciones) {
        this.totalAsignadaOraciones = totalAsignadaOraciones;
    }

    @Column(name = "total_respuesta_relacionar_oracion")
    public int getTotalRespuestaRelacionarOracion() {
        return totalRespuestaRelacionarOracion;
    }

    public void setTotalRespuestaRelacionarOracion(int totalRespuestaRelacionarOracion) {
        this.totalRespuestaRelacionarOracion = totalRespuestaRelacionarOracion;
    }

    @Column(name = "total_asignado_relacionar_oracion")
    public int getTotalAsignadaRelacionarOracion() {
        return totalAsignadaRelacionarOracion;
    }

    public void setTotalAsignadaRelacionarOracion(int totalAsignadaRelacionarOracion) {
        this.totalAsignadaRelacionarOracion = totalAsignadaRelacionarOracion;
    }

    @Column(name = "total_respuesta_completar")
    public int getTotalRespuestaCompletar() {
        return totalRespuestaCompletar;
    }

    public void setTotalRespuestaCompletar(int totalRespuestaCompletar) {
        this.totalRespuestaCompletar = totalRespuestaCompletar;
    }

    @Column(name = "total_asignado_completar")
    public int getTotalAsignadaCompletar() {
        return totalAsignadaCompletar;
    }

    public void setTotalAsignadaCompletar(int totalAsignadaCompletar) {
        this.totalAsignadaCompletar = totalAsignadaCompletar;
    }

}
