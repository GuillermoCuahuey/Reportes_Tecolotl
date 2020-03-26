package tecolotl.reporte.pdf;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.svg.converter.SvgConverter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import tecolotl.reporte.modelo.TareaAlumnoModelo;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Logger;

public class TablaAlumnoCalificacionesPDF {
    private Logger logger = Logger.getLogger(getClass().getName());
    private final DeviceCmyk color1 = new DeviceCmyk(75,100,0,0);
    private final DeviceCmyk color2 = new DeviceCmyk(22.27f, 17.97f, 24.61f, 0);
    private final DeviceCmyk color3 = new DeviceCmyk(8,7,7,0);
    private final DeviceRgb color4 = new DeviceRgb(255,255,255);

    /**
     * Metodo que crea una tabla
     * @param pdf un objeto del tipo {@link PdfDocument}
     * @return una tabla con sus valores correspondientes.
     * @throws IOException Error de lectura de archivo.
     */
    public Table creaTabla(PdfDocument pdf, List<TareaAlumnoModelo> tareaAlumnoModeloLista) throws IOException, URISyntaxException {
        Table tabla = new Table(9);
        Cell celda = this.crearCampo(1, 9);
        celda.add(new Paragraph("Filters").setFontColor(ColorConstants.WHITE));
        tabla.addCell(celda);
        tabla.addCell(this.crearCampo("Homework", 1,1, color2));
        tabla.addCell(this.crearCampo("Assigment", 1,1, color2));
        tabla.addCell(this.crearCampo("Transcript", 1,1, color2));
        tabla.addCell(this.crearCampo("Word Game", 1,1, color2));
        tabla.addCell(this.crearCampo("Think-Develop\nand Share", 1,1, color2));
        tabla.addCell(this.crearCampo("Mix & Match", 1,1, color2));
        tabla.addCell(this.crearCampo("Gap Filling", 1,1, color2));
        tabla.addCell(this.crearCampo("What Happened", 1,1, color2));
        tabla.addCell(this.crearCampo("Comprehension\nMatch", 1,1, color2));
        for (TareaAlumnoModelo tareaAlumnoModelo : tareaAlumnoModeloLista){
            tabla.addCell(this.tareaImagen(tareaAlumnoModelo.getIdActividad()));
            tabla.addCell(
                    this.crearCampo(new SimpleDateFormat("YYYY-MM-DD").format(tareaAlumnoModelo.getFechaAsignacion()), 1, 1, color3));
            tabla.addCell(
                    this.crearCampo(String.valueOf(tareaAlumnoModelo.getCalificacionTrascirpcion()).concat("%\n"), 1, 1, color4, tareaAlumnoModelo.getCalificacionTrascirpcion(),pdf));
            tabla.addCell(
                    this.crearCampo(String.valueOf(tareaAlumnoModelo.getCalificacionGramatica()).concat("%\n"), 1, 1, color4,tareaAlumnoModelo.getCalificacionGramatica(),pdf));
            tabla.addCell(
                    this.crearCampo(String.valueOf(tareaAlumnoModelo.getCalificacionMapamental()).concat("%\n"), 1, 1, color4,tareaAlumnoModelo.getCalificacionMapamental(),pdf));
            tabla.addCell(
                    this.crearCampo(String.valueOf(tareaAlumnoModelo.getCalificacionRelacionarImagen()).concat("%\n"), 1, 1, color4,tareaAlumnoModelo.getCalificacionRelacionarImagen(),pdf));
            tabla.addCell(
                    this.crearCampo(String.valueOf(tareaAlumnoModelo.getCalificacionCompletar()).concat("%\n"), 1, 1, color4,tareaAlumnoModelo.getCalificacionCompletar(),pdf));
            tabla.addCell(
                    this.crearCampo(String.valueOf(tareaAlumnoModelo.getCalificacionOraciones()).concat("%\n"), 1, 1, color4,tareaAlumnoModelo.getCalificacionOraciones(),pdf));
            tabla.addCell(
                    this.crearCampo(String.valueOf(tareaAlumnoModelo.getCalificacionRelacionarOraciones()).concat("%\n"), 1, 1, color4,tareaAlumnoModelo.getCalificacionRelacionarOraciones(),pdf));
        }
        tabla.useAllAvailableWidth();
        tabla.setMarginTop(10);
        return tabla;
    }

    /**
     * Metodo que crea las celdas para los nombres de las columnas y los valores de las tablas.
     * @param valorCampo El nombre de la columnax
     * @param rowSpan Numero de filas a unir o fusionar
     * @param colSpan Numero de columnas a unir o fusionar
     * @return una Celda con el campo correspondiente.
     */
    private Cell crearCampo(String valorCampo, int rowSpan, int colSpan, DeviceRgb color, Short progressBarSize, PdfDocument pdf) throws IOException, URISyntaxException {
        Cell celda = new Cell(rowSpan,colSpan)
                .setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(color,0f)
                .add(this.opciones(valorCampo, progressBarSize, pdf))
                .setFontSize(7);
        celda.setBorderBottom(new SolidBorder(color1,1));
        celda.setBorderLeft(Border.NO_BORDER);
        celda.setBorderRight(Border.NO_BORDER);
        celda.setBorderTop(Border.NO_BORDER);
        return celda;
    }

