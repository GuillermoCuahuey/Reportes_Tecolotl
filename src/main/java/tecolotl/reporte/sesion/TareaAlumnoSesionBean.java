package tecolotl.reporte.sesion;

import tecolotl.reporte.entidad.*;
import tecolotl.reporte.modelo.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Stateless
public class TareaAlumnoSesionBean {

    private Logger logger = Logger.getLogger(getClass().getName());

    @PersistenceContext(unitName = "reportes")
    private EntityManager entityManager;

    /**
     * Busca todos las tareas asigandas y realizadas de los alumnos asignados de un grupo
     * @param idGrupo Identificador del grupo
     * @return Colección de {@link TareaAlumnoGrupoModelo}
     */
    public List<TareaAlumnoGrupoModelo> busca(@NotNull UUID idGrupo) {
        Query query = entityManager.createNativeQuery("SELECT * FROM profesor.tareas_grupo(?)", TareaAlumnoGrupoEntidad.class);
        query.setParameter(1, idGrupo);
        return ((List<TareaAlumnoGrupoEntidad>)query.getResultList()).stream().map(TareaAlumnoGrupoModelo::new).collect(Collectors.toList());
    }

    /**
     * Busca el nivel de los alumnos, separados por grupo.
     * @param idGrupoLista indentificadores de grupos
     * @return Coleccion {@link TareasResueltasModelo}
     */
    public List<TareasResueltasModelo> busca(@NotNull @Size(min = 1) List<UUID> idGrupoLista){
        Query query = entityManager.createNativeQuery("SELECT * FROM profesor.busca_tareas_resueltas(CAST (? AS uuid[]))");
        final StringJoiner stringJoiner = new StringJoiner(",", "{", "}");
        idGrupoLista.forEach(grupo -> stringJoiner.add(grupo.toString()));
        query.setParameter(1,stringJoiner.toString());
        List<TareasResueltasModelo> tareasResueltasModeloLista = new ArrayList<>();
        List<Object[]> lista = query.getResultList();
        for (Object[] objects : lista) {
            TareasResueltasModelo tareasResueltasModelo = new TareasResueltasModelo();
            tareasResueltasModelo.setIdGrupo(UUID.fromString((String) objects[0]));
            tareasResueltasModelo.setIdAlumno(UUID.fromString((String)objects[1]));
            tareasResueltasModelo.setNivelLenguajeAlumno((Short)objects[2]);
            tareasResueltasModelo.setNombre((String)objects[3]);
            tareasResueltasModelo.setApellidoPaterno((String)objects[4]);
            tareasResueltasModelo.setApellidoMaterno((String)objects[5]);
            tareasResueltasModelo.setTotalTareas((Integer)objects[6]);
            tareasResueltasModelo.setNivelLenguaje((String)objects[7]);
            tareasResueltasModeloLista.add(tareasResueltasModelo);
        }
        return tareasResueltasModeloLista;
    }

    /**
     * Busca las calificaciones de un alumno.
     * @param idAlumno identificador del alumno
     * @return calificaciones de {@link TareaAlumnoModelo}
     */
    public List<TareaAlumnoModelo> buscaCalificaciones(@NotNull UUID idAlumno){
        Query query = entityManager.createNativeQuery("SELECT * FROM profesor.tareas_alumno(?)", TareaAlumnoEntidad.class);
        query.setParameter(1, idAlumno);
        return ((List<TareaAlumnoEntidad>)query.getResultList()).stream().map(TareaAlumnoModelo::new).collect(Collectors.toList());
    }

    public DatosAlumnoTareaModelo buscaAlumno(@NotNull UUID idAlumno){
        Query query = entityManager.createNativeQuery("SELECT * from profesor.datos_alumno(?)", DatosAlumnoTareaEntidad.class);
        query.setParameter(1,idAlumno);
        List<DatosAlumnoTareaEntidad> datosAlumnoTareaEntidadLista = query.getResultList();
        List<DatosAlumnoTareaModelo> datosAlumnoTareaModeloLista = datosAlumnoTareaEntidadLista.stream().map(DatosAlumnoTareaModelo::new).collect(Collectors.toList());
        return datosAlumnoTareaModeloLista.get(0);
    }

    /**
     *Busca los datos de sesion de los alumnos de un grupo.
     * @param idGrupo identificador del grupo.
     * @return una lista de {@link DatosAlumnoModelo}
     */
    public List<DatosAlumnoModelo> buscaDatosSesionAlumno(@NotNull UUID idGrupo){
        Query query = entityManager.createNativeQuery("SELECT * from profesor.datos_alumno_grupo(?)", DatosAlumnoEntidad.class);
        query.setParameter(1,idGrupo);
        return ((List<DatosAlumnoEntidad>)query.getResultList()).stream().map(DatosAlumnoModelo::new).collect(Collectors.toList());
    }

    /**
     * Busca los datos del profesor
     * @param idGrupo identificador del grupo
     * @return datos de {@link DatosProfesorModelo}
     */
    public DatosProfesorModelo buscaProfesor(@NotNull UUID idGrupo){
        logger.info("Id del grupo: ".concat(idGrupo.toString()));
        Query query = entityManager.createNativeQuery("SELECT * from profesor.datos_profesor(?)", DatosProfesorEntidad.class);
        query.setParameter(1, idGrupo);
        List<DatosProfesorEntidad> datosProfesorEntidadLista= query.getResultList();
        List<DatosProfesorModelo> datosProfesorModeloLista = datosProfesorEntidadLista.stream().map(DatosProfesorModelo::new).collect(Collectors.toList());
        logger.info("Datos del profesor entidad: ".concat(datosProfesorEntidadLista.toString()));
        logger.info("Datos del profesor modelo: ".concat(datosProfesorModeloLista.toString()));
        return datosProfesorModeloLista.get(0);
    }

    /**
     * Busca los datos de los grupos
     * @param idGrupoLista lista de identificadores de Grupos
     * @return lista de {@link GrupoModelo}
     */
    public List<GrupoModelo> buscaGrupo(@NotNull @Size(min = 1) List<UUID> idGrupoLista){
        Query query = entityManager.createNativeQuery("select * from profesor.datos_grupo(cast (? as uuid[]))", GrupoEntidad.class);
        final StringJoiner stringJoiner = new StringJoiner(",", "{", "}");
        idGrupoLista.forEach(grupo -> stringJoiner.add(grupo.toString()));
        query.setParameter(1, stringJoiner.toString());
        return ((List<GrupoEntidad>)query.getResultList()).stream().map(GrupoModelo::new).collect(Collectors.toList());
    }
}
