package tecolotl.reporte.servlet;

import org.hibernate.validator.constraints.EAN;
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
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "Reporte Grupos Alumno", urlPatterns = "reporte-grupo")
public class ReporteTareasGrupoServlet extends HttpServlet {
    @Inject
    private TareaAlumnoSesionBean tareaAlumnoSesionBean;

    @Inject
    private ReporteSquadron reporteSquadron;

    @Override
    protected void  doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        //UUID idGrupo = UUID.fromString((String)httpServletRequest.getParameter("grupo"));
        List<UUID> idGrupoLista = new ArrayList<>();
        idGrupoLista.add(UUID.fromString("561ee273-db1e-4952-88c2-ae67f3ac50c1"));
        ByteArrayOutputStream reporte = reporteSquadron.creaPDF1(tareaAlumnoSesionBean.busca(idGrupoLista), tareaAlumnoSesionBean.buscaGrupo(idGrupoLista), tareaAlumnoSesionBean.buscaProfesor(idGrupoLista.get(0)));
        httpServletResponse.setContentType("application/pdf");
        httpServletResponse.setHeader("Expires","0");
        httpServletResponse.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=ImportLog.pdf");
        httpServletResponse.setContentLength(reporte.size());
        OutputStream outputStream = httpServletResponse.getOutputStream();
        reporte.writeTo(outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
