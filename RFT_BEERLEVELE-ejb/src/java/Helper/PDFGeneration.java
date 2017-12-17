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
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author danida
 */
public class PDFGeneration {

    /**
     * @param args the command line arguments
     */
    private String FILE = "c:/temp/FirstPdf.pdf";
    private Customer customer;
    private Invoice invoice;
    private Document document;

    private static BaseFont times_new_roman;
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 24, Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    private static Font normal = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);

    public PDFGeneration(Invoice invoice, Customer customer) throws FileNotFoundException, DocumentException, IOException {

        times_new_roman = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.NOT_EMBEDDED);

        catFont = new Font(times_new_roman, 18, Font.BOLD);
        titleFont = new Font(times_new_roman, 24, Font.BOLD);
        redFont = new Font(times_new_roman, 12, Font.NORMAL, BaseColor.RED);
        subFont = new Font(times_new_roman, 16, Font.BOLD);
        smallBold = new Font(times_new_roman, 12, Font.BOLD);
        normal = new Font(times_new_roman, 12, Font.NORMAL);

        this.invoice = invoice;
        this.customer = customer;

        document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(FILE));
        document.open();
        addMetaData(document);
        generateInvoice(document);
        document.close();

    }

    private void addMetaData(Document document) {
        document.addTitle("Szamla");
        document.addSubject("Szamla");
        document.addKeywords("Szamla, PDF, RFT");
        document.addAuthor("BeerLevele Zrt.");
        document.addCreator("BeerLevele Zrt.");
    }

    private void generateInvoice(Document document)
            throws DocumentException, BadElementException, IOException {

        Paragraph cegadatok = new Paragraph();
        addEmptyLine(cegadatok, 1);
        cegadatok.add(new Paragraph("BeerLevele Zrt.", catFont));
        addEmptyLine(cegadatok, 1);
        cegadatok.add(new Paragraph("4030, Debrecen, Vágóhíd utca 1", normal));
        Image img = Image.getInstance("C:\\Users\\danida\\Desktop\\kep.jpg");

        PdfPTable header = new PdfPTable(3);
        header.setWidthPercentage(100);
        header.addCell(getCell(cegadatok, PdfPCell.ALIGN_LEFT));
        header.addCell(getCell(new Paragraph("Számla", titleFont), PdfPCell.ALIGN_CENTER));
        header.addCell(img);

        PdfPTable details = new PdfPTable(4);
        details.setWidthPercentage(100);
        Paragraph szamlaadatok = new Paragraph();

        Chunk c = new Chunk("Vevő:");
        c.setBackground(BaseColor.LIGHT_GRAY);
        c.setFont(catFont);
        Paragraph vevo = new Paragraph(c);
        Chunk d = new Chunk("Számla:");
        d.setBackground(BaseColor.LIGHT_GRAY);
        d.setFont(catFont);
        Paragraph szamla = new Paragraph(d);

        details.addCell(getCell(vevo, PdfPCell.ALIGN_LEFT));
        details.addCell(getCell(setCustomerDetails(customer), PdfPCell.ALIGN_CENTER));
        details.addCell(getCell(szamla, PdfPCell.ALIGN_CENTER));
        details.addCell(getCell(szamlaadatok, PdfPCell.ALIGN_RIGHT));

        document.add(header);
        document.add(details);

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
        return adatok;

    }

    public Paragraph setInvoiceDetails(Invoice invoice) {
        Paragraph adatok = new Paragraph();
        adatok.add(invoice.getInvoicenumber().toString());
        addEmptyLine(adatok, 1);
        adatok.add(invoice.getDate().toGMTString());
        addEmptyLine(adatok, 1);
        adatok.add(invoice.getLoyaltycard().toString());
        addEmptyLine(adatok, 1);
        adatok.add(invoice.getDiscount().toString());

        return adatok;

    }

    public PdfPCell getCell(Paragraph text, int alignment) {
        PdfPCell cell = new PdfPCell(new Phrase(text));
        cell.setPadding(0);
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(PdfPCell.NO_BORDER);
        return cell;
    }

    private void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph("\n"));
        }
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
