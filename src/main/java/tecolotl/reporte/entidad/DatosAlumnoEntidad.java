package tecolotl.reporte.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;

@Entity
public class DatosAlumnoEntidad {
    private UUID idAlumno;
    private String apodoProfesor;
    private String nombreAlumno;
    private String apodo;
    private byte[] contrasenia;
    private Short galaxia;

    public DatosAlumnoEntidad() {
    }

    public DatosAlumnoEntidad(UUID idAlumno, String apodoProfesor, String nombreAlumno, String apodo, byte[] contrasenia, Short galaxia) {
        this.idAlumno = idAlumno;
        this.apodoProfesor = apodoProfesor;
        this.nombreAlumno = nombreAlumno;
        this.apodo = apodo;
        this.contrasenia = contrasenia;
        this.galaxia = galaxia;
    }

    @Id
    @Column(name = "id")
    public UUID getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(UUID idAlumno) {
        this.idAlumno = idAlumno;
    }

    @Column(name = "apodo_profesor")
    public String getApodoProfesor() {
        return apodoProfesor;
    }

    public void setApodoProfesor(String apodoProfesor) {
        this.apodoProfesor = apodoProfesor;
    }

    @Column(name = "nombre_completo")
    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    @Column(name = "apodo_alumno")
    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    @Column(name = "contrasenia")
    public byte[] getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(byte[] contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Column(name = "galaxia")
    public Short getGalaxia() {
        return galaxia;
    }

    public void setGalaxia(Short galaxia) {
        this.galaxia = galaxia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DatosAlumnoEntidad that = (DatosAlumnoEntidad) o;
        return idAlumno.equals(that.idAlumno) &&
                apodoProfesor.equals(that.apodoProfesor) &&
                nombreAlumno.equals(that.nombreAlumno) &&
                apodo.equals(that.apodo) &&
                Arrays.equals(contrasenia, that.contrasenia) &&
                galaxia.equals(that.galaxia);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(idAlumno, apodoProfesor, nombreAlumno, apodo, galaxia);
        result = 31 * result + Arrays.hashCode(contrasenia);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DatosAlumnoEntidad.class.getSimpleName() + "[", "]")
                .add("idAlumno=" + idAlumno)
                .add("apodoProfesor='" + apodoProfesor + "'")
                .add("nombreAlumno='" + nombreAlumno + "'")
                .add("apodo='" + apodo + "'")
                .add("contrasenia=" + Arrays.toString(contrasenia))
                .add("galaxia=" + galaxia)
                .toString();
    }
}
