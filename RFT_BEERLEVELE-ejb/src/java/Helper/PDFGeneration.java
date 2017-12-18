/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

/**
 *
 * @author dnovak
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Entities.Customer;
import Entities.Invoice;
import Entities.Invoicedproducts;
import Logic.InvoiceLogic;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author danida
 */
public final class PDFGeneration {

    /**
     * @param args the command line arguments
     */
    private String FILE;
    private Customer customer;
    private Invoice invoice;
    private Document document;

    private static BaseFont times_new_roman;
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 24, Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    private static Font normal = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
    private static Font small = new Font(Font.FontFamily.TIMES_ROMAN, 6, Font.NORMAL);

    public PDFGeneration(Invoice invoice, Customer customer) throws FileNotFoundException, DocumentException, IOException {

        times_new_roman = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.NOT_EMBEDDED);

        catFont = new Font(times_new_roman, 18, Font.BOLD);
        titleFont = new Font(times_new_roman, 24, Font.BOLD);

        smallBold = new Font(times_new_roman, 12, Font.BOLD);
        normal = new Font(times_new_roman, 12, Font.NORMAL);

        this.invoice = invoice;
        this.customer = customer;
        this.FILE = "szamla.pdf";
        document = new Document();
        PdfWriter pdfwriter = PdfWriter.getInstance(document, new FileOutputStream(FILE));
        document.open();
        addMetaData(document);
        generateInvoice(document);
        addFooter(pdfwriter, document);
        document.close();

    }

    private void addMetaData(Document document) {
        document.addTitle("Szamla");
        document.addSubject("Szamla");
        document.addKeywords("Szamla, PDF, RFT");
        document.addAuthor("BeerLevele Zrt.");
        document.addCreator("BeerLevele Zrt.");
    }

    public void generateInvoice(Document document)
            throws DocumentException, BadElementException, IOException {

        Paragraph cegadatok = new Paragraph();
        addEmptyLine(cegadatok, 1);
        cegadatok.add(new Paragraph("BeerLevele Zrt.", catFont));
        addEmptyLine(cegadatok, 1);
        cegadatok.add(new Paragraph("4030, Debrecen, Vágóhíd u. 1", normal));
        Image img = Image.getInstance("/home/dnovak/Desktop/kep.jpg");

        PdfPTable header = new PdfPTable(3);
        header.setWidthPercentage(100);
        header.addCell(getCell(cegadatok, PdfPCell.ALIGN_LEFT, BaseColor.WHITE));
        header.addCell(getCell(new Paragraph("Számla", titleFont), PdfPCell.ALIGN_CENTER, BaseColor.WHITE));
        header.addCell(img);

        PdfPTable details = new PdfPTable(4);
        details.setWidthPercentage(100);

        float[] columnWidths = new float[]{10f, 35f, 28f, 27f};
        details.setWidths(columnWidths);
        Chunk cust = new Chunk("Vevő:");
        cust.setBackground(BaseColor.LIGHT_GRAY);
        cust.setFont(smallBold);
        Paragraph vevo = new Paragraph(cust);

        PdfPTable cdetails = new PdfPTable(1);
        cdetails.addCell(getCell(new Paragraph("Számlaszám: "), PdfPCell.ALIGN_LEFT, BaseColor.LIGHT_GRAY, smallBold));
        cdetails.addCell(getCell(new Paragraph("Kiállítás ideje: "), PdfPCell.ALIGN_LEFT, BaseColor.LIGHT_GRAY, smallBold));
        cdetails.addCell(getCell(new Paragraph("Bizalomkártya szintje: "), PdfPCell.ALIGN_LEFT, BaseColor.LIGHT_GRAY, smallBold));
        cdetails.addCell(getCell(new Paragraph("Alkalmazott kedvezmény: "), PdfPCell.ALIGN_LEFT, BaseColor.LIGHT_GRAY, smallBold));
        cdetails.setWidthPercentage(100);

        PdfPCell cell = new PdfPCell(cdetails);
        cell.setPadding(0);
        cell.setBorder(PdfPCell.NO_BORDER);

        details.addCell(getCell(vevo, PdfPCell.ALIGN_LEFT, BaseColor.WHITE));
        details.addCell(getCell(setCustomerDetails(customer), PdfPCell.ALIGN_CENTER, BaseColor.WHITE));
        details.addCell(cell);
        details.addCell(getCell(setInvoiceDetails(invoice), PdfPCell.ALIGN_RIGHT, BaseColor.WHITE));
        details.setSpacingBefore(10);

        PdfPTable stocks = new PdfPTable(4);
        stocks.setWidthPercentage(100);

        Chunk quant = new Chunk("Mennyiség:");
        quant.setBackground(BaseColor.LIGHT_GRAY);
        quant.setFont(smallBold);

        Paragraph menny = new Paragraph(quant);
        menny.setFont(normal);
        addEmptyLine(menny, 1);

        Chunk name = new Chunk("Tétel megnevezése:");
        name.setBackground(BaseColor.LIGHT_GRAY);
        name.setFont(smallBold);
        Paragraph nev = new Paragraph(name);
        nev.setFont(normal);
        addEmptyLine(nev, 1);

        Chunk price = new Chunk("Egység ár:");
        price.setBackground(BaseColor.LIGHT_GRAY);
        price.setFont(smallBold);
        Paragraph ar = new Paragraph(price);
        ar.setFont(normal);
        addEmptyLine(ar, 1);

        Chunk sum = new Chunk("Összesen:");
        sum.setBackground(BaseColor.LIGHT_GRAY);
        sum.setFont(smallBold);
        Paragraph osszesen = new Paragraph(sum);
        osszesen.setFont(normal);
        addEmptyLine(osszesen, 1);

        Double fullprice = 0.0;

        for (Invoicedproducts stock : invoice.getInvoicedproductsCollection()) {
            menny.add(stock.getSoldquantity().toString());
            addEmptyLine(menny, 1);
            nev.add(stock.getName());
            addEmptyLine(nev, 1);
            ar.add(stock.getSoldprice().toString() + " Ft");
            addEmptyLine(ar, 1);
            Double full = stock.getSoldprice() * stock.getSoldquantity();
            fullprice += full;
            osszesen.add(full.toString() + " Ft");
            addEmptyLine(osszesen, 1);

        }

        stocks.addCell(getCell(menny, PdfPCell.ALIGN_LEFT, BaseColor.WHITE));
        stocks.addCell(getCell(nev, PdfPCell.ALIGN_LEFT, BaseColor.WHITE));
        stocks.addCell(getCell(ar, PdfPCell.ALIGN_LEFT, BaseColor.WHITE));
        stocks.addCell(getCell(osszesen, PdfPCell.ALIGN_LEFT, BaseColor.WHITE));
        stocks.setSpacingBefore(10);

        document.add(header);
        document.add(details);
        document.add(stocks);
        Phrase footer2 = new Phrase("A számla 27% ÁFA-t tartalmaz, a feltüntetett árak az ÁFA-T tartalmazzák.", small);
        document.add(footer2);

        Chunk fullprice1 = new Chunk("Végösszeg: " + fullprice.toString() + " Ft");
        fullprice1.setFont(smallBold);
        Paragraph sumall = new Paragraph(fullprice1);
        sumall.setAlignment(Element.ALIGN_RIGHT);

        document.add(sumall);

    }

    public Paragraph setCustomerDetails(Customer customer) {
        Paragraph adatok = new Paragraph();

        adatok.add(customer.getName());
        addEmptyLine(adatok, 1);
        adatok.add(customer.getAddress());
        addEmptyLine(adatok, 1);
        adatok.add(customer.getCity());
        addEmptyLine(adatok, 1);
        adatok.add(customer.getPostalcode());
        addEmptyLine(adatok, 1);
        adatok.add(customer.getCountry());
        addEmptyLine(adatok, 1);
        return adatok;

    }

    public Paragraph setInvoiceDetails(Invoice invoice) {
        Paragraph adatok = new Paragraph();
        adatok.add(InvoiceLogic.generateInvoiceNumber(invoice));
        addEmptyLine(adatok, 1);
        DateFormat hungarianDay = new SimpleDateFormat("yyyy. MMMM dd. HH:mm", new Locale("hu"));

        adatok.add(hungarianDay.format(invoice.getDate()));
        addEmptyLine(adatok, 1);
        adatok.add(invoice.getLoyaltycard() ? "Arany" : "Nincs");
        addEmptyLine(adatok, 1);
        adatok.add(invoice.getDiscount().toString() + "%");

        return adatok;

    }

    public PdfPCell getCell(Paragraph text, int alignment, BaseColor color) {
        Phrase p = new Phrase(text);
        PdfPCell cell = new PdfPCell(p);
        cell.setPadding(0);
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setBackgroundColor(color);

        return cell;
    }

    public PdfPCell getCell(Paragraph text, int alignment, BaseColor color, Font font) {
        Chunk p = new Chunk(text.getContent());
        p.setFont(font);
        PdfPCell cell = new PdfPCell(new Paragraph(p));
        cell.setPadding(0);
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setBackgroundColor(color);

        return cell;
    }

    private void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph("\n"));
        }
    }

    public void addFooter(PdfWriter writer, Document document) {

        PdfContentByte cb = writer.getDirectContent();
        Phrase footer = new Phrase("Köszönjük, hogy nálunk vásárolt!", smallBold);

        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                footer,
                (document.right() - document.left()) / 2 + document.leftMargin(),
                document.bottom() - 10, 0);

    }

    public String getFILE() {
        return FILE;
    }

    public void setFILE(String FILE) {
        this.FILE = FILE;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

}
