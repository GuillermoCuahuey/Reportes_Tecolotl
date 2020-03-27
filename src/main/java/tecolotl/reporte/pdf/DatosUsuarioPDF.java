package tecolotl.reporte.pdf;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import tecolotl.reporte.modelo.DatosAlumnoTareaModelo;
import tecolotl.reporte.modelo.DatosProfesorModelo;

import javax.management.loading.MLet;
import java.net.MalformedURLException;
import java.net.URL;

public class DatosUsuarioPDF {

    private final DeviceCmyk color1 = new DeviceCmyk(75,100,0,0);
    private final DeviceCmyk color2 = new DeviceCmyk(22.27f, 17.97f, 24.61f, 0f);
    private final DeviceCmyk color3 = new DeviceCmyk(8,7,7,0);

    /**
     * Crea el encabezado de los datos del profesor
     * @param datosProfesorModelo datos del profesor.
     * @return Tabla con los datos del profesor
     * @throws Exception
     */
    public Table creaDatosEncabezado(DatosProfesorModelo datosProfesorModelo) throws Exception{
        return this.creaTabla(datosProfesorModelo.getNombreCompleto(), datosProfesorModelo.getApodo(), datosProfesorModelo.getCorreo());
    }

    public Table creaDatosEncabezado(DatosAlumnoTareaModelo datosAlumnoTareaModelo) throws Exception {
        return this.creaTabla(datosAlumnoTareaModelo.getNombreCompleto(), datosAlumnoTareaModelo.getApodo(), datosAlumnoTareaModelo.getCorreo());
    }
    private Table creaTabla(String nombreCompleto, String apodo, String correo) throws MalformedURLException{
        Table tabla = new Table(new float[]{1,1});
        tabla.addCell(
                new Cell(3,1)
                        .add(
                                new Paragraph("").add(
                                        new Image(ImageDataFactory.create(new URL("https","tecolotl-multimedia.nyc3.digitaloceanspaces.com","/Tecolotl/REPORTE_PDF/imagenesStorage/profesor.png")))
                                                .setWidth(80)
                                                .setHeight(80)
                                )
                                        .setTextAlignment(TextAlignment.RIGHT)
                        ).setBorder(Border.NO_BORDER));
        tabla.addCell(
                new Cell(1,1).add(
                        new Table(2)
                                .addCell(
                                        new Cell(1,1)
                                                .add(
                                                        new Paragraph("Nombre: ").setFontColor(color1)
                                                ).setBorder(Border.NO_BORDER)
                                )
                                .addCell(
                                        new Cell(1,1)
                                                .add(new Paragraph(nombreCompleto).setFontColor(color2))
                                                .setBorder(Border.NO_BORDER)
                                ).setBorder(Border.NO_BORDER)
                ).setBorder(Border.NO_BORDER)
        );
        tabla.addCell(
                new Cell(1,1)
                        .add(
                                new Table(2)
                                        .addCell(
                                                new Cell(1,1)
                                                        .add(new Paragraph("Apodo: ").setFontColor(color1))
                                                        .setBorder(Border.NO_BORDER)
                                        ).setBorder(Border.NO_BORDER)
                                        .addCell(
                                                new Cell(1,1)
                                                        .add(new Paragraph(apodo).setFontColor(color2))
                                                        .setBorder(Border.NO_BORDER)
                                        ).setBorder(Border.NO_BORDER)
                        ).setBorder(Border.NO_BORDER)
        );
        tabla.addCell(
                new Cell(1,1)
                        .add(
                                new Table(2)
                                        .addCell(
                                                new Cell(1,1)
                                                        .add(new Paragraph("Correo: ").setFontColor(color1))
                                                        .setBorder(Border.NO_BORDER))
                                        .setBorder(Border.NO_BORDER)
                                        .addCell(
                                                new Cell(1,1)
                                                        .add(new Paragraph(correo).setFontColor(color2))
                                                        .setBorder(Border.NO_BORDER))
                                        .setBorder(Border.NO_BORDER))
                        .setBorder(Border.NO_BORDER)
        );
        tabla.useAllAvailableWidth();
        tabla.setBackgroundColor(color3,0.4f);
        tabla.setBorder(Border.NO_BORDER);
        return tabla;
    }
}
