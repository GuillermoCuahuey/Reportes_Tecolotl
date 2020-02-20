package tecolotl.reporte.servlet;

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

@WebServlet(name = "Reporte Nivel Grupos", urlPatterns = "reporte-nivel")
public class ReporteNivelGrupoServlet extends HttpServlet {
    @Inject
    private TareaAlumnoSesionBean tareaAlumnoSesionBean;

    @Inject
    private ReporteSquadron reporteSquadron;

    @Override
    protected void  doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String idGrupos = (String)httpServletRequest.getParameter("grupos");
        List<UUID> idGrupoLista = new ArrayList<>();
        String[] grupos = idGrupos.split(",");
        if(grupos.length <= 1){
            idGrupoLista.add(UUID.fromString(idGrupos));
        }else{
            for (int i = 0; i < grupos.length; i++) {
                idGrupoLista.add(UUID.fromString(grupos[i]));
            }
        }
        ByteArrayOutputStream reporte = reporteSquadron.creaPDF1(tareaAlumnoSesionBean.busca(idGrupoLista), tareaAlumnoSesionBean.buscaGrupo(idGrupoLista), tareaAlumnoSesionBean.buscaProfesor(idGrupoLista.get(0)));
        httpServletResponse.setContentType("application/pdf");
        httpServletResponse.setHeader("Expires","0");
        httpServletResponse.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=Group_Information.pdf");
        httpServletResponse.setContentLength(reporte.size());
        OutputStream outputStream = httpServletResponse.getOutputStream();
        reporte.writeTo(outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
