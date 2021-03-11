package br.com.fpereira.testes.data;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class Main {

	public static void main(String[] args) throws DocumentException, IOException {
		  // IO
        File htmlSource = new File("C:\\Users\\felipe.pereira\\Downloads\\certificados_html_bv\\certificados_html_bv\\certificados\\BR_PR_CS_BV_PF_Consignado Facultativo_v5.1_02122020_E-mail.html");
        File pdfDest = new File("c:/teste/html.pdf");
         // pdfHTML specific code
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setCharset("UTF-8");
        converterProperties.setBaseUri("C:\\Users\\felipe.pereira\\Downloads\\certificados_html_bv\\certificados_html_bv\\certificados\\");
        HtmlConverter.convertToPdf(new FileInputStream(htmlSource), new FileOutputStream(pdfDest), converterProperties);

	}

	private static void teste1() throws DocumentException, FileNotFoundException, IOException {
		Document document = new Document();
	    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("c:/teste/html.pdf"));
	    ByteArrayInputStream html = new ByteArrayInputStream(FileUtils.readFileToByteArray(new File("C:\\Users\\felipe.pereira\\Downloads\\certificados_html_bv\\certificados_html_bv\\certificados\\BR_PR_CS_BV_PF_Consignado Facultativo_v5.1_02122020_E-mail.html")));
	    ByteArrayInputStream css = new ByteArrayInputStream(FileUtils.readFileToByteArray(new File("C:\\Users\\felipe.pereira\\Downloads\\certificados_html_bv\\certificados_html_bv\\certificados\\style.css")));
	    
	    document.open();
	    try {
			XMLWorkerHelper.getInstance().parseXHtml(writer, document, html, css, Charset.forName("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    document.close();
	}

}
