package tecolotl.reporte.pdf;

import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

public class EventoPagina implements IEventHandler {

    private Logger logger = Logger.getLogger(getClass().getName());
    Document documento;
    PdfDocument doc;
    private final DeviceCmyk color1 = new DeviceCmyk(75,100,0,0);

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
        float altoPie = 70F;
        Rectangle rectanguloPie = new Rectangle(xPie, yPie, anchoPie, altoPie);
        return rectanguloPie;
    }

    private Table crearTablaPie(PdfDocumentEvent docEvent, PdfFont pdfFont) {
        PdfPage page = docEvent.getPage();
        Table tablaPie = new Table(3);

        int pageNum = docEvent.getDocument().getPageNumber(page);
        tablaPie.addCell(
                new Cell(1,1)
                        .setBorder(Border.NO_BORDER)
                        .setWidth(10f)
        );
        try {
            tablaPie.addCell(
                    new Cell(1,1)
                            .setBorder(Border.NO_BORDER)
                            .add(
                                    new Paragraph("")
                                            .setTextAlignment(TextAlignment.CENTER)
                                            .setFontColor(color1)
                                            .setFont(pdfFont)
                                            .setItalic()
                                            .add(
                                                    new Image(ImageDataFactory.create(new URL("https", "tecolotl-multimedia.nyc3.digitaloceanspaces.com", "/Tecolotl/REPORTE_PDF/imagenesStorage/esq.png")))
                                                            .setHeight(30).setWidth(150).setBorderBottom(new SolidBorder(color1, 1))
                                            ).add("\nwww.e-squadron.com.mx")
                            )
            );
            tablaPie.addCell(
                    new Cell(1,1)
                            .setBorder(Border.NO_BORDER)
                            .add(
                                    new Paragraph("\n".concat(String.valueOf(pageNum)))
                                            .setFont(pdfFont)
                                            .setFontColor(color1)
                                            .setTextAlignment(TextAlignment.RIGHT)
                            )
            );
            tablaPie.setBorder(Border.NO_BORDER);
            tablaPie.setFontSize(10);
            tablaPie.useAllAvailableWidth();
        }catch (Exception ex){
            logger.severe("Ocurrio un error: ".concat(ex.getMessage()));
            logger.severe("Ocurrio por las siguientes razones:  ".concat(ex.getCause().toString()));
            logger.severe("Error:  ".concat(ex.toString()));
            System.out.println(ex.toString());
        }
        return tablaPie;
    }


    @Override
    public void handleEvent(Event event) {
        PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
        PdfDocument pdfDoc = docEvent.getDocument();
        PdfPage page = docEvent.getPage();
        PdfCanvas canvas = new PdfCanvas(page.newContentStreamBefore(), page.getResources(), pdfDoc);
        Table tablaNumeracion = null;
        try {
            FontProgram fontProgram = FontProgramFactory.createFont("../fonts/Montserrat-Light.otf");
            PdfFont pdfFont = PdfFontFactory.createFont(fontProgram, PdfEncodings.UTF8,true);
            tablaNumeracion = this.crearTablaPie(docEvent, pdfFont);
        }catch (IOException ioEx){
            logger.severe("Ocurrio un error: ".concat(ioEx.getMessage()));
            logger.severe("Ocurrio por las siguientes razones:  ".concat(ioEx.getCause().toString()));
            logger.severe("Error:  ".concat(ioEx.toString()));
        }
        Rectangle rectanguloPie = this.crearRectanguloPie(docEvent);
        Canvas canvasPie = new Canvas(canvas, pdfDoc, rectanguloPie);
        canvasPie.add(tablaNumeracion);
    }
}

