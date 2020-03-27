package tecolotl.reporte.servlet;

import tecolotl.reporte.pdf.ReporteSquadron;
import tecolotl.reporte.sesion.TareaAlumnoSesionBean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.ImagingOpException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@WebServlet(name = "Reporte Calificaciones Alumno", urlPatterns = "reporte-calificaciones")
public class ReporteCalificacionesAlumnoServlet extends HttpServlet {

    @Inject
    private TareaAlumnoSesionBean tareaAlumnoSesionBean;

    @Inject
    private ReporteSquadron reporteSquadron;

    @Override
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException{
        String alumno = (String) httpServletRequest.getParameter("alumno");
        ByteArrayOutputStream reporte = reporteSquadron.creaPDF3(
                tareaAlumnoSesionBean.buscaCalificaciones(UUID.fromString(alumno)), tareaAlumnoSesionBean.buscaAlumno(UUID.fromString(alumno))
        );
        //System.out.println(tareaAlumnoSesionBean.buscaCalificaciones(UUID.fromString("041bb886-bfb4-4b66-8a0f-464a70fd4de9")).toString());
        httpServletResponse.setContentType("application/pdf");
        httpServletResponse.setHeader("Expires","0");
        httpServletResponse.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=Individual_Score.pdf");
        httpServletResponse.setContentLength(reporte.size());
        OutputStream outputStream = httpServletResponse.getOutputStream();
        reporte.writeTo(outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
