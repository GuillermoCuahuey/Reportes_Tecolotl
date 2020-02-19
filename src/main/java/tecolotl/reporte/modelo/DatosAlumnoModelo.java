package tecolotl.reporte.modelo;

import tecolotl.reporte.entidad.DatosAlumnoEntidad;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.UUID;

public class DatosAlumnoModelo {
    private UUID idAlumno;
    private String apodoProfesor;
    private String nombreAlumno;
    private String apodo;
    private byte[] contrasenia;
    private Short galaxia;

    public DatosAlumnoModelo() {
    }

    public DatosAlumnoModelo(DatosAlumnoEntidad datosAlumnoEntidad) {
        this.idAlumno = datosAlumnoEntidad.getIdAlumno();
        this.apodoProfesor = datosAlumnoEntidad.getApodoProfesor();
        this.nombreAlumno = datosAlumnoEntidad.getNombreAlumno();
        this.apodo = datosAlumnoEntidad.getApodo();
        this.contrasenia = datosAlumnoEntidad.getContrasenia();
        this.galaxia = datosAlumnoEntidad.getGalaxia();
    }

    public UUID getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(UUID idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getApodoProfesor() {
        return apodoProfesor;
    }

    public void setApodoProfesor(String apodoProfesor) {
        this.apodoProfesor = apodoProfesor;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public byte[] getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(byte[] contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Short getGalaxia() {
        return galaxia;
    }

    public void setGalaxia(Short galaxia) {
        this.galaxia = galaxia;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DatosAlumnoModelo.class.getSimpleName() + "[", "]")
                .add("idAlumno=" + idAlumno)
                .add("apodoProfesor='" + apodoProfesor + "'")
                .add("nombreAlumno='" + nombreAlumno + "'")
                .add("apodo='" + apodo + "'")
                .add("contrasenia=" + Arrays.toString(contrasenia))
                .add("galaxia=" + galaxia)
                .toString();
    }
}
