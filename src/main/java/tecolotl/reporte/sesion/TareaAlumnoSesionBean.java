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
    /*
    *   8:58:31,890 INFO  [tecolotl.reporte.sesion.TareaAlumnoSesionBean] (default task-1) [TareasResueltasModelo[idGrupo=769ac54b-e10d-4ceb-8b67-060634721c90, idAlumno=35dd04a8-754c-478f-af5a-9ab8a3abdfb2, nivelLenguajeAlumno=1, nombre='Alumno010', apellidoPaterno='Alumno010', apellidoMaterno='Alumno010', promedio=25.0, totalTareas=0, nivelLenguaje='A1']
, TareasResueltasModelo[idGrupo=769ac54b-e10d-4ceb-8b67-060634721c90, idAlumno=35dd04a8-754c-478f-af5a-9ab8a3abdfb2, nivelLenguajeAlumno=1, nombre='Alumno010', apellidoPaterno='Alumno010', apellidoMaterno='Alumno010', promedio=25.0, totalTareas=0, nivelLenguaje='A2']
, TareasResueltasModelo[idGrupo=769ac54b-e10d-4ceb-8b67-060634721c90, idAlumno=36ed8fcb-cd01-41b6-80c5-74117bbe24ec, nivelLenguajeAlumno=1, nombre='Alumno011', apellidoPaterno='Alumno011', apellidoMaterno='Alumno011', promedio=null, totalTareas=0, nivelLenguaje='A1']
, TareasResueltasModelo[idGrupo=769ac54b-e10d-4ceb-8b67-060634721c90, idAlumno=ea3aaa89-bf8e-4799-ba32-722e964be6a6, nivelLenguajeAlumno=1, nombre='Alumno012', apellidoPaterno='Alumno012', apellidoMaterno='Alumno012', promedio=null, totalTareas=0, nivelLenguaje='A1']
, TareasResueltasModelo[idGrupo=769ac54b-e10d-4ceb-8b67-060634721c90, idAlumno=e07d90b3-c86f-43ea-a9c2-565c82c13efb, nivelLenguajeAlumno=2, nombre='Alumno013', apellidoPaterno='Alumno013', apellidoMaterno='Alumno013', promedio=null, totalTareas=0, nivelLenguaje='A2']
, TareasResueltasModelo[idGrupo=769ac54b-e10d-4ceb-8b67-060634721c90, idAlumno=928cea3e-be16-46a6-b00b-41ade74ce23e, nivelLenguajeAlumno=1, nombre='Alumno014', apellidoPaterno='Alumno014', apellidoMaterno='Alumno014', promedio=null, totalTareas=0, nivelLenguaje='A1']
]
     */
    /**
     * Busca el nivel de los alumnos, separados por grupo.
     * @param idGrupoLista indentificadores de grupos
     * @return Coleccion {@link TareasResueltasModelo}
     */
    public List<TareasResueltasModelo> busca(@NotNull @Size(min = 1) List<UUID> idGrupoLista){
        Query query = entityManager.createNativeQuery("SELECT * FROM profesor.busca_tareas_resueltas(CAST (? AS uuid[]))");
        Query query2 = entityManager.createNativeQuery("select tnl.id_nivel_lenguaje from alumno.tarea as t left join alumno.tarea_nivel_lenguaje as tnl on t.id = tnl.id_tarea where t.id_alumno = ?");
        final StringJoiner stringJoiner = new StringJoiner(",", "{", "}");
        idGrupoLista.forEach(grupo -> stringJoiner.add(grupo.toString()));
        query.setParameter(1,stringJoiner.toString());
        List<TareasResueltasModelo> tareasResueltasModeloLista = new ArrayList<>();
        List<Object[]> lista = query.getResultList();
        for (Object[] objects : lista) {
            query2.setParameter(1, UUID.fromString((String)objects[1]));
            if(query2.getResultList().size() >= 2 || query2.getResultList().isEmpty()){
                tareasResueltasModeloLista.add(this.agregaDatos(objects));
            }else{
                if(((String)objects[8]).equalsIgnoreCase(String.valueOf(query2.getResultList().get(0)))){
                    tareasResueltasModeloLista.add(this.agregaDatos(objects));
                }
            }
        }
        logger.info(tareasResueltasModeloLista.toString());
        return tareasResueltasModeloLista;
    }
    private TareasResueltasModelo agregaDatos(Object[] objects){
        TareasResueltasModelo tareasResueltasModelo = new TareasResueltasModelo();
        tareasResueltasModelo.setIdGrupo(UUID.fromString((String) objects[0]));
        tareasResueltasModelo.setIdAlumno(UUID.fromString((String)objects[1]));
        tareasResueltasModelo.setNivelLenguajeAlumno((Short)objects[2]);
        tareasResueltasModelo.setNombre((String)objects[3]);
        tareasResueltasModelo.setApellidoPaterno((String)objects[4]);
        tareasResueltasModelo.setApellidoMaterno((String)objects[5]);
        tareasResueltasModelo.setPromedio((Double)objects[6]);
        tareasResueltasModelo.setTotalTareas((Integer)objects[7]);
        tareasResueltasModelo.setNivelLenguaje((String)objects[8]);
        return tareasResueltasModelo;
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
