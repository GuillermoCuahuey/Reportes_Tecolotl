package tecolotl.reporte.pdf;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import tecolotl.reporte.modelo.GrupoModelo;
import tecolotl.reporte.modelo.TareasResueltasModelo;

import java.util.List;
import java.util.logging.Logger;

public class TablaGruposPDF {

    private final DeviceCmyk color1 = new DeviceCmyk(75,100,0,0);
    private final DeviceCmyk color2 = new DeviceCmyk(22.27f, 17.97f, 24.61f, 0f);
    private final DeviceCmyk color3 = new DeviceCmyk(8,7,7,0);
    private final DeviceRgb color4 = new DeviceRgb(255,255,255);

    public Table creaTabla(List<TareasResueltasModelo> tareasResueltasModeloLista, GrupoModelo grupoModelo){
        Table tabla = new Table(5);
        tabla .addCell(this.crearCampo(1,5)
                .add(
                        new Paragraph("Group  "
                                .concat(this.tipoGrado(grupoModelo.getGrado()))
                                .concat(" ")
                                .concat(String.valueOf(grupoModelo.getGrupo())))
                                .setFontColor(color4)
                )
        );
        tabla.addCell(this.crearCampo("Full name", 1, 1, color2));
        tabla.addCell(this.crearCampo("Level", 1, 1, color2));
        tabla.addCell(this.crearCampo("Activities Level",1,1,color2));
        tabla.addCell(this.crearCampo("Total Activities Level", 1, 1, color2));
        tabla.addCell(this.crearCampo("Total Activities Levels", 1, 1, color2));
        for (TareasResueltasModelo tareasResueltasModelo: tareasResueltasModeloLista){
            tabla.addCell(this.crearCampo(tareasResueltasModelo.getNombre().concat(" ").concat(tareasResueltasModelo.getApellidoPaterno()).concat(" ").concat(tareasResueltasModelo.getApellidoMaterno()), 1, 1, color3));
            tabla.addCell(this.crearCampo(this.opciones(tareasResueltasModelo.getNivelLenguajeAlumno()), 1, 1, color3));
            tabla.addCell(this.crearCampo(tareasResueltasModelo.getNivelLenguaje(),1 ,1 ,color3));
            tabla.addCell(this.crearCampo(String.valueOf(this.opciones(tareasResueltasModelo.getNivelLenguajeAlumno(),tareasResueltasModelo.getTotalTareas())).concat("%"), 1, 1, color3));
            tabla.addCell(this.crearCampo(String.valueOf((tareasResueltasModelo.getTotalTareas() * 100)/ 108).concat("%"), 1, 1, color3));
        }
        tabla.setBorder(Border.NO_BORDER);
        tabla.setMarginTop(10);
        tabla.useAllAvailableWidth();
        return tabla;
    }

    /**
     * Metodo que crea las celdas para los nombres de las columnas.
     * @param valorCampo El nombre de la columna
     * @param rowSpan Numero de filas a unir o fusionar
     * @param colSpan Numero de columnas a unir o fusionar
     * @return una Celda con el valor correspondiente.
     */
    private Cell crearCampo(String valorCampo, int rowSpan, int colSpan, DeviceCmyk color){
        Cell celda = new Cell(rowSpan,colSpan)
                .setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(color,0.5f)
                .add(new Paragraph(valorCampo).setFontColor(ColorConstants.BLACK))
                .setFontSize(7);
        celda.setBorderBottom(new SolidBorder(color1,1));
        celda.setBorderLeft(Border.NO_BORDER);
        celda.setBorderRight(Border.NO_BORDER);
        celda.setBorderTop(Border.NO_BORDER);
        return celda;
    }

    /**
     * Metodo para crear el titulo de la tabla
     * @param rowSpan numero de filas a unir o fusionar
     * @param colSpan numero de columnas a unir o fusionar
     * @return una Celda con las modificaciones correspondientes.
     */
    private Cell crearCampo(int rowSpan, int colSpan){
        Cell celda = new Cell(rowSpan,colSpan)
                .setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(color1);
        celda.setBorderBottom(new SolidBorder(color4,5));
        celda.setBorderLeft(Border.NO_BORDER);
        celda.setBorderRight(Border.NO_BORDER);
        celda.setBorderTop(Border.NO_BORDER);
        return celda;
    }

    private String opciones(Short opcion){
        String lvl = "";
        switch (String.valueOf(opcion)){
            case "1": {
                lvl = "A1";
                break;
            }
            case "2":{
                lvl = "A2";
                break;
            }
            case "3": {
                lvl = "B1";
                break;
            }
            case "4": {
                lvl = "B2";
                break;
            }
            case "5": {
                lvl = "C1";
                break;
            }
            case "6":{
                lvl = "C2";
                break;
            }
        }
        return lvl;
    }

    private int opciones(Short opcion, Integer valor){
        int tam = 0;
        switch (String.valueOf(opcion)){
            case "1": {
                tam = Math.round((valor * 100) / 18);
                break;
            }
            case "2": {
                tam = Math.round((valor * 100) / 36);
                break;
            }
            case "3": {
                tam = Math.round((valor * 100) / 54);
                break;
            }
            case "4": {
                tam = Math.round((valor * 100) / 72);
                break;
            }
            case "5": {
                tam = Math.round((valor * 100) / 90);
                break;
            }
            case "6": {
                tam = Math.round((valor * 100) / 108);
                break;
            }
        }
        return tam;
    }

    private String tipoGrado(Short grado){
        String grados = "";
        switch (String.valueOf(grado)){
            case "1":{
                grados = "1st";
                break;
            }
            case "2":{
                grados = "2nd";
                break;
            }
            case "3":{
                grados = "3rd";
                break;
            }
            default:{
                grados = String.valueOf(grado).concat("th");
                break;
            }
        }
        return grados;
    }
}
