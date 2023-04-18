package my.pdf;

import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Paragraph;
import my.beans.OrderPDFBean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;
import com.itextpdf.layout.Document;
import com.itextpdf.io.font.FontConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Component("reportView")
public class ReportPdfView extends AbstractView {

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model,
                                           HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {
        try{
            response.setHeader("Content-Disposition", "attachment; filename=myReport.pdf");
            OrderPDFBean report = (OrderPDFBean) model.get("report");

            //IText API
            PdfWriter pdfWriter = new PdfWriter(response.getOutputStream());
            PdfDocument pdf = new PdfDocument(pdfWriter);
            Document pdfDocument = new Document(pdf);

            //title
            Paragraph title = new Paragraph(report.getName());
            title.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));
            title.setFontSize(18f);
            title.setItalic();
            pdfDocument.add(title);

            //date
            DateTimeFormatter aFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            Paragraph date = new Paragraph(report.getDate().format(aFormatter));
            date.setFontSize(16f);
            pdfDocument.add(date);

            //content
            String textContent = "Dear Customer " +
                    report.getFirstName() + " " +
                    report.getLastName() + " you booked " +
                    report.getModelName() + " " + report.getBrandName() +
                    ", " + report.getReleaseYear() + ", for " +
                    report.getAmountOfDays() + " day(s) from " +
                    report.getDateStart() + " to " +
                    report.getDateFinish() + " . The total cost of the order is US$ " +
                    report.getPrice() + ".";
            Paragraph content = new Paragraph(textContent);
            pdfDocument.add(content);

            pdfDocument.close();
        }catch (Exception e){
            System.out.println("Exception message " + e.getMessage());
            System.out.println("Exception " + e);
            throw e;
        }

    }
}
