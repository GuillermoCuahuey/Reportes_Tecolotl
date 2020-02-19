package tecolotl.reporte.pdf;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

public class EventoPagina implements IEventHandler {

    Document documento;
    PdfDocument doc;

    public EventoPagina(Document documento, PdfDocument doc) {
        this.documento = documento;
        this.doc = doc;
    }

    private Rectangle crearRectanguloPie(PdfDocumentEvent docEvent) {
        PdfDocument pdfDoc = docEvent.getDocument();
        PdfPage page = docEvent.getPage();

        float xPie = pdfDoc.getDefaultPageSize().getX() + documento.getLeftMargin();
        float yPie = pdfDoc.getDefaultPageSize().getBottom() + 10;//Posicion y del pie de pagina
        float anchoPie = page.getPageSize().getWidth() - 72;
        float altoPie = 50F;

        Rectangle rectanguloPie = new Rectangle(xPie, yPie, anchoPie, altoPie);

        return rectanguloPie;
    }

    private Table crearTablaPie(PdfDocumentEvent docEvent) {
        PdfPage page = docEvent.getPage();
        Table tablaPie = new Table(3);

        int pageNum = docEvent.getDocument().getPageNumber(page);
         Cell celdaLogo = new Cell();
         try {
             //celdaLogo.add( new Paragraph("").add(new Image(ImageDataFactory.create("images/img/logo2-esq.png")).setWidth(30).setHeight(30)
             celdaLogo.add( new Paragraph("").setWidth(30).setHeight(30)
             );
             celdaLogo.setBorder(Border.NO_BORDER);
             tablaPie.addCell(celdaLogo);
             Cell celdaWeb = new Cell();
             celdaWeb = creaCelda(celdaWeb, "\nwww.e-squadron.com.mx", TextAlignment.CENTER, Border.NO_BORDER);
             tablaPie.addCell(celdaWeb);
             Cell celdaPag = new Cell();
             celdaPag = creaCelda(celdaPag, "\n" + pageNum, TextAlignment.RIGHT, Border.NO_BORDER);
             celdaPag.setWidth(40F);
             tablaPie.addCell(celdaPag);
             tablaPie.useAllAvailableWidth();
         }catch (Exception ex){
             System.out.println("Ocurrio un error: ".concat(ex.getMessage()));
         }
        return tablaPie;
    }


    @Override
    public void handleEvent(Event event) {
        PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
        PdfDocument pdfDoc = docEvent.getDocument();
        PdfPage page = docEvent.getPage();
        PdfCanvas canvas = new PdfCanvas(page.newContentStreamBefore(), page.getResources(), pdfDoc);

        Table tablaNumeracion = this.crearTablaPie(docEvent);
        Rectangle rectanguloPie = this.crearRectanguloPie(docEvent);
        Canvas canvasPie = new Canvas(canvas, pdfDoc, rectanguloPie);
        canvasPie.add(tablaNumeracion);
    }

    public Cell creaCelda(Cell celda, String texto, TextAlignment alineacion, Border borde) {
        celda.add(new Paragraph(texto));
        celda.setBorder(borde);
        celda.setFontColor(ColorConstants.BLACK, .5f);
        celda.setTextAlignment(alineacion);
        return celda;
    }

    public Cell creaCelda(Cell celda, Image imagen, Border borde){
        imagen.scaleAbsolute(40f,40f);
        celda.setBorder(borde);
        celda.add(imagen);
        return celda;
    }

}