    private Paragraph opciones(String valor, Short puntaje, PdfDocument pdf) throws IOException{
        Paragraph nuevoValor;
        try{
            if(puntaje == (short)-1){
                nuevoValor = new Paragraph("0%\n").setFontColor(ColorConstants.BLACK).add(this.creaImagen((short)0, pdf));
            }else{
                nuevoValor = new Paragraph(valor).setFontColor(ColorConstants.BLACK).add(this.creaImagen(puntaje, pdf));
            }
        }catch (NullPointerException e){
            nuevoValor = new Paragraph("").setTextAlignment(TextAlignment.CENTER).add(this.creaImagen(new URL("https","tecolotl-multimedia.nyc3.digitaloceanspaces.com","/Tecolotl/REPORTE_PDF/imagenesStorage/forbidden.svg"), pdf));
        }
        return nuevoValor;
    }

    private Cell crearCampo(String valorCampo, int rowSpan, int colSpan, DeviceCmyk color) {
        Cell celda = new Cell(rowSpan,colSpan)
                .setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(color, 0.1f)
                .add(new Paragraph(valorCampo).setFontColor(ColorConstants.BLACK))
                .setFontSize(7);
        celda.setBorderBottom(new SolidBorder(color1,1));
        celda.setBorderLeft(Border.NO_BORDER);
        celda.setBorderRight(Border.NO_BORDER);
        celda.setBorderTop(Border.NO_BORDER);
        return celda;
    }

    private Cell tareaImagen(String idVideo) throws MalformedURLException {
        Cell celda = new Cell()
                .setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(ColorConstants.WHITE)
                .add(
                        new Paragraph("").add( new Image(
                                ImageDataFactory.create(
                                        new URL("https","i.ytimg.com", "/vi/".concat(idVideo).concat("/mqdefault.jpg"))
                                )).setWidth(50).setHeight(30).setBorder(Border.NO_BORDER)
                        )
                );
        celda.setBorderBottom(new SolidBorder(ColorConstants.BLACK,1));
        celda.setBorderLeft(Border.NO_BORDER);
        celda.setBorderRight(Border.NO_BORDER);
        celda.setBorderTop(Border.NO_BORDER);
        return celda;
    }

    /**
     * Metodo que crea el titulo de la tabla
     * @param rowSpan numero de filas a unir o fusionar
     * @param colSpan numero de columnas a unir o fusionar
     * @return una Celda con el valor correspondientes.
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

    /**
     * Metodo que convierte un archivo xml en una imagen para la tabla
     * @param progressBarSize el valor en flotante
     * @param pdf un objeto del tipo {@link PdfDocument}
     * @return una imagen.
     * @throws IOException
     */
    private Image creaImagen(Short progressBarSize, PdfDocument pdf) throws IOException{
        try{
            this.progressBar(progressBarSize);
        }catch (Exception e){
            System.out.println("Ocurrio un error del tipo: "+e.getMessage());
            System.out.println("La causa del error: "+e.getCause());
            System.out.println("Error: "+e.toString());
        }
        File svg;
        svg = new File("../progressBar.xml");
        Image imgSVG = SvgConverter.convertToImage(svg.toURI().toURL().openStream(), pdf);
        return imgSVG;
    }

    /**
     * Metodo que lee una imagen SVG y la convierte en Imagen para el documento
     * @param urlArchivo direccion del archivo
     * @param pdf un objeto del tipo {@link PdfDocument}
     * @return una imagen.
     * @throws IOException
     */
    private Image creaImagen(URL urlArchivo, PdfDocument pdf) throws IOException{
        URLConnection connection = urlArchivo.openConnection();
        InputStream inputStream = connection.getInputStream();
        Image imgSVG = SvgConverter.convertToImage(inputStream, pdf);
        return imgSVG;
    }


    /**
     * Metodo que lee una imagen SVG y la convierte en un archivo XML
     * @param progressBarSize valor en flotante
     * @throws ParserConfigurationException Error de parseo SVG-XML
     * @throws IOException Error al abrir los archivos.
     * @throws SAXException Error crear el Documento.
     * @throws TransformerException Error al guardar los datos.
     */
    private void progressBar(Short progressBarSize) throws ParserConfigurationException, IOException, SAXException, TransformerException, URISyntaxException {
        float valor = ((50 * progressBarSize) / 100f);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new URL("https","tecolotl-multimedia.nyc3.digitaloceanspaces.com","/Tecolotl/REPORTE_PDF/imagenesStorage/recta.svg").openConnection().getInputStream());
        NodeList elementos = document.getElementsByTagName("rect");
        for (int i = 0; i < elementos.getLength(); i++) {
            Element el = (Element) elementos.item(i);
            if (el.getAttribute("id").equalsIgnoreCase("bar")){
                el.setAttribute("width", String.valueOf(valor));
            }
        }
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        File file = new File("../progressBar.xml");
        //Result result = new StreamResult(new File("C:\\Users\\Cavaliere\\Documents\\images\\progressBar.xml"));
        Result result = new StreamResult(file);
        Source input = new DOMSource(document);
        transformer.transform(input,result);
    }
}
