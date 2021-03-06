package tecolotl.reporte.pdf;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.DashedBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.svg.converter.SvgConverter;
import tecolotl.reporte.modelo.DatosAlumnoModelo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.logging.Logger;

public class DatosSesionGrupo {

    private final DeviceCmyk color1 = new DeviceCmyk(75,100,0,0);
    private final DeviceCmyk color2 = new DeviceCmyk(22.27f, 17.97f, 24.61f, 0f);
    private final DeviceCmyk color3 = new DeviceCmyk(8,7,7,0);
    private final DeviceRgb color4 = new DeviceRgb(255,255,255);

    public Table creaDatosSesioonGrupo(PdfDocument pdfDocument, List<DatosAlumnoModelo> datosAlumnoModeloLista) throws IOException, URISyntaxException {
        Table tabla = new Table(new float[] {1,1});
        for (DatosAlumnoModelo datosAlumnoModelo : datosAlumnoModeloLista){
            tabla.addCell(
                    this.celdaBorder().add(
                                    this.datosAlumno(
                                            datosAlumnoModelo.getNombreAlumno(),
                                            datosAlumnoModelo.getApodoProfesor(),
                                            datosAlumnoModelo.getApodo(),
                                            datosAlumnoModelo.getContrasenia(),
                                            datosAlumnoModelo.getGalaxia(),
                                            pdfDocument
                                    )
                    )
            );
        }
        tabla.setBorder(Border.NO_BORDER);
        tabla.setFontSize(10);
        tabla.useAllAvailableWidth().setMarginTop(20);
        return tabla;
    }

    private Table datosAlumno(String nombreCompleto, String apodoT, String apodoA, byte[] contrasenia, Short galaxia, PdfDocument pdf) throws IOException, URISyntaxException{
        String splitContrasenia = new String(contrasenia);
        String []contrasenias = splitContrasenia.split(",");
        Table tabla = new Table(1);
        //Imagen Squadron
        tabla.addCell(new Cell(1,1).setBorder(Border.NO_BORDER)
                .add(
                        new Paragraph("")
                                .setTextAlignment(TextAlignment.CENTER)
                                .add(
                                        new Image(ImageDataFactory.create(new URL("https", "tecolotl-multimedia.nyc3.digitaloceanspaces.com", "/Tecolotl/REPORTE_PDF/imagenesStorage/esqFill.png")))
                                                .setHeight(40).setWidth(150)
                                )
                )
        );
        //Nombre del Alumno
        tabla.addCell(new Cell(1,1)
                .setBorder(Border.NO_BORDER)
                .setBackgroundColor(color3)
                .add(new Paragraph(nombreCompleto).setTextAlignment(TextAlignment.CENTER).setFontColor(color1)));
        //Datos profesor
        tabla.addCell(new Cell(1,1).setBorder(Border.NO_BORDER).add(this.creaTabla1(apodoT)));
        tabla.addCell(new Cell(1,1).setBorder(Border.NO_BORDER)
                .add(new Paragraph("")
                        .setTextAlignment(TextAlignment.CENTER)
                        .add(new Image(ImageDataFactory.create(new URL("https", "tecolotl-multimedia.nyc3.digitaloceanspaces.com", "/Tecolotl/REPORTE_PDF/imagenesStorage/LINEA-HORIZONTAL.png"))).setWidth(200).setHeight(20))
                )
        );
        //Datos Alumno user, pass, galaxia
        tabla.addCell(new Cell(1,1).setBorder(Border.NO_BORDER).add(this.creaTabla2(apodoA,contrasenias, pdf)));
        tabla.addCell(new Cell(1,1).setBorder(Border.NO_BORDER)
                .add(
                        new Paragraph("Galaxy: \n".concat(String.valueOf(galaxia)))
                        .setTextAlignment(TextAlignment.CENTER)
                        .setFontColor(color1)
                )
        );
        tabla.addCell(new Cell(1,1)
                .setBorder(Border.NO_BORDER)
                .add(
                new Paragraph("www.e-squadron.com.mx").setTextAlignment(TextAlignment.CENTER).setFontColor(color1).setItalic()
                )
        );
        tabla.setBorder(Border.NO_BORDER);
        tabla.useAllAvailableWidth();
        return tabla;
    }

