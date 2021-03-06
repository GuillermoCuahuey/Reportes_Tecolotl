package tecolotl.reporte.servlet;

import org.jboss.logging.Logger;
import tecolotl.reporte.modelo.GrupoModelo;
import tecolotl.reporte.pdf.ReporteSquadron;
import tecolotl.reporte.sesion.TareaAlumnoSesionBean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "Reporte Grupo Alumnos", urlPatterns = "reporte-alumnos")
public class ReporteGrupoAlumnosServlet extends HttpServlet {

    @Inject
    private TareaAlumnoSesionBean tareaAlumnoSesionBean;

    @Inject
    private ReporteSquadron reporteSquadron;

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String grupo = (String) httpServletRequest.getParameter("grupo");
        List<UUID> idGrupos = new ArrayList<>();
        idGrupos.add(UUID.fromString(grupo));
        ByteArrayOutputStream reporte = reporteSquadron.creaPDF2(tareaAlumnoSesionBean.busca(UUID.fromString(grupo)), tareaAlumnoSesionBean.buscaProfesor(UUID.fromString(grupo)), tareaAlumnoSesionBean.buscaGrupo(idGrupos).get(0));
        httpServletResponse.setContentType("application/pdf");
        httpServletResponse.setHeader("Expires","0");
        httpServletResponse.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=Group_Score.pdf");
        httpServletResponse.setContentLength(reporte.size());
        OutputStream outputStream = httpServletResponse.getOutputStream();
        reporte.writeTo(outputStream);
        outputStream.flush();
        outputStream.close();
    }

}
