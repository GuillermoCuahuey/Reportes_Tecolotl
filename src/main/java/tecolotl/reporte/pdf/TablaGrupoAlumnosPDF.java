package tecolotl.reporte.pdf;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import tecolotl.reporte.modelo.TareaAlumnoGrupoModelo;

import java.io.IOException;
import java.util.List;

public class TablaGrupoAlumnosPDF {
    private final DeviceCmyk color1 = new DeviceCmyk(75,100,0,0);
    private final DeviceCmyk color2 = new DeviceCmyk(22.27f, 17.97f, 24.61f, 0f);
    private final DeviceCmyk color3 = new DeviceCmyk(8,7,7,0);
    private final DeviceRgb color4 = new DeviceRgb(255,255,255);
    /**
     * Metodo que crea una tabla
     * @return una Tabla con los valores correspondientes.
     * @throws Exception
     */
    public Table creaTabla(List<TareaAlumnoGrupoModelo> tareaAlumnoGrupoModeloList){
        float[] colWidths = {2, 1, 1, 1, 1, 1, 1, 1};
        Table tabla = new Table(colWidths);
        Cell celda = this.crearCampo(1, 9);
        celda.add(new Paragraph("Students").setFontColor(color4));
        tabla.addCell(celda);
        tabla.addCell(this.crearCampo("Full Name", 1, 2,color2));
        tabla.addCell(this.crearCampo("Think-Develop and Share", 1, 1,color2));
        tabla.addCell(this.crearCampo("Word Game", 1, 1,color2));
        tabla.addCell(this.crearCampo("Mix & Match", 1, 1,color2));
        tabla.addCell(this.crearCampo("What Happened?", 1, 1,color2));
        tabla.addCell(this.crearCampo("Comprehesion Match", 1, 1,color2));
        tabla.addCell(this.crearCampo("Gap Filling", 1, 1,color2));
        for (TareaAlumnoGrupoModelo tareaAlumnoGrupoModelo : tareaAlumnoGrupoModeloList){
            tabla.addCell(this.crearCampo(
                    tareaAlumnoGrupoModelo.getNombre().concat(" ")
                            .concat(tareaAlumnoGrupoModelo.getApellidoPaterno().concat(" ")
                                    .concat(tareaAlumnoGrupoModelo.getApellidoMaterno())),1,2, color3));
            tabla.addCell(this.crearCampo(String.valueOf(tareaAlumnoGrupoModelo.getTotalRespuestaMapaMental()),1,1, color3));
            tabla.addCell(this.crearCampo(String.valueOf(tareaAlumnoGrupoModelo.getTotalRespuestaGramatica()),1,1, color3));
            tabla.addCell(this.crearCampo(String.valueOf(tareaAlumnoGrupoModelo.getTotalRespuestaRelacionar()),1,1, color3));
            tabla.addCell(this.crearCampo(String.valueOf(tareaAlumnoGrupoModelo.getTotalRespuestaOraciones()),1,1, color3));
            tabla.addCell(this.crearCampo(String.valueOf(tareaAlumnoGrupoModelo.getTotalRespuestaRelacionarOracion()),1,1, color3));
            tabla.addCell(this.crearCampo(String.valueOf(tareaAlumnoGrupoModelo.getTotalRespuestaCompletar()),1,1, color3));
        }
        tabla.setBorder(Border.NO_BORDER);
        tabla.setMarginTop(20);
        tabla.useAllAvailableWidth();
        return tabla;
    }

    /**
     * Metodo que crea las celdas para los nombres de las columnas.
     * @param valorCampo El nombre de la columna
     * @param rowSpan Numero de filas a unir o fusionar
     * @param colSpan Numero de columnas a unir o fusionar
     * @return una Celda con el campo correspondiente.
     */
    private Cell crearCampo(String valorCampo, int rowSpan, int colSpan, DeviceCmyk color){
        Cell celda = new Cell(rowSpan,colSpan)
                .setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(color,0.1f)
                .add(new Paragraph(valorCampo.equalsIgnoreCase("null") ? "0" : valorCampo).setFontColor(ColorConstants.BLACK))
                .setFontSize(6);
        celda.setBorderBottom(new SolidBorder(color1,1));
        celda.setBorderLeft(Border.NO_BORDER);
        celda.setBorderRight(Border.NO_BORDER);
        celda.setBorderTop(Border.NO_BORDER);
        return celda;
    }

    /**
     * Metodo que crea una celda para el titulo de la tabla
     * @param rowSpan numero de filas a unir o fusionar
     * @param colSpan numero de filas a unir o fusionar
     * @return una nueva Celda con el valor correspondiente.
     */
    private Cell crearCampo(int rowSpan, int colSpan){
        Cell celda = new Cell(rowSpan,colSpan)
                .setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(color1);
        celda.setBorderBottom(new SolidBorder(ColorConstants.WHITE,5));
        celda.setBorderLeft(Border.NO_BORDER);
        celda.setBorderRight(Border.NO_BORDER);
        celda.setBorderTop(Border.NO_BORDER);
        return celda;
    }
}