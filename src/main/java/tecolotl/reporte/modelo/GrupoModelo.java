package tecolotl.reporte.modelo;

import tecolotl.reporte.entidad.GrupoEntidad;

import java.util.StringJoiner;
import java.util.UUID;

public class GrupoModelo {
    private UUID id;
    private Short grado;
    private char grupo;

    public GrupoModelo() {
    }

    public GrupoModelo(GrupoEntidad grupoEntidad) {
        this.id = grupoEntidad.getId();
        this.grado = grupoEntidad.getGrado();
        this.grupo = grupoEntidad.getGrupo();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Short getGrado() {
        return grado;
    }

    public void setGrado(Short grado) {
        this.grado = grado;
    }

    public char getGrupo() {
        return grupo;
    }

    public void setGrupo(char grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GrupoModelo.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("grado=" + grado)
                .add("grupo=" + grupo)
                .toString();
    }
}