    private Table creaTabla1(String dato) throws IOException{
        Table tabla = new Table(2);
        tabla.addCell(
                new Cell(2,1).setBorder(Border.NO_BORDER)
                        .add(
                                new Paragraph("")
                                        .add(
                                                new Image(ImageDataFactory.create(new URL("https", "tecolotl-multimedia.nyc3.digitaloceanspaces.com", "/Tecolotl/REPORTE_PDF/imagenesStorage/profesor.png"))).setWidth(40).setHeight(40)
                                        ).setTextAlignment(TextAlignment.RIGHT)
                        )
        );
        tabla.addCell(this.creaTitulo(1,1,"Teacher Username"));
        tabla.addCell(this.creaValor(dato));
        tabla.setBorder(Border.NO_BORDER);
        tabla.useAllAvailableWidth();
        return tabla;
    }

    private Table creaTabla2(String dato, String[] contraseniasArr, PdfDocument pdf) throws IOException{
        Table tabla = new Table(2);
        tabla.addCell(
                new Cell(4,1).setBorder(Border.NO_BORDER)
                        .add(
                                new Paragraph("")
                                        .add(
                                                new Image(ImageDataFactory.create(new URL("https", "tecolotl-multimedia.nyc3.digitaloceanspaces.com", "/Tecolotl/REPORTE_PDF/imagenesStorage/estudiante.png"))).setWidth(40).setHeight(40)
                                        ).setTextAlignment(TextAlignment.RIGHT)
                        )
        );
        tabla.addCell(this.creaTitulo(1,1,"Student Username"));
        tabla.addCell(this.creaValor(dato));
        tabla.addCell(this.creaTitulo(1,1,"Password: "));
        Paragraph planetas = new Paragraph("").setTextAlignment(TextAlignment.CENTER);
        for(int i = 0; i < contraseniasArr.length ; i++){
            planetas.add(this.passImg(contraseniasArr[i],pdf));
        }
        tabla.addCell(new Cell(1,1).setBorder(Border.NO_BORDER)
                .add(planetas)
        );
        tabla.setBorder(Border.NO_BORDER);
        tabla.useAllAvailableWidth();
        return tabla;
    }

    private Cell celdaBorder(){
        Cell celda = new Cell();
        celda.setBorder(new DashedBorder(color1,1));
        return celda;
    }

    private Cell creaValor(String dato){
        Cell celda = new Cell();
        celda.add(new Paragraph(dato).setFontColor(color2).setTextAlignment(TextAlignment.CENTER));
        celda.setBorder(Border.NO_BORDER);
        return celda;
    }

    private Cell creaTitulo(int rowS, int colS, String titulo){
        Cell celda = new Cell(rowS,colS);
        celda.setBackgroundColor(color3);
        celda.add(new Paragraph(titulo).setFontColor(color1).setTextAlignment(TextAlignment.CENTER));
        celda.setBorder(Border.NO_BORDER);
        return celda;
    }

    private Image passImg(String pass, PdfDocument pdf) throws IOException{
        URL urlSvg = new URL("https", "tecolotl-multimedia.nyc3.digitaloceanspaces.com", "/Tecolotl/REPORTE_PDF/imagenesStorage/".concat(String.valueOf((Integer.parseInt(pass)+1))).concat(".svg"));
        URLConnection connection = urlSvg.openConnection();
        InputStream inputStream = connection.getInputStream();
        Image imagen = SvgConverter.convertToImage(inputStream, pdf);
        imagen.setWidth(30);
        imagen.setHeight(30);
        return imagen;
    }
}
