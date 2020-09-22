package tecolotl.reporte.pdf;

import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.extgstate.PdfExtGState;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.AreaBreakType;
import com.itextpdf.layout.property.TextAlignment;
import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;
import tecolotl.reporte.modelo.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Stateless
public class ReporteSquadron {
    private Logger logger = Logger.getLogger(getClass().getName());

    public ReporteSquadron() {
    }

    public ByteArrayOutputStream creaPDF1(List<TareasResueltasModelo> tareasResueltasModeloLista, List<GrupoModelo> grupoModeloLista, DatosProfesorModelo datosProfesorModelo) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfDocument documentoPdf = new PdfDocument(new PdfWriter(byteArrayOutputStream));
        FontProgram fontProgram = FontProgramFactory.createFont("../fonts/Montserrat-Light.otf");
        PdfFont pdfFont = PdfFontFactory.createFont(fontProgram, PdfEncodings.UTF8,true);
        try(Document documento = new Document(documentoPdf)){
            documento.setFont(pdfFont);
            this.crearFondo(documentoPdf);
            documento.setMargins(documento.getTopMargin()-20,
                    documento.getRightMargin()-10,
                    documento.getBottomMargin()-75,
                    documento.getLeftMargin()-10);
            EventoPagina evento = new EventoPagina(documento, documentoPdf);
            documento.add(new Paragraph("Quantitative Report").setTextAlignment(TextAlignment.CENTER).setMinWidth(50).setFontSize(20).setMarginBottom(20));
            documentoPdf.addEventHandler(PdfDocumentEvent.END_PAGE, evento);
            TablaGruposPDF tablaGruposPDF = new TablaGruposPDF();
            DatosUsuarioPDF datosUsuarioPDF = new DatosUsuarioPDF();
            documento.add(datosUsuarioPDF.creaDatosEncabezado(datosProfesorModelo));
            int contador = 0;
            for (GrupoModelo grupoModelo : grupoModeloLista){
                List<TareasResueltasModelo> auxTareasResuetas = new ArrayList<>();
                for(TareasResueltasModelo tareasResueltasModelo: tareasResueltasModeloLista){
                    if(grupoModelo.getId().equals(tareasResueltasModelo.getIdGrupo())){
                        auxTareasResuetas.add(tareasResueltasModelo);
                    }
                }
                if(auxTareasResuetas.size() != 0 ){
                    this.agregaDatos(documento, documentoPdf, auxTareasResuetas, grupoModelo, tablaGruposPDF, contador);
                }
                contador+=1;
            }
        }catch (Exception e){
            logger.severe("Ocurrio un error: ".concat(e.getMessage()));
            logger.severe("Ocurrio por las siguientes razones:  ".concat(e.getCause().toString()));
            logger.severe("Error:  ".concat(e.toString()));
        }
        return byteArrayOutputStream;
    }

    public ByteArrayOutputStream creaPDF2(List<TareaAlumnoGrupoModelo> tareaAlumnoGrupoModeloList, DatosProfesorModelo datosProfesorModelo, GrupoModelo grupoModelo) throws IOException{
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FontProgram fontProgram = FontProgramFactory.createFont("../fonts/Montserrat-Light.otf");
        PdfFont pdfFont = PdfFontFactory.createFont(fontProgram, PdfEncodings.UTF8,true);
        PdfDocument documentoPdf = new PdfDocument(new PdfWriter(byteArrayOutputStream));
        try(Document documento = new Document(documentoPdf)){
            documento.setFont(pdfFont);
            this.crearFondo(documentoPdf);
            documento.setMargins(documento.getTopMargin()-20,
                    documento.getRightMargin()-10,
                    documento.getBottomMargin()-75,
                    documento.getLeftMargin()-10);
            documento.add(
                    new Paragraph("Activity Report Group "
                            .concat(String.valueOf(grupoModelo.getGrado()))
                            .concat(" \"")
                            .concat(String.valueOf(grupoModelo.getGrupo()))
                            .concat("\"")
                    )
                            .setTextAlignment(TextAlignment.CENTER).setMinWidth(50).setFontSize(20).setMarginBottom(20));
            TablaGrupoAlumnosPDF tablaGrupoAlumnosPDF = new TablaGrupoAlumnosPDF();
            DatosUsuarioPDF datosUsuarioPDF = new DatosUsuarioPDF();
            documento.add(datosUsuarioPDF.creaDatosEncabezado(datosProfesorModelo));
            if(tareaAlumnoGrupoModeloList.size() <=30){
                documento.add(tablaGrupoAlumnosPDF.creaTabla(tareaAlumnoGrupoModeloList));
            }else {
                for (int i = 0; i < tareaAlumnoGrupoModeloList.size(); i+=30) {
                    if(i <= (tareaAlumnoGrupoModeloList.size() - 30)){
                        List<TareaAlumnoGrupoModelo> datosSplit = tareaAlumnoGrupoModeloList.subList(i,i+30);
                        documento.add(tablaGrupoAlumnosPDF.creaTabla(datosSplit));
                        this.crearFondo(documentoPdf);
                        documento.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
                    }else{
                        List<TareaAlumnoGrupoModelo> datosSplit = tareaAlumnoGrupoModeloList.subList(i,tareaAlumnoGrupoModeloList.size());
                        documento.add(tablaGrupoAlumnosPDF.creaTabla(datosSplit));
                        break;
                    }
                }
               /*List<TareaAlumnoGrupoModelo> tareaAlumnoGrupoModeloList1 = tareaAlumnoGrupoModeloList.subList(0,30);
                List<TareaAlumnoGrupoModelo>  tareaAlumnoGrupoModeloList2 = tareaAlumnoGrupoModeloList.subList(30,tam);
                documento.add(tablaGrupoAlumnosPDF.creaTabla(tareaAlumnoGrupoModeloList1));
                this.crearFondo(documentoPdf);
                documento.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
                documento.add(tablaGrupoAlumnosPDF.creaTabla(tareaAlumnoGrupoModeloList2));*/
            }
        }catch (Exception e){
            logger.severe("Ocurrio un error: ".concat(e.getMessage()));
            logger.severe("Ocurrio por las siguientes razones:  ".concat(e.getCause().toString()));
            logger.severe("Error:  ".concat(e.toString()));
        }
        return byteArrayOutputStream;
    }

    public ByteArrayOutputStream creaPDF3(List<TareaAlumnoModelo> tareaAlumnoModeloLista, DatosAlumnoTareaModelo datosAlumnoTareaModelo, String p1, String p2, String p3) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FontProgram fontProgram = FontProgramFactory.createFont("../fonts/Montserrat-Light.otf");
        PdfFont pdfFont = PdfFontFactory.createFont(fontProgram, PdfEncodings.UTF8,true);
        PdfDocument documentoPdf = new PdfDocument(new PdfWriter(byteArrayOutputStream));
        try(Document documento = new Document(documentoPdf)){
            documento.setFont(pdfFont);
            this.crearFondo(documentoPdf);
            documento.setMargins(documento.getTopMargin()-20,
                    documento.getRightMargin()-10,
                    documento.getBottomMargin()-75,
                    documento.getLeftMargin()-10);
            EventoPagina evento = new EventoPagina(documento, documentoPdf);
            documento.add(new Paragraph("Student Activities Report").setTextAlignment(TextAlignment.CENTER).setMinWidth(50).setFontSize(20).setMarginBottom(20));
            documentoPdf.addEventHandler(PdfDocumentEvent.END_PAGE, evento);
            DatosUsuarioPDF datosUsuarioPDF = new DatosUsuarioPDF();
            TablaAlumnoCalificacionesPDF tablaAlumnoCalificacionesPDF = new TablaAlumnoCalificacionesPDF();
            documento.add(datosUsuarioPDF.creaDatosEncabezado(datosAlumnoTareaModelo));
            documento.add(new Paragraph("Assigned HW: ".concat(p1).concat("    TASK count: ").concat(p2).concat("    Grade average: ").concat(Integer.parseInt(p3) == -1 ? "Nothing answered yet!": p3)).setTextAlignment(TextAlignment.CENTER));
            if(tareaAlumnoModeloLista.size() <= 14){
                documento.add(tablaAlumnoCalificacionesPDF.creaTabla(documentoPdf, tareaAlumnoModeloLista));
            }else{
                for (int i = 0; i < tareaAlumnoModeloLista.size(); i+=14) {
                    if(i <= (tareaAlumnoModeloLista.size() - 14)){
                        List<TareaAlumnoModelo> datosSplit = tareaAlumnoModeloLista.subList(i,i+14);
                        documento.add(tablaAlumnoCalificacionesPDF.creaTabla(documentoPdf,datosSplit));
                        this.crearFondo(documentoPdf);
                        documento.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
                    }else{
                        List<TareaAlumnoModelo> datosSplit = tareaAlumnoModeloLista.subList(i,tareaAlumnoModeloLista.size());
                        documento.add(tablaAlumnoCalificacionesPDF.creaTabla(documentoPdf,datosSplit));
                        break;
                    }
                }
            }
        }catch (Exception e){
            logger.severe("Ocurrio un error: ".concat(e.getMessage()));
            logger.severe("Ocurrio por las siguientes razones:  ".concat(e.getCause().toString()));
            logger.severe("Error:  ".concat(e.toString()));
        }
        return byteArrayOutputStream;
    }

    public ByteArrayOutputStream creaPDFDatosSesionGrupo(List<DatosAlumnoModelo> datosAlumnoModeloLista) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FontProgram fontProgram = FontProgramFactory.createFont("../fonts/Montserrat-Light.otf");
        PdfFont pdfFont = PdfFontFactory.createFont(fontProgram, PdfEncodings.UTF8,true);
        PdfDocument documentoPdf = new PdfDocument(new PdfWriter(byteArrayOutputStream));
        try(Document documento = new Document(documentoPdf, PageSize.A4)){
            documento.setFont(pdfFont);
            this.crearFondo(documentoPdf);
            documento.setMargins(documento.getTopMargin()-20,
                    documento.getRightMargin()-10,
                    documento.getBottomMargin()-75,
                    documento.getLeftMargin()-10);
            EventoPagina evento = new EventoPagina(documento, documentoPdf);
            documento.add(new Paragraph("Students Login Info")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setMinWidth(50)
                    .setFontSize(20)
                    .setMarginBottom(20));
            documentoPdf.addEventHandler(PdfDocumentEvent.END_PAGE, evento);
            DatosSesionGrupo datosSesionGrupo = new DatosSesionGrupo();
            if(datosAlumnoModeloLista.size() <= 4){
                documento.add(datosSesionGrupo.creaDatosSesioonGrupo(documentoPdf,datosAlumnoModeloLista));
            }else {
                for (int i = 0; i < datosAlumnoModeloLista.size(); i+=4) {
                    if(i <= (datosAlumnoModeloLista.size() - 4)){
                        List<DatosAlumnoModelo> datosSplit = datosAlumnoModeloLista.subList(i,i+4);
                        documento.add(datosSesionGrupo.creaDatosSesioonGrupo(documentoPdf,datosSplit));
                        this.crearFondo(documentoPdf);
                        documento.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
                    }else{
                        List<DatosAlumnoModelo> datosSplit = datosAlumnoModeloLista.subList(i,datosAlumnoModeloLista.size());
                        documento.add(datosSesionGrupo.creaDatosSesioonGrupo(documentoPdf,datosSplit));
                        break;
                    }
                }
            }
        }catch (Exception e){
            logger.severe("Ocurrio un error: ".concat(e.getMessage()));
            logger.severe("Ocurrio por las siguientes razones:  ".concat(e.getCause().toString()));
            logger.severe("Error:  ".concat(e.toString()));
        }
        return byteArrayOutputStream;
    }

    private void crearFondo(PdfDocument pdfDocument) throws IOException{
        PdfExtGState pdfExtGState = new PdfExtGState().setFillOpacity(0.5f);
        ///ImageData imageData = ImageDataFactory.create("C:\\Users\\Cavaliere\\Documents\\FONDO.png");
        ImageData imageData = ImageDataFactory.create(new URL("https","tecolotl-multimedia.nyc3.digitaloceanspaces.com", "/Tecolotl/REPORTE_PDF/imagenesStorage/FONDO.png"));
        PdfCanvas pdfCanvas= new PdfCanvas(pdfDocument.addNewPage());
        pdfCanvas.saveState();
        pdfCanvas.setExtGState(pdfExtGState);
        pdfCanvas.addImage(imageData, pdfDocument.getDefaultPageSize(),false);
        pdfCanvas.restoreState();
    }

    private void agregaDatos(Document documento, PdfDocument pdf, List<TareasResueltasModelo> tareasResueltasModeloLista, GrupoModelo grupoModelo, TablaGruposPDF tablaGruposPDF, int contador) throws IOException{
        if(tareasResueltasModeloLista.size() <= 30){
            if(contador != 0){
                this.crearFondo(pdf);
                documento.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
                documento.add(tablaGruposPDF.creaTabla(tareasResueltasModeloLista, grupoModelo));
            }else{
                documento.add(tablaGruposPDF.creaTabla(tareasResueltasModeloLista, grupoModelo));
            }
        }else {
            for (int i = 0; i < tareasResueltasModeloLista.size(); i+=30) {
                if(i <= (tareasResueltasModeloLista.size() - 30)){
                    List<TareasResueltasModelo> datosSplit = tareasResueltasModeloLista.subList(i,i+30);
                    documento.add(tablaGruposPDF.creaTabla(datosSplit, grupoModelo));
                    this.crearFondo(pdf);
                    documento.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
                }else{
                    List<TareasResueltasModelo> datosSplit = tareasResueltasModeloLista.subList(i,tareasResueltasModeloLista.size());
                    documento.add(tablaGruposPDF.creaTabla(datosSplit, grupoModelo));
                    break;
                }
            }
        }
    }
}
